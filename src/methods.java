import com.sun.xml.internal.bind.v2.TODO;

public class methods {

    /*
    TODO
    Fix confirmation bug
     */

    public static String processedInput;
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static String name;
    public static String confirmation = "no";

    //fetches name
    public static String fetchName(){
        System.out.println("What is your name?");
        name = scanner.next();
        while (!(confirmation == "yes")){
            System.out.println(name + " is your name. Type 'yes' to confirm.");
            if (scanner.next().equals("yes")){
                confirmation = "yes";
                return name;
            }
            else {
                System.out.println(confirmation);
                fetchName();
            }
        }
        confirmation = "no";
        return name;
    }


    //fetches nationality
    public static String fetchNationality(){
        System.out.println("Choose your nationality, you can only choose one:" +
                "\nAmalian" +
                "\nThe amalian race is the largest race on the continent. Unorganized, but strong in terms of damage and mediocre defense." +
                "\nElven" +
                "\nThe elven race is the magic of the continent, using skill points and superior magic. They are also relatively taller." +
                "\nDwarven" +
                "\nThe dwarven race is the forge of the continent. Having superior tools and weapons, they also have good defense while being relatively shorter." +
                "\nHuman" +
                "\nThe human race is the most intelligent; having lots of skill points and a larger level difference.");
        switch (scanner.next()) {
            case "amalian": {
                Character.nationality = "amalian";
            }
            case "elven": {
                Character.nationality = "elven";
            }
            case "dwarven": {
                Character.nationality = "dwarven";
            }
            case "human": {
                Character.nationality = "human";
            }
            default:
                scanner.next();
        }
        return Character.nationality;
    }

    public static void assureNationality(String nationality){
        System.out.println("You're a " + nationality + ", right?");
        if (scanner.next() == "yes"){
        }
    }

    //combat menu options
    public static String userInput(String uInput){
        switch(uInput){
            case "attack":{
            }
            case "items":{
            }
            case "flee":{
            }
        }
        return processedInput;
    }


}