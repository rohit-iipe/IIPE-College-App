package com.example.iipe_take1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity {
FirebaseFirestore db;
DatabaseReference databaseReference;
TextView name, roll;

ImageButton timetable;
ImageView profile_pic;
String Sname, Sroll,profileName;
ImageButton profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db = FirebaseFirestore.getInstance();
        name = (TextView) findViewById(R.id.student_name);
        roll = (TextView) findViewById(R.id.student_roll);

        ImageButton curriculum=findViewById(R.id.curriculum_icon);

        timetable=findViewById(R.id.timetable_icon);

        profile=findViewById(R.id.Profile);

        ImageButton attendance=findViewById(R.id.attendance_icon);

        Intent intent=getIntent();
        String email = intent.getStringExtra("email");
        fetchData(email, name, roll);


        switch (email) {
            case "rishikeshrishu@iipe.ac.in":
                profileName = "Rishikesh Rishu";
                break;
            case "rohitkumar_ch@iipe.ac.in":
                profileName = "Rohit Kumar";
                break;
            case "pandeyvishaljitendra@iipe.ac.in":
                profileName = "Vishal Jitendra Pandey";
                break;
            case "gtarunrao.iipe.ac.in":
                profileName = "Tarun";
                break;
        }

        curriculum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Curriculum loading", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity2.this,Curriculum.class);
                startActivity(intent);
            }
        });

        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Time Table Loading", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity2.this,TimeTable.class);
                startActivity(intent);
            }
        });

        //Profile section
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Profile.class);
                intent.putExtra("email",email);
                startActivity(intent);
            }
        });

        // Attendance

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this,attendance.class);
                startActivity(intent);
            }
        });

        // Notice
        ImageButton notice;
        notice=findViewById(R.id.notice_icon);
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this,notice.class);
                startActivity(intent);
            }
        });

        // Library
        ImageButton library;
        library=findViewById(R.id.library_icon);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),library.class);
                intent.putExtra("email",email);
                startActivity(intent);

            }
        });

        // Calender
        ImageButton calender;
        calender=findViewById(R.id.calender_icon);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this,calender.class);
                startActivity(intent);
            }
        });

        // Result
        ImageButton result;
        result=findViewById(R.id.result_icon);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this,result.class);
                startActivity(intent);
            }
        });

        // Contact
        ImageButton contact;
        contact=findViewById(R.id.Contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this,contact.class);
                startActivity(intent);
            }
        });



        //Profile Pic
        profile_pic= findViewById(R.id.profile_pic);
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference();
        DatabaseReference getImage = databaseReference.child(profileName);
        getImage.addListenerForSingleValueEvent(
                new ValueEventListener() {





                    @Override
                    public void onDataChange(
                            @NonNull DataSnapshot dataSnapshot)
                    {
                        // getting a DataSnapshot for the
                        // location at the specified relative
                        // path and getting in the link variable
                        String link = dataSnapshot.getValue(
                                String.class);

                        // loading that data into rImage
                        // variable which is ImageView
                        Picasso.get().load(link).into(profile_pic);
                    }

                    // this will called when any problem
                    // occurs in getting data
                    @Override
                    public void onCancelled(
                            @NonNull DatabaseError databaseError)
                    {
                        // we are showing that error message in
                        // toast
                        Toast
                                .makeText(MainActivity2.this,
                                        "Error Loading Image",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                });



    }

    public void fetchData(String email,TextView name, TextView roll) {

        String docId = "details";
        DocumentReference document = db.collection(email).document(docId);
        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>(){
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot){
                if(documentSnapshot.exists()){
                     Sname = documentSnapshot.getString("name");
                     Sroll = documentSnapshot.getString("roll");
                    name.setText(Sname);
                    roll.setText(Sroll);
            }
        }
    })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Failed to fetch data", Toast.LENGTH_LONG).show();
                    }
                });
}
}
