package com.mycompany.shapedrawerapp;

import java.awt.*;

public class Square implements Shape {
    private int side;
    private Color color;

    public Square(int side, Color color) {
        this.side = side;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d, int panelWidth, int panelHeight) {
        g2d.setColor(color);
        int x = (panelWidth - side) / 2;
        int y = (panelHeight - side) / 2;
        g2d.drawRect(x, y, side, side);
    }

    @Override
    public Color getColor() {
        return color;
    }
}