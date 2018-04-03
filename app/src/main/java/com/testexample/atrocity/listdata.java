package com.testexample.atrocity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class listdata extends AppCompatActivity {
    TextView fir_n, na, nam;
    Button collect;
    EditText editText;
    String fir, stat,pymentsta;
    String value = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getInstance().getReference("users" );
        fir_n = (TextView) findViewById(R.id.fir_n);
        collect = (Button) findViewById(R.id.collected);
        na = (TextView) findViewById(R.id.na);
        editText =(EditText) findViewById(R.id.collby);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            fir = bundle.getString("fir_no");
            stat = bundle.getString("status");
            collect.setText(stat);
            if(stat.isEmpty())
            {
                collect.setVisibility(View.INVISIBLE);

            }
            if (stat.equals("complete")){
                editText.setVisibility(View.VISIBLE);}
            DatabaseReference oneref = ref.child(fir);
            oneref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User2 use = dataSnapshot.getValue(User2.class);
                    String name = use.Name;
                    String sp1 = use.status_of_Payment_1;
                    String sp2 = use.status_of_Payment_2;
                    String sp3 = use.status_of_Payment_3;
                    String fir_no = use.Firno;
                    String status = use.Status_of_case;
                    String address = use.Address;
                    String Incident_Date=use.Incident_Date;
                    String Incident_Place=use.Incident_Place;
                    String Location=use.Location;

                    String string = "Name: " + name + "\nAddress: " + address + "\nstatus: " + status + "\nFir_no:  " + fir_no +"\nIncident_Date"+Incident_Date+"\nIncident_Place"+Incident_Place+"\nLocation"+Location+ "\nStage Payment 1:" + sp1 + "\nStage Payment 2:" + sp2 + "\nStage Payment 3:" + sp3;
                    na.setText(string);
                }
                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }
    }
    public void collect(View view) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference ref = database.getInstance().getReference("users");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            stat = bundle.getString("status");
            pymentsta=bundle.getString("pymentsta");
        }
        DatabaseReference oneref = ref.child(fir).child(pymentsta);
        oneref.setValue(stat);

        if (stat.equals("complete")){
           // editText.setVisibility(View.VISIBLE);
        ref.child(fir).child("Collected_By").setValue(editText.getText().toString());
        }
    }
}