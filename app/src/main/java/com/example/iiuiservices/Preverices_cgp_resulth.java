package com.example.iiuiservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Preverices_cgp_resulth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preverices_cgp_resulth);
        getSupportActionBar().hide();
        ////////////////Store CPA RESULT/////////////

        TextView t1,t2,t3;
        t1 = findViewById(R.id.cgpa);
        t2 = findViewById(R.id.credit);
        t3 = findViewById(R.id.GPA);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("Gpas", Context.MODE_PRIVATE);
        String subject = sp.getString("subject","");
        String GPA = sp.getString("GPA","");
        String credit = sp.getString("credit","");
//
        t1.setText(subject);
        t2.setText(GPA);
        t3.setText(credit);
        ///////////////////////////CGPA STORE RESULT END ///////////////////

    }

    public void onBackPressed (){
        finish ();
        finish ();
//         startActivity (new Intent ( getApplicationContext (),Home_page.class ));
    }
}