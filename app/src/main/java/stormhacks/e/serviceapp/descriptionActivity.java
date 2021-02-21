package stormhacks.e.serviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.Format;

public class descriptionActivity extends AppCompatActivity {

    public static final String TUTOR_NAME = "Tutor Name";
    public static final String TUTOR_EMAIL = "Tutor email";
    public static final String TUTOR_PHONE = "Tutor phone";
    public static final String TUTOR_RATE = "Tutor rate";
    public static final String TUTOR_DESCRIPTION = "Tutor description";
    private TutorManager manager;
    String name,email,description;
    int rate;
    String phone;
    boolean math, science, english , socials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        manager = TutorManager.getInstance();

        extractDataFromIntent();

    }

    private void extractDataFromIntent(){
        Intent intent = getIntent();
        name = intent.getStringExtra(TUTOR_NAME);
        email = intent.getStringExtra(TUTOR_EMAIL);
        description = intent.getStringExtra(TUTOR_DESCRIPTION);
        rate = intent.getIntExtra(TUTOR_RATE,0);
        phone = intent.getStringExtra(TUTOR_PHONE);
        setDetails();
    }
    private void setDetails() {

        TextView nameV = (TextView)findViewById(R.id.nameTV);
        nameV.setText(formatS(name));
        TextView emailV = (TextView)findViewById(R.id.emailTV);
        emailV.setText(formatS(email));
        TextView phoneV = (TextView)findViewById(R.id.phoneTV);
        System.out.println("printing phone"+phone);
        phoneV.setText(formatS(phone));
        TextView rateV = (TextView)findViewById(R.id.rateTV);
        rateV.setText(formatI(rate));
        TextView availabilityV = (TextView)findViewById(R.id.availTV);
        TextView descriptionV = (TextView)findViewById(R.id.descriptionTV);
        descriptionV.setText(formatS(description));

    }

    public static Intent makeLaunchIntent(Context c, Tutors t1) {
        Intent intent = new Intent(c, descriptionActivity.class);

        intent.putExtra(TUTOR_NAME,t1.getName());
        intent.putExtra(TUTOR_EMAIL,t1.getEmail());
        intent.putExtra(TUTOR_PHONE,t1.getPhone());
        intent.putExtra(TUTOR_RATE,t1.getRate());
        intent.putExtra(TUTOR_DESCRIPTION,t1.getDescription());
        return intent;
    }

    private String formatS(String str){
        String s = new String(str);
        return s;
    }
    private String formatI(int num){
        String i = String.valueOf(num);
        return i;

    }

}
