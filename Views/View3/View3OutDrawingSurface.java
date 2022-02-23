package Views.View3;

import Models.ModelChangedListener;
import Models.TemperatureModel;

import javax.swing.*;
import java.awt.*;

public class View3OutDrawingSurface extends JPanel implements ModelChangedListener {

    private TemperatureModel model;
    private BarThermometer t1;

    public View3OutDrawingSurface(TemperatureModel model) {
        this.model = model;
        this.model.addModelChangedListener(this);

        this.t1 = new BarThermometer(model.getTitle());
        this.t1.setX_offset(15);
        this.t1.setY_offset(30);
        this.t1.setTemperature(model.getTemperature());
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        var g2d = (Graphics2D)g;

        this.t1.setTemperature(model.getTemperature());

        this.t1.draw(g2d);
    }

    @Override
    public void onModelChanged(Object source) {
        this.repaint();
    }
}
