package Models;

public class Model1 extends BaseModel {

    private String message = "Hello, World!!";
    private int rotationSpeed = 6;
    private boolean warpSpeedFlag = false;

    public Model1(String title) {
        super(title);
    }

    public String getMessage() { return this.message; }
    public void setMessage(String message) {
        this.message = message;
        notifyModelChangedListeners(this);
    }

    public int getRotationSpeed() { return this.rotationSpeed; }
    public void setRotationSpeed(int rotationSpeed) {
        this.rotationSpeed = rotationSpeed;
        notifyModelChangedListeners(this);
    }

    public boolean isWarpSpeedEnabled() { return this.warpSpeedFlag; }
    public void setWarpSpeedFlag(boolean flagValue) {
        this.warpSpeedFlag = flagValue;
        notifyModelChangedListeners(this);
    }
}
