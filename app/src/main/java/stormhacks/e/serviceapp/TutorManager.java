package stormhacks.e.serviceapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TutorManager implements Iterable<Tutors> {

    private static TutorManager instance;
    TutorManager(){

    }
    public static TutorManager getInstance(){
        if(instance == null){
            instance = new TutorManager();
        }
        return instance;
    }

    private List<Tutors> tutorStore = new ArrayList<>();

    public void add(Tutors tutor){
        tutorStore.add(tutor);
    }

    public Tutors get(int i){
        return tutorStore.get(i);
    }

    public int size(){
        return tutorStore.size();
    }

    public void printFunction(List<Tutors> tutors){
        System.out.println("All tutors for you:");
        for(int i =0 ; i<tutors.size() ; i++){
            System.out.println("  "+i+". "+tutors.get(i));
        }
        System.out.println("  "+"(-1 to exit)\n:");
    }

    public void printGet(){
        printFunction(tutorStore);
    }

    @Override
    public Iterator<Tutors>iterator(){
        return tutorStore.iterator();
    }
}
