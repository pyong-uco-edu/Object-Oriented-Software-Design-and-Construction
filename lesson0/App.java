package lesson0;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.Container;

public class App {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 300);
        window.setLocation(400, 200);

        Container cp = window.getContentPane();
        JPanel panel = new JPanel();
        panel.add(new JTextField("Hello World!"));
        panel.add(new JButton("Click on Me!"));
        panel.add(new JButton("Sign Up"));
        panel.add(new JTextField("Java World!"));
        cp.add(panel);

        window.pack();
        window.setVisible(true);
    }
}
