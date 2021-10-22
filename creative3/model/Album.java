package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Album extends Music {
    private int year;
    private String artist, tracks[];

    public Album(int x, int y, String name, int year, String artist, int trackCount) {
        super(x, y, name);
        this.year = year;
        this.artist = artist;
        this.tracks = new String[trackCount];
    }

    public int getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    public String getTracks() {
        String trackStr = "";
        for (int x = 0; x < tracks.length; x++) {
            if (tracks[x] == null) {
                break;
            }
            if (x == 0) trackStr += tracks[x];
            else trackStr += " ~ " + tracks[x];
        }
        return trackStr;
    }

    public void addTrack(String track) {
        int i = 0;
        while(i < tracks.length) {
            if (tracks[i] == null) {
                tracks[i] = track;
                break;
            }
            i++;
        }
    }

    @Override
    public void render(Graphics2D g2, boolean show) {
        g2.drawImage(getImage(), null, getX(), getY());
        g2.setColor(Color.blue);
        if (show) g2.drawString("Name - " + getName() + " | Year - " + getYear() + " | Artist - " + getArtist() + " | Tracks - " + getTracks(), getX(), getY() - 10);
    }
    
}
