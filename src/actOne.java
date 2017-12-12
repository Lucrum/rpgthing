public class actOne {
    //class that stores dialogue and other story elements in Act One

    //array that stores dialogue
    private static String[] storyDialogue = new String[]{
            "...",
            "\"Oh, great, you're awake!\"",
            "The first thing you notice is the heady smell of food"
    };

    public static int dialogue(int lines){

        for (int i = 0; i < lines; i++){

            System.out.println(storyDialogue[i]);

            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }

        return 0;
    }
}