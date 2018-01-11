package character;

import magic.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import utilities.pause;

public class combat {


    private static Scanner sc = new Scanner(System.in);

    //variables required for character.combat system
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

        character whoWon;

        int turnCounter = 0;
        player.playerState = 1;

        for(int i = 0; i <= 5; i++){
            System.out.println(combatCommands[i]);
        }

        //holds the damage modifier, allows it to return it its normal value after consecutive attacks
        int damageModifierHolder = damageModifier;

        //prints out opponent's stats with delay
        System.out.println("\nOpponent stats");
        pause.sleepThread(100);
        System.out.println("Health: " + opponent.health);
        pause.sleepThread(100);
        System.out.println("Strength: " + opponent.strength);
        pause.sleepThread(100);
        System.out.println("Agility: " + opponent.agility);
        pause.sleepThread(100);
        System.out.println("Speed: " + opponent.speed);
        pause.sleepThread(100);
        System.out.println("Defense: " + opponent.defense);

        while (opponent.health > 0 && player.health > 0) {

            System.out.println("\nTurn " + turnCounter);


            if (opponent.speed >= player.speed) {
                //does it if opponent is the attacker
                enemyTurn(opponent, player);



                //resets any handicaps
                damageModifier = damageModifierHolder;
                player.speed = player.normSpeed;


                opponent.speed /= 2;


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

                //resets opponent's speed
                opponent.speed = opponent.normSpeed;

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

        //resets any buffs
        player.intelligence = player.normIntelligence;
        player.strength = player.normStrength;
        player.agility = player.normAgility;
        player.defense = player.normDefense;
        player.health = player.normHealth;
        player.speed = player.normSpeed;

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
                attacker.dealPhysicalDamage(defender);
                break;
            }

            case "magic":
            case "m":{

                //magic code

                spell castedSpell = spellCast.cast(attacker, 0);

                if(attacker.mana < castedSpell.getManaCost()){
                    System.out.println("Insufficient mana.");

                    sInput = sc.next();
                    playerTurn(attacker, defender, sInput);
                }


                else if(attacker.mana >= castedSpell.getManaCost()){

                    System.out.println("You have casted " + castedSpell.getName() + "!");

                    if(castedSpell.spellType == 1){
                        System.out.println(castedSpell.getName() + " has dealt " + attacker.dealMagicDamage(castedSpell, defender) + " damage!");
                    }

                    attacker.mana -= castedSpell.getManaCost();

                    defender.addDebuffs(castedSpell.getSpellEffect());
                }

                break;
            }

            case "guard":
            case "g":{

                //change defense by a multiple of 1.5
                attacker.defense = Math.floor(1.5 * attacker.defense);
                System.out.println("Your defense is now " + attacker.defense + "!");
                break;
            }

                //needs to be tested
            case "item":
            case "i":{
                /*System.out.println(attacker.read());
                sInput = sc.next();
                while (!attacker.check(sInput)) {
                    System.out.println("Item does not exist");
                    sInput = sc.next();
                }
                */
                //method to change and use items
                
                
                break;
            }

            //code that outputs the stats of both parties. Does not consume a turn.
            case "stats":
            case "s":{

                //prints out opponent's stats with delay
                System.out.println("Opponent stats");
                pause.sleepThread(100);
                System.out.println("Health: " + defender.health);
                pause.sleepThread(100);
                System.out.println("Strength: " + defender.strength);
                pause.sleepThread(100);
                System.out.println("Agility: " + defender.agility);
                pause.sleepThread(100);
                System.out.println("Speed: " + defender.speed);
                pause.sleepThread(100);
                System.out.println("Defense: " + defender.defense);

                pause.sleepThread(200);
                System.out.println("---------------------");
                pause.sleepThread(200);

                //prints your stats with delay
                System.out.println("Your stats");
                pause.sleepThread(100);
                System.out.println("Health: " + attacker.health);
                pause.sleepThread(100);
                System.out.println("Strength: " + attacker.strength);
                pause.sleepThread(100);
                System.out.println("Agility: " + attacker.agility);
                pause.sleepThread(100);
                System.out.println("Speed: " + attacker.speed);
                pause.sleepThread(100);
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

        //code that checks for debuffs/whatever
        if (!(attacker.checkDebuffs() == 0)){
            for (int i = 0; i < attacker.debuffs.length; i++){

                effect debuff = attacker.debuffs[i];

                effectAction.doEffectAction(defender, attacker, debuff);

            }
        }
    }

    //for checking and registering inputs if monster/character.enemy is attacker
    private static void enemyTurn(character attacker, protagonist defender) {
        //if health is low, has a higher chance to defend
        if (Math.random() > 0.15 * attacker.maxHealth / (attacker.health + 1)) {
            //attacks second, in this case player
            System.out.println(attacker.name + " has done " + attacker.dealPhysicalDamage(defender) + " damage!");
        }

        else {
            //change defense by a multiple of 1.5
            attacker.defense *= 1.5;
            //prints out
            System.out.println(attacker.name + "'s defense is now " + attacker.defense + "!");
        }
    }
}
