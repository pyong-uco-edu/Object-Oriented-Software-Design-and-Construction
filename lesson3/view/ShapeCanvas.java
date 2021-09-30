package view;

import javax.swing.JPanel;

import model.Circle;
import model.Rectangle;
import model.Shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class ShapeCanvas extends JPanel {
    private ShapePanel panel;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public ShapeCanvas(ShapePanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);

        shapes.add(new Circle(50, 50, Color.yellow, 50));
        shapes.add(new Rectangle(100, 100, Color.red, 70, 90));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        for (var s : shapes) {
            s.render(g2);
        }
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }
}
