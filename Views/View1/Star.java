package Views.View1;

public class Star {

    private final int NORMAL_SPEED = 10;
    private final int WARP_SPEED = 20;

    private double x;
    private double y;
    private double z;
    private double pz;

    public Star(int viewportWidth, int viewportHeight) {
        init(viewportWidth, viewportHeight);
    }

    public void init(int viewportWidth, int viewportHeight) {

        initX(viewportWidth);
        initY(viewportHeight);
        initZ(viewportHeight);

        this.pz = z;
    }

    public void initX(int viewportWidth) {
        this.x = Math.random() / Math.nextDown(1.0) * (viewportWidth / 2) * (Math.random() > 0.5 ? -1 : 1);
    }

    public void initY(int viewportHeight) {
        this.y = Math.random() / Math.nextDown(1.0) * (viewportHeight / 2) * (Math.random() > 0.5 ? -1 : 1);
    }

    public void initZ(int viewportHeight) {
        this.z = Math.random() / Math.nextDown(1.0) * viewportHeight;
    }

    public double getX() { return this.x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return this.y; }
    public void setY(double y) { this.y = y; }

    public double getZ() { return this.z; }
    public void setZ(double z) { this.z = z;}

    public double getPreviousZ() { return this.pz; }
    public void setPreviousZ(double pz) { this.pz = pz; }

    public void update(int viewportWidth, int viewportHeight, boolean isWarpSpeedEnabled) {
        int speed = NORMAL_SPEED;
        if (isWarpSpeedEnabled) speed = WARP_SPEED;
        double z = this.z - speed;
        if (z < 1) {
            init(viewportWidth, viewportHeight);
        } else {
            this.z = z;
        }
    }
}
