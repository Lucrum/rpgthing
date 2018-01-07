package magic;

import character.character;

public class effectAction {
    protected static void burn(int effectPotency, character victim, effect effect){

        victim.setHealth(victim.getHealth() - (2 * effectPotency));

        effect.effectDuration--;

    }
}
