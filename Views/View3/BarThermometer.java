package Views.View3;

import Models.Enums.Orientation;

import java.awt.*;

public class BarThermometer {

    private final Color COLOR_1 = new Color(200, 0, 0);
    private final Color COLOR_2 = new Color(128, 128, 128);
    private final int LOWEST_TEMP = 0;
    private final int HIGHEST_TEMP = 50;
    private final int PIXELS_PER_DEGREE = 7;
    private final int WIDTH = 20;

    private int x_offset = 0;
    private int y_offset = 0;
    private String name;
    private int temperature;
    private Orientation orientation = Orientation.VERTICAL;

    public BarThermometer(String name) {
        this.name = name;
    }

    public void setTemperature(int temperature) { this.temperature = temperature; }
    public void setOrientation(Orientation orientation) { this.orientation = orientation; }

    public void setX_offset(int x_offset) { this.x_offset = x_offset; }
    public void setY_offset(int y_offset) { this.y_offset = y_offset; }

    private int getTotalHeight() {
        return (Math.abs(LOWEST_TEMP) + HIGHEST_TEMP) * PIXELS_PER_DEGREE;
    }

    private int getHeightOfTemperatureBar() {
        return (HIGHEST_TEMP - this.temperature) * PIXELS_PER_DEGREE;
    }

    public void draw(Graphics2D g2d) {

        // COLOR-1
        Rectangle rect = null;
        if (orientation == Orientation.VERTICAL) {
            rect = new Rectangle(this.x_offset, this.y_offset, WIDTH, getTotalHeight());
        } else {
            rect = new Rectangle(this.x_offset, this.y_offset, getTotalHeight(), WIDTH);
        }
        g2d.setColor(COLOR_1);
        g2d.fill(rect);

        // COLOR-2
        if (orientation == Orientation.VERTICAL) {
            rect = new Rectangle(this.x_offset, this.y_offset, WIDTH, getHeightOfTemperatureBar());
        } else {
            rect = new Rectangle(this.x_offset, this.y_offset, getHeightOfTemperatureBar(), WIDTH);
        }

        g2d.setColor(COLOR_2);
        g2d.fill(rect);

        // TEXT
        g2d.setFont(new Font("Sans Serif", Font.BOLD, 11));
        int y = (Math.abs(LOWEST_TEMP) + HIGHEST_TEMP) * PIXELS_PER_DEGREE;
        for(int i = LOWEST_TEMP; i <= HIGHEST_TEMP; i += 10) {

            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(i), x_offset + WIDTH + 5, y_offset + y);

            g2d.setColor(new Color(100, 100, 100));
            g2d.drawLine(x_offset, y_offset + y, x_offset + WIDTH + 3, y_offset + y);

            y -= 10 * PIXELS_PER_DEGREE;
        }
        g2d.drawString(String.valueOf(HIGHEST_TEMP), WIDTH + 5, y);

        // NAME
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Sans Serif", Font.BOLD, 12));
        g2d.drawString(this.name, x_offset - 15, y_offset - 15);
    }
}
