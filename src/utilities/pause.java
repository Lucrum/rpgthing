package utilities;

public class pause {

    public static void sleepThread(int ms){
        try{
            Thread.currentThread().sleep(ms);
        }
        catch(InterruptedException ex){
            System.out.println("Something went wrong and we don't know how to fix it.");
            Thread.currentThread().interrupt();
        }
    }
}