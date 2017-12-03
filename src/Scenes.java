/**
 * Created by JJ on 12/2/2017.
 */
class Scenes{
    //story
    public static void print(String input, int sceneCount, boolean onScene, Protagonist you) {
        if (sceneCount == 0) {
            System.out.println("Once upon a time, in a continent of many different races mingling and interacting.");
        }
        if (sceneCount == 1) {
            System.out.println("However, they were divided between the Radical faith and Vita faith.");
        }
        if (sceneCount == 2) {
            System.out.println("The Radical faith believed in the one true god and the deities associated with him, while the Vita faith believed in Tessera (the goddess of order), Aporie (the god of chaos), and Custus (the gate guardian).");
        }
        if (sceneCount == 3) {
            System.out.println("Tessera and Aporie made Tempus (the god of time), Locua (the goddess of space), Magik (the goddess of mana), and Vita (the goddess of creation). However, Aporie wanted them dead and Tessera locked him up with the power of Custus.");
        }
        if (sceneCount == 4) {
            System.out.println("Tempus and Locua loved each other. However, Aporie, in his final effort, cursed them by separating them so that they always are together, but never can meet.");
        }
        if (sceneCount == 5) {
            System.out.println("Vita, devasated, tried to make her siblings again with Magik's help. They failed many times, creating nothings, until they made a life form similar to a slime.");
        }
        if (sceneCount == 6) {
            System.out.println("The slime was too innocent compared to the nothings and she decided to keep it as a reminder of her siblings, and the slime was left alone on a rock she made called 'Earth.'");
        }
        if (sceneCount == 7) {
            System.out.println("There, the slime grew and specialized: first with fish, then lizards, then dragons, mammals, amalians, and the rest of the races.");
        }
        if (sceneCount == 8) {
            System.out.println("Many Radical faith believers say that amalians are cursed humans and humans were first (as their worshippers are all human), however, Vita believers the opposite.");
        }
        if (sceneCount == 9) {
            System.out.println("However, with magic, they both agree that mages require a tribute of mana and a prayer to Magik (an agreed-on deity) in order to cast a spell.");
        }
        if (sceneCount == 10) {
            System.out.println("You are a young " + you.nationality + " and in the Vita faith, fight the Radical faith and uncover secrets about your own faith.");
        }
    }
}
