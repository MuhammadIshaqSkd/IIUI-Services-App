package com.example.iiuiservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    TextInputLayout email,Password;
    Button Login_btn;
    TextView VE;

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        //        hide the Action bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);
        broadcastReceiver = new ConnectionReceiver();
        register();

        ProgressBar pb =  findViewById(R.id.loadingProgress);
        Login_btn = findViewById(R.id.Login);
        email     = findViewById(R.id.email);
        Password  = findViewById(R.id.Password);
        VE  = findViewById(R.id.VE);

        VE.setVisibility(View.INVISIBLE);



        Login_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {


                String Email    = email.getEditText().getText().toString();
                String password = Password.getEditText().getText().toString();


                if(TextUtils.isEmpty(Email)) {
                    email.setError("E-mail Required");
                    return;
                }


                if(TextUtils.isEmpty(password)) {
                    Password.setError("Password Required");
                    return;
                }

                pb.setVisibility(View.VISIBLE);
                FirebaseAuth.getInstance().signInWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            String br = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            if(user.isEmailVerified())
                            {
                              Snackbar.make(view,"Your Login  Successfully",Snackbar.LENGTH_LONG).show();
                              pb.setVisibility(View.INVISIBLE);
                              startActivity(new Intent(getApplicationContext(),Home_page.class));
                            }else {
                                pb.setVisibility(View.INVISIBLE);
                                VE.setVisibility(View.VISIBLE);

                            }
                        }
                        else {
                            pb.setVisibility(View.INVISIBLE);
                            Snackbar.make(view,"Invalid E-mail or Password",Snackbar.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
    //////////////////////check internet connection start-2//////////////////////////

    @SuppressLint("ObsoleteSdkInt")
    protected  void register(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }
    //////////////////////check internet connection end-2//////////////////////////


    public void onBackPressed(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

    public void Register(View view) {
        startActivity(new Intent(getApplicationContext(),Registration.class));
    }
    /////////////////////////////Send Password Reset Link Activity Start //////////////////////////////////////////////

    public void Forget_pass(View view) {
        startActivity(new Intent(getApplicationContext(),Forget_Password.class));
    }
    /////////////////////////////Send Password Reset Link Activity  End///////////////////////////////////////////////

}