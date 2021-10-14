package model.idemo;

import java.awt.Color;
import java.awt.Graphics2D;

public class Car extends Vehicle {
    private String type;

    public Car(int x, int y, String make, double price, String type) {
        super(x, y, make, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[Car] " + super.toString() + ", type = " + type; 
    }

    @Override
    public String getSound() {
        return "[Car] Vroom";
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(getImage(), null, getX(), getY());
        g2.setColor(Color.red);
        g2.drawString("type=" + type, getX(), getY());
    }
}
