package character;

import magic.*;
import java.util.Scanner;
import utilities.pause;

public class character {
    //has stats and info for all characters (temporary values, can be manipulated)
    protected String name;
    protected double health, maxHealth, agility, strength, speed, intelligence, defense, magicResist;
    protected int mana;
    protected String race;
    protected spell[] spellbook;
    protected int[] debuffs = new int[10];
    protected int[] buffs;
    protected int mastery;

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getAgility() {
        return agility;
    }

    public double getDefense() {
        return defense;
    }

    public double getStrength() {
        return strength;
    }

    public double getSpeed() {
        return speed;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public String getRace() {
        return race;
    }

    public double getMana() {
        return mana;
    }

    public spell[] getSpellbook() {
        return spellbook;
    }

    public double getMagicResist() {
        return magicResist;
    }

    public int[] getDebuffs() {
        return debuffs;
    }

    public int[] getBuffs(){
        return buffs;
    }
    
    public int getMastery(){
        return mastery;
    }



    /*integer identifier for race, makes for easier usage
        0 = human
        1 = elven
        2 = dwarven
        3 = amalian
         */

    private static int raceID;

    public int getRaceID(){
        return raceID;
    }

    //IDs for the races
    private static String[] validRaces = new String[] {
            "human", "elven", "dwarven", "amalian", "god"
    };

    //comparison values when leaving character.combat, prevents stats from being permanently buffed
    protected double normHealth, normAgility, normDefense, normStrength, normSpeed, normMagicResist, normIntelligence;

    public double getNormHealth() {
        return normHealth;
    }

    public double getNormAgility() {
        return normAgility;
    }

    public double getNormDefense() {
        return normDefense;
    }

    public double getNormStrength() {
        return normStrength;
    }

    public double getNormSpeed() {
        return normSpeed;
    }

    public double getNormIntelligence() {
        return normIntelligence;
    }

    public double getNormMagicResist() {
        return normMagicResist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setMaxHealth(double maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setSpellbook(spell[] spellbook) {
        this.spellbook = spellbook;
    }

    public void setMagicResist(double magicResist) {
        this.magicResist = magicResist;
    }

    public void addDebuffs(int debuffID){
        this.debuffs[debuffID] = effect.effectDurationArray[debuffID];
    }

    public String raceString;


    //necessary variables for character.character creation
    private String confirmationQuestion;

    private Scanner input = new Scanner(System.in);

    private static String[] raceDescriptions = new String[]{
            "Choose your race, you can only choose one:",
            "\nAmalian" + "\nThe amalian race is the largest race on the continent. They are an unorganized bunch, but they make up for it with strength.",
            "\nElven" + "\nThe elven race is the beating heart of magic on the continent, using skill points and superior magic to bring down their enemies.",
            "\nDwarven" + "\nThe dwarven race is the forge of the continent. Having superior tools and weapons, they have superior defensive stats, making up for their short stature.",
            "\nHuman" + "\nThe human race is known as the weakest, having little in terms of strength. However, they compensate with their intellect and versatility."
    };



    //gets name
    public void setName(int attempt){

        if(attempt != 1) {
            System.out.println("What is your name?");
        }
        else{
            System.out.println("What is your name then?");
        }

        String givenName = input.next();


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
    [6] = mana pool
     */

    private String[] baseStatsStructure = new String[]{
            "Health: ",
            "Agility: ",
            "Defense: ",
            "Strength: ",
            "Speed: ",
            "Intelligence: ",
            "Mana: "
    };

    private int[] humanBaseStats = new int[]{
            100,
            50,
            10,
            30,
            50,
            60,
            125
    };
    private int[] elvenBaseStats = new int[]{
            85,
            40,
            5,
            10,
            40,
            75,
            200
    };
    private int[] dwarvenBaseStats = new int[]{
            120,
            30,
            12,
            45,
            30,
            25,
            100
    };
    private int[] amalianBaseStats = new int[]{
            110,
            65,
            15,
            40,
            65,
            30,
            95
    };
    private int[] godBaseStats = new int[]{
            10000000,
            10000000,
            10000000,
            10000000,
            10000000,
            10000000,
            10000000
    };


    private int[] array;

    //confirmation code
    private boolean confirm(int application, String characterProperty) {

        boolean confirmation;

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

                //debug race
                case "god":{
                    array = godBaseStats;
                    break;
                }
            }

            for(int i = 0; i < array.length; i++){
                System.out.println(baseStatsStructure[i] + array[i]);
                pause.sleepThread(100);
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

        switch(raceString){
            case "human":
            case "h":{
                raceString = "human";
                break;
            }

            case "elven":
            case "e":{
                raceString = "elven";
                break;
            }

            case "dwarven":
            case "d":{
                raceString = "dwarven";
                break;
            }

            case "amalian":
            case "a":{
                raceString = "amalian";
                break;
            }

            case "god":{
                raceString = "god";
                break;
            }

            default:{
                System.out.println("Invalid race. Try again.");
                setRace(1);
            }


        }

        //recursive thingy for the race
        if (!(confirm(1, raceString))){
            setRace(1);
        }
        else{
            this.race = raceString;
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
            case "god":{
                raceID = 4;
            }
        }
    }


    //introduces and describes races to player
    private static void raceIntro(){

        for (int i = 0; i < 5; i++){
            System.out.println(raceDescriptions[i]);

            //pauses the printing for 1 second, so it isn't just spat out at you simultaneously and is more organic
            pause.sleepThread(1000);
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
        this.mana = array[6];
    }

    //END OF CHARACTER CREATION-------------------

    private double damageDealt;
    //lowers hp in combat
    public double dealPhysicalDamage(character victim){
        damageDealt = Math.ceil(this.strength * (1 - (75)/(victim.defense + 75)));

        if (damageDealt < 0){
            damageDealt = 1;
        }

        victim.setHealth(victim.getHealth() - damageDealt);

        return damageDealt;
    }

    public double dealMagicDamage(spell Spell, character victim){
        damageDealt = Spell.getDamage() * ((75)/(victim.magicResist + 75));

        victim.health -= damageDealt;
        return damageDealt;
    }


    //prints current stats, such as mana or health
    public void currentStats(){
        System.out.println(this.name + "'s stats");
        pause.sleepThread(100);
        System.out.println("Health: " + this.health);
        pause.sleepThread(100);
        System.out.println("Mana: " + this.mana);
    }
}
