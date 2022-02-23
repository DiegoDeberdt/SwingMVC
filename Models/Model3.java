package Models;

public class Model3 {

    private String title = null;

    private TemperatureModel temperature1 = new TemperatureModel("Kitchen", 16);
    private TemperatureModel temperature2 = new TemperatureModel("Office", 21);
    private TemperatureModel temperature3 = new TemperatureModel("Bedroom", 35);

    public Model3(String title) {
        this.title = title;
    }

    public String getTitle() { return this.title; }

    public TemperatureModel getTemperatureModel1() { return this.temperature1; }
    public TemperatureModel getTemperatureModel2() { return this.temperature2; }
    public TemperatureModel getTemperatureModel3() { return this.temperature3; }
}
