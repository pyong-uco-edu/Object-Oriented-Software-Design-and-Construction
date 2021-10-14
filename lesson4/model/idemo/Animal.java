package model.idemo;

import java.awt.image.BufferedImage;

import java.awt.Rectangle;

public abstract class Animal implements ISound, IRender {
    private int x, y, age;
    private String name;
    private BufferedImage image;
    
    public Animal(int x, int y, String name, int age) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.age = age;
    }

    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Animal at (" + x + ", " + y + ") name = " + name + ", age = " + age;
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
