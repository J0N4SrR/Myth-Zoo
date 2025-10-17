package rosa.ribeiro.jonas.core;

import rosa.ribeiro.jonas.enums.EffectType;

public record Effect( String name, EffectType type ,double chance, int duration, boolean stackable){

}
