package magic;

import character.character;

public class spellCast{


    private static String spellName;
    private static String spellDescription;
    private static int spellDamage;
    private static effect spellEffect;
    private static int manaCost;
    private static int duration;


    //arrays for holding information
    private static String[] spellNameArray = new String[]{
        "Fireball",
    };

    private static String[] spellDescriptionArray = new String[]{
            "Launches a fireball at the enemy, dealing " + spellDamage + " damage. Also ignites the target."
    };

    private static int[] spellBaseDamageArray = new int[]{
            20
    };

    private static effect[] spellEffectArray = new effect[]{
            effect.burn
    };

    private static int[] manaCostArray = new int[]{
            20
    };




    public static spell cast(character caster, int spellID){

        spellName = spellNameArray[spellID];
        spellDamage = caster.intelligence + spellBaseDamageArray[spellID];
        spellDescription = spellDescriptionArray[spellID];
        spellEffect = spellEffectArray[spellID];
        manaCost = manaCostArray[spellID];


        spell castedSpell = new spell(spellName, spellDamage, spellDescription, spellEffect, manaCost, duration);

        return castedSpell;
    }

}