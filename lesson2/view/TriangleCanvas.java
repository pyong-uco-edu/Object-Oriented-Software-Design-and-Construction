package view;

import javax.swing.JPanel;

import model.Triangle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class TriangleCanvas extends JPanel {
    private TriangleDrawingPanel panel;
    private ArrayList<Triangle> shapes = new ArrayList<>();

    public TriangleCanvas(TriangleDrawingPanel panel) {
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

    public ArrayList<Triangle> getShapes() {
        return shapes;
    }
}
