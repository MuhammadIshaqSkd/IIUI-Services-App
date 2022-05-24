package com.example.iiuiservices;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

public class luncher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luncher);


        Objects.requireNonNull(getSupportActionBar()).hide();

        Thread mythread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(2000);

                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        mythread.start();
    }
}