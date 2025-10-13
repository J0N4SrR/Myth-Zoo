package rosa.ribeiro.jonas.level;

public class LinearLevelCurve implements LevelCurve{
    private int baseXp;
    private double multiplier;

    public LinearLevelCurve(int baseXp, int multiplier) {
        this.baseXp = baseXp;
        this.multiplier = multiplier;
    }

    @Override
    public int calculateXp(int level) {
        return (int) (baseXp + (multiplier * level - 1));
    }
    
}
