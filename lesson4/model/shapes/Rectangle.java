package model.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle extends Shape implements IShapeDraw {
    private int width, height;
    private Color color;
    private boolean filled;

    public Rectangle(int x, int y, int width, int height, Color color, boolean filled) {
        super(x, y);
        this.width = width;
        this.height = height;
        this.color = color;
        this.filled = filled;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);
        if (filled) {
            g2.fillRect(getX() - width/2, getY() - height/2, width, height);
        } else {
            g2.drawRect(getX() - width/2, getY() - height/2, width, height);
        }
    }
    
}
