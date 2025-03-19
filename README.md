# SwingMVC Java Program

## Overview

This Java program is a Swing-based GUI application developed as a project for the University of Luxembourg. The application follows the Model-View-Controller (MVC) design pattern and includes multiple models, views, and controllers.

[![Watch the demo](screenshot.png)](https://youtu.be/ePQbzIJmA2A)

## Main Components

### Main Class

The `Main` class extends `JFrame` and serves as the entry point for the application. It initializes the main window and sets up the various models, views, and controllers.

```java
import Controllers.*;
import Views.InputPanel;
import Views.OutputPanel;
import Models.Model1;
import Models.Model2;
import Models.Model3;
import Models.Model4;
import Models.Model5;
import Views.View1.View1In;
import Views.View2.View2In;
import Views.View3.View3In;
import Views.View4.View4In;
import Views.View5.View5In;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var frame = new Main();
            frame.setVisible(true);
        });
    }

    public Main() {
        super("University of Luxembourg - 2021/2022 - GUI Project - D. Deberdt");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var m1 = new Model1("A Message From Interstellar Space");
        var v1 = new View1In(m1);
        var c1 = new Controller1(v1, m1);

        var m2 = new Model2("Flag Design");
        var v2 = new View2In(m2);
        var c2 = new Controller2(v2, m2);

        var m3 = new Model3("Thermostat");
        var v3 = new View3In(m3);
        var c3 = new Controller3(v3, m3);

        var m4 = new Model4("Infinite Walk");
        var v4 = new View4In(m4);
        var c4 = new Controller4(v4, m4);

        var m5 = new Model5("Bubbles and Snow");
        var v5 = new View5In(m5);
        var c5 = new Controller5(v5, m5);

        setLayout(new BorderLayout());

        var inputPanel = new InputPanel(v1, v2, v3, v4, v5);
        var outputPanel = new OutputPanel(m1, m2, m3, m4, m5);

        add(outputPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        pack();
    }
}
