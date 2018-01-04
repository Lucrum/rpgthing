package character;

import magic.*;

import java.util.Scanner;

public class combat {

    public static void pause(int ms){
        try{
            Thread.currentThread().sleep(ms);
        }
        catch(InterruptedException ex){
            System.out.println("Something went wrong and we don't know how to fix it.");
            Thread.currentThread().interrupt();
        }
    }

    private static Scanner sc = new Scanner(System.in);

    //variables required for character.combat system
    public static character whoWon;
    private static String[] combatCommands = new String[]{
            "Valid commands (first letter works too):",
            "ATTACK",
            "MAGIC",
            "ITEM",
            "GUARD",
            "STATS"
    };


    //damageModifier reduces the damage of consecutive attacks to prevent it from being too easy
    public static character enterCombat(protagonist player, enemy opponent, int damageModifier){

        int turnCounter = 0;
        player.playerState = 1;

        for(int i = 0; i <= 5; i++){
            System.out.println(combatCommands[i]);
        }

        //holds the damage modifier, allows it to return it its normal value after consecutive attacks
        int damageModifierHolder = damageModifier;

        //prints out opponent's stats with delay
        System.out.println("\nOpponent stats");
        pause(100);
        System.out.println("Health: " + opponent.health);
        pause(100);
        System.out.println("Strength: " + opponent.strength);
        pause(100);
        System.out.println("Agility: " + opponent.agility);
        pause(100);
        System.out.println("Speed: " + opponent.speed);
        pause(100);
        System.out.println("Defense: " + opponent.defense);

        while (opponent.health > 0 && player.health > 0) {

            System.out.println("\nTurn " + turnCounter);


            if (opponent.speed >= player.speed) {
                //does it if opponent is the attacker
                enemyTurn(opponent, player);

                //resets any handicaps
                damageModifier = damageModifierHolder;
                player.speed = player.normSpeed;

                turnCounter++;
            }

            else {
                //does it if player is attacker or speed is the same
                //adds an input and compares it
                player.currentStats();
                System.out.println("\n");
                opponent.currentStats();
                System.out.println("\n");
                String sInput = sc.next().toLowerCase();
                playerTurn(player, opponent, sInput);

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
    private static void playerTurn(protagonist attacker, character defender, String sInput) {

        switch(sInput){

            case "attack":
            case "a":{
                System.out.println("You have done " + attacker.strength + " damage!");
                //attacks second, in this case monster
                defender.physicalDamage(attacker.strength, defender.defense);
                break;
            }

            case "magic":
            case "m":{

                //magic code
                spell castedSpell = spellCast.cast(attacker, 0);

                System.out.println("You have casted " + castedSpell.name + "!");

                defender.magicDamage(castedSpell, defender);

                break;
            }

            case "guard":
            case "g":{

                //change defense by a multiple of 1.5
                attacker.defense = Math.floor(1.5 * attacker.defense);
                System.out.println("Your defense is now " + attacker.defense + "!");
                break;
            }

            case "item":
            case "i":{
                System.out.println(attacker.read());
                sInput = sc.next();
                while (!check(sInput)) {
                    System.out.println("Invalid item. Either " + (String) attacker.dataForinventory[where(sInput)][0] + "is not a valid item or it does not exist.");
                    sInput = sc.next();
                }
                change(sInput);
                break;
            }

            //code that outputs the stats of both parties. Does not consume a turn.
            case "stats":
            case "s":{

                //prints out opponent's stats with delay
                System.out.println("Opponent stats");
                pause(100);
                System.out.println("Health: " + defender.health);
                pause(100);
                System.out.println("Strength: " + defender.strength);
                pause(100);
                System.out.println("Agility: " + defender.agility);
                pause(100);
                System.out.println("Speed: " + defender.speed);
                pause(100);
                System.out.println("Defense: " + defender.defense);

                pause(200);
                System.out.println("---------------------");
                pause(200);

                //prints your stats with delay
                System.out.println("Your stats");
                pause(100);
                System.out.println("Health: " + attacker.health);
                pause(100);
                System.out.println("Strength: " + attacker.strength);
                pause(100);
                System.out.println("Agility: " + attacker.agility);
                pause(100);
                System.out.println("Speed: " + attacker.speed);
                pause(100);
                System.out.println("Defense: " + attacker.defense);


                sInput = sc.next().toLowerCase();
                playerTurn(attacker, defender, sInput);
                break;
            }

            case "help":
            case "h": {

                //prints out valid commands
                for(int i = 0; i <= 5; i++){
                    System.out.println(combatCommands[i]);
                }

                sInput = sc.next().toLowerCase();
                playerTurn(attacker, defender, sInput);
                break;
            }

            default:{
                //tries again if input is not a registered input
                System.out.println("Sorry, command is not recognized. Try again. Type \"help\" for available commands.");

                //player's turn again
                sInput = sc.next().toLowerCase();
                playerTurn(attacker, defender, sInput);
                break;
            }
        }
    }

    //for checking and registering inputs if monster/character.enemy is attacker
    private static void enemyTurn(character attacker, protagonist defender) {
        //if health is low, has a higher chance to defend
        if (Math.random() > 0.15 * attacker.maxHealth / (attacker.health + 1)) {
            //attacks second, in this case player
            System.out.println("Monster has done " + defender.physicalDamage(attacker.strength, defender.defense) + " damage!");
        }

        else {
            //change defense by a multiple of 1.5
            attacker.defense *= 1.5;
            //prints out
            System.out.println(attacker.name + "'s defense is now " + attacker.defense + "!");
        }
    }
}
