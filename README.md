# Shape Drawer Application

## Overview

The Shape Drawer Application is a Java-based desktop program that allows users to draw various shapes with customizable dimensions and colors. This interactive tool provides a user-friendly interface for creating and visualizing simple geometric shapes.

## Features

- Draw multiple shapes: Rectangle, Square, Circle, and Triangle
- Real-time shape preview
- Customizable shape dimensions using sliders
- Color selection for shapes
- Centered shape display in both preview and main drawing areas

## Technical Details

- Language: Java
- GUI Framework: Swing
- Build Tool: Maven

## Project Structure

```
ShapeDrawerApp/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── mycompany/
│                   └── shapedrawerapp/
│                       ├── ShapeDrawerApp.java
│                       ├── ShapePanel.java
│                       ├── Shape.java
│                       ├── Rectangle.java
│                       ├── Square.java
│                       ├── Circle.java
│                       └── Triangle.java
└── pom.xml
```

## Classes

1. `ShapeDrawerApp`: Main application class that sets up the GUI and handles user interactions.
2. `ShapePanel`: Custom JPanel for drawing shapes.
3. `Shape`: Interface defining the common methods for all shapes.
4. `Rectangle`, `Square`, `Circle`, `Triangle`: Classes implementing the Shape interface for specific shapes.

## How to Use

1. Run the application.
2. Select a shape using the radio buttons on the right panel.
3. Adjust the shape's dimensions using the sliders.
4. Click the "Choose Color" button to select a color for your shape.
5. The preview panel will update in real-time as you make changes.
6. Click the "Draw Shape" button to finalize the shape on the main drawing area.

## Building and Running

To build and run the project:

1. Ensure you have Java JDK 8 or higher and Maven installed.
2. Navigate to the project root directory.
3. Run `mvn clean install` to build the project.
4. Run `java -jar target/shapedrawerapp-1.0-SNAPSHOT.jar` to start the application.

## Development

To further develop or modify this application:

1. Import the project into your preferred Java IDE (e.g., NetBeans, IntelliJ IDEA, Eclipse).
2. The `ShapeDrawerApp` class is the main entry point and contains the GUI setup.
3. To add new shapes:
   - Create a new class implementing the `Shape` interface.
   - Add the shape to the shape selection options in `ShapeDrawerApp`.
   - Implement the drawing logic in the new shape class.

## Future Enhancements

- Add more complex shapes (e.g., pentagon, hexagon)
- Implement shape rotation
- Allow multiple shapes on the canvas
- Add undo/redo functionality
- Implement save/load features for created drawings

## Contributing

Contributions to the Shape Drawer Application are welcome! Please feel free to submit pull requests or create issues for bugs and feature requests.

## License

This project is open source and available under the [MIT License](LICENSE).
