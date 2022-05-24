package com.example.iiuiservices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class Forget_Password extends AppCompatActivity {
    EditText Semail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        getSupportActionBar().hide();
        Semail = findViewById(R.id.sendEmail);
    }
    /////////////////////////////Send Password Reset Link  Start//////////////////////////////////////////////

    public void send_Email_btn(View view) {
        String Email    = Semail.getText().toString();
        if(TextUtils.isEmpty(Email)) {
            Semail.setError("E-mail Required");
            return;
        }
        FirebaseAuth.getInstance().sendPasswordResetEmail(Email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
              if(task.isSuccessful())
              {
                  Toast.makeText(Forget_Password.this, "Please  check your E-mail", Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(getApplicationContext(),MainActivity.class));
              }
              else {
                  Toast.makeText(Forget_Password.this, "Account with this E-mail don't Exit ", Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(getApplicationContext(),MainActivity.class));
              }
            }
        });
        /////////////////////////////Send Password Reset Link End //////////////////////////////////////////////

    }
}