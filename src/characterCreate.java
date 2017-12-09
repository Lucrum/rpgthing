public class characterCreate {

    /*
    TODO make nationality work
     */


    //Declares all variables used in this class
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    private static String name;
    private static boolean confirmation;
    private static String nationality;
    private static String raceResult = "o";
    private static String confirmationQuestion;

    private static String[] race = new String[] {
            "human", "elven", "dwarven", "amalian"
    };

    //fetches name
    public static String fetchName(){
        System.out.println("What is your name?");
        name = scanner.next();


        //recursive thingy for the name
        if (confirm(0, name)){
            return name;
        }
        else {
            fetchName();
        }
        return null;
    }

    //confirmation code
    public static boolean confirm(int application, String characterProperty) {

        //changes question based on what's being confirmed (switch doesn't work for some reason)
        if (application == 0){
            confirmationQuestion = "Your name is ";
        }
        else if (application == 1){
            confirmationQuestion = "You're ";
        }

        System.out.println(confirmationQuestion + characterProperty + ", right? Type yes to confirm");

        if (scanner.next().equals("yes")){
            confirmation = true;
        }
        else{
            confirmation = false;
        }
        return confirmation;
    }


    //fetches and confirms nationality
    public static String fetchRace(){

        Scenes.raceIntro();

        nationality = scanner.next();

        for(int i = 0; i < 4; i++) {
            if (race[i].equals(nationality)) {
                raceResult = nationality;
            }
        }

        if (raceResult.equals("o")){
            System.out.println("Invalid answer! Try again!");
            fetchRace();
        }

        //recursive thingy for the race
        if (confirm(1, raceResult)){
            return raceResult;
        }
        else {
            fetchRace();
        }
        return null;
    }
}