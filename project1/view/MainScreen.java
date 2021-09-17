package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainKeyListener;
import model.WordGuess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

public class MainScreen {
    public enum GameState {
        READY, PLAYING, GAMEOVER, GAMEWIN;
    }

    private JFrame window;
    private JTextField gameKeyField = new JTextField();
    private JTextField guessField = new JTextField();

    private CenterCanvas canvas;

    private JButton[] charButtons;
    private JButton newButton = new JButton("New");

    private WordGuess game = new WordGuess();

    private GameState gameState = GameState.READY;

    public MainScreen(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        // At “North”: 2x1 GridLayout with 2 non-editable JTextField’s – one for the
        // game key, the other for player’s guess
        JPanel northPanel = new JPanel();
        cp.add(BorderLayout.NORTH, northPanel);
        northPanel.setLayout(new GridLayout(2, 1));
        northPanel.add(gameKeyField);
        northPanel.add(guessField);
        gameKeyField.setEditable(false);
        guessField.setEditable(false);
        gameKeyField.setFont(new Font("Courier New", Font.BOLD, 20));
        gameKeyField.setForeground(Color.red);
        guessField.setFont(new Font("Courier New", Font.BOLD, 20));
        // guessField.setForeground(Color.GRAY);

        // At “Center”: a canvas for drawing health level and game over message
        canvas = new CenterCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        // At “South”: 4x7 GridLayout with 27 JButtons (26 alphabets and 1 “New”)
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(4, 7));

        MainKeyListener keyListener = new MainKeyListener(this);

        charButtons = new JButton[26];

        for (int i = 0; i < 26; i++) {
            charButtons[i] = new JButton("" + Character.toString(i + 97));
            southPanel.add(charButtons[i]);
            charButtons[i].addActionListener(keyListener);
        }
        newButton.addActionListener(keyListener);
        southPanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southPanel);

        for (var b : charButtons) {
            b.setEnabled(false);
        }
    }

    public JButton getNewButton() {
        return newButton;
    }

    public WordGuess getGame() {
        return game;
    }

    public JTextField getGameKeyField() {
        return gameKeyField;
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public JButton[] getCharButtons() {
        return charButtons;
    }

    public CenterCanvas getCanvas() {
        return canvas;
    }

    public void setGameState(GameState state) {
        this.gameState = state;
    }

    public GameState getGameState() {
        return gameState;
    }
}
