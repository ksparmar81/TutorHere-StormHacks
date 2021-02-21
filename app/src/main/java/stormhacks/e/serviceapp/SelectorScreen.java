package stormhacks.e.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectorScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_screen);
        launchStudentViewButton();
    }

    private void launchStudentViewButton() {
        Button stdBtn = (Button)findViewById(R.id.studentViewBtn);
        stdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = Student_GaurdianView.makeLaunchIntent(SelectorScreen.this);
                startActivity(i);
            }
        });
    }


    public static Intent makeLaunchIntent(Context c) {
        Intent intent = new Intent(c, SelectorScreen.class);
        return intent;
    }
}