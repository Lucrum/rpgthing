package magic;

import character.*;


public class effectAction {

    public static void doEffectAction(character caster, character victim, effect eff){
        switch (eff.getEffectID()){
            case 1:{
                burn(caster, victim);
                break;
            }
        }

        eff.setEffectDuration(eff.getEffectDuration() - 1);
    }

    private static void burn(character caster, character victim){
        victim.setHealth(victim.getHealth() - (int)(Math.floor(caster.getIntelligence() * 1.5)));

        System.out.println(victim.getName() + " has burned for " + Math.floor(caster.getIntelligence() * 1.5) + "!");
    }
}