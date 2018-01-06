package magic;

import character.character;

public class spellCast{


    private static String spellName;
    private static String spellDescription;
    private static int spellBaseDamage;
    private static effect spellEffect;
    private static int manaCost;
    private static int duration;
    private static int spellType;


    //arrays for holding information
    private static String[] spellNameArray = new String[]{
            "Fireball",
            "Freeze"
    };

    private static String[] spellDescriptionArray = new String[]{
            "Launches a fireball at the enemy, dealing " + spellBaseDamage + " damage. Also ignites the target.",
            "Freezes an enemy, forcing it to skip a turn."
    };

    private static int[] spellBaseDamageArray = new int[]{
            20,
            10
    };

    private static effect[] spellEffectArray = new effect[]{
            effect.burn,
            effect.freeze
    };

    private static int[] manaCostArray = new int[]{
            20,
            25
    };

    private static int[] spellDurationArray = new int[]{
            2,
            1
    };

    /*Spell type
    1 = offensive
    2 = defensive
     */


    private static int[] spellTypeArray = new int[]{
            1,
            1
    };



    public static spell cast(character caster, int spellID){

        spellName = spellNameArray[spellID];
        spellBaseDamage = caster.getIntelligence() + spellBaseDamageArray[spellID];
        spellDescription = spellDescriptionArray[spellID];
        spellEffect = spellEffectArray[spellID];
        manaCost = manaCostArray[spellID];
        duration = spellDurationArray[spellID];
        spellType = spellTypeArray[spellID];


        spell castedSpell = new spell(spellName, spellBaseDamage, spellDescription, spellEffect, manaCost, duration, spellType);

        return castedSpell;
    }

}