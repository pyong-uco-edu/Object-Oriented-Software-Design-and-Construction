package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Dimension;

public class MenuScreen {
    private JFrame window;

    public MenuScreen(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2, 1));
        menuPanel.setPreferredSize(new Dimension(400, 200));

        JButton questionButton = new JButton("Questions classes");
        JButton shapeButton = new JButton("Shape classes");
        menuPanel.add(questionButton);
        menuPanel.add(shapeButton);

        cp.add(BorderLayout.CENTER, menuPanel);

        questionButton.addActionListener(event -> {
            window.getContentPane().removeAll();
            var panel = new QuestionPanel(window);
            panel.init();
            window.pack();
            window.revalidate();
        });

        shapeButton.addActionListener(event -> {
            window.getContentPane().removeAll();
            var panel = new ShapePanel(window);
            panel.init();
            window.pack();
            window.revalidate();
        });
    }
}
