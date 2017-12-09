import java.util.concurrent.TimeUnit;

public class GAEM2{

    //Keep track of actions, an internal clock
    private static int sceneCount = 0;

    public static void main(String[] args) {
        //inputs this to start
        System.out.println("Type anything to start.");

        //beginning of scanner and stuff
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.next();
        sceneCount++;

        //Creates protagonist
        Protagonist you = new Protagonist();

        you.name = characterCreate.fetchName();
        you.race = characterCreate.fetchRace();


        Beginning.phase(input, you);


        //story
        System.out.println("Type 1 to progress the story.");
        while (sceneCount <= 10) {
            input = sc.next();
            if (input.equals("1")) {
                Scenes.print(input, sceneCount, true, you);
                sceneCount++;

                //Pauses printing, so it doesn't spit it all out at once
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException ex){
                    Thread.currentThread().interrupt();
                }
            }
            else{
                System.out.println("Type 1 to progress the story.");
            }
        }
    }
}