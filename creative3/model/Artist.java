package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Artist extends Music {
    private String genre, country;

    public Artist(int x, int y, String name, String genre, String country) {
        super(x, y, name);
        this.genre = genre;
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public void render(Graphics2D g2, boolean show) {
        g2.drawImage(getImage(), null, getX(), getY());
        g2.setColor(Color.red);
        if (show) g2.drawString("Name - " + getName() + " | Genre - " + getGenre() + " | Country - " + getCountry(), getX(), getY() - 10);
    }
    
}
