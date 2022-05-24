package com.example.iiuiservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;
import java.util.List;

public class GPA_Calculator extends AppCompatActivity {
    TextView gpa,resd,Cgpa,resd2,C_cgpa,resd3,User1;
    EditText P_GPA,P_CH;
    SharedPreferences sp;
    String grds,sub,crdes;
    Button saveResulth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_calculator);

        /////////////////////////////////////////////// Remove Actionbar///////////////////////////////////////////////////////
        getSupportActionBar().hide();
        saveResulth = findViewById (R.id.button2);
        saveResulth.setVisibility (View.INVISIBLE);


        ///////////////////////////////////////////////Spinner Grader 1//////////////////////////////////

        List<String> grades = Arrays.asList("select","A", "B+", "B", "C+", "C", "D+", "D", "F");

        final Spinner spinner = findViewById(R.id.S1_G);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, grades);
        spinner.setAdapter(adapter);

        ///////////////////////////////////////////////ENds///////////////////////////////////////////////


        ///////////////////////////////////////////////Spinner Grader 2//////////////////////////////////

        List<String> grades2 = Arrays.asList("select","A", "B+", "B", "C+", "C", "D+", "D", "F");

        final Spinner spinner2 = findViewById(R.id.S1_G2);

//
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, grades2);
        spinner2.setAdapter(adapter2);

        ///////////////////////////////////////////////ENds///////////////////////////////////////////////


        ///////////////////////////////////////////////Spinner Grader 3//////////////////////////////////

        List<String> grades3 = Arrays.asList("select","A", "B+", "B", "C+", "C", "D+", "D", "F");

        final Spinner spinner3 = findViewById(R.id.S1_G3);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, grades3);
        spinner3.setAdapter(adapter3);

        ///////////////////////////////////////////////ENds///////////////////////////////////////////////



        ///////////////////////////////////////////////Spinner Grader 4//////////////////////////////////

        List<String> grades4 = Arrays.asList("select","A", "B+", "B", "C+", "C", "D+", "D", "F");

        final Spinner spinner4 = findViewById(R.id.S1_G4);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, grades4);
        spinner4.setAdapter(adapter4);

        ///////////////////////////////////////////////ENds///////////////////////////////////////////////



        ///////////////////////////////////////////////Spinner Grader 5//////////////////////////////////

        List<String> grades5 = Arrays.asList("select","A", "B+", "B", "C+", "C", "D+", "D", "F");

        final Spinner spinner5 = findViewById(R.id.S1_G5);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, grades5);
        spinner5.setAdapter(adapter5);

        ///////////////////////////////////////////////ENds///////////////////////////////////////////////

        ///////////////////////////////////////////////Spinner Grader 6//////////////////////////////////

        List<String> grades6 = Arrays.asList("select","A", "B+", "B", "C+", "C", "D+", "D", "F");

        final Spinner spinner6 = findViewById(R.id.S1_G6);

        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, grades6);
        spinner6.setAdapter(adapter6);

        ///////////////////////////////////////////////ENds///////////////////////////////////////////////



        ///////////////////////////////////Spinner Credit Hours 1////////////////////////////////////////


        Integer[] arraySpinner = new Integer[] {
                0,2,3,4
        };
        Spinner s = (Spinner) findViewById(R.id.S1_CH);
        ArrayAdapter<Integer> adapters = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapters);

        ////////////////////////////////////////////////////////ENDS/////////////////////////////////////////

        ///////////////////////////////////Spinner Credit Hours 2////////////////////////////////////////


        Integer[] arraySpinner2 = new Integer[] {
                0,2,3,4
        };
        Spinner s2 = (Spinner) findViewById(R.id.S1_CH2);
        ArrayAdapter<Integer> adapters2 = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arraySpinner2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(adapters2);

        ////////////////////////////////////////////////////////ENDS/////////////////////////////////////////



        ///////////////////////////////////Spinner Credit Hours 3////////////////////////////////////////


        Integer[] arraySpinner3 = new Integer[] {
                0,2,3,4
        };
        Spinner s3 = (Spinner) findViewById(R.id.S1_CH3);
        ArrayAdapter<Integer> adapters3 = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arraySpinner3);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(adapters3);

        ////////////////////////////////////////////////////////ENDS/////////////////////////////////////////


        ///////////////////////////////////Spinner Credit Hours 4////////////////////////////////////////


        Integer[] arraySpinner4 = new Integer[] {
                0,2,3,4
        };
        Spinner s4 = (Spinner) findViewById(R.id.S1_CH4);
        ArrayAdapter<Integer> adapters4 = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arraySpinner4);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(adapters4);

        ////////////////////////////////////////////////////////ENDS/////////////////////////////////////////

