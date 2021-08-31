package lesson1;

import javax.swing.JFrame;

import lesson1.view.MenuScreen;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);

        // add contents in the body of the window
        var menu = new MenuScreen(window);
        menu.init();

        window.pack();
        window.setVisible(true);
    }
}
