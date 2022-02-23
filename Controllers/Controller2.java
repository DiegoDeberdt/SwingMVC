package Controllers;

import Models.Model2;
import Views.View2.View2In;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;

public class Controller2 {

    public Controller2(View2In view, Model2 model) {

        var sliderListenerColor1 = new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setColor1(getColor1(view));
            }
        };

        view.sliderColor1Red.addChangeListener(sliderListenerColor1);
        view.sliderColor1Green.addChangeListener(sliderListenerColor1);
        view.sliderColor1Blue.addChangeListener(sliderListenerColor1);

        var sliderListenerColor2 = new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setColor2(getColor2(view));
            }
        };

        view.sliderColor2Red.addChangeListener(sliderListenerColor2);
        view.sliderColor2Green.addChangeListener(sliderListenerColor2);
        view.sliderColor2Blue.addChangeListener(sliderListenerColor2);

        var sliderListenerColor3 = new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setColor3(getColor3(view));
            }
        };

        view.sliderColor3Red.addChangeListener(sliderListenerColor3);
        view.sliderColor3Green.addChangeListener(sliderListenerColor3);
        view.sliderColor3Blue.addChangeListener(sliderListenerColor3);

        view.textColor1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                view.sliderColor1Red.requestFocus();
            }
            }
        });

        view.textColor1.addFocusListener(new FocusListener() {

            Color oldValue;

            @Override
            public void focusGained(FocusEvent e) {
                oldValue = Color.decode("#" + ((JTextField)e.getSource()).getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Color newValue = Color.decode("#" + ((JTextField)e.getSource()).getText());
                    model.setColor1(newValue);
                } catch (Exception ex) {
                    model.setColor1(oldValue);
                }
            }
        });

        view.textColor2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    view.sliderColor2Red.requestFocus();
                }
            }
        });

        view.textColor2.addFocusListener(new FocusListener() {

            Color oldValue;

            @Override
            public void focusGained(FocusEvent e) {
                oldValue = Color.decode("#" + ((JTextField)e.getSource()).getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Color newValue = Color.decode("#" + ((JTextField)e.getSource()).getText());
                    model.setColor2(newValue);
                } catch (Exception ex) {
                    model.setColor2(oldValue);
                }
            }
        });

        view.textColor3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    view.sliderColor3Red.requestFocus();
                }
            }
        });

        view.textColor3.addFocusListener(new FocusListener() {

            Color oldValue;

            @Override
            public void focusGained(FocusEvent e) {
                oldValue = Color.decode("#" + ((JTextField)e.getSource()).getText());
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    Color newValue = Color.decode("#" + ((JTextField)e.getSource()).getText());
                    model.setColor3(newValue);
                } catch (Exception ex) {
                    model.setColor3(oldValue);
                }
            }
        });

        view.orientationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                model.setFlipOrientationFlag();
            }
        });
    }

    private Color getColor1(View2In view) {
        int r = view.sliderColor1Red.getValue();
        int g = view.sliderColor1Green.getValue();
        int b = view.sliderColor1Blue.getValue();
        return new Color(r, g, b);
    }

    private Color getColor2(View2In view) {
        int r = view.sliderColor2Red.getValue();
        int g = view.sliderColor2Green.getValue();
        int b = view.sliderColor2Blue.getValue();
        return new Color(r, g, b);
    }

    private Color getColor3(View2In view) {
        int r = view.sliderColor3Red.getValue();
        int g = view.sliderColor3Green.getValue();
        int b = view.sliderColor3Blue.getValue();
        return new Color(r, g, b);
    }
}
