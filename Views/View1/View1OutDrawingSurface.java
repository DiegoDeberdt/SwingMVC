package Views.View1;

import Models.Model1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.util.Vector;

public class View1OutDrawingSurface extends JPanel {

    private Model1 model;

    private int text_angle = 0;
    private double fontSize = 0;
    private Vector<Star> starVector = new Vector<Star>();

    private final int NR_OF_STARS = 250;
    private final int STAR_SIZE = 2;
    private final Color messageColor = new Color(0, 255, 0);
    private final Color background = new Color(0, 0, 0);
    private final Color starColor = new Color(255, 255, 255);

    public View1OutDrawingSurface(Model1 model) {
        this.model = model;

        int delay = (int)(1000 / 60); // 60 FPS
        new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                repaint();
            }
        }).start();
    }

    private void initStarVector() {
        for(int i=0; i<NR_OF_STARS; i++) {
            starVector.add(new Star(getWidth(), getHeight()));
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (starVector.size() == 0) initStarVector();

        g.setColor(this.background);
        g.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(this.starColor);
        g2d.setStroke(new BasicStroke(0.3f));

        for(Star star : starVector) {

            star.update(getWidth(), getHeight(), model.isWarpSpeedEnabled());

            double sx = mapValue(star.getX() / star.getZ(), 0, 1, 0, getWidth());
            double sy = mapValue(star.getY() / star.getZ(), 0, 1, 0, getHeight());
            double r = mapValue(star.getZ(), 0, getHeight(), 6, 0);

            Ellipse2D.Double circle = new Ellipse2D.Double((getWidth() / 2) + sx, (getHeight() / 2) + sy, r, r);
            g2d.fill(circle);

            if (model.isWarpSpeedEnabled()) {
                double px = mapValue(star.getX() / star.getPreviousZ(), 0, 1, 0, getWidth());
                double py = mapValue(star.getY() / star.getPreviousZ(), 0, 1, 0, getHeight());
                g2d.drawLine((getWidth() / 2) + (int)px, (getHeight() / 2) + (int)py, (getWidth() / 2) + (int)sx, (getHeight() / 2) + (int)sy);
            }
        }

//        this.fontSize -= 0.5;
//        if (this.fontSize <= 0) this.fontSize = model.getFontSize();
        this.fontSize += 0.5;
        if (this.fontSize >= 64) this.fontSize = 0;

        var messageFont = new Font("Sans Serif", Font.BOLD, (int)this.fontSize);

        text_angle += model.getRotationSpeed() * (model.isWarpSpeedEnabled() ? 3.0 : 1.0);

        //drawRotatedText((Graphics2D) g, getWidth()/2, getHeight()/2, messageFont);

        g2d.setColor(this.messageColor);
        drawCenteredString((Graphics2D) g, model.getMessage(), new Rectangle(getWidth(), getHeight()), messageFont);
    }

    private double mapValue(double value, double rangeMinIn, double rangeMaxIn, double rangeMinOut, double rangeMaxOut) {
        return ( (value - rangeMinIn) / (rangeMaxIn-rangeMinIn) ) * (rangeMaxOut-rangeMinOut) + rangeMinOut;
    }

    public void drawCenteredString(Graphics2D g2d, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g2d.getFontMetrics(font);
        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2 ;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        // Set the font
        g2d.setFont(font);
        // Draw the String
        g2d.translate(getWidth()/2, getHeight()/2);
        g2d.rotate(Math.toRadians(this.text_angle));
        g2d.drawString(text, x - rect.width / 2, y - rect.height / 2);
    }

    public void drawRotatedText(Graphics2D g2d, double x, double y, Font font)
    {
        g2d.setColor(this.messageColor);
        g2d.setFont(font);
        g2d.translate((float)x,(float)y);
        g2d.rotate(Math.toRadians(this.text_angle));
        g2d.drawString(model.getMessage(),0,0);
    }
}
