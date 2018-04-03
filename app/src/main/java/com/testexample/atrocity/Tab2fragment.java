package com.testexample.atrocity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class Tab2fragment extends Fragment {

    private EditText ed5 ,ed4, ed3, ed10,ed9,ed8;
    private TextView ed1, ed2;
    private Button b1, b2, b3,b4;
    String check="0";
    View view;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference usersRef = ref.child("users");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // view=  inflater.inflate(R.layout.fragment_tab2, null);
        view = inflater.inflate(R.layout.activity_tab2_fragment, container, false);

        // s = "complete";
        ed1 = (TextView) view.findViewById(R.id.text2);
        ed2 = (TextView) view.findViewById(R.id.editText2);
        ed4 = (EditText) view.findViewById(R.id.firnumber);
        ed5 = (EditText) view.findViewById(R.id.PFID);
        ed3 = (EditText) view.findViewById(R.id.editText3);
        ed9 = (EditText) view.findViewById(R.id.editText9);
        ed10 = (EditText) view.findViewById(R.id.editText10);
        ed8 = (EditText) view.findViewById(R.id.editText8);
        b1 = (Button) view.findViewById(R.id.getstatus);
        b2 = (Button) view.findViewById(R.id.urgent);
        b3 = (Button) view.findViewById(R.id.btnsubmit);
        b4 = (Button) view.findViewById(R.id.complete);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final String Fri = ed4.getText().toString();
final String PFRI = ed5.getText().toString();
                usersRef.getRef().addValueEventListener(new ValueEventListener() { //attach listener

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) { //something changed!

                        String Val = dataSnapshot.child(Fri).child("Police_ID").getValue().toString();
                        if (Val.equals(PFRI))
                        {
                        String location = dataSnapshot.child(Fri).child("status_of_Payment_1").getValue().toString();
                        String location1 = dataSnapshot.child(Fri).child("status_of_Payment_2").getValue().toString();
                        String location2 = dataSnapshot.child(Fri).child("status_of_Payment_3").getValue().toString();
//if (location.equals("complete"))
  //  flag=1;
//if (flag==1)
//{
    final String Status = dataSnapshot.child(Fri).child("Status_of_case").getValue().toString();
    if (Status.equals("1"))
    {
        if (location1.equals("complete")){
            ed1.setText(location1);
            ed2.setVisibility(View.VISIBLE);
            ed3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            ed2.setText("2");
        }
        else
            {
            ed1.setText(location1);
            b2.setVisibility(View.VISIBLE);
            ed2.setVisibility(View.INVISIBLE);
                ed3.setVisibility(View.INVISIBLE);
                b3.setVisibility(View.INVISIBLE);
        check="2";
                b2.setOnClickListener(new View.OnClickListener() {
                    final String Fri = ed4.getText().toString();
                    @Override
                    public void onClick(View v) {
                            usersRef.child(Fri).child("status_of_Payment_2").setValue("urgent");
                            usersRef.child(Fri).child("Urgent").setValue("yes");
                    }
                });
            }
    }
    else if (Status.equals("0"))
    {
        if (location.equals("complete")){
            ed1.setText(location);
            ed2.setVisibility(View.VISIBLE);
            ed3.setVisibility(View.VISIBLE);
            b3.setVisibility(View.VISIBLE);
            ed2.setText("1");
        }
        else
        {
            ed1.setText(location);
            b2.setVisibility(View.VISIBLE);
            ed2.setVisibility(View.INVISIBLE);
            ed3.setVisibility(View.INVISIBLE);
            b3.setVisibility(View.INVISIBLE);
            check="1";
            b2.setOnClickListener(new View.OnClickListener() {
                final String Fri = ed4.getText().toString();
                @Override
                public void onClick(View v) {
                    usersRef.child(Fri).child("status_of_Payment_1").setValue("urgent");
                    usersRef.child(Fri).child("Urgent").setValue("yes");
                }
            });
        }
    }
    else if (Status.equals("2"))
    {
        if (location2.equals("complete")){
            ed1.setText(location2);
            ed2.setVisibility(View.VISIBLE);
            ed3.setVisibility(View.INVISIBLE);
            ed9.setVisibility(View.VISIBLE);
            ed10.setVisibility(View.VISIBLE);
            ed8.setVisibility(View.VISIBLE);
            b3.setVisibility(View.INVISIBLE);
            b2.setVisibility(View.INVISIBLE);
            ed2.setText("Toggle FIR to complete Status");
            b4.setVisibility(View.VISIBLE);
            b4.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                String Fri = ed4.getText().toString();
                    String Crimanl_name = ed9.getText().toString();
                String Date_of_Punishment = ed10.getText().toString();
                usersRef.child(Fri).child("Criminal_Name").setValue(Crimanl_name);
                usersRef.child(Fri).child("Date_Punishment").setValue(Date_of_Punishment);
                usersRef.child(Fri).child("Status_of_case").setValue("Complete");
                }
            });
        }
        else
        {
            ed1.setText(location2);
            b2.setVisibility(View.VISIBLE);
            ed2.setVisibility(View.INVISIBLE);
            ed3.setVisibility(View.INVISIBLE);
            b3.setVisibility(View.INVISIBLE);
        check="3";
            b2.setOnClickListener(new View.OnClickListener() {
                final String Fri = ed4.getText().toString();
                @Override
                public void onClick(View v) {
                    usersRef.child(Fri).child("status_of_Payment_3").setValue("urgent");
                    usersRef.child(Fri).child("Urgent").setValue("yes");
                }
            });
        }
    }
}

else                    {
                        ed2.setVisibility(View.VISIBLE);
                        ed2.setText("Invalid Police Login");
                            ed3.setVisibility(View.INVISIBLE);
                            ed1.setVisibility(View.INVISIBLE);
                            b3.setVisibility(View.INVISIBLE);
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.i("hi", "ERRRROOORRRRRR");
                    }
                });
                // if ()
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Fri = ed4.getText().toString();
                final String Status2 = ed2.getText().toString();
                final String Comments = ed3.getText().toString();

                if (Comments.startsWith("M")) {
                    usersRef.child(Fri).child("Status_of_case").setValue(Status2);
                }
                usersRef.child(Fri).child("Status_of_case").setValue(Status2);
                // Update Query for Comments left //
            }
        });


        return view;
    }
}