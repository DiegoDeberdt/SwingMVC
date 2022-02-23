package Views.View2;

import Models.Model2;
import Models.ModelChangedListener;
import Views.BaseViewOut;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View2Out extends BaseViewOut implements ModelChangedListener {

    private JPanel outerPanel1;
    private JPanel innerPanel;
    private JPanel outerPanel2;

    private FlowLayout flagLayout;

    private int configuration = 0;

    public View2Out(Model2 model){

        super();

        model.addModelChangedListener(this);

        this.flagLayout = new FlowLayout();
        this.flagLayout.setVgap(0);
        this.flagLayout.setHgap(0);
        getCenterPanel().setLayout(this.flagLayout);

        this.outerPanel1 = new JPanel();
        getCenterPanel().add(outerPanel1);

        this.innerPanel = new JPanel();
        getCenterPanel().add(innerPanel);

        this.outerPanel2 = new JPanel();
        getCenterPanel().add(outerPanel2);

        getCenterPanel().setBorder(new EmptyBorder(100, 10, 10, 10));

        model.setFlipOrientationFlag();
    }

    public void onModelChanged(Object source) {
        var model = (Model2) source;

        if (model.isFlipOrientationFlagSet()) {
            if (++configuration > 4) this.configuration = 1;
        }

        if (this.configuration % 2 == 0) {
            this.outerPanel1.setPreferredSize(new Dimension(180, 60));
            this.innerPanel.setPreferredSize(new Dimension(180, 60));
            this.outerPanel2.setPreferredSize(new Dimension(180, 60));
        }
        else {
            outerPanel1.setPreferredSize(new Dimension(60, 180));
            innerPanel.setPreferredSize(new Dimension(60, 180));
            outerPanel2.setPreferredSize(new Dimension(60, 180));
        }

        if (this.configuration == 1 || this.configuration == 2) {
            outerPanel1.setBackground(model.getColor1());
            innerPanel.setBackground(model.getColor2());
            outerPanel2.setBackground(model.getColor3());
        }
        else {
            outerPanel1.setBackground(model.getColor3());
            innerPanel.setBackground(model.getColor2());
            outerPanel2.setBackground(model.getColor1());
        }

        getCenterPanel().updateUI();
        model.resetFlipOrientationFlag();
    }
}
