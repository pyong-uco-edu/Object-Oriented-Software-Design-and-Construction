package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Circle;
import model.Rectangle;
import model.Shape;
import view.MenuScreen;
import view.ShapePanel;

public class ShapeEventListener implements ActionListener {
    private ShapePanel panel;

    public ShapeEventListener(ShapePanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getExitButton()) {
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        } else if (button == panel.getRandomShapeButton()) {
            ArrayList<Shape> shapes = panel.getCanvas().getShapes();
            shapes.clear();

            Random random = new Random();
            for (int i = 0; i < 200; i++) {
                int r = random.nextInt(155) + 100;
                int g = random.nextInt(155) + 100;
                int b = random.nextInt(155) + 100;
                Color c = new Color(r, g, b);
                shapes.add(new Circle(random.nextInt(500), random.nextInt(500), c, 25));
                shapes.add(new Rectangle(random.nextInt(500), random.nextInt(500), c, 25, 25));
            }
            panel.getCanvas().repaint();
        }
    }

}
