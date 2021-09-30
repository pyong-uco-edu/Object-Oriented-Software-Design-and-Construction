package controller;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.QuestionBank;
import view.MenuScreen;
import view.QuestionPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuestionButtonListener implements ActionListener {
    private QuestionPanel panel;

    public QuestionButtonListener(QuestionPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == panel.getQuitButton()) {
            panel.getWindow().getContentPane().removeAll();
            var menu = new MenuScreen(panel.getWindow());
            menu.init();
            panel.getWindow().pack();
            panel.getWindow().revalidate();
        } else if (button == panel.getNextButton()) {
            int index = panel.getCanvas().getQuestionIndex();
            ++index;
            if (index == QuestionBank.database.size()) {
                index = 0;
            }
            panel.getCanvas().setQuestionIndex(index);
            panel.getCanvas().repaint();
        } else if (button == panel.getPrevButton()) {
            int index = panel.getCanvas().getQuestionIndex();
            --index;
            if (index < 0) {
                index = QuestionBank.database.size() - 1;
            }
            panel.getCanvas().setQuestionIndex(index);
            panel.getCanvas().repaint();
        } else if (button == panel.getEnterButton()) {
            int index = panel.getCanvas().getQuestionIndex();
            if (index < 0) {
                JOptionPane.showMessageDialog(panel.getWindow(), "No question presented yet");
                return;
            }
            String response = panel.getAnswerField().getText();
            String message;
            if (QuestionBank.database.get(index).checkAnswer(response)) {
                message = response + ": Correct answer!";
            } else {
                message = response + ": Wrong answer!";
            }
            JOptionPane.showMessageDialog(panel.getWindow(), message);
            panel.getAnswerField().setText("");
        }
    }
}
