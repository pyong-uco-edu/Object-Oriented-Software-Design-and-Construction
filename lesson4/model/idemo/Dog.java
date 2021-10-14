package model.idemo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Dog extends Animal {
    private String color;

    public Dog(int x, int y, String name, int age, String color) {
        super(x, y, name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "[Dog] " + super.toString() + ", color = " + color;
    }

    @Override
    public String getSound() {
        return "[Dog] Woof";
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(getImage(), null, getX(), getY());
        g2.setColor(Color.yellow);
        g2.drawString("color="+color, getX(), getY());
    }
}
