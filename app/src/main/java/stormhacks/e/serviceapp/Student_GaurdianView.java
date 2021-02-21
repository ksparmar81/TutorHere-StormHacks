package stormhacks.e.serviceapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Student_GaurdianView extends AppCompatActivity {


    Button subjectBtn, daysBtn, locationBtn;
    boolean subjectClicked,daysClicked ,locationClicked;
    private int selectedSubjectPos,selectedDaysPos,selectedLocationPos;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__gaurdian_view);


        setSubjects();
        setDays();
        setRange();
    }

    private void setSubjects(){

        subjectBtn = (Button)findViewById(R.id.subjectBtn);

        subjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems = getResources().getStringArray(R.array.subjects);
                checkedItems = new boolean[listItems.length];
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Student_GaurdianView.this);
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if(isChecked){
                            if(!mUserItems.contains(position)) {
                                mUserItems.add(position);
                            }
                        }
                        else if(mUserItems.contains(position)){
                            mUserItems.remove(position);
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for(int i=0;i<mUserItems.size();i++){
                            item = item + listItems[mUserItems.get(i)];
                            if(i!= mUserItems.size()-1){
                                item = item +",";
                            }
                        }
                        subjectBtn.setText(item);
                    }
                });
                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for(int j=0;j<checkedItems.length;j++){
                            checkedItems[j] = false;
                            mUserItems.clear();
                            subjectBtn.setText("SELECT");
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });



    }

    private void setDays(){
        daysBtn = (Button)findViewById(R.id.daysBtn);


        daysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItems = getResources().getStringArray(R.array.days);
                checkedItems = new boolean[listItems.length];
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(Student_GaurdianView.this);
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if(isChecked){
                            if(!mUserItems.contains(position)) {
                                mUserItems.add(position);
                            }
                        }
                        else if(mUserItems.contains(position)){
                            mUserItems.remove(position);
                        }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for(int i=0;i<mUserItems.size();i++){
                            item = item + listItems[mUserItems.get(i)];
                            if(i!= mUserItems.size()-1){
                                item = item +",";
                            }
                        }
                       daysBtn.setText(item);
                    }
                });
                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for(int j=0;j<checkedItems.length;j++){
                            checkedItems[j] = false;
                            mUserItems.clear();
                            daysBtn.setText("SELECT");
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

    }

    private void setRange() {
        SeekBar rangeBar = (SeekBar)findViewById(R.id.rangeSeekBar);
        final TextView progessTV = (TextView)findViewById(R.id.progressTV);

        rangeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progessTV.setText(""+(progress*10)+"km from location");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public static Intent makeLaunchIntent(Context c) {
        Intent intent = new Intent(c, Student_GaurdianView.class);
        return intent;
    }
}
