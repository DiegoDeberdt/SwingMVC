# SwingMVC Java Program

## Overview

This Java program is a Swing-based GUI application developed as a project for the University of Luxembourg. The application follows the Model-View-Controller (MVC) design pattern and includes multiple models, views, and controllers.

![GIF](animation.gif)

## Project Structure

The project is organized into several packages:

- `Controllers`: Contains the controller classes for each view.
- `Models`: Contains the model classes representing the data and business logic.
- `Views`: Contains the view classes for the GUI components.
- `Views.View1`, `Views.View2`, `Views.View3`, `Views.View4`, `Views.View5`: Contain specific view implementations for different parts of the application.

### Main Components

#### Main Class

The `Main` class extends `JFrame` and serves as the entry point for the application. It initializes the main window and sets up the various models, views, and controllers. The main window is titled "University of Luxembourg - 2021/2022 - GUI Project - D. Deberdt" and uses a `BorderLayout` to organize the components.

#### Models

The application includes five models, each representing different data and business logic:

- `Model1`: Represents a message from interstellar space.
- `Model2`: Represents a flag design.
- `Model3`: Represents a thermostat.
- `Model4`: Represents an infinite walk.
- `Model5`: Represents bubbles and snow.

#### Views

The views are responsible for displaying the data to the user. Each model has a corresponding view:

- `View1In`: Displays the data from `Model1`.
- `View2In`: Displays the data from `Model2`.
- `View3In`: Displays the data from `Model3`.
- `View4In`: Displays the data from `Model4`.
- `View5In`: Displays the data from `Model5`.

Additionally, there are input and output panels:

- `InputPanel`: Allows user interaction with the views.
- `OutputPanel`: Displays the output from the models.

#### Controllers

The controllers handle the interaction between the models and views. Each model-view pair has a corresponding controller:

- `Controller1`: Manages the interaction between `Model1` and `View1In`.
- `Controller2`: Manages the interaction between `Model2` and `View2In`.
- `Controller3`: Manages the interaction between `Model3` and `View3In`.
- `Controller4`: Manages the interaction between `Model4` and `View4In`.
- `Controller5`: Manages the interaction between `Model5` and `View5In`.

### IronManSprite Class

The `IronManSprite` class is responsible for loading and rendering the Iron Man sprite image. It uses the `ImageIO` class to read the image file and provides methods to update the sprite's position and paint it on the screen. The image file `ironman.png` is located in the `Views/View4` directory.

## Features

- **MVC Design Pattern**: The application follows the MVC design pattern, separating the data (models), user interface (views), and control logic (controllers).
- **Swing GUI**: The application uses Java Swing to create a graphical user interface.
- **Multiple Models and Views**: The application includes five different models and corresponding views, each representing different data and functionality.
- **Interactive Panels**: The input and output panels allow user interaction and display the results.