///////////////////////////////////Spinner Credit Hours 5////////////////////////////////////////


        Integer[] arraySpinner5 = new Integer[] {
                0,2,3,4
        };
        Spinner s5 = (Spinner) findViewById(R.id.S1_CH5);
        ArrayAdapter<Integer> adapters5 = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arraySpinner5);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s5.setAdapter(adapters5);

        ////////////////////////////////////////////////////////ENDS/////////////////////////////////////////


///////////////////////////////////Spinner Credit Hours 6////////////////////////////////////////


        Integer[] arraySpinner6 = new Integer[] {
                0,2,3,4
        };
        Spinner s6 = (Spinner) findViewById(R.id.S1_CH6);
        ArrayAdapter<Integer> adapters6 = new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_item, arraySpinner6);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s6.setAdapter(adapters6);

        ////////////////////////////////////////////////////////ENDS/////////////////////////////////////////



        /////////////////////////////////////ON CLICK//////////////////////////////////////////////////


        gpa = findViewById(R.id.gpa);
        resd = findViewById(R.id.res);
        Cgpa = findViewById(R.id.CH_text);
        resd2 = findViewById(R.id.C_H);
        C_cgpa = findViewById(R.id.CGPA_text);
        resd3 = findViewById(R.id.CGPA);
        P_CH  = findViewById(R.id.P_CH);
        P_GPA = findViewById(R.id.P_GPA);

        sp = getSharedPreferences("Gpas", Context.MODE_PRIVATE);


        Button Result = findViewById(R.id.button);
        Result.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String Grade = spinner.getSelectedItem().toString();

                double result,count = 0,count2=0,Total=0,Count=0,PCH=0,PCGP=0,p=0,P_CHs;



                String P_Ch = P_CH.getText().toString();
                String P_CPGA = P_GPA.getText().toString();

                float mnum1=0,mnum2=0;
                if(TextUtils.isEmpty(P_CPGA)) {
                    mnum1=0;
                    mnum2=0;
                }
                else if(TextUtils.isEmpty(P_Ch)) {
                    mnum2=0;
                    mnum1=0;
                }
                else {
                    mnum1= Float.parseFloat(P_Ch);
                    mnum2= Float.parseFloat(P_CPGA);
                }

                if(mnum2 > 4.0){
                    P_GPA.setError("CGPA is not greater than 4");
                    return;
                }



                float res=mnum1*mnum2;


                ///////////////////////// for subject 1////////////////////////////

                switch (Grade) {
                    case "A": {

                        int a = Integer.parseInt(s.getSelectedItem().toString());
                        result = a * 4.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B+": {

                        int a = Integer.parseInt(s.getSelectedItem().toString());
                        result = a * 3.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B": {
                        int a = Integer.parseInt(s.getSelectedItem().toString());
                        result = a * 3.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C+": {
                        int a = Integer.parseInt(s.getSelectedItem().toString());
                        result = a * 2.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C": {
                        int a = Integer.parseInt(s.getSelectedItem().toString());
                        result = a * 2.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D+": {
                        int a = Integer.parseInt(s.getSelectedItem().toString());
                        result = a * 1.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D": {
                        int a = Integer.parseInt(s.getSelectedItem().toString());
                        result = a * 1.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "F": {
                        int a = Integer.parseInt(s.getSelectedItem().toString());
                        result = a * 0.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                }
                //////////////////////////////////////// END subject 1////////////////////////////


                ////////////////////////////////////// for subject 2////////////////////////////


                String Grade2 = spinner2.getSelectedItem().toString();

                switch (Grade2) {
                    case "A": {

                        int a = Integer.parseInt(s2.getSelectedItem().toString());
                        result = ((double) a * 4.0);
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B+": {

                        int a = Integer.parseInt(s2.getSelectedItem().toString());
                        result = a * 3.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B": {
                        int a = Integer.parseInt(s2.getSelectedItem().toString());
                        result = a * 3.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C+": {
                        int a = Integer.parseInt(s2.getSelectedItem().toString());
                        result = a * 2.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C": {
                        int a = Integer.parseInt(s2.getSelectedItem().toString());
                        result = a * 2.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D+": {
                        int a = Integer.parseInt(s2.getSelectedItem().toString());
                        result = a * 1.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D": {
                        int a = Integer.parseInt(s2.getSelectedItem().toString());
                        result = a * 1.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "F": {
                        int a = Integer.parseInt(s2.getSelectedItem().toString());
                        result = a * 0.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                }

                ////////////////////////////////////////////Subject 2 END////////////////////////////////////////////////////////

                ////////////////////////////////////// for subject 2////////////////////////////


                String Grade3 = spinner3.getSelectedItem().toString();

                switch (Grade3) {
                    case "A": {

                        int a = Integer.parseInt(s3.getSelectedItem().toString());
                        result = ((double) a * 4.0);
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B+": {

                        int a = Integer.parseInt(s3.getSelectedItem().toString());
                        result = a * 3.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B": {
                        int a = Integer.parseInt(s3.getSelectedItem().toString());
                        result = a * 3.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C+": {
                        int a = Integer.parseInt(s3.getSelectedItem().toString());
                        result = a * 2.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C": {
                        int a = Integer.parseInt(s3.getSelectedItem().toString());
                        result = a * 2.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D+": {
                        int a = Integer.parseInt(s3.getSelectedItem().toString());
                        result = a * 1.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D": {
                        int a = Integer.parseInt(s3.getSelectedItem().toString());
                        result = a * 1.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "F": {
                        int a = Integer.parseInt(s3.getSelectedItem().toString());
                        result = a * 0.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                }

                ////////////////////////////////////////////Subject 3 END////////////////////////////////////////////////////////


                ////////////////////////////////////// for subject 4////////////////////////////


                String Grade4 = spinner4.getSelectedItem().toString();

                switch (Grade4) {
                    case "A": {

                        int a = Integer.parseInt(s4.getSelectedItem().toString());
                        result = ((double) a * 4.0);
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B+": {

                        int a = Integer.parseInt(s4.getSelectedItem().toString());
                        result = a * 3.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B": {
                        int a = Integer.parseInt(s4.getSelectedItem().toString());
                        result = a * 3.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C+": {
                        int a = Integer.parseInt(s4.getSelectedItem().toString());
                        result = a * 2.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C": {
                        int a = Integer.parseInt(s4.getSelectedItem().toString());
                        result = a * 2.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D+": {
                        int a = Integer.parseInt(s4.getSelectedItem().toString());
                        result = a * 1.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D": {
                        int a = Integer.parseInt(s4.getSelectedItem().toString());
                        result = a * 1.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "F": {
                        int a = Integer.parseInt(s4.getSelectedItem().toString());
                        result = a * 0.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                }

                ////////////////////////////////////////////Subject 4 END////////////////////////////////////////////////////////



                ////////////////////////////////////// for subject 5////////////////////////////


                String Grade5 = spinner5.getSelectedItem().toString();

                switch (Grade5) {
                    case "A": {

                        int a = Integer.parseInt(s5.getSelectedItem().toString());
                        result = ((double) a * 4.0);
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B+": {

                        int a = Integer.parseInt(s5.getSelectedItem().toString());
                        result = a * 3.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B": {
                        int a = Integer.parseInt(s5.getSelectedItem().toString());
                        result = a * 3.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C+": {
                        int a = Integer.parseInt(s5.getSelectedItem().toString());
                        result = a * 2.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C": {
                        int a = Integer.parseInt(s5.getSelectedItem().toString());
                        result = a * 2.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D+": {
                        int a = Integer.parseInt(s5.getSelectedItem().toString());
                        result = a * 1.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D": {
                        int a = Integer.parseInt(s5.getSelectedItem().toString());
                        result = a * 1.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "F": {
                        int a = Integer.parseInt(s5.getSelectedItem().toString());
                        result = a * 0.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                }

                ////////////////////////////////////////////Subject 5 END////////////////////////////////////////////////////////



                ////////////////////////////////////// for subject 6////////////////////////////


                String Grade6 = spinner6.getSelectedItem().toString();

                switch (Grade6) {
                    case "A": {

                        int a = Integer.parseInt(s6.getSelectedItem().toString());
                        result = ((double) a * 4.0);
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B+": {

                        int a = Integer.parseInt(s6.getSelectedItem().toString());
                        result = a * 3.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "B": {
                        int a = Integer.parseInt(s6.getSelectedItem().toString());
                        result = a * 3.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C+": {
                        int a = Integer.parseInt(s6.getSelectedItem().toString());
                        result = a * 2.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "C": {
                        int a = Integer.parseInt(s6.getSelectedItem().toString());
                        result = a * 2.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D+": {
                        int a = Integer.parseInt(s6.getSelectedItem().toString());
                        result = a * 1.5;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "D": {
                        int a = Integer.parseInt(s6.getSelectedItem().toString());
                        result = a * 1.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                    case "F": {
                        int a = Integer.parseInt(s6.getSelectedItem().toString());
                        result = a * 0.0;
                        count = count + result;
                        count2 = count2 + a;
                        break;
                    }
                }

                ////////////////////////////////////////////Subject 5 END////////////////////////////////////////////////////////



                //////////////////////////////////////////////////Total GPA RESULT//////////////////////////////////////////////
                Total = ((double) count/count2);
                Count = (( double) count2);
                String s=Double.toString(Total);


                resd.setText("Your GPA ");
                gpa.setText(s);

                count =count+res;
                count2 = count2+mnum1;
                String s2=Double.toString(count2);
                Total = ((double) count/count2);
                String s3=Double.toString(Total);




                Cgpa.setText("Total Credit Hours ");
                resd2.setText(s2);

//                P_GPA.setText(String.valueOf(res));

                C_cgpa.setText("Your CGPA is ");
                resd3.setText(s3);
//
//                sub = gpa.getText().toString();
//                grds = resd2.getText().toString();
//                crdes = resd3.getText().toString();
//
//                SharedPreferences.Editor editor = sp.edit();
//
//                editor.putString("subject",sub);
//                editor.putString("GPA",grds);
//                editor.putString("credit",crdes);
//                editor.commit();

                saveResulth.setVisibility (View.VISIBLE);

                ///// END subject 2////////////////////////////
            }

        });

        /////////////////////////////////////////////ENDS//////////////////////////////////////////


    }

    public void save_CGPA_Resulth(View view) {

        sub = gpa.getText().toString();
        grds = resd2.getText().toString();
        crdes = resd3.getText().toString();

        SharedPreferences.Editor editor = sp.edit();

        editor.putString("subject",sub);
        editor.putString("GPA",grds);
        editor.putString("credit",crdes);
        editor.commit();
        Toast.makeText(GPA_Calculator.this,"You're Data has been Saved",Toast.LENGTH_SHORT).show();

    }
}