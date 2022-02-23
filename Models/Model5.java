package Models;

import Models.Enums.RenderTheme;

import java.util.HashMap;
import java.util.Map;

public class Model5 extends BaseModel {

    private int numberOfObjects = 100;
    private RenderTheme renderTheme = RenderTheme.WINTER;

    public Map<String, Integer> numberOfObjectsMap = new HashMap<>();

    public Model5(String title) {
        super(title);
        numberOfObjectsMap.put("Min.", 250);
        numberOfObjectsMap.put("Low", 500);
        numberOfObjectsMap.put("High", 750);
        numberOfObjectsMap.put("Max.", 1000);
    }

    public int getNumberOfObjects() { return this.numberOfObjects; }
    public void setNumberOfObjects(int numberOfObjects) {
        this.numberOfObjects = numberOfObjects;
        notifyModelChangedListeners(this);
    }

    public RenderTheme getRenderTheme() { return this.renderTheme; }
    public void setRenderTheme(RenderTheme renderTheme) {
        this.renderTheme = renderTheme;
        notifyModelChangedListeners(this);
    }
}
