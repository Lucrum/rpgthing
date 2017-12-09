class Scenes{
    //story and all the other text crap

    private static String[] raceDescriptions = new String[]{
            "Choose your race, you can only choose one:",
            "\nAmalian" + "\nThe amalian race is the largest race on the continent. Unorganized, but strong in terms of damage and mediocre defense.",
            "\nElven" + "\nThe elven race is the magic of the continent, using skill points and superior magic. They are also relatively taller.",
            "\nDwarven" + "\nThe dwarven race is the forge of the continent. Having superior tools and weapons, they also have good defense while being relatively shorter.",
            "\nHuman" + "\nThe human race is the most intelligent; having lots of skill points and a larger level difference."
    };

    public static void raceIntro(){

        for (int i = 0; i < 5; i++){
            System.out.println(raceDescriptions[i]);

            //Pauses the printing for 1 second, so it isn't just spat out at you
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    }


    public static void print(String input, int sceneCount, boolean onScene, Protagonist you) {

        switch(sceneCount){
            case 0: {
                System.out.println("Once upon a time, in a continent of many different races mingled and interacted.");
            }
            case 1: {
                System.out.println("However, they were divided between the Radical faith and Vita faith.");
            }
            case 2: {
                System.out.println("The Radical faith believed in the one true god and the deities associated with him, while the Vita faith believed in Tessera (the goddess of order), Aporie (the god of chaos), and Custus (the gate guardian).");
            }
            case 3: {
                System.out.println("Tessera and Aporie made Tempus (the god of time), Locua (the goddess of space), Magik (the goddess of mana), and Vita (the goddess of creation). However, Aporie wanted them dead and Tessera locked him up with the power of Custus.");
            }
            case 4: {
                System.out.println("Tempus and Locua loved each other. However, Aporie, in his final effort, cursed them by separating them so that they always are together, but never can meet.");
            }
            case 5: {
                System.out.println("Vita, devasated, tried to make her siblings again with Magik's help. They failed many times, creating nothings, until they made a life form similar to a slime.");
            }
            case 6: {
                System.out.println("The slime was too innocent compared to the nothings and she decided to keep it as a reminder of her siblings, and the slime was left alone on a rock she made called 'Earth.'");
            }
            case 7: {
                System.out.println("There, the slime grew and specialized: first with fish, then lizards, then dragons, mammals, amalians, and the rest of the races.");
            }
            case 8: {
                System.out.println("Many Radical faith believers say that amalians are cursed humans and humans were first (as their worshippers are all human), however, Vita believers the opposite.");
            }
            case 9: {
                System.out.println("However, with magic, they both agree that mages require a tribute of mana and a prayer to Magik (an agreed-on deity) in order to cast a spell.");
            }
            case 10: {
                //add stuffs
            }
        }
    }
}
