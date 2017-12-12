import java.util.Scanner;

public class GAEM2{

    final static double VER_NUM = 0.1;

    //Keep track of actions, an internal clock
    private static int actCount = 1;
    private static int sceneCount = 1;
    private static int partCount = 1;


    public static void main(String[] args) {


        try{
            System.out.println("GAEM VERSION " + VER_NUM);
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }


        //inputs this to start
        System.out.println("Type anything to start.");

        //beginning of scanner and stuff
        Scanner sc = new java.util.Scanner(System.in);
        sc.next();

        //creates protagonist
        Protagonist player = new Protagonist();

        player.getName();
        player.getRace();
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

        while (1 == 1){
            if (player.playerState == 0){

            }
            else if (player.playerState == 1){

            }
        }



    }
}