package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;

import javax.swing.JFrame;

import model.Triangle;
import view.MenuScreen;
import view.TriangleDrawingPanel;

public class TriangleEventListener implements ActionListener, MouseListener {

    private TriangleDrawingPanel panel;
    private Color color = Color.white;
    private int clicks = 0;
    private Triangle triangle;

    public TriangleEventListener(TriangleDrawingPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == panel.getExitButton()) {
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        } else if (source == panel.getClearButton()) {
            panel.getCanvas().getShapes().clear();
            panel.getCanvas().repaint();
        } else if (source == panel.getRedButton()) {
            color = Color.red;
        } else if (source == panel.getYellowButton()) {
            color = Color.yellow;
        } else if (source == panel.getBlueButton()) {
            color = Color.blue;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clicks++;
        switch (clicks) {
            case 1:
                triangle = new Triangle();
                triangle.setPos(0, e.getX(), e.getY());
                triangle.setColor(color);
                panel.getCanvas().getShapes().add(triangle);
                break;
            case 2:
                triangle.setPos(1, e.getX(), e.getY());
                break;
            case 3:
                triangle.setPos(2, e.getX(), e.getY());
                clicks = 0;
                break;
        }
        panel.getCanvas().repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
