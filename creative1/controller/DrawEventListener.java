package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Color;

import model.Shape;
import view.MainScreen;

public class DrawEventListener implements ActionListener, MouseListener {
    private MainScreen panel;
    private Shape.ShapeType type = Shape.ShapeType.SQUARE;
    private Color color = Color.RED;
    private int size = 10;

    public DrawEventListener(MainScreen panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == panel.getSquareButton()) {
            type = Shape.ShapeType.SQUARE;
        } else if (source == panel.getCircleButton()) {
            type = Shape.ShapeType.CIRCLE;
        } else if (source == panel.getTriangleButton()) {
            type = Shape.ShapeType.TRIANGLE;
        } else if (source == panel.getRedButton()) {
            color = Color.RED;
        } else if (source == panel.getGreenButton()) {
            color = Color.GREEN;
        } else if (source == panel.getBlueButton()) {
            color = Color.BLUE;
        } else if (source == panel.getSmallButton()) {
            size = 10;
        } else if (source == panel.getMediumButton()) {
            size = 20;
        } else if (source == panel.getLargeButton()) {
            size = 30;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Shape shape = new Shape(e.getX(), e.getY(), size, color, type);
        panel.getCanvas().getShapes().add(shape);
        panel.getCanvas().repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
