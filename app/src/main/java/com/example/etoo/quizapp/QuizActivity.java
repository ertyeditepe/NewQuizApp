package com.example.etoo.quizapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.etoo.quizapp.R.id.genderGroup;

public class QuizActivity extends AppCompatActivity {
    Button yes,no;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9;
    ScrollView homePage;
    RadioGroup genderGroupButtons;
    private boolean smokeCheck = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);}





        //No button hides if yes button clicked once and shown the hidden part.

            public void noButton(View view) {
                no = findViewById(R.id.noButton);
                LinearLayout hiddenPart = findViewById(R.id.hiddenPartLayout);
                hiddenPart.setVisibility(LinearLayout.INVISIBLE);
                homePage.setBackgroundResource(R.drawable.home_page);
                return;
            }

        //Yes button shows hidden part of form.

            public void yesButton(View view) {
                yes = findViewById(R.id.yesButton);
                LinearLayout hiddenPart = findViewById(R.id.hiddenPartLayout);
                hiddenPart.setVisibility(LinearLayout.VISIBLE);
                homePage =findViewById(R.id.arkaPlan);
                homePage.setBackgroundResource(R.drawable.yes_button);
                smokeCheck = true;
            }

    public void sendFeedback(View view) {
        // Do click handling here
        final EditText nameText = findViewById(R.id.nameTextView);
        String name = nameText.getText().toString();
        TextView checkedGender = findViewById(genderGroupButtons.getCheckedRadioButtonId());
        String gender = checkedGender.getText().toString();
        final Spinner spinnerFeedback =findViewById(R.id.durationSpinnerView);
        String clickedSpinner = spinnerFeedback.getSelectedItem().toString();
        String feedbackSummary = createFeedbackSummary(name,gender,clickedSpinner,knownRisks());
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.putExtra(Intent.EXTRA_SUBJECT,"Quiz Summary For " + name);
        intent.putExtra(Intent.EXTRA_TEXT," " + feedbackSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }}
    public String knownRisks()
    {
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        String strMessage = "";
        if(c1.isChecked())
        { strMessage+="Going Blind "; }
        if(c2.isChecked())
        { strMessage+="\nType 2 Diabetes "; }
        if(c3.isChecked())
        { strMessage+="\nErectile Dysfunction"; }
        if(c4.isChecked())
        { strMessage+="\nEctopic Pregnancy"; }
        if(c5.isChecked())
        { strMessage+="\nHip Fractures"; }
        if(c6.isChecked())
        { strMessage+="\nColorectal Cancer"; }
        if(c7.isChecked())
        { strMessage+="\nFertility Issues"; }
        if(c8.isChecked())
        { strMessage+="\nGum Disease"; }
        if(c9.isChecked())
        { strMessage+="\nHigh Cholesterol";}
            return strMessage;
        }

    public String createFeedbackSummary(String addName,String addGender,String addDuration,String knownRisk) {
        String summary = "Name : " + addName;
        summary += "\n" + "Gender : " + addGender;
        summary += "\n" + "Does he/she smoke ?: " + smokeCheck;
        summary += "\n" + getString(R.string.durationQuestion) +" :"+ addDuration;
        summary += "\n" + "What risks does he know ?: " + knownRisk;
        return summary;
    }
}



