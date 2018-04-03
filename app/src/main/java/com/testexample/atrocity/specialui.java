package com.testexample.atrocity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class specialui extends AppCompatActivity {
    EditText date, date1, time, policeid;
   // DatePickerDialog datePickerDialog;
    //TimePickerDialog timePickerDialog;
   final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference usersRef = ref.child("Councellor");
    Button B4;

    protected EditText Name, Mobile, police,adharno,casenoatation, firno, address, registration, incidentdate, incidenttime, incidentplace, District, casestatus;
    protected Button buttonSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialui);
        date = findViewById(R.id.registrationdate);
        date1 = findViewById(R.id.Incidentplace);
        time = findViewById(R.id.incidentTime);
        firno = findViewById(R.id.firnumber);
        police = findViewById(R.id.policelocation);
        Name = findViewById(R.id.name);
        policeid = findViewById(R.id.IncidentDate);
        Mobile = findViewById(R.id.phonenumber);
        adharno = findViewById(R.id.adharno);
        B4 = findViewById(R.id.btnsubmit);

        B4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Fir = date.getText().toString();
                String loC = date1.getText().toString();
                String Nam = time.getText().toString();
                String POL = policeid.getText().toString();
                String Phone = time.getText().toString();
                String Aadhar = Name.getText().toString();
                String RegisD = Mobile.getText().toString();
                String IncidentD = adharno.getText().toString();
                String IncidentT = firno.getText().toString();
                usersRef.child(POL).setValue(new User6(Fir, loC, Nam, Aadhar, Phone, Fir ,RegisD, IncidentD,IncidentT));
            }
        });

    }
}
class User6 {
    public String Victim_Name;
    public String Caretaker_name;
    public String dissability;
    public String Cert_id;
    public String Docname;
    public String Victim_add;
    public String Victim_dis;
    public String caretaker_num;
    public String Docnum;
    public User6()
    {

    }
    public User6(String Fir,String Loc, String Nam, String Aadhar,  String Phone, String RegisD, String IncidentD,String IncidentT, String POL) {
        this.Victim_Name = Fir;
        this.Caretaker_name = POL;
        this.dissability = Loc;
        this.Cert_id = Phone;
        this.Docname = Nam;
        this.Victim_add = Aadhar;
        this.Victim_dis = RegisD;
        this.caretaker_num = IncidentD;
        this.Docnum = IncidentT;
}}