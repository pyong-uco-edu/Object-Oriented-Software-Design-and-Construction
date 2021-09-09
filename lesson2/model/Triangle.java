package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Triangle {
    public class Pos {
        public int x;
        public int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private Pos[] p = new Pos[3];
    private Color color = Color.white;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setPos(int index, int x, int y) {
        assert (0 <= index && index <= 2);
        p[index] = new Pos(x, y);
    }

    public void render(Graphics2D g2) {
        g2.setColor(color);

        if (p[0] == null && p[1] == null && p[2] == null) {
            return;
        } else if (p[1] == null && p[2] == null) {
            g2.fillOval(p[0].x, p[0].y, 4, 4);
        } else if (p[2] == null) {
            g2.drawLine(p[0].x, p[0].y, p[1].x, p[1].y);
        } else {
            g2.drawLine(p[0].x, p[0].y, p[1].x, p[1].y);
            g2.drawLine(p[1].x, p[1].y, p[2].x, p[2].y);
            g2.drawLine(p[0].x, p[0].y, p[2].x, p[2].y);
        }
    }
}
