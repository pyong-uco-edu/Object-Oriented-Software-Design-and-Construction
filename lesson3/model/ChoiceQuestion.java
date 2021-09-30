package model;

import java.util.ArrayList;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class ChoiceQuestion extends Question {
    private ArrayList<String> choices;

    public ChoiceQuestion(String text, String answer) {
        super(text, answer);
        choices = new ArrayList<>();
    }

    public void addChoice(String c) {
        choices.add(c);
    }

    @Override
    public void display() {
        super.display();
        int no = 1;
        for (var c : choices) {
            System.out.println("\t" + no + ". " + c);
            ++no;
        }
    }

    @Override
    public void render(Graphics2D g2) {
        super.render(g2);
        g2.setColor(Color.white);
        g2.setFont(new Font("courier", Font.BOLD, 12));
        int no = 1;
        for (var c : choices) {
            g2.drawString(no + ". " + c, 90, no * 50 + 100);
            ++no;
        }
    }
}
