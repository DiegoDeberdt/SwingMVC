package Views;

import Models.Model1;
import Views.View1.View1In;
import Views.View2.View2In;
import Models.Model2;
import Views.View3.View3In;
import Models.Model3;
import Views.View4.View4In;
import Models.Model4;
import Views.View5.View5In;
import Models.Model5;

import javax.swing.*;
import java.awt.*;

public class InputPanel extends JPanel {

    public InputPanel(View1In v1, View2In v2, View3In v3, View4In v4, View5In v5) {

        setLayout(new GridLayout(1, 5));

        add(v1);
        add(v2);
        add(v4);
        add(v3);
        add(v5);
    }
}
