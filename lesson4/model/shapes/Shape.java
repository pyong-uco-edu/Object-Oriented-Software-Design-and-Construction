package model.shapes;

public abstract class Shape {
    private int x, y;
    
    public Shape() {
        this(0, 0);
    }

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
