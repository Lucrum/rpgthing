class Protagonist extends Character {
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

    public void defineBaseStats(String playerRace){
        switch (playerRace){
            case "human": {

            }
        }
    }

    public int getPlayerState(){
        return playerState;
    }
}
