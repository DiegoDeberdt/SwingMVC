package Views.View4;

import Models.Model4;
import Models.ModelChangedListener;
import Views.BaseViewIn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View4In extends BaseViewIn implements ModelChangedListener {

    public JButton leftButton = null;
    public JButton rightButton = null;
    public JComboBox<String> walkingSpeed = null;
    public JSlider sliderWalkingSpeed = null;
    public JRadioButton rbSunny = null;
    public JRadioButton rbRain = null;

    public View4In(Model4 model) {

        super();

        model.addModelChangedListener(this);

        var mainPanel = new JPanel(new GridLayout(3, 1));

        var buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Direction"));
        this.leftButton = new JButton("Walk Left");
        this.rightButton = new JButton("Walk Right");
        buttonPanel.add(this.leftButton);
        buttonPanel.add(this.rightButton);

        mainPanel.add(buttonPanel);

        var walkingSpeedPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.add(walkingSpeedPanel);
        walkingSpeedPanel.setBorder(BorderFactory.createTitledBorder("Walking Speed"));

        this.walkingSpeed = new JComboBox<String>();
        this.walkingSpeed.addItem("Slow");
        this.walkingSpeed.addItem("Moderate");
        this.walkingSpeed.addItem("Fast");
        walkingSpeedPanel.add(this.walkingSpeed);

        this.sliderWalkingSpeed = new JSlider(SwingConstants.HORIZONTAL, 1, 3, model.getWalkingSpeed());
        this.sliderWalkingSpeed.setMajorTickSpacing(1);
        this.sliderWalkingSpeed.setPaintTicks(true);
        walkingSpeedPanel.add(this.sliderWalkingSpeed);

        this.rbSunny = new JRadioButton("Sunny");
        this.rbRain = new JRadioButton("Rain");

        var weatherRbPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        weatherRbPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Weather"), new EmptyBorder(0, 0, 0, 0)));
        weatherRbPanel.add(this.rbSunny);
        weatherRbPanel.add(this.rbRain);

        mainPanel.add(weatherRbPanel);

        var weatherGroup = new ButtonGroup();
        weatherGroup.add(this.rbSunny);
        weatherGroup.add(this.rbRain);

        getCenterPanel().add(mainPanel, BorderLayout.NORTH);

        this.walkingSpeed.setSelectedItem(model.getWalkingSpeedName());
        this.rbSunny.setSelected(true);
    }

    @Override
    public void onModelChanged(Object source) {
        var model = (Model4)source;
        this.sliderWalkingSpeed.setValue(model.getWalkingSpeed());
        this.walkingSpeed.setSelectedItem(model.getWalkingSpeedName());
    }
}
