package rosa.ribeiro.jonas.core;

import rosa.ribeiro.jonas.world.Food;
import rosa.ribeiro.jonas.level.Level;
import rosa.ribeiro.jonas.level.LevelCurve;

public class Status {
    private Level level;
    private boolean alive;
    private VitalsManager vitalsManager;
    private CombatManager combatManager;

    public Status(LevelCurve curve, VitalsManager vitalsManager, CombatManager combatManager) {
        this.level = new Level(curve, 0, 0);
        this.alive = true;
        this.vitalsManager = vitalsManager;
        this.combatManager = combatManager;

    }

    private boolean isAlive(){
        if(vitalsManager.getCurrentHp() <= 0 ) alive = false;
        return alive;
    }

    private void onLevelUp() {
        vitalsManager.setMaxHp(vitalsManager.getMaxHp() + 5);
        vitalsManager.setMaxMana(vitalsManager.getMaxMana() + 3);
        vitalsManager.setCurrentHp(vitalsManager.getMaxHp());
        vitalsManager.setCurrentMana(vitalsManager.getMaxMana());
        combatManager.setAttack(combatManager.getAttack() + 1);
        combatManager.setDefense(combatManager.getDefense() + 1);
        combatManager.setSpeed(combatManager.getSpeed() + 1);
        combatManager.setAcuracy(combatManager.getAcuracy() + 0.1);
    }

    public void gainExperience(int amount){
        int levelUpdate = level.addXp(amount);
        for(int i = 0; i < levelUpdate; i++){
            onLevelUp();
        }
    }

    //heath
    private void healHp(int amount){
        if(isAlive()){
            vitalsManager.setCurrentHp(vitalsManager.getCurrentHp() + amount);
        }
    }
    private void takeDamage(int rawAmount){
        int amount = rawAmount - defense;
        if(isAlive()){
            if((amount) > 0){
            currentHp -= amount ;}
        }
    }

    //mana
    private void healMana(int amount){
        if(isAlive()){
            currentMana += amount;}
    }
    private void consumeMana(int amount){
        if(isAlive()){
            currentMana -= amount;}

    }

    //hunger
    private void restoreEnergy(int amount){
        if(isAlive()){
            currentHunger -= amount;}
    }

    private void consumeEnergy(int amount){
        if(isAlive()){
            currentHunger += amount;
        }
    }

    public void consumeFood(Food food){
        currentHp = Math.min((currentHp + food.getHealthValue()), maxHp);
        currentMana = Math.min((currentMana +food.getEnergyValue()),maxMana);
        if((currentHunger - food.getNutritionalValue()) >= 0){
        currentHunger = Math.min((currentHunger - food.getNutritionalValue()), maxHunger);
        } else { currentHunger = 0;}
        currentSanity = Math.min((currentSanity + food.getSanityValue()), maxSanity);
    }

}
