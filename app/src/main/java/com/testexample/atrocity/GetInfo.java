package com.testexample.atrocity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by DHANANJAY on 19-03-2018.
 */

public class GetInfo  extends AppCompatActivity {
     TextView editp, no,editq, reg,loca,stat,notation,nan,nal,naq;
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference usersRef = ref.child("users");

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_getinfo);
            editp = (TextView) findViewById(R.id.firno_field);
            editq = (TextView) findViewById(R.id.policest_field);
            reg = (TextView) findViewById(R.id.name_field);
            loca = (TextView) findViewById(R.id.phoneno_field);
            stat = (TextView) findViewById(R.id.reddate_field);
            notation = (TextView) findViewById(R.id.status_field);
            no = (TextView) findViewById(R.id.stage_field);
            nan =(TextView) findViewById(R.id.firno_fi);
            nal =(TextView) findViewById(R.id.firno_fiel);
            naq =(TextView) findViewById(R.id.firno_fild);



            final Bundle bundle = getIntent().getExtras();
            // Bundle bundle = getIntent().getExtras();


                    usersRef.getRef().addValueEventListener(new ValueEventListener() { //attach listener

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) { //something changed!

                            if (bundle != null) {
                                if (bundle.containsKey("Fir")) {
                                    final String fir = bundle.getString("Fir");
                                    Log.i("Activity2 Log", "Fir:" + fir);
                                    String location = dataSnapshot.child(fir).child("Name").getValue().toString();
                                    String location1 = dataSnapshot.child(fir).child("PhoneNumber").getValue().toString();
                                    String location2 = dataSnapshot.child(fir).child("Regis_Date").getValue().toString();
                                    String location3 = dataSnapshot.child(fir).child("Location").getValue().toString();
                                    String location4 = dataSnapshot.child(fir).child("Status_of_case").getValue().toString();
                                    String location5 = dataSnapshot.child(fir).child("CaseNotation").getValue().toString();
                                    String location6 = dataSnapshot.child(fir).child("Police_ID").getValue().toString();
                                    String location7 = dataSnapshot.child(fir).child("status_of_Payment_1").getValue().toString();
                                    String location8 = dataSnapshot.child(fir).child("status_of_Payment_2").getValue().toString();
                                    String location9 = dataSnapshot.child(fir).child("status_of_Payment_3").getValue().toString();
                                    editp.setText("Name:    "+ location);
                                    editq.setText("Phone Number:    "+ location1);
                                    reg.setText("Registration Date of Case:    "+ location2);
                                    loca.setText("Location of Police Station:    "+ location3);
                                    stat.setText("Stage of Case:    "+ location4);
                                    notation.setText("Case Notation:    "+ location5);
                                    no.setText("ID of Policeman incharge of Case:  "+ location6);
                                    nal.setText("Payment Status of case:"+ location7);
                                    naq.setText("Payment Status of Case(2):    "+ location8);
                                    nan.setText("Payment Status of Case(3):    "+ location9);
                                }
                                //for (DataSnapshot locationSnapshot : dataSnapshot.getChildren()) {
                                //  if (locationSnapshot.child("1")!=null) {
                                //  String location = locationSnapshot.child("1").child("Name").getValue().toString();

                                //}
                                // String location1 = locationSnapshot.child("KIO").child("").getValue().toString();

                                //System.out.println("USERNAME" + " " +location);

                                //          System.out.println("USERNAME" + " " + location1);

                                //}
                            }
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { //update UI here if error occurred.

                        }
                    });


                }
            }
