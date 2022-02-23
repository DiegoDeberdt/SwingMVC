package Controllers;

import Models.Model1;
import Views.View1.View1In;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class Controller1 {

    public Controller1(View1In view, Model1 model) {

        view.sliderRotationSpeed.addChangeListener(e -> model.setRotationSpeed(((JSlider)e.getSource()).getValue()));

        view.textRotationSpeed.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    view.sliderRotationSpeed.requestFocus();
                }
            }
        });

        view.textRotationSpeed.addFocusListener(new FocusListener() {

            int oldValue;

            @Override
            public void focusGained(FocusEvent e) {
                this.oldValue = Integer.valueOf(((JTextField)e.getSource()).getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    int newValue = Integer.valueOf(((JTextField)e.getSource()).getText());
                    if (newValue < 0 || newValue > 10) throw new Exception();
                    model.setRotationSpeed(newValue);
                } catch (Exception ex) {
                    model.setRotationSpeed(oldValue);
                }
            }
        });

        view.message.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            model.setMessage(view.message.getText());
            }
        });

        view.warpSpeed.addChangeListener(e -> model.setWarpSpeedFlag(((JCheckBox)e.getSource()).isSelected()));
    }
}
