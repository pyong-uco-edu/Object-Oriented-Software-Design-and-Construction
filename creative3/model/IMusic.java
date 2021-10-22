package model;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface IMusic {
    void render(Graphics2D g2, boolean show);
    Rectangle getBoundingBox();
}
