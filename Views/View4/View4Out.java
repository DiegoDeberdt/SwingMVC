package Views.View4;

import Models.Model4;
import Models.ModelChangedListener;
import Views.BaseViewOut;

import java.awt.*;

public class View4Out extends BaseViewOut implements ModelChangedListener {

    public View4Out(Model4 model) {

        super();

        model.addModelChangedListener(this);

        getCenterPanel().add(new View4OutDrawingSurface(model), BorderLayout.CENTER);
    }

    public void onModelChanged(Object source) {
        var model = (Model4) source;
    }
}
