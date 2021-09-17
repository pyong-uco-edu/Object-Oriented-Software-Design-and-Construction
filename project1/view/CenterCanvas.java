package view;

import javax.swing.JPanel;

import model.WordGuess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CenterCanvas extends JPanel {
    // Size: 500 x 500
    // Health level begins at 5
    // At each wrong guess, the health level decreases
    // The game ends when the health level is 0; displays game over message.
    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private MainScreen panel;

    public CenterCanvas(MainScreen panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        MainScreen.GameState state = panel.getGameState();
        if (state == MainScreen.GameState.READY) {
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("Press <New> to Start", 50, 150);
        } else if (state == MainScreen.GameState.GAMEOVER) {
            g2.setColor(Color.red);
            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("YOU LOST !!!", 50, 100);
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("Press <New> to Start", 50, 150);
        } else if (state == MainScreen.GameState.GAMEWIN) {
            g2.setColor(Color.red);
            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("YOU WON !!!", 50, 100);
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("Courier New", Font.BOLD, 30));
            g2.drawString("Press <New> to Start", 50, 150);
        } else {
            g2.setColor(Color.BLUE);
            g2.setFont(new Font("Courier New", Font.BOLD, 40));
            g2.drawString("Health Level", 50, 50);

            WordGuess game = panel.getGame();

            for (int i = 0; i < game.getHealth(); i++) {
                g2.fillRect(i * 50 + 50, 65, 45, 50);
            }
        }
    }
}
