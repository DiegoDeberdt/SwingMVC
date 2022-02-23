package Views;

import Models.Model1;
import Views.View1.View1Out;
import Models.Model2;
import Views.View2.View2Out;
import Models.Model3;
import Models.Model4;
import Views.View3.View3Out;
import Views.View4.View4Out;
import Models.Model5;
import Views.View5.View5Out;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OutputPanel extends JPanel {

    public OutputPanel(Model1 m1, Model2 m2, Model3 m3, Model4 m4, Model5 m5) {

        setLayout(new GridLayout(1, 5));

        var p1 = new JPanel(new BorderLayout());
        var l1 = new JLabel(m1.getTitle(), SwingConstants.CENTER);
        l1.setBorder(new EmptyBorder(10, 0, 0, 0));
        p1.add(new View1Out(m1), BorderLayout.CENTER);
        p1.add(l1, BorderLayout.NORTH);
        add(p1);

        var p2 = new JPanel(new BorderLayout());
        var l2 = new JLabel(m2.getTitle(), SwingConstants.CENTER);
        l2.setBorder(new EmptyBorder(10, 0, 0, 0));
        p2.add(new View2Out(m2), BorderLayout.CENTER);
        p2.add(l2, BorderLayout.NORTH);
        add(p2);

        var p3 = new JPanel(new BorderLayout());
        var l3 = new JLabel(m3.getTitle(), SwingConstants.CENTER);
        l3.setBorder(new EmptyBorder(10, 0, 0, 0));
        p3.add(new View3Out(m3), BorderLayout.CENTER);
        p3.add(l3, BorderLayout.NORTH);

        var p4 = new JPanel(new BorderLayout());
        var l4 = new JLabel(m4.getTitle(), SwingConstants.CENTER);
        l4.setBorder(new EmptyBorder(10, 0, 0, 0));
        p4.add(new View4Out(m4), BorderLayout.CENTER);
        p4.add(l4, BorderLayout.NORTH);

        add(p4);
        add(p3);

        var p5 = new JPanel(new BorderLayout());
        var l5 = new JLabel(m5.getTitle(), SwingConstants.CENTER);
        l5.setBorder(new EmptyBorder(10, 0, 0, 0));
        p5.add(new View5Out(m5), BorderLayout.CENTER);
        p5.add(l5, BorderLayout.NORTH);
        add(p5);
    }
}
