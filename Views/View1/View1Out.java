package Views.View1;

import Models.Model1;
import Views.BaseViewOut;

import java.awt.*;

public class View1Out extends BaseViewOut {

    private View1OutDrawingSurface surface;

    public View1Out(Model1 model) {

        super();

        this.surface = new View1OutDrawingSurface(model);
        getCenterPanel().add(this.surface, BorderLayout.CENTER);
    }
}
