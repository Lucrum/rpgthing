package magic;

import character.character;
import java.lang.reflect.Method;

public class effect {

    protected String effectName;
    protected int effectPotency;
    protected int effectType;
    protected Method effectAction;

    protected static effect burn;
    protected static effect freeze;

    public effect(String effectName, int effectPotency, int effectType, Method effectAction) {
        this.effectName = effectName;
        this.effectPotency = effectPotency;
        this.effectType = effectType;
        this.effectAction = effectAction;
    }

    protected static void burn(int effectPotency, character victim){

        victim.setHealth(victim.getHealth() - (2 * effectPotency));
    }
}