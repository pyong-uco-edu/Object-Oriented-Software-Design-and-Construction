package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import model.BaseballGame;
import view.BaseballGamePanel;
import view.MenuScreen;

public class BaseballKeyListener implements ActionListener {
    private BaseballGamePanel panel;
    private int clicks = 0;

    public BaseballKeyListener(BaseballGamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getPlayButton()) {
            var baseball = new BaseballGame();
            panel.setBaseball(baseball);
            panel.setGameState(BaseballGamePanel.GameState.PLAYING);
            int[] keys = baseball.getKey();
            String keyString = "" + keys[0] + keys[1] + keys[2];
            panel.getGameKeyField().setText(keyString);
            panel.getGuessField().setText("");
            // enable digit buttons
            for (var b : panel.getDigitButtons()) {
                b.setEnabled(true);
            }
            panel.getCanvas().setBallStrikeCount(0, 0);
            panel.getCanvas().repaint();
        } else if (button == panel.getExitButton()) {
            JFrame window = panel.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        } else {
            // digit button 0 - 9
            button.setEnabled(false);

            JTextField guessField = panel.getGuessField();
            if (clicks == 0)
                guessField.setText("");

            BaseballGame baseball = panel.getBaseball();
            String n = button.getText();
            guessField.setText(guessField.getText() + n);
            baseball.setGuess(clicks, n.charAt(0) - '0');
            clicks++;

            if (clicks == 3) {
                baseball.computeBallsStrikes();
                int balls = baseball.getBallCount();
                int strikes = baseball.getStrikeCount();
                panel.getCanvas().setBallStrikeCount(balls, strikes);

                if (strikes == 3) {
                    panel.setGameState(BaseballGamePanel.GameState.GAMEOVER);
                    for (var b : panel.getDigitButtons()) {
                        b.setEnabled(false);
                    }
                } else {
                    // enable all digit buttons
                    for (var b : panel.getDigitButtons()) {
                        b.setEnabled(true);
                    }
                }

                clicks = 0;
                panel.getCanvas().repaint();
            }
        }
    }
}
