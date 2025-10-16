package rosa.ribeiro.jonas.world;

import rosa.ribeiro.jonas.enums.FoodType;
import rosa.ribeiro.jonas.enums.MagicalType;

public class Food extends Item {
    private FoodType foodType;
    private MagicalType magicalType;
    private int healthValue;
    private int energyValue;
    private int nutritionalValue;
    private int sanityValue;
    private int AttackBonusValue;
    private int DefenseBonusValue;
    private int SpeedBonusValue;

    public FoodType getFoodType() {
        return foodType;
    }

    public MagicalType getMagicalType() {
        return magicalType;
    }

    public int getHealthValue() {
        return healthValue;
    }

    public int getEnergyValue() {
        return energyValue;
    }

    public int getNutritionalValue() {
        return nutritionalValue;
    }

    public int getSanityValue() {
        return sanityValue;
    }

    public int getAttackBonusValue() {
        return AttackBonusValue;
    }

    public int getDefenseBonusValue() {
        return DefenseBonusValue;
    }

    public int getSpeedBonusValue() {
        return SpeedBonusValue;
    }
}