package model.strategyPattern;

public class Breakable implements BreakableStrategy {

    @Override
    public boolean isBreakable() {
        return true;
    }
    
}
