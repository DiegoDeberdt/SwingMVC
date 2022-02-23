package Views.View4;

public class Raindrop {

    private int x;
    private int y;
    private int py;

    private int viewportWidth = 0;
    private int viewportHeight = 0;

    public Raindrop(int viewportWidth, int viewportHeight) {
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;

        init();
    }

    public void init() {

        this.x = (int) (Math.random() * this.viewportWidth);
        this.y = (int) (Math.random() * this.viewportHeight);
        this.py = y;
    }

    public int getX() { return this.x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return this.y; }
    public void setY(int y) { this.y = y; }

    public int getPreviousY() { return this.py; }
    public void setPreviousY(int py) { this.py = py; }

    public void update(int viewportWidth, int viewportHeight) {

        if (this.viewportHeight != viewportHeight || this.viewportWidth != viewportWidth) {

            this.viewportWidth = viewportWidth;
            this.viewportHeight = viewportHeight;

            init();
        }

        this.py = y;
        this.y += 11;
        if (this.y >= viewportHeight) {
            this.y = 0;
            this.py = y;
        }
    }
}
