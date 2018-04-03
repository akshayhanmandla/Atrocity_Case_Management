package com.testexample.atrocity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Fakeform extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button B4;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference usersRef = ref.child("users");
EditText e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fakeform);
        rg = (RadioGroup) findViewById(R.id.rgroup);
    B4 = findViewById(R.id.btnsubmit);

        rb = findViewById(R.id.radioButton);
    }
    public void rbclick(View v) {
        e3 = (EditText) findViewById(R.id.firnumber);
        int radiobuttonid=rg.getCheckedRadioButtonId();
        rb = findViewById(R.id.radioButton);
        final String Val = rb.getText().toString();
       final String Firn = e3.getText().toString();

        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersRef.child(Firn).child("Status_of_case").setValue(Val);
                usersRef.child(Firn).child("CaseNotation").setValue("No further Payments - Report to nearest Police Station");
            }
        });

    }
}