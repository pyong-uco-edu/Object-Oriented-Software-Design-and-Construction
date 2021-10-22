package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Track extends Music {
    private int year, duration;
    private String artist;

    public Track(int x, int y, String name, int year, int duration, String artist) {
        super(x, y, name);
        this.year = year;
        this.duration = duration;
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public void render(Graphics2D g2, boolean show) {
        g2.drawImage(getImage(), null, getX(), getY());
        g2.setColor(Color.green);
        if (show) g2.drawString("Name - " + getName() + " | Year - " + getYear() + " | Duration - " + getDuration() + " | Artist - " + getArtist(), getX(), getY() - 10);
    }
}
