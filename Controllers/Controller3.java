package Controllers;

import Models.Model3;
import Views.View3.View3In;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller3 {
    public Controller3(View3In view, Model3 model){

        view.slider1.addChangeListener(e -> {
            int v = ((JSlider)e.getSource()).getValue();
            model.getTemperatureModel1().setTemperature(v);
        });

        view.slider2.addChangeListener(e -> {
            int v = ((JSlider)e.getSource()).getValue();
            model.getTemperatureModel2().setTemperature(v);
        });

        view.slider3.addChangeListener(e -> {
            int v = ((JSlider)e.getSource()).getValue();
            model.getTemperatureModel3().setTemperature(v);
        });

        view.spinner1.addChangeListener(e -> {
            int v = (int)((JSpinner)e.getSource()).getValue();
            model.getTemperatureModel1().setTemperature(v);
        });

        view.spinner2.addChangeListener(e -> {
            int v = (int)((JSpinner)e.getSource()).getValue();
            model.getTemperatureModel2().setTemperature(v);
        });

        view.spinner3.addChangeListener(e -> {
            int v = (int)((JSpinner)e.getSource()).getValue();
            model.getTemperatureModel3().setTemperature(v);
        });
    }
}
