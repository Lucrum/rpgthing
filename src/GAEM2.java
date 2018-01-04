import character.*;
import java.util.Scanner;

public class GAEM2{

    private final static String VER_NUM = "0.02A COMBAT TEST";

    //Keep track of actions, an internal clock maybe
    private static int actCount = 1;
    private static int sceneCount = 1;
    private static int partCount = 1;


    //pause code
    public static void pause(int ms){
        try{
            Thread.currentThread().sleep(ms);
        }
        catch(InterruptedException ex){
            System.out.println("Something went wrong and we don't know how to fix it.");
            Thread.currentThread().interrupt();
        }
    }

    private static void devBuildWarning(){
        System.out.println(
                "This is a development build. Features will be missing, things will be broken, and the game might not even work at all."
        );
        pause(500);
    }

    private static int damageModifier = 1;
    private static int difficulty = 1;

    //main
    public static void main(String[] args) {


        try{
            System.out.println("RPGTHING VER " + VER_NUM);
            devBuildWarning();
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }


        //inputs this to start
        //System.out.println("Type anything to start.");

        //beginning of scanner and stuff
        Scanner sc = new Scanner(System.in);
        //sc.next();

        //creates character.protagonist
        protagonist player = new protagonist();

        player.setName(0);
        player.setRace(0);
        player.setRaceID(player.raceString);
        player.defineBaseStats(player.getRaceID());
        player.playerState = 0;


        System.out.println("Please define a difficulty for the enemy. Default is 1 (can't be less than zero, if so default value is used).");
        difficulty = sc.nextInt();
        if (difficulty <= 0){
            difficulty = 1;
        }


        //story
        /*System.out.println("Welcome, " + you.name + ", type 1 to continue.");
        while (sceneCount <= 10) {
            sc.next();
            if (input.equals("1")) {
                actOne.dialogue(sceneCount);
                sceneCount++;
            }
            else{
                System.out.println("Type 1 to progress the story.");
            }
        } */

        //skips straight to character.combat for now

        //pause(1000);
        //actOne.dialogue(0);

        combat.enterCombat(player, enemy.spawnEnemy(difficulty), damageModifier);
    }
}