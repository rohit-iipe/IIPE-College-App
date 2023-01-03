package com.example.iipe_take1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class PE3TIMETABLE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pe3_timetable);

        PDFView pdfView=findViewById(R.id.timetable);

        pdfView.fromAsset("TIME_TABLE_5TH_SEM_PE.pdf").load();
    }
}