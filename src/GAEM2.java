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


        //makes you, a protagonist
        Protagonist you = new Protagonist();

        //player makes character
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
            }
            else{
                System.out.println("Type 1 to progress the story.");
            }
        }
    }
}