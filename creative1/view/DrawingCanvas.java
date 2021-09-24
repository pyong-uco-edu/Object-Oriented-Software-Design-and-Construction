package view;

import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.Shape;

public class DrawingCanvas extends JPanel {
    private MainScreen panel;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public DrawingCanvas(MainScreen panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
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
