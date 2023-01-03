package com.example.iipe_take1;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile extends AppCompatActivity {
    FirebaseFirestore db;
    DatabaseReference databaseReference;

    TextView name, roll, gender, dob, nat, bg, rel, add, cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = (TextView) findViewById(R.id.student_name);
        roll = (TextView) findViewById(R.id.student_roll);
        gender = (TextView) findViewById(R.id.gender);
        dob = (TextView) findViewById(R.id.dob);
        nat = (TextView) findViewById(R.id.nationality);
        bg = (TextView) findViewById(R.id.blood);
        rel = (TextView) findViewById(R.id.religion);
        add = (TextView) findViewById(R.id.address);
        cont = (TextView) findViewById(R.id.contact);

        db = FirebaseFirestore.getInstance();
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String docId = "details";
        DocumentReference document = db.collection(email).document(docId);
        document.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    name.setText(documentSnapshot.getString("name"));
                    roll.setText(documentSnapshot.getString("roll"));
                    gender.setText(documentSnapshot.getString("gender"));
                    dob.setText(documentSnapshot.getString("dob"));
                    nat.setText(documentSnapshot.getString("nat"));
                    bg.setText(documentSnapshot.getString("bg"));
                    rel.setText(documentSnapshot.getString("rel"));
                    add.setText(documentSnapshot.getString("add"));
                    cont.setText(documentSnapshot.getString("cont"));


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
