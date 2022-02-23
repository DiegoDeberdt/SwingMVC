package Views.View4;

import Models.Enums.Direction;
import Models.Model4;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class IronManSprite {

    private Model4 model = null;

    public static final int SPRITE_WIDTH = 64;
    public static final int SPRITE_HEIGHT = 64;

    private BufferedImage spriteMap = null;
    private int sprite_x_offset = 0;
    private int sprite_y_offset = 0;

    private long elapsedTimeStart = System.currentTimeMillis();

    public IronManSprite(Model4 model) throws IOException {

        this.model = model;

        URL resource = IronManSprite.class.getResource("ironman.png");
        this.spriteMap = ImageIO.read(resource);
    }

    public void update() {

        int speed = -1;

        if (model.getWalkingSpeed() == 1) speed = 10;
        else if (model.getWalkingSpeed() == 2) speed = 20;
        else if (model.getWalkingSpeed() == 3) speed = 50;
        else throw new UnsupportedOperationException();

        long elapsedTimeEnd = System.currentTimeMillis();
        long elapsedTimeMillis = elapsedTimeEnd - elapsedTimeStart;
        if (elapsedTimeMillis >= 1000 / speed) {
            sprite_y_offset = 0;

            if (model.getDirection() == Direction.RIGHT_TO_LEFT) {
                sprite_x_offset += 1;
                if (sprite_x_offset == 10) sprite_x_offset = 0;
            } else {
                sprite_x_offset -= 1;
                if (sprite_x_offset < 0) sprite_x_offset = 9;

                sprite_y_offset = 70;
            }

            elapsedTimeStart = elapsedTimeEnd;
        }
    }

    public BufferedImage getSprite() {
        int x = sprite_x_offset * SPRITE_WIDTH;
        return this.spriteMap.getSubimage(x, sprite_y_offset, SPRITE_WIDTH, SPRITE_HEIGHT);
    }

    public void paint(Graphics2D g2d, int panelWidth, int panelHeight) {
        int marginFromBottom = 45;
        int renderSize = 128;

        g2d.drawImage(getSprite(), (panelWidth / 2) - IronManSprite.SPRITE_WIDTH, panelHeight - renderSize - marginFromBottom, renderSize, renderSize, null);
    }
}
