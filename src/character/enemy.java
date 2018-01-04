package character;

import java.util.concurrent.ThreadLocalRandom;

public class enemy extends character {


    private static String[] names = new String[]{
            "Slime",
            "Feral Wolf",
            "Messorem",
            "Cultist",
            "Possessed Villager",
            "Heleck"
    };

    //creates a new character.enemy object
    public static enemy spawnEnemy(int difficulty){

        //creates the character.enemy itself and defines its stats
        enemy newEnemy = new enemy();
        newEnemy.normHealth = newEnemy.health = difficulty * 40;
        newEnemy.normStrength = newEnemy.strength = difficulty * 2;
        newEnemy.normAgility = newEnemy.agility = difficulty;
        newEnemy.normSpeed = newEnemy.speed = difficulty;
        newEnemy.normDefense = newEnemy.defense = difficulty;


        int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
        newEnemy.name = names[(int)Math.floor(randomNum)];


        return newEnemy;
    }
}