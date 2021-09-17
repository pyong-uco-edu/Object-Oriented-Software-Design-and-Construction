package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.WordGuess;
import view.MainScreen;

public class MainKeyListener implements ActionListener {
    private MainScreen panel;

    public MainKeyListener(MainScreen panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getNewButton()) {
            panel.setGameState(MainScreen.GameState.PLAYING);
            WordGuess game = panel.getGame();
            game.setWord();
            JTextField gameKeyField = panel.getGameKeyField();
            gameKeyField.setText(game.getWord());
            JTextField guessField = panel.getGuessField();
            String guessText = "";
            for (int i = 0; i < game.getWord().length(); i++) {
                guessText += ".";
            }
            guessField.setText(guessText);
            for (var b : panel.getCharButtons()) {
                b.setEnabled(true);
            }
        } else {
            button.setEnabled(false);
            char selectedChar = button.getText().charAt(0);
            WordGuess game = panel.getGame();
            String currentWord = game.getWord();
            JTextField guessField = panel.getGuessField();
            String currentGuess = guessField.getText();
            String newGuess = "";
            boolean hit = false;
            for (int i = 0; i < currentWord.length(); i++) {
                if (currentWord.charAt(i) == selectedChar) {
                    newGuess += selectedChar;
                    hit = true;
                } else {
                    newGuess += currentGuess.charAt(i);
                }
            }
            guessField.setText(newGuess);
            if (newGuess.indexOf('.') == -1) {
                for (var b : panel.getCharButtons()) {
                    b.setEnabled(false);
                }
                panel.setGameState(MainScreen.GameState.GAMEWIN);
            }
            if (!hit) {
                if (game.reduceHealth()) {
                    for (var b : panel.getCharButtons()) {
                        b.setEnabled(false);
                    }
                    panel.setGameState(MainScreen.GameState.GAMEOVER);
                }
            }
        }
        panel.getCanvas().repaint();
    }

}
