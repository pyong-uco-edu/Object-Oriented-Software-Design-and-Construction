import javax.swing.JFrame;

import view.MainScreen;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Shape Drawer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);

        var menu = new MainScreen(window);
        menu.init();
        window.pack();
        window.setVisible(true);
    }
}