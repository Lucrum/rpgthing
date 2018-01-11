package magic;

import character.*;

import java.util.Scanner;


public class effectAction {

    private static Scanner sc = new Scanner(System.in);

    //identifies the effect and hands over characters to the correct method
    public static void doEffectAction(character caster, character victim, int effectID){
        switch (effectID){
            case 0:{
                burn(caster, victim);
                break;
            }
            case 1:{
                freeze(caster, victim);
                break;
            }
        }
    }

    //burn effect, is a DoT
    private static void burn(character caster, character victim){

        //actually subtracts the health
        victim.setHealth(victim.getHealth() - (int)Math.floor(caster.getIntelligence() * 1.5));

        //console message
        System.out.println(victim.getName() + " has burned for " + Math.floor(caster.getIntelligence() * 1.5) + "!");
    }

    //freeze effect (skips turn)
    private static void freeze(character caster, character victim){
        System.out.println(victim.getName() + " has been frozen! " + victim.getName() + "'s turn is skipped!");


        //checks whether the victim is an enemy or not, then carries out the correct method for performing the caster's turn
        if (victim.getClass().getName().equals("character.enemy")){
            String sInput = sc.next();
            combat.playerTurn(caster, victim, sInput);
        }
        else if (victim.getClass().getName().equals("character.protagonist")){
            combat.enemyTurn(victim, caster);
        }
    }
}