//has bug when typing yes in start, skips name

//need more classes
public class GAEM2{
    private static int sceneCount = 0;
    public static void main(String[] args) {
        //inputs this to start
        System.out.println("Type anything to start.");

        //beginning of scanner and stuff
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.next();
        if (input.equals("gay")) {
            while(0 == 0) {
                System.out.println("ELTON");
            }
        }

        //makes you, a protagonist
        Protagonist you = new Protagonist();

        //asks for your name
        System.out.println("Type your name.");
        //waits for input (name), replaces it, and reassures player
        input = sc.next();
        if (input.equals("elton")) {
            while (0 == 0) {
                System.out.println("gay");
            }
        }
        you.name = input;
        Beginning.phase(input, you);
        input = sc.next();

        //waits for yes, if doesn't remakes name
        while (!input.equals("yes")) {
            //asks for your name
            System.out.println("Type your name.");
            //waits for input (name), replaces it, and reassures player
            input = sc.next();
            if (input.equals("elton")) {
                while (0 == 0) {
                    System.out.println("gay");
                }
            }
            you.name = input;
            Beginning.phase(input, you);
            input = sc.next();
        }

        //resets input
        input = "";

        //sets your nationality with secondary input
        String input2 = "";

        //choose nationality
        while (!input.equals("yes")) {
            Beginning.nationC();
            input = sc.next();
            while (!input.equals("amalian") && !input.equals("elven") && !input.equals("dwarven") && !input.equals("human")) {
                Beginning.nationC();
                input = sc.next();
            }
            input2 = input;
            System.out.println("Your nationality is " + input + ".\nType yes to continue.");
            input = sc.next();
        }

        //sets nationality
        you.nationality = input2;

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

