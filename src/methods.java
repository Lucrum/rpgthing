public class methods {

    /*
    TODO make nationality work
     */


    //Declares all variables used in this class
    private static java.util.Scanner scanner = new java.util.Scanner(System.in);
    private static String name;
    private static boolean confirmation;
    private static String nationality;
    private static String confirmationQuestion;
    private static String action;

    //fetches name
    public static String fetchName(){
        System.out.println("What is your name?");
        name = scanner.next();


        //recursive thingy for the name
        if (confirm("name", name)){
            return name;
        }
        else {
            fetchName();
        }
        return null;
    }

    //TODO for some reason only uses case "race" in the question. pls fix

    //confirmation code
    public static boolean confirm(String application, String characterProperty) {

        //changes question based on what's being confirmed
        switch(application){
            case "name":{
                confirmationQuestion = "Your name is ";
            }
            case "race":{
                confirmationQuestion = "You're a ";
            }
        }

        System.out.println(confirmationQuestion + characterProperty + ", right? Type yes to confirm");

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

        Scenes.raceIntro();

        nationality = scanner.next();

        //Need to filter the nationalities so system rejects any invalid ones

        confirm("race", nationality);
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
        return action;
    }


}