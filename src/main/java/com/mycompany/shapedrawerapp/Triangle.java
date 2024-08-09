package com.mycompany.shapedrawerapp;

import java.awt.*;

public class Triangle implements Shape {
    private int base;
    private int height;
    private Color color;

    public Triangle(int base, int height, Color color) {
        this.base = base;
        this.height = height;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d, int panelWidth, int panelHeight) {
        g2d.setColor(color);
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        xPoints[0] = (panelWidth - base) / 2;
        xPoints[1] = panelWidth / 2;
        xPoints[2] = (panelWidth + base) / 2;

        yPoints[0] = (panelHeight + height) / 2;
        yPoints[1] = (panelHeight - height) / 2;
        yPoints[2] = (panelHeight + height) / 2;

        g2d.drawPolygon(xPoints, yPoints, 3);
    }

    @Override
    public Color getColor() {
        return color;
    }
}