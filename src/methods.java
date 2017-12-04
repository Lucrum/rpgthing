public class methods {

    /*
    TODO
    Make nationality work
     */

    public static String processedInput;


    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    private static String name;
    private static boolean confirmation;
    private static String confirmationQuestion;
    private static String usage;
    private static String nationality;

    //fetches name
    public static String fetchName(){
        System.out.println("What is your name?");
        name = scanner.next();


        //recursive thingy for the name
        if (confirm(0, name)){
            return name;
        }
        else {
            fetchName();
        }
        return null;
    }

    //confirmation code
    public static boolean confirm(int application, String characterProperty) {

        //changes question based on what's being confirmed
        switch(application){
            case 0:{
                confirmationQuestion = "Your name is ";
                usage = characterProperty;
            }
            case 1:{
                confirmationQuestion = "You're a ";
                usage = characterProperty;
            }
        }

        System.out.println(confirmationQuestion + usage + ", right? Type yes to confirm");
        if (scanner.next().equals("yes")){
            confirmation = true;
        }
        else{
            confirmation = false;
        }
        return confirmation;
    }


    //fetches and confirms nationality
    public static String fetchRace(){
        System.out.println("Choose your nationality, you can only choose one:" +
                "\nAmalian" +
                "\nThe amalian race is the largest race on the continent. Unorganized, but strong in terms of damage and mediocre defense." +
                "\nElven" +
                "\nThe elven race is the magic of the continent, using skill points and superior magic. They are also relatively taller." +
                "\nDwarven" +
                "\nThe dwarven race is the forge of the continent. Having superior tools and weapons, they also have good defense while being relatively shorter." +
                "\nHuman" +
                "\nThe human race is the most intelligent; having lots of skill points and a larger level difference.");

        nationality = scanner.next();

        //Need to filter the nationalities so system rejects any invalid ones

        confirm(1, nationality);
        return nationality;
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