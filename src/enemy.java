public class enemy extends Character{


    //creates a new enemy object
    public static enemy spawnEnemy(int difficulty){

        //creates the enemy itself and defines its stats
        enemy newEnemy = new enemy();
        newEnemy.normHealth = newEnemy.health = difficulty * 40;
        newEnemy.normStrength = newEnemy.strength = difficulty * 2;
        newEnemy.normAgility = newEnemy.agility = difficulty;
        newEnemy.normSpeed = newEnemy.speed = difficulty;
        newEnemy.normDefense = newEnemy.defense = difficulty;


        return newEnemy;
    }
}