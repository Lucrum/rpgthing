public class GAEM2{

    //Keep track of actions, an internal clock
    private static int actCount = 1;
    private static int sceneCount = 0;
    private static int partCount = 1;

    public static void main(String[] args) {

        //inputs this to start
        System.out.println("Type anything to start.");

        //beginning of scanner and stuff
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.next();

        //Creates protagonist
        Protagonist you = new Protagonist();

        you.name = characterCreate.fetchName();
        you.race = characterCreate.fetchRace();



        //story
        System.out.println("Welcome, " + you.name + ", type 1 to continue.");
        while (sceneCount <= 10) {
            input = sc.next();
            if (input.equals("1")) {
                actOne.dialogue(sceneCount);
                sceneCount++;
            }
            else{
                System.out.println("Type 1 to progress the story.");
            }
        }
    }
}