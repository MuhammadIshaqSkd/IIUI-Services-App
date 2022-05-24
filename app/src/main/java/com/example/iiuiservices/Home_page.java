package com.example.iiuiservices;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.iiuiservices.databinding.ActivityHomePageBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Home_page extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomePageBinding binding;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //        hide the Action bar
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();


        binding = ActivityHomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.appBarHomePage.toolbar);
        DrawerLayout drawer = binding.drawerLayout;

        ////////////////////////////////// set the textview values ///////////////////////////////////////
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View HView = navigationView.getHeaderView(0);
        TextView User1=(TextView) HView.findViewById(R.id.user);
        TextView User2=(TextView) HView.findViewById(R.id.user2);
        DatabaseReference dc = FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        dc.addValueEventListener(new ValueEventListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User1.setText(snapshot.child("Firstname").getValue().toString());
                User2.setText(snapshot.child("lastname").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
////////////////////////////////////////////// Set textView Value in Navigatiom bar////////////////////////////


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,R.id.nav_About)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home_page);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }




    public void onBackPressed(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Logout")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

//        super.onBackPressed();
    }

    public void Hostal(View view) {
//        Toast.makeText(Home_page.this,"Hostal  click",Toast.LENGTH_LONG).show();

        startActivity(new Intent(getApplicationContext(),iiui_hostel.class));
    }

    public void GPA_calculator(View view) {
        startActivity(new Intent(getApplicationContext(),GPA_Calculator.class));
    }

    public void Courses(View view) {
       startActivity(new Intent(getApplicationContext(),cources.class));

    }

    public void Buses(View view) {
        startActivity(new Intent(getApplicationContext(),IIUI_Buses_Routes.class));

    }

    public void FYP(View view) {
//        Toast.makeText(Home_page.this,"Fyp  click",Toast.LENGTH_LONG).show();

        startActivity(new Intent(getApplicationContext(),fyp.class));

    }

    public void Con(View view) {
        startActivity(new Intent(getApplicationContext(),IIUI_Contact_list.class));
    }

    ////////////////LogOut button/menu //////////////////////////////////// 
    public void logout(MenuItem item) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to Logout")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public void Pre(MenuItem item) {
        startActivity (new Intent ( getApplicationContext (),Preverices_cgp_resulth.class ));
    }



    public void rating(MenuItem item) {
        startActivity (new Intent ( getApplicationContext (),Ratingbar.class ));
    }

    ////////////////LogOut button/menu End ////////////////////////////////////

}