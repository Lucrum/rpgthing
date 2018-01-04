public class actOne {
    //class that stores dialogue and other story elements in Act One

    private static int startLine;
    private static int endLine;

    private static String[] storyDialogue = new String[]{

            //0 - 4
            "...",
            "...",
            "...",
            "\"Oh, great, you're awake!\"",
            "The first thing you notice is the heady smell of food",
            "\"You had me really worried there!\"",
            "Your crusty eyes open, barely able to focus on anything.",
            ""

            //1
            //text goes here
    };

    public static void dialogue(int lineID){

        //converts the ID of the line into something the array can use
        switch(lineID){
            case 0:
                startLine = 0;
                endLine = 6;
                break;
            /*
            case 1:
                startLine = 5;
                endLine = 6;
                break;
            */
        }


        //prints array's contents based on lines
        for(int i = startLine; i <= endLine; i++){
            System.out.println(storyDialogue[i]);
            GAEM2.pause(1000);
        }
    }
}