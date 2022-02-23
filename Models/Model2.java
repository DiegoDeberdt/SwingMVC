package Models;

import java.awt.*;
import java.util.Locale;

public class Model2 extends BaseModel {

    private Color color1 = new Color(0, 0, 0);
    private Color color2 = new Color(255, 255, 0);
    private Color color3 = new Color(255, 0, 0);

    private boolean flipOrientationFlag;

    public Model2(String title) {
        super(title);
    }

    public Color getColor1() { return this.color1; }
    public String getColor1AsHex() { return getHexValue(this.color1); }
    public void setColor1(Color c) {
        this.color1 = c;
        notifyModelChangedListeners(this);
    }

    public Color getColor2() { return this.color2; }
    public String getColor2AsHex() { return getHexValue(this.color2); }
    public void setColor2(Color c) {
        this.color2 = c;
        notifyModelChangedListeners(this);
    }

    public Color getColor3() { return this.color3; }
    public String getColor3AsHex() { return getHexValue(this.color3); }
    public void setColor3(Color c) {
        this.color3 = c;
        notifyModelChangedListeners(this);
    }

    public boolean isFlipOrientationFlagSet() {
        return this.flipOrientationFlag;
    }
    public void resetFlipOrientationFlag() {
        this.flipOrientationFlag = false;
    }
    public void setFlipOrientationFlag() {
        this.flipOrientationFlag = true;
        notifyModelChangedListeners(this);
    }

    private String getHexValue(Color c) {
        String red = String.format("%02X", c.getRed());
        String green = String.format("%02X", c.getGreen());
        String blue = String.format("%02X", c.getBlue());
        String hexValue = red + green + blue;
        return hexValue.toUpperCase(Locale.ROOT);
    }
}
