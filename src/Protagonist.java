import java.util.Scanner;
import java.util.SortedMap;

class Protagonist extends Character {

    private static Scanner sc = new Scanner(System.in);


    public int mana;
    public String[] inventory;
    public String[] skills;
    public int coins;

    /* keeps track of player state (out of combat, in town, etc) and determines the commands the player can use
    0 = intro/tutorial
    1 = in combat
    2 = in town
    3 = in shop
    4 = traveling
    etc
     */

    public int playerState;

    public int getPlayerState(){
        return playerState;
    }

    //variables required for combat system
    public Character whoWon;
    private String[] combatCommands = new String[]{
            "\nAttack",
            "Item",
            "Guard",
            "Stats"
    };

    //prints current stats, such as mana or health
    public void currentStats(){
        System.out.println("\nYour stats");
        System.out.println("Health: " + this.health);
        GAEM2.pause(200);
        System.out.println("Mana: " + this.mana);
    }

    //damageModifier reduces the damage of consecutive attacks to prevent it from being too easy
    public Character enterCombat(Protagonist player, enemy opponent, int damageModifier){

        int turnCounter = 0;
        player.playerState = 1;

        //holds the damage modifier, allows it to return it its normal value after consecutive attacks
        int damageModifierHolder = damageModifier;

        //prints out opponent's stats with delay
        System.out.println("Opponent stats");
        GAEM2.pause(100);
        System.out.println("Health: " + opponent.health);
        GAEM2.pause(100);
        System.out.println("Strength: " + opponent.strength);
        GAEM2.pause(100);
        System.out.println("Agility: " + opponent.agility);
        GAEM2.pause(100);
        System.out.println("Speed: " + opponent.speed);
        GAEM2.pause(100);
        System.out.println("Defense: " + opponent.defense);

        while (opponent.health > 0 && player.health > 0) {

            System.out.println("\nTurn " + turnCounter);

            //outputs options

            if (opponent.speed >= player.speed) {
                //does it if opponent is the attacker
                enemyAttack(opponent, player);

                //resets any handicaps
                damageModifier = damageModifierHolder;
                player.speed = player.normSpeed;

                turnCounter++;
            }

            else {
                //does it if player is attacker or speed is the same
                //adds an input and compares it
                player.currentStats();
                for(int i = 0; i <= 3; i++){
                    System.out.println(combatCommands[i]);
                }
                String sInput = sc.next().toLowerCase();
                playerAttack(player, opponent, sInput);

                //reduces speed, allows player to attack multiple times if sufficiently quick
                player.speed /= 2;
                //reduces damage per subsequent attack by 25%
                damageModifier *= .75;

                turnCounter++;
            }
        }

        //checks whose health is 0 or lower (dead) and outputs who wins
        if (opponent.health <= 0) {
            whoWon = player;
            player.playerState = 0;
        }

        else {
            whoWon = opponent;
            player.playerState = 0;
        }
        //returns whoWon to use for later on
        return whoWon;
    }


    //for checking and registering inputs if player is the attacker
    private void playerAttack(Protagonist attacker, Character defender, String sInput) {

        switch(sInput){

            case "attack":{
                System.out.println("You have done " + attacker.strength + " damage!");
                //attacks second, in this case monster
                defender.loseHp(attacker.strength);
                break;
            }

            case "guard":{
                //change defense by a multiple of 1.5
                attacker.defense = Math.floor(1.5 * attacker.defense);
                System.out.println("Your defense is now " + attacker.defense + "!");
                break;
            }

            case "item":{
                System.out.println(/*a method to produce all the inventory*/);
                sInput = sc.next();
                playerAttack(attacker, defender, sInput);
                //insert method that checks if a input is part of the string
                //insert method that uses the inventory
                break;
            }

            //code that outputs the stats of both parties. Does not consume a turn.
            case "stats":{

                //prints out opponent's stats with delay
                System.out.println("Opponent stats");
                GAEM2.pause(100);
                System.out.println("Health: " + defender.health);
                GAEM2.pause(100);
                System.out.println("Strength: " + defender.strength);
                GAEM2.pause(100);
                System.out.println("Agility: " + defender.agility);
                GAEM2.pause(100);
                System.out.println("Speed: " + defender.speed);
                GAEM2.pause(100);
                System.out.println("Defense: " + defender.defense);

                GAEM2.pause(500);
                System.out.println("---------------------");
                GAEM2.pause(500);

                //prints your stats with delay
                System.out.println("Your stats");
                GAEM2.pause(100);
                System.out.println("Health: " + attacker.health);
                GAEM2.pause(100);
                System.out.println("Strength: " + attacker.strength);
                GAEM2.pause(100);
                System.out.println("Agility: " + attacker.agility);
                GAEM2.pause(100);
                System.out.println("Speed: " + attacker.speed);
                GAEM2.pause(100);
                System.out.println("Defense: " + attacker.defense);


                sInput = sc.next().toLowerCase();
                playerAttack(attacker, defender, sInput);
                break;
            }

            default:{
                //tries again if input is not a registered input
                System.out.println("Sorry, command is not recognized. Try again.");

                sInput = sc.next().toLowerCase();
                playerAttack(attacker, defender, sInput);
                break;
            }
        }
    }

    //for checking and registering inputs if monster/enemy is attacker
    private static void enemyAttack(Character attacker, Protagonist defender) {
        //if health is low, has a higher chance to defend
        if (Math.random() > 0.05 * attacker.maxHealth / (attacker.health + 1)) {
            //prints out
            System.out.println("Monster has done " + attacker.strength + " damage!");
            //attacks second, in this case player
            defender.loseHp(attacker.strength);
        }

        else {
            //change defense by a multiple of 1.5
            attacker.defense *= 1.5;
            //prints out
            System.out.println("The enemy defense is now " + attacker.defense + "!");
        }

    }
}