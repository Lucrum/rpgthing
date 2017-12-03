public class GAEM2{

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

        //just a thing
        System.out.println("Type your name.");

        input = sc.next();
        you.name = input;

        Beginning.phase(input, you);
        input = sc.next();

        //waits for yes, if doesn't remakes name
        while (!input.equals("yes")) {
            //asks for your name
            System.out.println("Type your name.");
            //waits for input (name), replaces it, and reassures player
            input = sc.next();
            you.name = input;
            Beginning.phase(input, you);
            input = sc.next();
        }

        //choose nationality
        Beginning.nationC();
        input = sc.next();

        //while (!input.equals("amalian") && !input.equals("elven") && !input.equals("dwarven") && !input.equals("human")) {

        //}

        if (input.equals("amalian")) {
                you.nationality = "amalian";}
        if (input.equals("elven")) {
                you.nationality = "elven";}
        if (input.equals("dwarven")) {
                you.nationality = "dwarven";}
        if (input.equals("human")) {
            you.nationality = "human";}

    }
}

