package Controllers;

import Models.Model5;
import Models.Enums.RenderTheme;
import Views.View5.View5In;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller5 {
    public Controller5(View5In view, Model5 model){

        var listenerNrOfObjects = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton rb = (JRadioButton) e.getSource();
                int v = model.numberOfObjectsMap.get(rb.getText());
                model.setNumberOfObjects(v);
            }
        };

        view.rbNrOfObjects1.addActionListener(listenerNrOfObjects);
        view.rbNrOfObjects2.addActionListener(listenerNrOfObjects);
        view.rbNrOfObjects3.addActionListener(listenerNrOfObjects);
        view.rbNrOfObjects4.addActionListener(listenerNrOfObjects);

        var listenerTheme = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton rb = (JRadioButton) e.getSource();
                if (rb.isSelected()) {
                    if (rb == view.rbTheme1) model.setRenderTheme(RenderTheme.WINTER);
                    if (rb == view.rbTheme2) model.setRenderTheme(RenderTheme.CORAL_REEF);
                }
            }
        };

        view.rbTheme1.addActionListener(listenerTheme);
        view.rbTheme2.addActionListener(listenerTheme);

        view.slider.addChangeListener(e -> {
            int v = ((JSlider)e.getSource()).getValue();
            model.setNumberOfObjects(v);
        });
    }
}
