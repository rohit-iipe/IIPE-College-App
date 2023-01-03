package com.example.iipe_take1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class TimeTable extends AppCompatActivity {

TextView ch3,pe3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        ch3=findViewById(R.id.ch3);
        pe3=findViewById(R.id.pe3);

        ch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TimeTable.this, "Loading Time Table", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(TimeTable.this,CH3TIMETABLE.class);
                startActivity(intent);
            }
        });

        pe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TimeTable.this, "Loading Time Table", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(TimeTable.this,PE3TIMETABLE.class);
                startActivity(intent);
            }
        });

    }
}