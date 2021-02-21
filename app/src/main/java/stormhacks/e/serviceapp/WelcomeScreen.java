package stormhacks.e.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WelcomeScreen extends AppCompatActivity {

    final Handler h = new Handler();
    final Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent i = SelectorScreen.makeLaunchIntent(WelcomeScreen.this);
            startActivity(i);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        launchAnimation();
        setUpContinueButton();
    }


    private void launchAnimation() {
        ImageView animation = (ImageView)findViewById((R.id.imageView));
        TextView animText = (TextView)findViewById(R.id.titleTextView);

        Animation welCome = AnimationUtils.loadAnimation(this,R.anim.fadein);
        Animation textwelCome = AnimationUtils.loadAnimation(this, R.anim.fadein);

        welCome.setDuration(3000);
        textwelCome.setDuration((3000));
        animation.startAnimation(welCome);
        animText.startAnimation(textwelCome);

        launchSelectorScreen();
    }

    private void launchSelectorScreen() {
        h.postDelayed(r,7000);
    }

    private void setUpContinueButton() {
        Button continueBtn = (Button)findViewById(R.id.continueBtn);
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = SelectorScreen.makeLaunchIntent(WelcomeScreen.this);
                startActivity(i);
                h.removeCallbacks(r);
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

    public static Intent makeLaunchIntent(Context c) {
        Intent intent = new Intent(c,WelcomeScreen.class);
        return intent;
    }

}