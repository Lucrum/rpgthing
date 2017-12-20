public class actOne {
    //class that stores dialogue and other story elements in Act One

    private static int startLine;
    private static int endLine;

    private static String[] storyDialogue = new String[]{

            //0
            "...",
            "\"Oh, great, you're awake!\"",
            "The first thing you notice is the heady smell of food",

            //1
            //text goes here
    };

    public static void dialogue(int lineID){

        switch(lineID){
            case 0:{
                startLine = 0;
                endLine = 2;
            }
        }


        for(int i = startLine; i <= endLine; i++){
            System.out.println(storyDialogue[i]);
            try{
                Thread.currentThread().sleep(1000);
            }
            catch(InterruptedException ex){
                System.out.println(GAEM2.apology);
                Thread.currentThread().interrupt();
            }
        }
    }
}