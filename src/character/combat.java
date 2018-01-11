package character;

import magic.*;

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

    public static int turnCounter;

    //damageModifier reduces the damage of consecutive attacks to prevent it from being too easy
    public static character enterCombat(protagonist player, enemy opponent, int damageModifier){

        character whoWon;

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


    private static int spellCastID;

    //for checking and registering inputs if player is the attacker
    public static void playerTurn(character attacker, character defender, String sInput) {

        //checks what the player wants to do
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
                //TODO: make code that prints out spell book contents

                System.out.println("F for fireball. R for freeze. Q to return to previous menu.");

                String spellCastString = sc.next().toLowerCase();

                //loop that asks for what spell they want
                inputLoop: while(true) {
                    switch (spellCastString) {
                        case "f": {
                            spellCastID = 0;
                            break inputLoop;
                        }
                        case "r": {
                            spellCastID = 1;
                            break inputLoop;
                        }
                        case "q":{
                            sInput = sc.next();
                            playerTurn(attacker, defender, sInput);
                            break inputLoop;
                        }
                        default: {
                            System.out.println("Invalid input.");
                        }
                    }
                }

                spell castedSpell = spellCast.cast(attacker, spellCastID);


                //the following if and else if functions are to check if player has sufficient mana to cast the spell
                if(attacker.mana < castedSpell.getManaCost()){
                    System.out.println("Insufficient mana.");

                    sInput = sc.next();
                    playerTurn(attacker, defender, sInput);
                }


                //if player has enough mana, casts the spell
                else if(attacker.mana >= castedSpell.getManaCost()){

                    System.out.println("You have casted " + castedSpell.getName() + "!");

                    if(castedSpell.spellType == 1){
                        System.out.println(castedSpell.getName() + " has dealt " + attacker.dealMagicDamage(castedSpell, defender) + " damage!");
                    }

                    //subtracts mana cost from mana pool
                    attacker.mana -= castedSpell.getManaCost();

                    defender.addDebuffs(castedSpell.getSpellEffectID());
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

            //prints valid commands
            case "help":
            case "h": {

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

        /*checks for debuffs, sends both attacker (protagonist) and defender
        because of things like turn skips that might apply to other party (or sapping effects)
        */
        checkDebuffs(attacker, defender);
    }

    //for checking and registering inputs if monster/enemy is attacker
    public static void enemyTurn(character attacker, character defender) {
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

        //checks debuffs on enemy
        checkDebuffs(attacker, defender);
    }

    private static void checkDebuffs(character attacker, character defender){

        //cycles through the debuffs array, making sure all entries are clear
        //an entry that isn't clear means there's an active debuff in place
        for(int i = 0; i < attacker.debuffs.length; i++){
            if(attacker.debuffs[i] != 0) {

                effectAction.doEffectAction(defender, attacker, i);

                attacker.debuffs[i]--;
            }
        }
    }
}