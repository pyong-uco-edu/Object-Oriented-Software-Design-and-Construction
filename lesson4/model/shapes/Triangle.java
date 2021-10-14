package model.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

public class Triangle extends Shape implements IShapeDraw {
    private int side;
    private Color color;
    private boolean filled;

    public Triangle(int x, int y, int side, Color color, boolean filled) {
        super(x, y);
        this.side = side;
        this.color = color;
        this.filled = filled;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(color);

        int xs[] = new int[3];
        int ys[] = new int[3];
        int x = getX();
        int y = getY();
        xs[0] = x;
        ys[0] = y;
        xs[1] = x + side;
        ys[1] = y;
        xs[2] = x;
        ys[2] = y + side;

        if (filled) {
            g2.fillPolygon(xs, ys, xs.length);
        } else {
            g2.drawPolygon(xs, ys, xs.length);
        }
    }
    
}
