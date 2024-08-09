package com.mycompany.shapedrawerapp;

import java.awt.*;

public class Circle implements Shape {
    private int diameter;
    private Color color;

    public Circle(int diameter, Color color) {
        this.diameter = diameter;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d, int panelWidth, int panelHeight) {
        g2d.setColor(color);
        int x = (panelWidth - diameter) / 2;
        int y = (panelHeight - diameter) / 2;
        g2d.drawOval(x, y, diameter, diameter);
    }

    @Override
    public Color getColor() {
        return color;
    }
}