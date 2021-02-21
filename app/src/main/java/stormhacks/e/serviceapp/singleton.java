package stormhacks.e.serviceapp;

public class singleton {

    /*
    singleton support
     */
    private static singleton instance;
    singleton(){

    }
    public static singleton getInstance(){
        if(instance == null){
            instance = new singleton();
        }
        return instance;
    }


}
