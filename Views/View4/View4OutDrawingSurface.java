package Views.View4;

import Models.Model4;
import Models.Enums.Weather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

public class View4OutDrawingSurface extends JPanel {

    private Model4 model = null;

    private IronManSprite ironManSprite = null;
    private InfiniteBackground backgroundImage = null;

    private Vector<Raindrop> raindropVector = new Vector<Raindrop>();

    public View4OutDrawingSurface(Model4 model) {

        this.model = model;

        try {
            ironManSprite = new IronManSprite(model);
            backgroundImage = new InfiniteBackground(model);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        int delay = (int)(1000 / 60); // 60 FPS
        new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                repaint();
            }
        }).start();
    }

    private void initRaindropVector() {
        for(int i=0; i<500; i++) {
            var raindrop = new Raindrop(getWidth(), getHeight());
            this.raindropVector.add(raindrop);
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        var g2d = (Graphics2D)g;

        if (this.raindropVector.size() == 0) {
            initRaindropVector();
        } else {
            for(Raindrop raindrop : raindropVector) {
                raindrop.update(getWidth(), getHeight());
            }
        }

        ironManSprite.update();
        backgroundImage.update();

        backgroundImage.paint(g2d, getWidth(), getHeight());
        ironManSprite.paint(g2d, getWidth(), getHeight());

        if (model.getWeather() == Weather.RAIN){
            g2d.setStroke(new BasicStroke(1.0f));
            for(Raindrop raindrop : raindropVector) {
                int c = (int)(Math.random() * 128);
                g.setColor(new Color(c, c, c, c));
                g2d.drawLine(raindrop.getX(), raindrop.getY(), raindrop.getX(), raindrop.getPreviousY());
            }
        }
    }
}
