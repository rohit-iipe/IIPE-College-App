package com.example.iipe_take1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        PDFView pdfView=findViewById(R.id.resultpdf);

        pdfView.fromAsset("Result.pdf").load();
    }
}