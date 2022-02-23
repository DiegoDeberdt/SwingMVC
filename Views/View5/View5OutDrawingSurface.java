package Views.View5;

import Models.Model5;
import Models.Enums.RenderTheme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Vector;

public class View5OutDrawingSurface extends JPanel {

    private Model5 model;

    private Vector<RoundObject> roundObjectVector;
    private Color background;

    private final int MAX_NR_OF_OBJECTS = 1000;
    private final Color OBJECT_COLOR;
    private final int DEFAULT_OBJECT_SIZE = 4;

    private BufferedImage image = null;
    private BufferedImage winterImage = null;
    private BufferedImage coralReefImage = null;

    public View5OutDrawingSurface(Model5 model) {

        this.model = model;

        this.roundObjectVector = new Vector<RoundObject>();
        this.background = new Color(0, 100, 255);
        this.OBJECT_COLOR = new Color(255, 255, 255);

        try {
            URL resource = View5OutDrawingSurface.class.getResource("bruegel.png");
            this.winterImage = ImageIO.read(resource);

            resource = View5OutDrawingSurface.class.getResource("coralreef.png");
            this.coralReefImage = ImageIO.read(resource);
        } catch(IOException ex) {

        }

        int delay = (int)(1000 / 60); // 60 FPS
        new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                repaint();
            }
        }).start();
    }

    private void initVector() {
        for(int i = 0; i< MAX_NR_OF_OBJECTS; i++) {
            int bubbleSize = (int)((Math.random() * 4) + DEFAULT_OBJECT_SIZE); // random bubble size.
            var roundObject =new RoundObject(getWidth(), getHeight(), bubbleSize);
            roundObjectVector.add(roundObject);
        }
    }

    int background_x_offset = 0;
    boolean pan_right = true;
    int pan_speed = 1;

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (model.getRenderTheme() == RenderTheme.CORAL_REEF) this.image = this.coralReefImage;
        else if (model.getRenderTheme() == RenderTheme.WINTER) this.image = this.winterImage;
        else throw new UnsupportedOperationException();

        for(int i = 0; i< roundObjectVector.size(); i++) {
            var airBubble = roundObjectVector.get(i);
            airBubble.update(model.getRenderTheme(), getWidth(), getHeight());
        }

        var g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (pan_right == true) {
            if (background_x_offset + pan_speed + getWidth() >= this.image.getWidth()) {
                pan_right = false;
                background_x_offset = this.image.getWidth() - getWidth();
            } else {
                background_x_offset++;
            }
        } else {
            if (background_x_offset <= 0) {
                pan_right = true;
                background_x_offset = 0;
            } else {
                background_x_offset--;
            }
        }

        BufferedImage sub_image = null;
        if (getHeight() > this.image.getHeight()) {
            sub_image = this.image.getSubimage(background_x_offset, 0, getWidth(), this.image.getHeight());
        } else {
            sub_image = this.image.getSubimage(background_x_offset, this.image.getHeight() - getHeight(), getWidth(), getHeight());
        }

        g2d.drawImage(sub_image, 0, 0, getWidth(), getHeight(), null);

        g2d.setColor(this.OBJECT_COLOR);

        if (roundObjectVector.size() == 0) initVector();

        for(int i = 0; i< model.getNumberOfObjects(); i++){
            var airBubble = roundObjectVector.get(i);
            if (model.getRenderTheme() == RenderTheme.CORAL_REEF) {
                g2d.drawOval((int)airBubble.getX(), (int)airBubble.getY(), airBubble.getSize(), airBubble.getSize());
            } else {
                Ellipse2D.Double circle = new Ellipse2D.Double((int)airBubble.getX(), (int)airBubble.getY(), airBubble.getSize(), airBubble.getSize());
                g2d.fill(circle);
            }
        }
    }
}
