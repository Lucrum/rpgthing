package character;

import magic.*;
import java.util.Scanner;

public class character {
    //has stats and info for all characters (temporary values, can be manipulated)
    public String name;
    public int health;
    public int maxHealth;
    public int agility;
    public double defense;
    public int strength;
    public int speed;
    public int intelligence;
    public String race;
    public int mana;
    public spell[] spellbook;
    public int magicResist;

    /*integer identifier for race, makes for easier usage
    0 = human
    1 = elven
    2 = dwarven
    3 = amalian
     */
    protected static int raceID;

    public int getRaceID(){
        return raceID;
    }

    //IDs for the races
    private static String[] validRaces = new String[] {
            "human", "elven", "dwarven", "amalian"
    };

    //comparison values when leaving character.combat, prevents stats from being permanently buffed
    public int normHealth;
    public int normAgility;
    public double normDefense;
    public int normStrength;
    public int normSpeed;
    public int normIntelligence;
    public int normMagicResist;


    public String raceString;


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

    /*arrays for storing stats of the characters
    [0] = health
    [1] = agility
    [2] = defense (armor)
    [3] = strength
    [4] = speed
    [5] = intelligence
     */

    private String[] baseStatsStructure = new String[]{
            "Health: ",
            "Agility: ",
            "Defense: ",
            "Strength: ",
            "Speed: ",
            "Intelligence: "
    };

    private int[] humanBaseStats = new int[]{
            20,
            5,
            2,
            5,
            5,
            10
    };
    private int[] elvenBaseStats = new int[]{
            18,
            4,
            1,
            5,
            5,
            15
    };
    private int[] dwarvenBaseStats = new int[]{
            25,
            2,
            4,
            7,
            3,
            2
    };
    private int[] amalianBaseStats = new int[]{
            25,
            5,
            3,
            10,
            7,
            3
    };


    private int[] array;

    //confirmation code
    private boolean confirm(int application, String characterProperty) {

        //changes question based on what's being confirmed (switch doesn't work for some reason)
        if (application == 0){
            confirmationQuestion = "Your name is ";
        }
        else if (application == 1){

            switch(characterProperty){
                //human
                case "human":{
                    array = humanBaseStats;
                    break;
                }

                //elven
                case "elven":{
                    array = elvenBaseStats;
                    break;
                }

                //dwarven
                case "dwarven":{
                    array = dwarvenBaseStats;
                    break;
                }

                //amalian
                case "amalian":{
                    array = amalianBaseStats;
                    break;
                }
            }

            for(int i = 0; i < array.length; i++){
                System.out.println(baseStatsStructure[i] + array[i]);
                pause(100);
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



    //defines base stats based on the ID of the race.
    public void defineBaseStats(){
        this.normHealth = this.health = array[0];
        this.normAgility = this.agility = array[1];
        this.normDefense = this.defense = array[2];
        this.normStrength = this.strength = array[3];
        this.normSpeed = this.speed = array[4];
        this.normIntelligence = this.intelligence = array[5];
    }

    int damageDealt;
    //lowers hp in combat
    public int dealPhysicalDamage(character victim){
        damageDealt = (int)(Math.ceil(this.strength * (1 - (75)/(victim.defense + 75))));

        if (damageDealt < 0){
            damageDealt = 1;
        }

        return damageDealt;
    }

    public int dealMagicDamage(spell Spell, character victim){
        damageDealt = Spell.damage * ((75)/(victim.magicResist + 75));

        victim.health -= damageDealt;
        return damageDealt;
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
