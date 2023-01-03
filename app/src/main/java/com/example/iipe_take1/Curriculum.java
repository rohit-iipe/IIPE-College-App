package com.example.iipe_take1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Curriculum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);

        PDFView pdfView=findViewById(R.id.curriculumpdf);

        pdfView.fromAsset("Syllabus_Chemical_Engineering.pdf").load();
    }
}