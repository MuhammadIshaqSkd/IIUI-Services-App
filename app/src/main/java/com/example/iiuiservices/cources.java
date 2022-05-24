package com.example.iiuiservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class cources extends AppCompatActivity {
    Spinner s;
    Button submite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cources);

                getSupportActionBar().hide();


        String[] arraySpinner = new String[] {
                "BSSE", "BSCS", "BSIT",
        };
        s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);


/////////////////////// ON SUBMITE /////////////////////////////////////////////////////////////////

        submite = findViewById(R.id.submitte);

        submite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valToSet = s.getSelectedItem().toString();

                if(valToSet == "BSIT"){
                    startActivity(new Intent(getApplicationContext(),bsit_courses.class));
                }
                if(valToSet == "BSSE"){
                    startActivity(new Intent(getApplicationContext(),BSSE.class));
                }
                if(valToSet == "BSCS"){
                    startActivity(new Intent(getApplicationContext(),bscs.class));
                }

            }
        });

///////////////////////////////////////////ENDS ////////////////////////////////////////////////////



    }
}