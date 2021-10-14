package model.idemo;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;

public abstract class Vehicle implements ISound, IRender {
    private int x, y;
    private String make;
    private double price;
    private BufferedImage image;

    public Vehicle(int x, int y, String make, double price) {
        this.x = x;
        this.y = y;
        this.make = make;
        this.price = price;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getMake() {
        return make;
    }

    public double getPrice() {
        return price;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Vehicle at  (" + x + ", " + y + ") " + make + " $" + price;
    }

    @Override
    public Rectangle getBoundingBox() {
        return new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    @Override
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
