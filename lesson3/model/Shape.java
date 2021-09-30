package model;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape {
    private float x, y;
    private Color color;

    public Shape(float x, float y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "[Shape: (" + x + ", " + y + ", area = " + getArea() + ")]";
    }

    public abstract float getArea();

    public abstract void render(Graphics2D g2);
}
