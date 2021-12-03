package model.builderPattern;

import java.awt.Color;

public class Bomb {
    private Color color;
    private String type;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bomb[" + color + ", " + type + "]";
    }
}
