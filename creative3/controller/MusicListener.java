package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;

import view.MusicScreen;

public class MusicListener implements ActionListener, KeyListener {
    private MusicScreen panel;

    public MusicListener(MusicScreen panel) {
        this.panel = panel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int selectIndex = panel.getCanvas().getSelectIndex();
        var key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                panel.getCanvas().setSelectIndex(selectIndex - 1);
                break;
            case KeyEvent.VK_DOWN:
            panel.getCanvas().setSelectIndex(selectIndex + 1);
                break;
        }
        panel.getCanvas().repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panel.getShowDetailsBox()) {
            JCheckBox checkBox = (JCheckBox) e.getSource();
            panel.getCanvas().setShowDetails(checkBox.isSelected());
            panel.getCanvas().repaint();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
