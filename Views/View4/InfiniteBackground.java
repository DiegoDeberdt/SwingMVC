package Views.View4;

import Models.Enums.Direction;
import Models.Model4;
import Models.Enums.Weather;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class InfiniteBackground {

    private Model4 model = null;

    private BufferedImage image = null;
    private int imageWidth = 0;
    private int imageHeight = 0;

    private int x_offset = 0;

    private final int BASELINE_SCROLL_SPEED = 4;

    private long elapsedTimeStart = System.currentTimeMillis();

    public InfiniteBackground(Model4 model) throws IOException {

        this.model = model;

        URL resource = InfiniteBackground.class.getResource("background.png");
        image = ImageIO.read(resource);

        imageWidth = image.getWidth();
        imageHeight = image.getHeight();
    }

    public int getImageWidth() { return this.imageWidth; }
    public int getImageHeight() { return this.imageHeight; }

    public void update() {

        int speed = -1;

        if (model.getWalkingSpeed() == 1) speed = BASELINE_SCROLL_SPEED / 2;
        else if (model.getWalkingSpeed() == 2) speed = BASELINE_SCROLL_SPEED;
        else if (model.getWalkingSpeed() == 3) speed = BASELINE_SCROLL_SPEED * 2;
        else throw new UnsupportedOperationException();

        if (model.getDirection() == Direction.RIGHT_TO_LEFT) {
            x_offset -= speed;
            if (x_offset < 0) x_offset = imageWidth - 1;
        } else {
            x_offset += speed;
            if (x_offset >= imageWidth) x_offset = imageWidth - x_offset;
        }
    }

    public BufferedImage getInfiniteBackground() {

        var infiniteBackground = new BufferedImage(this.imageWidth, this.imageHeight, model.getWeather() == Weather.RAIN ? BufferedImage.TYPE_BYTE_GRAY : this.image.getType());

        if (this.x_offset > 0) {
            var leftSection = this.image.getSubimage(0, 0, this.x_offset, this.imageHeight);
            var rightSection = this.image.getSubimage(this.x_offset, 0, this.imageWidth - this.x_offset, this.imageHeight);

            var g = infiniteBackground.getGraphics();
            g.drawImage(rightSection, 0, 0, imageWidth - x_offset, imageHeight, null);
            g.drawImage(leftSection, imageWidth - x_offset, 0, x_offset, imageHeight, null);
        } else {
            return this.image;
        }

        return infiniteBackground;
    }

    public void paint(Graphics2D g2d, int panelWidth, int panelHeight) {

        var infiniteSky = getInfiniteBackground();

        BufferedImage skySubImage = null;
        if (panelHeight >= getImageHeight()) {
            skySubImage = infiniteSky.getSubimage(0, 0, panelWidth, getImageHeight());
        } else {
            skySubImage = infiniteSky.getSubimage(0, getImageHeight() - panelHeight, panelWidth, panelHeight);
        }
        g2d.drawImage(skySubImage, 0, 0, panelWidth, panelHeight, null);
    }
}
