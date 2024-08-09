package com.mycompany.shapedrawerapp;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ShapeDrawerApp extends JFrame {
    private ShapePanel shapePanel;
    private ShapePanel previewPanel;
    private JRadioButton rectangleButton, squareButton, circleButton, triangleButton;
    private JSlider slider1, slider2;
    private JLabel slider1Label, slider2Label;
    private JButton colorButton;
    private Color currentColor = Color.BLUE;

    public ShapeDrawerApp() {
        setTitle("Shape Drawer App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Main shape panel
        shapePanel = new ShapePanel();
        add(shapePanel, BorderLayout.CENTER);

        // Control panel
        JPanel controlPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Shape selection radio buttons
        ButtonGroup shapeGroup = new ButtonGroup();
        rectangleButton = new JRadioButton("Rectangle");
        squareButton = new JRadioButton("Square");
        circleButton = new JRadioButton("Circle");
        triangleButton = new JRadioButton("Triangle");

        shapeGroup.add(rectangleButton);
        shapeGroup.add(squareButton);
        shapeGroup.add(circleButton);
        shapeGroup.add(triangleButton);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        controlPanel.add(new JLabel("Select Shape:"), gbc);

        gbc.gridy++;
        controlPanel.add(rectangleButton, gbc);
        gbc.gridy++;
        controlPanel.add(squareButton, gbc);
        gbc.gridy++;
        controlPanel.add(circleButton, gbc);
        gbc.gridy++;
        controlPanel.add(triangleButton, gbc);

        // Sliders for dimensions
        slider1 = new JSlider(JSlider.HORIZONTAL, 10, 200, 100);
        slider2 = new JSlider(JSlider.HORIZONTAL, 10, 200, 100);
        slider1Label = new JLabel("Width: 100");
        slider2Label = new JLabel("Height: 100");

        gbc.gridy++;
        gbc.gridwidth = 1;
        controlPanel.add(slider1Label, gbc);
        gbc.gridx = 1;
        controlPanel.add(slider1, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        controlPanel.add(slider2Label, gbc);
        gbc.gridx = 1;
        controlPanel.add(slider2, gbc);

        // Color selection button
        colorButton = new JButton("Choose Color");
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        controlPanel.add(colorButton, gbc);

        // Preview panel
        previewPanel = new ShapePanel();
        previewPanel.setPreferredSize(new Dimension(200, 200));
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        controlPanel.add(previewPanel, gbc);

        // Draw button
        JButton drawButton = new JButton("Draw Shape");
        gbc.gridy++;
        controlPanel.add(drawButton, gbc);

        add(controlPanel, BorderLayout.EAST);

        // Add listeners
        ActionListener shapeListener = e -> updatePreview();
        rectangleButton.addActionListener(shapeListener);
        squareButton.addActionListener(shapeListener);
        circleButton.addActionListener(shapeListener);
        triangleButton.addActionListener(shapeListener);

        ChangeListener sliderListener = e -> updatePreview();
        slider1.addChangeListener(sliderListener);
        slider2.addChangeListener(sliderListener);

        colorButton.addActionListener(e -> chooseColor());
        drawButton.addActionListener(e -> drawShape());

        rectangleButton.setSelected(true);
        updatePreview();
    }

    private void updatePreview() {
        Shape shape = createCurrentShape();
        previewPanel.setShape(shape);
        previewPanel.repaint();

        // Update slider labels
        slider1Label.setText(getSlider1Label() + ": " + slider1.getValue());
        slider2Label.setText(getSlider2Label() + ": " + slider2.getValue());

        // Show/hide second slider based on shape
        slider2.setVisible(rectangleButton.isSelected() || triangleButton.isSelected());
        slider2Label.setVisible(rectangleButton.isSelected() || triangleButton.isSelected());
    }

    private void drawShape() {
        Shape shape = createCurrentShape();
        shapePanel.setShape(shape);
        shapePanel.repaint();
    }

    private Shape createCurrentShape() {
        int value1 = slider1.getValue();
        int value2 = slider2.getValue();

        if (rectangleButton.isSelected()) {
            return new Rectangle(value1, value2, currentColor);
        } else if (squareButton.isSelected()) {
            return new Square(value1, currentColor);
        } else if (circleButton.isSelected()) {
            return new Circle(value1, currentColor);
        } else if (triangleButton.isSelected()) {
            return new Triangle(value1, value2, currentColor);
        }
        return null;
    }

    private String getSlider1Label() {
        if (rectangleButton.isSelected())
            return "Width";
        if (squareButton.isSelected())
            return "Side";
        if (circleButton.isSelected())
            return "Diameter";
        if (triangleButton.isSelected())
            return "Base";
        return "Dimension 1";
    }

    private String getSlider2Label() {
        if (rectangleButton.isSelected())
            return "Height";
        if (triangleButton.isSelected())
            return "Height";
        return "Dimension 2";
    }

    private void chooseColor() {
        Color newColor = JColorChooser.showDialog(this, "Choose Shape Color", currentColor);
        if (newColor != null) {
            currentColor = newColor;
            colorButton.setBackground(currentColor);
            updatePreview();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShapeDrawerApp().setVisible(true));
    }
}