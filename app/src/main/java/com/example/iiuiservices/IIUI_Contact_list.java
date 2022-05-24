package com.example.iiuiservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class IIUI_Contact_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iiui_contact_list);

        getSupportActionBar().hide();


        PDFView pdfse = findViewById(R.id.pdfView);

        pdfse.fromAsset("IIUI_Contact_List.pdf")
                .pages(0,1,2,3,4)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)

                .enableAntialiasing(true)
                .spacing(0)
                .autoSpacing(false)

                .fitEachPage(false)
                .pageSnap(false)
                .pageFling(false)
                .nightMode(false)
                .load();
    }
}