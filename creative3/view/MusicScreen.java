package view;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MusicListener;
import model.Album;
import model.Artist;
import model.IMusic;
import model.Track;
import model.images.ImageStore;

import java.awt.BorderLayout;
import java.awt.Container;

import java.util.ArrayList;

public class MusicScreen {
    private JFrame window;
    private MusicCanvas canvas;
    private JCheckBox showDetailsBox = new JCheckBox("Show Details");

    public MusicScreen(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();
        canvas = new MusicCanvas(this);
        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);
        southPanel.add(showDetailsBox);

        populatePicture();

        MusicListener listener = new MusicListener(this);
        canvas.addKeyListener(listener);
        canvas.requestFocusInWindow();
        canvas.setFocusable(true);
        showDetailsBox.addActionListener(listener);
        showDetailsBox.setFocusable(false);
    }

    private void populatePicture() {
        ArrayList<IMusic> pics = canvas.getPictures();
        var m1 = new Album(50, 50, "Cyka Blyat", 2021, "DJ Blyatman & Russian Village Boys", 2);
        m1.addTrack("Cyka Blyat");
        m1.addTrack("Ez Katka");
        pics.add(m1);
        m1.setImage(ImageStore.album);
        var m2 = new Artist(50, 200, "DJ Blyatman", "Dance/Electronic", "Slovakia");
        pics.add(m2);
        m2.setImage(ImageStore.artist);
        var m3 = new Track(50, 350, "Cyka Blyat", 2021, 182, "DJ Blyatman & Russian Village Boys");
        pics.add(m3);
        m3.setImage(ImageStore.track);
    }

    public JCheckBox getShowDetailsBox() {
        return showDetailsBox;
    }

    public MusicCanvas getCanvas() {
        return canvas;
    }

    public JFrame getWindow() {
        return window;
    }
}
