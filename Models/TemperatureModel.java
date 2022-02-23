package Models;

public class TemperatureModel extends BaseModel {

    protected final int TEMPERATURE_MIN = 16;
    protected final int TEMPERATURE_MAX = 50;

    private int temperature = 0;

    public TemperatureModel(String title, int temperature) {
        super(title);
        setTemperature(temperature);
    }

    public int getTemperature() { return this.temperature; }

    public void setTemperature(int t) {
        if (t < TEMPERATURE_MIN || t > TEMPERATURE_MAX) throw new IllegalArgumentException();
        this.temperature = t;
        notifyModelChangedListeners(this);
    }
}
