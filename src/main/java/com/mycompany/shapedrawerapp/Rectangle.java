package com.mycompany.shapedrawerapp;

import java.awt.*;

public class Rectangle implements Shape {
    private int width;
    private int height;
    private Color color;

    public Rectangle(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d, int panelWidth, int panelHeight) {
        g2d.setColor(color);
        int x = (panelWidth - width) / 2;
        int y = (panelHeight - height) / 2;
        g2d.drawRect(x, y, width, height);
    }

    @Override
    public Color getColor() {
        return color;
    }
}