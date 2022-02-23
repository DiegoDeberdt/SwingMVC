package Views.View1;

import Models.Model1;
import Models.ModelChangedListener;
import Views.BaseViewIn;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View1In extends BaseViewIn implements ModelChangedListener {

    public JSlider sliderRotationSpeed = null;
    public JTextField textRotationSpeed = null;
    public JTextField message = null;
    public JCheckBox warpSpeed = null;

    public View1In(Model1 model) {

        super();

        model.addModelChangedListener(this);

        var panel = new JPanel(new GridLayout(3, 1));

        // Message
        var messagePanel = new JPanel(new BorderLayout());
        messagePanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Message"), new EmptyBorder(3, 5, 3, 5)));
        this.message = new JTextField(model.getMessage());
        messagePanel.add(this.message, BorderLayout.CENTER);

        // Rotation speed (slider)
        var speedPanel = new JPanel(new BorderLayout());
        speedPanel.setBorder(BorderFactory.createTitledBorder("Rotation Speed"));
        this.sliderRotationSpeed = new JSlider(0, 10, model.getRotationSpeed());
        this.sliderRotationSpeed.setPaintTicks(true);
        this.sliderRotationSpeed.setMajorTickSpacing(5);
        this.sliderRotationSpeed.setMinorTickSpacing(1);

        speedPanel.add(this.sliderRotationSpeed, BorderLayout.CENTER);

        // Rotation speed (text)
        textRotationSpeed = new JTextField(String.valueOf(model.getRotationSpeed()));
        textRotationSpeed.setHorizontalAlignment(SwingConstants.CENTER);
        textRotationSpeed.setPreferredSize(new Dimension(30, 25));

        speedPanel.add(textRotationSpeed, BorderLayout.EAST);

        // Warp speed
        this.warpSpeed = new JCheckBox("Enable Warp Speed");
        this.warpSpeed.setSelected(model.isWarpSpeedEnabled());

        panel.add(messagePanel);
        panel.add(speedPanel);
        panel.add(warpSpeed);

        getCenterPanel().add(panel, BorderLayout.NORTH);
    }

    @Override
    public void onModelChanged(Object source) {
        var model = (Model1)source;
        this.textRotationSpeed.setText(String.valueOf(model.getRotationSpeed()));
        this.sliderRotationSpeed.setValue(model.getRotationSpeed());
    }
}
