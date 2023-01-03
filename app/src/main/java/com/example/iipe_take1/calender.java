package com.example.iipe_take1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class calender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        PDFView pdfView=findViewById(R.id.calenderpdf);

        pdfView.fromAsset("Academic_calender.pdf").load();
    }
}