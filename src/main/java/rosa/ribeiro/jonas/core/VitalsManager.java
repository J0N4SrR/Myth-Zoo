package rosa.ribeiro.jonas.core;

public class VitalsManager {
    private int currentHp;
    private int currentMana;
    private int currentHunger;
    private int currentSanity;
    private int maxHp;
    private int maxMana;
    private int maxHunger;
    private int maxSanity;

    public int getCurrentMana() {
        return currentMana;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public int getCurrentHunger() {
        return currentHunger;
    }

    public void setCurrentHunger(int currentHunger) {
        this.currentHunger = currentHunger;
    }

    public int getCurrentSanity() {
        return currentSanity;
    }

    public void setCurrentSanity(int currentSanity) {
        this.currentSanity = currentSanity;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getMaxHunger() {
        return maxHunger;
    }

    public void setMaxHunger(int maxHunger) {
        this.maxHunger = maxHunger;
    }

    public int getMaxSanity() {
        return maxSanity;
    }

    public void setMaxSanity(int maxSanity) {
        this.maxSanity = maxSanity;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }
}
