package view;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.IMusic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MusicCanvas extends JPanel {
    private MusicScreen panel;
    private ArrayList<IMusic> pictures = new ArrayList<>();
    private int selectIndex = 0;
    private boolean showDetails;

    public MusicCanvas(MusicScreen panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(800, 500));
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        
        for (int i = 0; i < pictures.size(); i++) {
            IMusic pic = pictures.get(i);
            pic.render(g2, i == selectIndex && showDetails);
            if (i == selectIndex) {
                g2.setStroke(new BasicStroke(5));
                g2.setColor(Color.red);
                g2.draw(pic.getBoundingBox());
            }
        }
    }

    public ArrayList<IMusic> getPictures() {
        return pictures;
    }

    public int getSelectIndex() {
        return selectIndex;
    }

    public void setSelectIndex(int selectIndex) {
        if (selectIndex > -1 && selectIndex < pictures.size()) this.selectIndex = selectIndex;
    }

    public void setShowDetails(boolean showDetails) {
        this.showDetails = showDetails;
    }
}
