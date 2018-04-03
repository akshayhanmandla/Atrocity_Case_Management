package com.testexample.atrocity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LISTDATA1 extends AppCompatActivity {
    TextView fir_n, na, nam;
    Button collect;
    EditText editText;
    String fir, stat,pymentsta;
    Bundle bundle;
    String value = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata1);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getInstance().getReference("Councellor");
        fir_n = (TextView) findViewById(R.id.fir_n1);

        na = (TextView) findViewById(R.id.na1);
        if (bundle != null) {
            fir = bundle.getString("fir_no");
        DatabaseReference oneref = ref.child(fir);
        oneref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //User2 use = dataSnapshot.getValue(User2.class);
                String name = dataSnapshot.child("Caretaker_name").getValue().toString();
                String name1 = dataSnapshot.child("Cert_id").getValue().toString();
                String name2 = dataSnapshot.child("Docname").getValue().toString();
                String name3 = dataSnapshot.child("Docnum").getValue().toString();
                String name4 = dataSnapshot.child("Victim_Name").getValue().toString();
                String name5 = dataSnapshot.child("Victim_add").getValue().toString();
                String name6 = dataSnapshot.child("Victim_dis").getValue().toString();
                String name7 = dataSnapshot.child("caretaker_num").getValue().toString();
                String name8 = dataSnapshot.child("dissability").getValue().toString();
                String string = "Name: " + name + "\nAddress: " + name1 + "\nstatus: " + name2 + "\nFir_no:  " + name3 +"\nIncident_Date"+name4+"\nIncident_Place"+name5+"\nLocation"+name6+ "\nStage Payment 1:" + name7 + "\nStage Payment 2:" + name8 ;
                na.setText(string);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        }}

}