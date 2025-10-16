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

    public Status(LevelCurve curve, int maxHp, int maxMana, int maxHunger, int maxSanity, int attack, int defense, int speed) {
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
    }

    private boolean isAlive(){
        if(currentHp <= 0 ) alive = false;
        return alive;
    }
    public void onLevelUp() {
        maxHp += 5;
        maxMana += 3;
        attack += 1;
        defense += 1;
        speed += 1;
        currentHp = maxHp;
        currentMana = maxMana;
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
        currentHp += food.getHealthValue();
        currentMana += food.getEnergyValue();
        currentHunger -= food.getNutritionalValue();
        currentSanity += food.getSanityValue();

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
