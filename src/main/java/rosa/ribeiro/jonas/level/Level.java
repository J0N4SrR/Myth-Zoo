package rosa.ribeiro.jonas.level;

import rosa.ribeiro.jonas.core.Status;

public class Level {
    private int level;
    private int maxExperienceToLevel;
    private int currentExperience;
    private LevelCurve curve;

    public Level(LevelCurve curve, int experience, int level) {
        this.curve = curve;
        this.maxExperienceToLevel = curve.calculateXp(level);
        this.level = level;

    }

    public void addXp(int xp, Status status) {
        currentExperience += xp;

        while (currentExperience >= maxExperienceToLevel) {
            currentExperience -= maxExperienceToLevel;
            level++;
            maxExperienceToLevel = curve.calculateXp(level);
            status.onLevelUp();
        }
    }

    public int getLevel() {
        return level;
    }

    public int getMaxExperienceToLevel() {
        return maxExperienceToLevel;
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    public LevelCurve getCurve() {
        return curve;
    }

    public void setMaxExperienceToLevel(int maxExperienceToLevel) {
        this.maxExperienceToLevel = maxExperienceToLevel;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = currentExperience;
    }

    public void setCurve(LevelCurve curve) {
        this.curve = curve;
    }
}
