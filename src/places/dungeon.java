package places;

import java.util.concurrent.ThreadLocalRandom;
import character.*;

public class dungeon {
    protected String name;
    protected int rooms, enemies, difficulty;

    public String getName() {
        return name;
    }

    public int getRooms() {
        return rooms;
    }

    public int getEnemies() {
        return enemies;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public void setEnemies(int enemies){
        this.enemies = enemies;
    }

    private static String[] names = new String[]{
            "Blueberry",
            "Raspberry",
            "Tideberry",
            "Cookie",
            "Gay",
            "Straight"
    };

    public static dungeon generateDungeon(int difficulty){

        dungeon generatedDungeon = new dungeon();

        generatedDungeon.name = names[(int)(Math.floor(ThreadLocalRandom.current().nextInt(0,6)))];
        generatedDungeon.enemies = (int)(Math.floor(difficulty * 1.5));

        System.out.println((int)(Math.floor(difficulty * 1.5)) + " enemies");

        generatedDungeon.rooms = (int)Math.ceil(generatedDungeon.enemies / 4);
        generatedDungeon.difficulty = difficulty;

        return generatedDungeon;
    }

    public static void enter(protagonist player, dungeon dungeon){
        System.out.println("Now entering " + dungeon.getName() + " Dungeon.");

        while(dungeon.getEnemies() > 0){
            if((combat.enterCombat ( player, enemy.spawnEnemy( dungeon.getDifficulty() ) ) ) == player){

                dungeon.setEnemies(dungeon.getEnemies() - 1);

                if(dungeon.getEnemies() > 1){
                    System.out.println(dungeon.getEnemies() + " enemies are left.");
                }
                //TODO: fix this weird bug where there's a zeroth enemy (repeats this next line twice)
                else{
                    System.out.println("Last one! Hang in there!");
                }

                System.out.println("\n \n");
            }

        }

    }

}
