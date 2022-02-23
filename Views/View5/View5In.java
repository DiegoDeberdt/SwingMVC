package Views.View5;

import Models.Model5;
import Models.ModelChangedListener;
import Views.BaseViewIn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View5In extends BaseViewIn implements ModelChangedListener {

    public JRadioButton rbNrOfObjects1 = null;
    public JRadioButton rbNrOfObjects2 = null;
    public JRadioButton rbNrOfObjects3 = null;
    public JRadioButton rbNrOfObjects4 = null;
    public JRadioButton rbTheme1 = null;
    public JRadioButton rbTheme2 = null;
    public JSlider slider = null;

    public View5In(Model5 model) {

        super();

        model.addModelChangedListener(this);

        var mainPanel = new JPanel(new GridLayout(2, 1));

        this.rbNrOfObjects1 = new JRadioButton("Min.");
        this.rbNrOfObjects2 = new JRadioButton("Low");
        this.rbNrOfObjects3 = new JRadioButton("High");
        this.rbNrOfObjects4 = new JRadioButton("Max.");

        this.rbTheme1 = new JRadioButton("Snow");
        this.rbTheme2 = new JRadioButton("Bubbles");

        var numberOfObjectsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        numberOfObjectsPanel.setBorder(BorderFactory.createTitledBorder("Number of Objects"));
        numberOfObjectsPanel.add(this.rbNrOfObjects1);
        numberOfObjectsPanel.add(this.rbNrOfObjects2);
        numberOfObjectsPanel.add(this.rbNrOfObjects3);
        numberOfObjectsPanel.add(this.rbNrOfObjects4);
        mainPanel.add(numberOfObjectsPanel);

        var themePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        themePanel.setBorder(BorderFactory.createTitledBorder("Theme"));
        themePanel.add(this.rbTheme1);
        themePanel.add(this.rbTheme2);
        mainPanel.add(themePanel);

        getCenterPanel().add(mainPanel, BorderLayout.CENTER);

        this.slider = new JSlider(JSlider.VERTICAL, 0, 1000, 100);
        this.slider.setPaintTicks(true);
        this.slider.setMajorTickSpacing(100);
        this.slider.setBorder(new EmptyBorder(0, 15, 0, 5));
        getCenterPanel().add(this.slider, BorderLayout.EAST);

        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(this.rbNrOfObjects1);
        buttonGroup1.add(this.rbNrOfObjects2);
        buttonGroup1.add(this.rbNrOfObjects3);
        buttonGroup1.add(this.rbNrOfObjects4);

        var buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(this.rbTheme1);
        buttonGroup2.add(this.rbTheme2);

        this.rbNrOfObjects1.setSelected(true);
        this.rbTheme1.setSelected(true);
        this.slider.setValue(250);

    }

    @Override
    public void onModelChanged(Object source) {
        var model = (Model5)source;

        int v = model.getNumberOfObjects();
        this.slider.setValue(v);

        int valRb1 = model.numberOfObjectsMap.get(this.rbNrOfObjects1.getText());
        int valRb2 = model.numberOfObjectsMap.get(this.rbNrOfObjects2.getText());
        int valRb3 = model.numberOfObjectsMap.get(this.rbNrOfObjects3.getText());
        int valRb4 = model.numberOfObjectsMap.get(this.rbNrOfObjects4.getText());

        if (v >=0 && v <= valRb1) {
            this.rbNrOfObjects1.setSelected(true);
        }
        else if (v > valRb1 && v <= valRb2) {
            this.rbNrOfObjects2.setSelected(true);
        }
        else if (v > valRb2 && v <= valRb3) {
            this.rbNrOfObjects3.setSelected(true);
        }
        else if (v > valRb3 && v <= valRb4) {
            this.rbNrOfObjects4.setSelected(true);
        }
    }
}
