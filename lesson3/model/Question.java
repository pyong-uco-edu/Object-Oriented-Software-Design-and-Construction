package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Question {
    private String text;
    private String answer;

    public Question(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    public boolean checkAnswer(String response) {
        return response.equalsIgnoreCase(answer);
    }

    public void display() {
        System.out.println(text);
    }

    public void render(Graphics2D g2) {
        g2.setColor(Color.yellow);
        g2.setFont(new Font("courier", Font.BOLD, 14));
        g2.drawString(text, 50, 100);
    }
}
