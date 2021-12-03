package model.strategyPattern;

public class Unbreakable implements BreakableStrategy {

    @Override
    public boolean isBreakable() {
        return false;
    }
    
}
