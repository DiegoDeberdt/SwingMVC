package Views.View2;

import Models.Model2;
import Models.ModelChangedListener;
import Views.BaseViewIn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Locale;

public class View2In extends BaseViewIn implements ModelChangedListener {

    public JTextField textColor1 = null;
    public JTextField textColor2 = null;
    public JTextField textColor3 = null;

    public JSlider sliderColor1Red = null;
    public JSlider sliderColor1Green = null;
    public JSlider sliderColor1Blue = null;

    public JSlider sliderColor2Red = null;
    public JSlider sliderColor2Green = null;
    public JSlider sliderColor2Blue = null;

    public JSlider sliderColor3Red = null;
    public JSlider sliderColor3Green = null;
    public JSlider sliderColor3Blue = null;

    public JButton orientationButton = null;

    public View2In(Model2 model){

        super();

        model.addModelChangedListener(this);

        var textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2, 3, 15, 0));

        var labelRed = new JLabel("Color-1");
        var labelGreen = new JLabel("Color-2");
        var labelBlue = new JLabel("Color-3");

        labelRed.setHorizontalAlignment(JLabel.CENTER);
        labelGreen.setHorizontalAlignment(JLabel.CENTER);
        labelBlue.setHorizontalAlignment(JLabel.CENTER);

        this.textColor1 = new JTextField();
        this.textColor1.setHorizontalAlignment(SwingConstants.CENTER);
        this.textColor2 = new JTextField();
        this.textColor2.setHorizontalAlignment(SwingConstants.CENTER);
        this.textColor3 = new JTextField();
        this.textColor3.setHorizontalAlignment(SwingConstants.CENTER);

        textPanel.add(labelRed);
        textPanel.add(labelGreen);
        textPanel.add(labelBlue);
        textPanel.add(this.textColor1);
        textPanel.add(this.textColor2);
        textPanel.add(this.textColor3);

        var sliderPanel1 = new JPanel(new GridLayout(1, 3));
        sliderPanel1.setBorder(new EmptyBorder(10, 10, 10, 10));

        var sliderPanel2 = new JPanel(new GridLayout(1, 3));
        sliderPanel2.setBorder(new EmptyBorder(10, 10, 10, 10));

        var sliderPanel3 = new JPanel(new GridLayout(1, 3));
        sliderPanel3.setBorder(new EmptyBorder(10, 10, 10, 10));

        this.sliderColor1Red = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        this.sliderColor1Green = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        this.sliderColor1Blue = new JSlider(JSlider.VERTICAL, 0, 255, 0);

        this.sliderColor2Red = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        this.sliderColor2Green = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        this.sliderColor2Blue = new JSlider(JSlider.VERTICAL, 0, 255, 0);

        this.sliderColor3Red = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        this.sliderColor3Green = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        this.sliderColor3Blue = new JSlider(JSlider.VERTICAL, 0, 255, 0);

        sliderPanel1.add(this.sliderColor1Red);
        sliderPanel1.add(this.sliderColor1Green);
        sliderPanel1.add(this.sliderColor1Blue);

        sliderPanel2.add(this.sliderColor2Red);
        sliderPanel2.add(this.sliderColor2Green);
        sliderPanel2.add(this.sliderColor2Blue);

        sliderPanel3.add(this.sliderColor3Red);
        sliderPanel3.add(this.sliderColor3Green);
        sliderPanel3.add(this.sliderColor3Blue);

        var sliderPanel = new JPanel(new GridLayout(1, 3));
        sliderPanel.add(sliderPanel1);
        sliderPanel.add(sliderPanel2);
        sliderPanel.add(sliderPanel3);

        var rgbTextPanel = new JPanel(new GridLayout(1, 3));
        rgbTextPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        rgbTextPanel.add(new JLabel("R G B", SwingConstants.CENTER));
        rgbTextPanel.add(new JLabel("R G B", SwingConstants.CENTER));
        rgbTextPanel.add(new JLabel("R G B", SwingConstants.CENTER));

        var centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(sliderPanel, BorderLayout.CENTER);
        centerPanel.add(rgbTextPanel, BorderLayout.SOUTH);

        getCenterPanel().add(textPanel, BorderLayout.NORTH);
        getCenterPanel().add(centerPanel, BorderLayout.CENTER);

        this.orientationButton = new JButton("Clockwise Rotation");
        getCenterPanel().add(orientationButton, BorderLayout.SOUTH);

        this.textColor1.setText(model.getColor1AsHex());
        this.textColor2.setText(model.getColor2AsHex());
        this.textColor3.setText(model.getColor3AsHex());

        initSliderColor1(model.getColor1());
        initSliderColor2(model.getColor2());
        initSliderColor3(model.getColor3());
    }

    @Override
    public void onModelChanged(Object source) {

        var model = (Model2)source;

        this.textColor1.setText(model.getColor1AsHex());
        this.textColor2.setText(model.getColor2AsHex());
        this.textColor3.setText(model.getColor3AsHex());

        initSliderColor1(model.getColor1());
        initSliderColor2(model.getColor2());
        initSliderColor3(model.getColor3());
    }

    private void initSliderColor1(Color c) {
        this.sliderColor1Red.setValue(c.getRed());
        this.sliderColor1Green.setValue(c.getGreen());
        this.sliderColor1Blue.setValue(c.getBlue());
    }

    private void initSliderColor2(Color c) {
        this.sliderColor2Red.setValue(c.getRed());
        this.sliderColor2Green.setValue(c.getGreen());
        this.sliderColor2Blue.setValue(c.getBlue());
    }

    private void initSliderColor3(Color c) {
        sliderColor3Red.setValue(c.getRed());
        sliderColor3Green.setValue(c.getGreen());
        sliderColor3Blue.setValue(c.getBlue());
    }
}
