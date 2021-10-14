package view;

import javax.swing.JPanel;

import model.shapes.IShapeDraw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class DrawingDemoCanvas extends JPanel {
    private DrawingDemoPanel panel;
    private ArrayList<IShapeDraw> shapes = new ArrayList<>();
    private int singleStepIndex = -1;

    public DrawingDemoCanvas(DrawingDemoPanel panel) {
        this.panel = panel;
        setBackground(Color.black);
        setPreferredSize(new Dimension(500, 400));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (singleStepIndex >= 0) {
            for (int i = 0; i <= singleStepIndex; i++) {
                if (singleStepIndex < shapes.size())
                    shapes.get(i).render(g2);
            }
        } else {
            for (var s: shapes) {
                s.render(g2);
            }
        }
    }

    public void incrementSingleStepIndex() {
        if (shapes.size() == 0) return;

        ++singleStepIndex;
        if (singleStepIndex == shapes.size()) {
            singleStepIndex = 0;
        }
    }

    public ArrayList<IShapeDraw> getShapes() {
        return shapes;
    }

    public void setSingleStepIndex(int singleStepIndex) {
        this.singleStepIndex = singleStepIndex;
    }
}
