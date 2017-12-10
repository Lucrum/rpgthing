public class characterCreate {

    //declares all variables used in this class
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    private static String name;
    private static boolean confirmation;
    private static String nationality;
    private static String raceResult = "reasoner";
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

        System.out.println(confirmationQuestion + characterProperty + ", right? Type yes to confirm.");

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

        raceIntro();
        nationality = scanner.next();

        //cycles through possible nationalities
        for(int i = 0; i < 4; i++) {
            if (race[i].equals(nationality)) {
                raceResult = nationality;
            }
        }

        //only accepts valid races ("reasoner" is the default value for the string). If invalid, fetches race again.
        if (raceResult.equals("reasoner")){
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

    //describes races to player
    private static String[] raceDescriptions = new String[]{
            "Choose your race, you can only choose one:",
            "\nAmalian" + "\nThe amalian race is the largest race on the continent. Unorganized, but strong in terms of damage and mediocre defense.",
            "\nElven" + "\nThe elven race is the magic of the continent, using skill points and superior magic. They are also relatively taller.",
            "\nDwarven" + "\nThe dwarven race is the forge of the continent. Having superior tools and weapons, they also have good defense while being relatively shorter.",
            "\nHuman" + "\nThe human race is the most intelligent; having lots of skill points and a larger level difference."
    };

    public static void raceIntro(){

        for (int i = 0; i < 5; i++){
            System.out.println(raceDescriptions[i]);

            //pauses the printing for 1 second, so it isn't just spat out at you simultaneously and is more organic
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }


}