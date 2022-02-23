package Views.View3;

import Models.Model3;
import Views.BaseViewOut;

import java.awt.*;

public class View3Out extends BaseViewOut {

    private View3OutDrawingSurface drawingSurface1 = null;
    private View3OutDrawingSurface drawingSurface2 = null;
    private View3OutDrawingSurface drawingSurface3 = null;

    public View3Out(Model3 model){
        super();

        this.drawingSurface1 = new View3OutDrawingSurface(model.getTemperatureModel1());
        this.drawingSurface2 = new View3OutDrawingSurface(model.getTemperatureModel2());
        this.drawingSurface3 = new View3OutDrawingSurface(model.getTemperatureModel3());

        getCenterPanel().setLayout(new GridLayout(1, 3));
        getCenterPanel().add(this.drawingSurface1);
        getCenterPanel().add(this.drawingSurface2);
        getCenterPanel().add(this.drawingSurface3);
    }
}
