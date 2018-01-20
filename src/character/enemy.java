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

    //creates a new enemy object
    public static enemy spawnEnemy(double difficulty){

        //randomizes difficulty, making it equal to somewhere +- the difficulty
        difficulty = Math.floor(ThreadLocalRandom.current().nextInt((int)difficulty - 2, (int)difficulty + 2));

        //creates the enemy itself and defines its stats
        enemy newEnemy = new enemy();
        newEnemy.normHealth = newEnemy.health = difficulty * 40;
        newEnemy.normStrength = newEnemy.strength = difficulty * 2;
        newEnemy.normAgility = newEnemy.agility = difficulty;
        newEnemy.normSpeed = newEnemy.speed = difficulty;
        newEnemy.normDefense = newEnemy.defense = difficulty;
        newEnemy.name = names[(int)Math.floor(ThreadLocalRandom.current().nextInt(0,6))];


        return newEnemy;
    }
}