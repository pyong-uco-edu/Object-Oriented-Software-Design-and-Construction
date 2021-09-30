package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle extends Shape {
    private float width, height;

    public Rectangle(float x, float y, Color color, float width, float height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public float getArea() {
        return width * height;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getColor());
        g2.drawRect((int) super.getX(), (int) super.getY(), (int) width, (int) height);
    }

    @Override
    public String toString() {
        return "[Rectangle:" + super.toString() + " w=" + width + " h=" + height + "]";
    }
}
