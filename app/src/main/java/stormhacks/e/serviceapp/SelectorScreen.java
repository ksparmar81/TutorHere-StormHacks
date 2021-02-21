package stormhacks.e.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class SelectorScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector_screen);
    }

    public static Intent makeLaunchIntent(Context c){
        Intent intent = new Intent(c,SelectorScreen.class);
        return intent;
    }
}