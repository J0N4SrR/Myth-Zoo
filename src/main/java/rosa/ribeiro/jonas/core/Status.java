package rosa.ribeiro.jonas.core;

import rosa.ribeiro.jonas.world.Food;
import rosa.ribeiro.jonas.level.Level;
import rosa.ribeiro.jonas.level.LevelCurve;

public class Status {
    private Level level;
    private boolean alive;
    private int currentHp;
    private int currentMana;
    private int currentHunger;
    private int currentSanity;
    private int maxHp;
    private int maxMana;
    private int maxHunger;
    private int maxSanity;
    private int attack;
    private int defense;
    private int speed;
    private double acuracy;

    public Status(LevelCurve curve, int maxHp, int maxMana, int maxHunger, int maxSanity, int attack, int defense, int speed, double acuracy) {
        this.level = new Level(curve, 0, 0);
        this.alive = true;
        this.currentHp = maxHp;
        this.currentMana = maxMana;
        this.currentHunger = 0;
        this.currentSanity = maxSanity;
        this.maxHp = maxHp;
        this.maxMana = maxMana;
        this.maxHunger = maxHunger;
        this.maxSanity = maxSanity;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.acuracy = acuracy;
    }

    private boolean isAlive(){
        if(currentHp <= 0 ) alive = false;
        return alive;
    }

    private void onLevelUp() {
        maxHp += 5;
        maxMana += 3;
        attack += 1;
        defense += 1;
        speed += 1;
        acuracy += 0.1;
        currentHp = maxHp;
        currentMana = maxMana;
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
        currentHp += amount;
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









    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    public int getCurrentHunger() {
        return currentHunger;
    }

    public int getCurrentSanity() {
        return currentSanity;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getMaxSanity() {
        return maxSanity;
    }

    public int getMaxHunger() { return maxHunger;}

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }
}
