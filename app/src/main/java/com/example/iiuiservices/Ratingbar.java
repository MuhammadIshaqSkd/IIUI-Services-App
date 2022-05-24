package com.example.iiuiservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Ratingbar extends AppCompatActivity {
    RatingBar ratingBar;
    TextView rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_ratingbar);
        getSupportActionBar().hide();

/////////////////////Retrieve Store Rating//////////////////////////////
        ratingBar = findViewById (R.id.rating);
        rate = findViewById (R.id.ratetext);
        SharedPreferences sharedPreferences= getSharedPreferences ("rating",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

/////////////////////Retrieve Store Rating end//////////////////////////////

        rate.setText ("");


        float f = sharedPreferences.getInt ("rating", (int) 0f);
        ratingBar.setRating (f);

        ratingBar.setOnRatingBarChangeListener (new RatingBar.OnRatingBarChangeListener ( ) {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                String message = null;

                switch ((int) v){
                    case 1:
                        message = "Terffic";
                        break;
                    case 2:
                        message = "bad";
                        break;
                    case 3:
                        message = "Neutral";
                        break;
                    case 4:
                        message = "Good";
                        break;
                    case 5:
                        message = "Very Good";
                        break;

                }
                rate.setText (message);

                editor.putInt ("rating",(int) v);
                editor.commit ();
                finish ();
            }
        });


    }
}