package character;

import item.*;

public class protagonist extends character {


    public item[] inventory;
    public object[][] dataForInventory;
    //String for name
    //boolean for consumable
    //int for amount
    public String[] skills;
    public int coins;
    
    item NOTHING = new item();

    /* keeps track of player state (out of character.combat, in town, etc) and determines the commands the player can use
    0 = intro/tutorial
    1 = in character.combat
    2 = in town
    3 = in shop
    4 = traveling
    etc
     */

    public int playerState;

    public int getPlayerState(){
        return playerState;
    }
    
    //Note: not tested
    //reads the inventory
    public String read() {
        String output = "";
        for (int i = 0; i < inventory.length; i++) {
            output = (String) dataForInventory[i][0];
            if ((boolean) dataForInventory[i][1] == true) {
                ouput = "\nAmount: " + ((int) dataForInventory[i][2]).toString();
            }
            ouput = "\n";
        }
        return output;
    }
    
    public int where(String input) {
        int output = -1;
        for (int i = 0; i < inventory.length; i++) {
            if (sInput.equals(dataForInventory[i][0])) {
                return i;
            }
        }
        return output;
    }
    
    public boolean check(String input) {
        boolean output = false;
        if(where(input) != -1) {
            return true;
        }
        if(!((boolean) dataForInventory[i][1])) {
            return false;
        }
    }
    
    //needs method to change and use item
    public string[][] change(String input) {
        datForInventory[where(input)][2]-=;
        changeNothing();
        for (int i = 0; i < inventory.length; i++) {
            if (sInput.equals(dataForInventory[i][2]) <= 0) {
                inventory[i] = NOTHING;
                dataForInventory[i][0] = "";
                dataForInventory[i][1] = false;
                dataForInventory[i][2] = 0;
            }
        }
        moveOver(inventory);
        moveOver(dataForInventory)
    }
    
    public void moveOver(item[] inventory) {
    }
   
    public void moveOver(object[][] dataForInventory) {
    }
               

}
