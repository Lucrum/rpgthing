package character;

import magic.*;
import java.util.Scanner;

public class character {
    //has stats and info for all characters (temporary values, can be manipulated)
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int agility;
    protected double defense;
    protected int strength;
    protected int speed;
    public int intelligence;
    protected String race;
    public int mana;
    protected spell[] spellbook;

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

    //comparison values when leaving character.combat, prevents stats from being permanently buffed
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

    //necessary variables for character.character creation
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

    //pause code
    public static void pause(int ms){
        try{
            Thread.currentThread().sleep(ms);
        }
        catch(InterruptedException ex){
            System.out.println("Something went wrong and we don't know how to fix it.");
            Thread.currentThread().interrupt();
        }
    }

    private String givenName;
    //gets name
    public void setName(int attempt){

        if(attempt != 1) {
            System.out.println("What is your name?");
        }
        else{
            System.out.println("What is your name then?");
        }

        givenName = input.next();


        //recursive thingy for the name
        if (!(confirm(0, givenName))){
            setName(1);
        }
        else{
            this.name = givenName;
        }
    }

    //arrays for storing stats of the characters
    private String[] humanBaseStats = new String[]{
            "Health : 20",
            "Agility: 5",
            "Defense: 2",
            "Strength: 5",
            "Speed: 5",
            "Intelligence: 10"
    };
    private String[] elvenBaseStats = new String[]{
            "Health : 18",
            "Agility: 4",
            "Defense: 1",
            "Strength: 5",
            "Speed: 5",
            "Intelligence: 15"
    };
    private String[] dwarvenBaseStats = new String[]{
            "Health : 25",
            "Agility: 2",
            "Defense: 4",
            "Strength: 7",
            "Speed: 3",
            "Intelligence: 2"
    };
    private String[] amalianBaseStats = new String[]{
            "Health : 25",
            "Agility: 5",
            "Defense: 3",
            "Strength: 10",
            "Speed: 7",
            "Intelligence: 3"
    };



    //confirmation code
    public boolean confirm(int application, String characterProperty) {

        //changes question based on what's being confirmed (switch doesn't work for some reason)
        if (application == 0){
            confirmationQuestion = "Your name is ";
        }
        else if (application == 1){
            switch(characterProperty){
                case "human":{
                    System.out.println("\nStats");
                    pause(100);
                    for(int i = 0; i < 6; i++){
                        System.out.println(humanBaseStats[i]);
                        pause(100);
                    }
                    break;
                }
                case "elven":{
                    System.out.println("\nStats");
                    pause(100);
                    for(int i = 0; i < 6; i++){
                        System.out.println(elvenBaseStats[i]);
                        pause(100);
                    }
                    break;
                }
                case "dwarven":{
                    System.out.println("\nStats");
                    pause(100);
                    for(int i = 0; i < 6; i++){
                        System.out.println(dwarvenBaseStats[i]);
                        pause(100);
                    }
                    break;
                }
                case "amalian":{
                    System.out.println("\nStats");
                    pause(100);
                    for(int i = 0; i < 6; i++){
                        System.out.println(amalianBaseStats[i]);
                        pause(100);
                    }
                    break;
                }
            }
            confirmationQuestion = "\nYou're ";
        }

        System.out.println(confirmationQuestion + characterProperty + ", right? Type yes to confirm.");

        switch(input.next().toLowerCase()){
            case "yes":{
                confirmation = true;
                break;
            }
            default:{
                confirmation = false;
                break;
            }
        }

        return confirmation;
    }


    //gets race
    public void setRace(int attempt){

        if(attempt != 1){
            raceIntro();
        }
        else{
            System.out.println("What is your race, then?");
        }

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
            setRace(1);
        }

        //recursive thingy for the race
        if (!(confirm(1, raceResult))){
            setRace(1);
        }
        else{
            this.race = raceResult;
        }
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
            pause(1000);
        }
    }

    //defines base stats based on the ID of the race. Please update array above if these values change.
    public void defineBaseStats(int raceID){
        switch (raceID){
            case 0:{
                //human
                health = 20;
                agility = 5;
                defense = 2;
                strength = 5;
                speed = 5;
                intelligence = 10;
                break;
            }
            case 1:{
                //elven
                health = 18;
                agility = 4;
                defense = 1;
                strength = 5;
                speed = 5;
                intelligence = 15;
                break;
            }
            case 2:{
                //dwarven
                health = 25;
                agility = 2;
                defense = 4;
                strength = 7;
                speed = 3;
                intelligence = 2;
                break;
            }
            case 3:{
                //amalian
                health = 25;
                agility = 5;
                defense = 3;
                strength = 10;
                speed = 7;
                intelligence = 3;
                break;
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
    public int physicalDamage(int strength, double defense){
        int dmg = (int)(strength - defense);

        if (dmg < 0){
            dmg = 1;
        }

        this.health -= dmg;
        return dmg;
    }

    public void magicDamage(spell Spell, character victim){

    }


    //prints current stats, such as mana or health
    public void currentStats(){
        System.out.println(this.name + "'s stats");
        pause(100);
        System.out.println("Health: " + this.health);
        pause(100);
        System.out.println("Mana: " + this.mana);
    }
}
