import java.util.Scanner;

public class GAEM2{

    final private static String VER_NUM = "0.01";

    //Keep track of actions, an internal clock maybe
    private static int actCount = 1;
    private static int sceneCount = 1;
    private static int partCount = 1;


    //pause code
    public final static String apology = "Something went wrong and we don't know how to fix it.";

    public static void pause(int ms){
        try{
            Thread.currentThread().sleep(ms);
        }
        catch(InterruptedException ex){
            System.out.println(apology);
            Thread.currentThread().interrupt();
        }
    }

    private static void devBuildWarning(){
        System.out.println(
                "This is a development build. Features will be missing, things will be broken, and the game might not even work at all."
        );
        pause(1000);
    }

    //main
    public static void main(String[] args) {


        try{
            System.out.println("GAME VERSION " + VER_NUM);
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

        //creates protagonist
        Protagonist player = new Protagonist();

        //player.setName();
        player.setRace();
        player.setRaceID(player.raceString);
        player.defineBaseStats(player.getRaceID());
        player.playerState = 0;


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

        //skips straight to combat for now

        //pause(1000);
        //actOne.dialogue(0);


        player.enterCombat(player, enemy.spawnEnemy(1), 1);
    }
}