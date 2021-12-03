package model.builderPattern;

import java.awt.Color;

public class NormalBombBuilder extends BombBuilder {

    @Override
    public void buildColor() {
        bomb.setColor(Color.green);
    }

    @Override
    public void buildType() {
        bomb.setType("Normal");
    }
    
}
