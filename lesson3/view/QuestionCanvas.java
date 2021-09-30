package view;

import javax.swing.JPanel;

import model.Question;
import model.QuestionBank;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class QuestionCanvas extends JPanel {
    private QuestionPanel panel;
    private int questionIndex = -1;

    public QuestionCanvas(QuestionPanel panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(500, 400));
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (questionIndex >= 0) {
            Question q = QuestionBank.database.get(questionIndex);
            q.render(g2);
        }
    }

    public void setQuestionIndex(int index) {
        questionIndex = index;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }
}
