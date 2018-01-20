package character;

import item.*;

public class protagonist extends character {


    public item[] inventory;
    public String[] skills;
    public int coins;
    protected double damageModifier;

    public double getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    /* keeps track of player state (out of character.combat, in town, etc) and determines the commands the player can use
    0 = intro/tutorial
    1 = in character.combat
    2 = in town
    3 = in shop
    4 = traveling
    etc
     */

    public int playerState;

    public int getPlayerState(){
        return playerState;
    }


}