package Views.View3;

import Models.Model3;
import Models.ModelChangedListener;
import Models.TemperatureModel;
import Views.BaseViewIn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View3In extends BaseViewIn {

    public final int MIN_TEMPERATURE = 16;
    public final int MAX_TEMPERATURE = 50;

    public JSlider slider1 = null;
    public JSlider slider2 = null;
    public JSlider slider3 = null;

    public JSpinner spinner1 = null;
    public JSpinner spinner2 = null;
    public JSpinner spinner3 = null;

    public View3In(Model3 model) {

        super();

        model.getTemperatureModel1().addModelChangedListener(new ModelChangedListener() {
            @Override
            public void onModelChanged(Object source) {
                var m = (TemperatureModel)source;
                spinner1.setValue(m.getTemperature());
                slider1.setValue(m.getTemperature());
            }
        });

        model.getTemperatureModel2().addModelChangedListener(new ModelChangedListener() {
            @Override
            public void onModelChanged(Object source) {
                var m = (TemperatureModel)source;
                spinner2.setValue(m.getTemperature());
                slider2.setValue(m.getTemperature());
            }
        });

        model.getTemperatureModel3().addModelChangedListener(new ModelChangedListener() {
            @Override
            public void onModelChanged(Object source) {
                var m = (TemperatureModel)source;
                spinner3.setValue(m.getTemperature());
                slider3.setValue(m.getTemperature());
            }
        });

        this.slider1 = new JSlider(JSlider.HORIZONTAL, MIN_TEMPERATURE, MAX_TEMPERATURE, model.getTemperatureModel1().getTemperature());
        this.slider2 = new JSlider(JSlider.HORIZONTAL, MIN_TEMPERATURE, MAX_TEMPERATURE, model.getTemperatureModel2().getTemperature());
        this.slider3 = new JSlider(JSlider.HORIZONTAL, MIN_TEMPERATURE, MAX_TEMPERATURE, model.getTemperatureModel3().getTemperature());

        this.spinner1 = new JSpinner(new SpinnerNumberModel(MIN_TEMPERATURE, MIN_TEMPERATURE, MAX_TEMPERATURE, 1));
        this.spinner1.setBorder(new EmptyBorder(0, 5, 0, 10));
        this.spinner1.setValue(model.getTemperatureModel1().getTemperature());

        this.spinner2 = new JSpinner(new SpinnerNumberModel(MIN_TEMPERATURE, MIN_TEMPERATURE, MAX_TEMPERATURE, 1));
        this.spinner2.setBorder(new EmptyBorder(0, 5, 0, 10));
        this.spinner2.setValue(model.getTemperatureModel2().getTemperature());

        this.spinner3 = new JSpinner(new SpinnerNumberModel(MIN_TEMPERATURE, MIN_TEMPERATURE, MAX_TEMPERATURE, 1));
        this.spinner3.setBorder(new EmptyBorder(0, 5, 0, 10));
        this.spinner3.setValue(model.getTemperatureModel3().getTemperature());

        var label1 = new JLabel("Kitchen", SwingConstants.CENTER);
        label1.setBorder(new EmptyBorder(10, 0, 5, 0));

        var label2 = new JLabel("Office", SwingConstants.CENTER);
        label2.setBorder(new EmptyBorder(10, 0, 5, 0));

        var label3 = new JLabel("Bedroom", SwingConstants.CENTER);
        label3.setBorder(new EmptyBorder(10, 0, 5, 0));

        var sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(3, 4));

        sliderPanel.add(label1);
        sliderPanel.add(label2);
        sliderPanel.add(label3);

        sliderPanel.add(this.slider1);
        sliderPanel.add(this.slider2);
        sliderPanel.add(this.slider3);

        sliderPanel.add(this.spinner1);
        sliderPanel.add(this.spinner2);
        sliderPanel.add(this.spinner3);

        getCenterPanel().add(sliderPanel, BorderLayout.NORTH);
    }
}
