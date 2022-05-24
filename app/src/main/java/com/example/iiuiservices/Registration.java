package com.example.iiuiservices;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registration extends AppCompatActivity {
    TextInputLayout fname,Lname,email,password,Phonenumber;
    Button CAccount_btn;
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        hide the Action bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registration);

        // getting data from registration form by id
        fname = findViewById(R.id.fname);
        Lname = findViewById(R.id.Lname);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.RPassword);
        Phonenumber = findViewById(R.id.Phonenumber);

       ////////////////////////////////For internet Check//////////////////////
        broadcastReceiver = new ConnectionReceiver();
        register();

        CAccount_btn = findViewById(R.id.CAccount);

        ProgressBar pb =  findViewById(R.id.loadingProgress);

        CAccount_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String Fname = fname.getEditText().getText().toString();
                String lname = Lname.getEditText().getText().toString();
                String Email = email.getEditText().getText().toString();
                String Password = password.getEditText().getText().toString();
                String phonenumber = Phonenumber.getEditText().getText().toString();


                if(TextUtils.isEmpty(Fname)) {
                    fname.setError("Your message");
                    return;
                }
                if(TextUtils.isEmpty(Email)) {
                    email.setError("E-mail is Required");
                    return;
                }
                else if(TextUtils.isEmpty(Password)) {
                    password.setError("Your message");
                    return;
                }

                else if(TextUtils.isEmpty(phonenumber)) {
                    Phonenumber.setError("Your message");
                    return;
                }
                pb.setVisibility(View.VISIBLE);
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
       /////////////////////////////Send Verification link to user E-mail/////////////////////////////
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(Registration.this,"Please check your E-mail. We sent E-mail verification Link",Toast.LENGTH_LONG).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Registration.this," E-mail verification Link is not send",Toast.LENGTH_LONG).show();

//                                 Log.d(TAG,"E-mail Not Sent" + e.getMessage());
                                }
                            });

                            HashMap<String,String> map= new HashMap<>();
                            map.put("Firstname", Fname);
                            map.put("lastname",lname);
                            map.put("Email",Email);
                            map.put("Phone_Number",phonenumber);

                            String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            DatabaseReference dr = FirebaseDatabase.getInstance().getReference().child("users").child(id);
                            dr.setValue(map);

                            pb.setVisibility(View.INVISIBLE);
                            Snackbar.make(view,"Your Account is created Successfully",Snackbar.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else {
                            pb.setVisibility(View.INVISIBLE);
                            Snackbar.make(view,"Your account is not created",Snackbar.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }

    protected  void register(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    public void Login(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}