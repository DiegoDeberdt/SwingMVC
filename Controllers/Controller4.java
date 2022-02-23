package Controllers;

import Models.Enums.Direction;
import Models.Model4;
import Models.Enums.Weather;
import Views.View4.View4In;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class Controller4 {
    public Controller4(View4In view, Model4 model) {

        view.leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.setDirection(Direction.RIGHT_TO_LEFT);
            }
        });

        view.rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.setDirection(Direction.LEFT_TO_RIGHT);
            }
        });

        view.walkingSpeed.addActionListener(e -> model.setWalkingSpeed((String)view.walkingSpeed.getSelectedItem()));

        view.sliderWalkingSpeed.addChangeListener(e -> {
            int v = ((JSlider)e.getSource()).getValue();
            model.setWalkingSpeed(v);
        });

        var listenerWeather = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JRadioButton rb = (JRadioButton) e.getSource();
                if (rb.isSelected()) {
                    if (rb == view.rbSunny) model.setWeather(Weather.SUNNY);
                    if (rb == view.rbRain) model.setWeather(Weather.RAIN);
                }
            }
        };

        view.rbSunny.addActionListener(listenerWeather);
        view.rbRain.addActionListener(listenerWeather);
    }
}
