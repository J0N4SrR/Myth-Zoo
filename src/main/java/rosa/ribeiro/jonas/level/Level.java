package rosa.ribeiro.jonas.level;

import rosa.ribeiro.jonas.Status;

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

    private void levelUp(Status status){
        while(currentExperience >= maxExperienceToLevel){
            currentExperience -= maxExperienceToLevel;
            level++;
            maxExperienceToLevel = curve.calculateXp(level);
        status.onLevelUp();
        };
    }

    private boolean checkLevelUp(){
        return currentExperience >= maxExperienceToLevel;
    }

    public void addXp(int xp, Status status){
        currentExperience += xp;
        if(checkLevelUp()){
            levelUp(status);
        }

    }


}
