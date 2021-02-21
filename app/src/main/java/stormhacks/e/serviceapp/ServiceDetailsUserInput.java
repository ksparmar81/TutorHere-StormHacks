package stormhacks.e.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ServiceDetailsUserInput extends AppCompatActivity {

    private TutorManager manager;
    ListView tutorList;
    ArrayList <Tutors> tutors;
    ArrayAdapter arrayAdapter;
    ArrayAdapter newArrayAdapter;
    ArrayList<Tutors> newTutors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_details_user_input);

        manager = TutorManager.getInstance();

        populateListView();
        setUpItemListener();
    }


    private void populateListView() {

        manager.add(new Tutors("A","abc@gmail.com",234-343-4343,"Math Tutor",24,true,true,true,false,"math tutor"));
        manager.add(new Tutors("B","def@gmail.com",234-344-4343,"Math Tutor",22,false,true,false,true,"math tutor"));
        manager.add(new Tutors("C","ghi@gmail.com",234-345-4343,"Math Tutor",18,false,false,true,true,"math tutor"));
        manager.add(new Tutors("D","jkl@gmail.com",234-346-4343,"Math Tutor",20,true,true,true,false,"math tutor"));
        manager.add(new Tutors("A","abc@gmail.com",234-343-4343,"Math Tutor",24,true,true,true,false,"math tutor"));
        manager.add(new Tutors("B","def@gmail.com",234-344-4343,"Math Tutor",22,false,true,false,true,"math tutor"));
        manager.add(new Tutors("C","ghi@gmail.com",234-345-4343,"Math Tutor",18,false,false,true,true,"math tutor"));
        manager.add(new Tutors("D","jkl@gmail.com",234-346-4343,"Math Tutor",20,true,true,true,false,"math tutor"));
        manager.add(new Tutors("A","abc@gmail.com",234-343-4343,"Math Tutor",24,true,true,true,false,"math tutor"));
        manager.add(new Tutors("B","def@gmail.com",234-344-4343,"Math Tutor",22,false,true,false,true,"math tutor"));
        manager.add(new Tutors("C","ghi@gmail.com",234-345-4343,"Math Tutor",18,false,false,true,true,"math tutor"));
        manager.add(new Tutors("D","jkl@gmail.com",234-346-4343,"Math Tutor",20,true,true,true,false,"math tutor"));

        tutorList =(ListView)findViewById(R.id.resultDisplay);

        tutors = new ArrayList<>();
        for(Tutors tutor:manager){
            tutors.add(tutor);
        }

        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,tutors);
        tutorList.setAdapter(arrayAdapter);

    }

    private void setUpItemListener() {
        tutorList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tutors t1 = new Tutors();
                t1 = manager.get(i);
                Intent intent = descriptionActivity.makeLaunchIntent(ServiceDetailsUserInput.this,t1);
                startActivity(intent);
            }
        });
    }

    public static Intent makeLaunchIntent(Context c) {
        Intent intent = new Intent(c, ServiceDetailsUserInput.class);
        return intent;
    }
}
