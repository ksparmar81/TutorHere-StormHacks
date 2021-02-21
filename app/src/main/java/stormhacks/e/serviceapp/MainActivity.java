package stormhacks.e.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchWelcomeScreen();
    }

    private void launchWelcomeScreen(){
        Intent i = WelcomeScreen.makeLaunchIntent(MainActivity.this);
        startActivity(i);
        finish();
    }
}