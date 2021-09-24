package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Shape {
    public enum ShapeType {
        SQUARE, CIRCLE, TRIANGLE;
    }

    private int x;
    private int y;
    private int size;
    private Color color;
    private ShapeType type;

    public Shape(int x, int y, int size, Color color, ShapeType type) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.type = type;
    }

    public void render(Graphics2D g2) {
        g2.setColor(color);

        switch (type) {
            case SQUARE:
                g2.drawLine(x - (size / 2), y - (size / 2), x + (size / 2), y - (size / 2));
                g2.drawLine(x + (size / 2), y + (size / 2), x + (size / 2), y - (size / 2));
                g2.drawLine(x + (size / 2), y + (size / 2), x - (size / 2), y + (size / 2));
                g2.drawLine(x - (size / 2), y - (size / 2), x - (size / 2), y + (size / 2));
                break;
            case CIRCLE:
                g2.fillOval(x - (size / 2), y - (size / 2), size, size);
                break;
            case TRIANGLE:
                g2.drawLine(x, y - (size / 2), x + (size / 2), y + (size / 2));
                g2.drawLine(x, y - (size / 2), x - (size / 2), y + (size / 2));
                g2.drawLine(x + (size / 2), y + (size / 2), x - (size / 2), y + (size / 2));
                break;
            default:
                return;
        }
    }
}
