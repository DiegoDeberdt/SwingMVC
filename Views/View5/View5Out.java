package Views.View5;

import Models.Model5;
import Views.BaseViewOut;

import java.awt.*;

public class View5Out extends BaseViewOut {

    public View5Out(Model5 model) {

        super();

        getCenterPanel().add(new View5OutDrawingSurface(model), BorderLayout.CENTER);
    }
}
