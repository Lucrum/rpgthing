import java.util.Scanner;

public class Character{
    //has stats and info for all characters (temporary values, can be manipulated)
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int agility;
    protected double defense;
    protected int strength;
    protected int speed;
    protected int intelligence;

    /*integer identifier for race, makes for easier usage
    0 = human
    1 = elven
    2 = dwarven
    3 = amalian
     */
    static protected int raceID;

    //IDs for the races
    private static String[] validRaces = new String[] {
            "human", "elven", "dwarven", "amalian"
    };

    //comparison values when leaving combat, prevents stats from being permanently buffed
    protected int normHealth;
    protected int normAgility;
    protected double normDefense;
    protected int normStrength;
    protected int normSpeed;
    protected int normIntelligence;


    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAgility() {
        return agility;
    }

    public double getDefense() {
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

    public String raceString;

    public int getRaceID(){
        return raceID;
    }

    //necessary variables for character creation
    private String confirmationQuestion;
    private boolean confirmation;
    private String raceResult = "reason";

    Scanner input = new Scanner(System.in);

    private static String[] raceDescriptions = new String[]{
            "Choose your race, you can only choose one:",
            "\nAmalian" + "\nThe amalian race is the largest race on the continent. They are an unorganized bunch, but they make up for it with strength.",
            "\nElven" + "\nThe elven race is the beating heart of magic on the continent, using skill points and superior magic to bring down their enemies.",
            "\nDwarven" + "\nThe dwarven race is the forge of the continent. Having superior tools and weapons, they have superior defensive stats, making up for their short stature.",
            "\nHuman" + "\nThe human race is known as the weakest, having little in terms of strength. However, they compensate with their intellect and versatility."
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

        if (input.next().toLowerCase().equals("yes")){
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
        raceString = input.next().toLowerCase();

        //cycles through possible races
        for(int i = 0; i < 4; i++) {
            if (validRaces[i].equals(raceString)) {
                raceResult = raceString;
            }
        }

        //only accepts valid races ("reason" is the default value for the string). If invalid, fetches race again.)
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

    //turns race into an integer for easy usage
    public void setRaceID(String race){
        switch (race){
            case "human": {
                raceID = 0;
                break;
            }
            case "elven": {
                raceID = 1;
                break;
            }
            case "dwarven": {
                raceID = 2;
                break;
            }
            case "amalian": {
                raceID = 3;
                break;
            }
        }
    }


    //introduces and describes races to player
    private static void raceIntro(){

        for (int i = 0; i < 5; i++){
            System.out.println(raceDescriptions[i]);

            //pauses the printing for 1 second, so it isn't just spat out at you simultaneously and is more organic
            GAEM2.pause(1000);
        }
    }

    public void defineBaseStats(int raceID){
        switch (raceID){
            case 0:{
                //human
                this.health = 20;
                this.agility = 5;
                this.defense = 2;
                this.strength = 5;
                this.speed = 5;
                this.intelligence = 10;
            }
            case 1:{
                //elven
                this.health = 18;
                this.agility = 4;
                this.defense = 1;
                this.strength = 5;
                this.speed = 5;
                this.intelligence = 15;
            }
            case 2:{
                //dwarven
                this.health = 25;
                this.agility = 2;
                this.defense = 4;
                this.strength = 7;
                this.speed = 3;
                this.intelligence = 2;
            }
            case 3:{
                //amalian
                this.health = 25;
                this.agility = 5;
                this.defense = 3;
                this.strength = 10;
                this.speed = 7;
                this.intelligence = 3;
            }
        }
        this.normAgility = this.agility;
        this.normDefense = this.defense;
        this.normHealth = this.health;
        this.normStrength = this.strength;
        this.normSpeed = this.speed;
        this.normIntelligence = this.intelligence;
    }

    //lowers hp in combat
    public void loseHp(int damage){
        this.health -= damage;
    }
}