import java.util.Scanner;

public class Character{
    //has stats and info for all characters
    protected String name;
    protected int health;
    protected int agility;
    protected int defense;
    protected int strength;
    protected int speed;
    protected int intelligence;
    static protected String race;


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAgility() {
        return agility;
    }

    public int getDefense() {
        return defense;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public String getRace(){
        return race;
    }

    //necessary variables for character creation
    private String confirmationQuestion;
    private boolean confirmation;
    private String raceResult = "reason";

    private static String[] validRaces = new String[] {
            "human", "elven", "dwarven", "amalian"
    };

    Scanner input = new Scanner(System.in);

    private static String[] raceDescriptions = new String[]{
            "Choose your race, you can only choose one:",
            "\nAmalian" + "\nThe amalian race is the largest race on the continent. Unorganized, but strong in terms of damage and mediocre defense.",
            "\nElven" + "\nThe elven race is the magic of the continent, using skill points and superior magic. They are also relatively taller.",
            "\nDwarven" + "\nThe dwarven race is the forge of the continent. Having superior tools and weapons, they also have good defense while being relatively shorter.",
            "\nHuman" + "\nThe human race is the most intelligent; having lots of skill points and a larger level difference."
    };


    //gets name
    public String setName(){
        System.out.println("What is your name?");
        name = input.next();


        //recursive thingy for the name
        if (confirm(0, name)){
            return name;
        }
        else {
            setName();
        }
        return null;
    }

    //confirmation code
    public boolean confirm(int application, String characterProperty) {

        //changes question based on what's being confirmed (switch doesn't work for some reason)
        if (application == 0){
            confirmationQuestion = "Your name is ";
        }
        else if (application == 1){
            confirmationQuestion = "You're ";
        }

        System.out.println(confirmationQuestion + characterProperty + ", right? Type yes to confirm.");

        if (input.next().equals("yes")){
            confirmation = true;
        }
        else{
            confirmation = false;
        }
        return confirmation;
    }

    //gets race
    public String setRace(){

        raceIntro();
        race = input.next();

        //cycles through possible races
        for(int i = 0; i < 4; i++) {
            if (validRaces[i].equals(race)) {
                raceResult = race;
            }
        }

        //only accepts valid races ("reasoner" is the default value for the string). If invalid, fetches race again.
        if (raceResult.equals("reason")){
            System.out.println("Invalid answer! Try again!");
            setRace();
        }

        //recursive thingy for the race
        if (confirm(1, raceResult)){
            return raceResult;
        }
        else {
            setRace();
        }
        return null;
    }


    //introduces and describes races to player
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