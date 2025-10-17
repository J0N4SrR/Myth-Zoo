package rosa.ribeiro.jonas.core;

import rosa.ribeiro.jonas.enums.Gender;
import rosa.ribeiro.jonas.enums.MagicalType;
import rosa.ribeiro.jonas.enums.Nature;
import rosa.ribeiro.jonas.world.Food;
import rosa.ribeiro.jonas.world.Habitat;

import java.util.Set;
import java.util.UUID;

public class Creature {
    // General Information
    private UUID id;
    private String nickname;
    private String specie;
    private Gender gender;
    private int size;
    private String description;
    private MagicalType magicalType;
    private Habitat habitat;
    private Nature nature;
    private Status status;
    private LifeCycle lifeCycle;
    private Set<Skill> skills;

    // Progressão
    public void gainExperience(int amount){

    };

    public void eat(Food food){
        status.consumeFood(food);
    }

}
