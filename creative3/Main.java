import javax.swing.JFrame;

import view.MusicScreen;

public class Main {
    public static void main(String args[]) {
        JFrame window = new JFrame("Music Library");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(150, 150);
        var clock = new MusicScreen(window);
        clock.init();

        window.pack();
        window.setVisible(true);
    }  
}
