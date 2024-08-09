package com.mycompany.shapedrawerapp;

import java.awt.*;

public interface Shape {
    void draw(Graphics2D g2d, int panelWidth, int panelHeight);

    Color getColor();
}