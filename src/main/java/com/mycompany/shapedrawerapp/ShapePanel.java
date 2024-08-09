package com.mycompany.shapedrawerapp;

import javax.swing.*;
import java.awt.*;

public class ShapePanel extends JPanel {
    private Shape currentShape;

    public ShapePanel() {
        setBackground(Color.WHITE);
    }

    public void setShape(Shape shape) {
        this.currentShape = shape;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentShape != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            currentShape.draw(g2d, getWidth(), getHeight());
        }
    }
}