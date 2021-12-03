package model.builderPattern;

import java.awt.Color;

public class UnbreakableBombBuilder extends BombBuilder {

    @Override
    public void buildColor() {
        bomb.setColor(Color.blue);
    }

    @Override
    public void buildType() {
        bomb.setType("Unbreakable");
    }
    
}
