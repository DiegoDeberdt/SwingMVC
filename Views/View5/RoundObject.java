package Views.View5;

import Models.Enums.RenderTheme;

public class RoundObject {

    private double x;
    private double y;

    private int size;

    private int viewportWidth;
    private int viewportHeight;

    public RoundObject(int viewportWidth, int viewportHeight, int size) {

        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;

        this.size = size;

        init();
    }

    public double getX() { return this.x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return this.y; }
    public void setY(double y) { this.y = y; }

    public int getSize() { return this.size; }
    public void setSize(int size) { this.size = size; }

    private void init() {
        x = Math.random() * viewportWidth;
        y = Math.random() * viewportHeight;
    }

    public void update(RenderTheme renderTheme, int viewportWidth, int viewportHeight) {

        if (this.viewportHeight != viewportHeight || this.viewportWidth != viewportWidth) {

            this.viewportWidth = viewportWidth;
            this.viewportHeight = viewportHeight;

            init();
        }

        if (renderTheme == RenderTheme.CORAL_REEF) {
            y -= Math.max(3, getSize() - 3); // bigger bubbles rise more quickly
            if (y < 0) y = this.viewportHeight + 1;
        } else {
            y += Math.max(3, getSize() -3); // bigger snowflakes fall faster
            if (y > this.viewportHeight) y = -10;
        }

        double wiggleDirection = Math.random() < 0.5 ? -1.0 : 1.0;
        x += (wiggleDirection * Math.random());
    }
}
