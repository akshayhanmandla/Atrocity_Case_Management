package com.testexample.atrocity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;



public class Tab1fragment extends Fragment {
    EditText date, date1, time, policeid;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    protected EditText Name, Mobile, police,adharno,casenoatation, firno, address, registration, incidentdate, incidenttime, incidentplace, District, casestatus;
    protected Button buttonSubmit;

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref = database.getReference();
    DatabaseReference usersRef = ref.child("users");

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_tab1_fragment, container, false);
        date = view.findViewById(R.id.registrationdate);
        date1 = view.findViewById(R.id.IncidentDate);
        time = view.findViewById(R.id.incidentTime);
        firno = view.findViewById(R.id.firnumber);
        police = view.findViewById(R.id.policelocation);
        Name = view.findViewById(R.id.name);
        policeid = view.findViewById(R.id.PFID);
        Mobile = view.findViewById(R.id.phonenumber);
        adharno = view.findViewById(R.id.adharno);
        incidentplace = view.findViewById(R.id.Incidentplace);
        District = view.findViewById(R.id.criminalname);
        casestatus = view.findViewById(R.id.statuscase);
        casenoatation = view.findViewById(R.id.casenotation);
        final EditText Fid = (EditText) view.findViewById(R.id.firnumber);
        final EditText Fod = (EditText) view.findViewById(R.id.policelocation);
        final EditText FN = (EditText) view.findViewById(R.id.name);
        //final EditText FA = (EditText) view.findViewById(R.id.Address);
        final EditText FP = (EditText) view.findViewById(R.id.phonenumber);
        final EditText FAD = (EditText) view.findViewById(R.id.adharno);
        final EditText FRD = (EditText) view.findViewById(R.id.registrationdate);
        final EditText FID = (EditText) view.findViewById(R.id.IncidentDate);
        final EditText FIT = (EditText) view.findViewById(R.id.incidentTime);
        final EditText FIP = (EditText) view.findViewById(R.id.Incidentplace);
        final EditText FC = (EditText) view.findViewById(R.id.criminalname);
        final EditText FS = (EditText) view.findViewById(R.id.statuscase);
        final EditText FCS = (EditText) view.findViewById(R.id.casenotation);


        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

// date picker dialog
                datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date1.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR); // current hour
                int mMinute = c.get(Calendar.MINUTE); // current minute
                // time picker dialog
                timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hour,
                                                  int minute) {
                                // set day of month , month and year value in the edit text
                                time.setText(hour + ":"
                                        + minute);

                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }


        });

        buttonSubmit = (Button) view.findViewById(R.id.btnsubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String regdate = date.getText().toString();
                String inc_date = date1.getText().toString();
                String inc_time = time.getText().toString();
                String fir_no = FID.getText().toString();
                String police_station = Fod.getText().toString();
                String name = FN.getText().toString();
                String mobile = FP.getText().toString();
                String police = policeid.getText().toString();
                String Adharno = FAD.getText().toString();
                String inc_place = FIP.getText().toString();
                String criminalname = FC.getText().toString();
                String status = FS.getText().toString();
                String casenotation = FCS.getText().toString();
                int i = 0;
                if (regdate.equals("")) {
                    date.setError("Please enter registration date");
                    i = 1;
                }
                if (inc_date.equals("")) {
                    date1.setError("Please enter incident date");
                    i = 1;
                }
                if (inc_time.equals("")) {
                    time.setError("Please enter incident time");
                    i = 1;
                }
                if (fir_no.length() == 0) {
                    FID.setError("Please enter fir no");
                    i = 1;
                }
                if (police_station.length() < 5) {
                    Fod.setError("Police station location should be atleast 5 characters long");
                    i = 1;
                }
                if (name.length() <= 2) {
                    FN.setError("Name should be atleast 3 characters long");
                    i = 1;
                }
                if (mobile.length() < 10) {
                    FP.setError("Mobile no should be atleast 10 characters long");
                    i = 1;
                }
                if (police.length() < 3) {
                    policeid.setError("Address should be atleast 5 characters long");
                    i = 1;
                }
                if (Adharno.length() < 12) {
                    FAD.setError("Aadhar no should be atleast 12 characters long");
                    i = 1;
                }
                if (inc_place.length() < 3)
                    FID.setError("Incident place should be atleast 3 characters long");
                if (criminalname.length() < 3) {
                    FC.setError("Criminal name should be atleast 3 characters long");
                    i = 1;
                }
                if (status.equals("")) {
                    FS.setError("Please enter status");
                    i = 1;
                }
                if (casenotation.equals("")) {
                    FCS.setError("Please enter case notation");
                    i = 1;
                }
                String Fir = Fid.getText().toString();
                String loC = Fod.getText().toString();
                String Nam = FN.getText().toString();
                String POL = policeid.getText().toString();
                String Phone = FP.getText().toString();
                String Aadhar = FAD.getText().toString();
                String RegisD = FRD.getText().toString();
                String IncidentD = FID.getText().toString();
                String IncidentT = FIT.getText().toString();
                String IncidentP = FIP.getText().toString();
                String Criminal = FC.getText().toString();
                String CaseStat = FS.getText().toString();
                String Casenot = FCS.getText().toString();
                String sp1="Not Initialised";
                //String sp2="Not Initialized";
                //String sp3="Not Initialized";
                if (i != 1)
                    usersRef.child(Fir).setValue(new User(Fir, loC, Nam, Aadhar, Phone, POL ,RegisD, IncidentD,IncidentP, IncidentT, Criminal, CaseStat, Casenot,sp1));

                else {
                    System.out.print("ERROR ;;;;;;;;;");
                }


            }
        });
        return view;
    }}

class User {
   public String Firno;
    public String Location;
    public String Name;
    public String Police_ID;
    public String PhoneNumber;
    public String Aadhar_No;
    public String Regis_Date;
    public String Incident_Date;
    public String Incident_Time;
    public String Incident_Place;
    public String District;
    public String Status_of_case;
    public String CaseNotation;
    public String status_of_Payment_1;
    public String status_of_Payment_2;
    public String status_of_Payment_3;
public String Urgent;
    public String Urgent_F;
   public User()
        {

        }

    //String Location;
    public User(String Fir, String P,String Loc, String Nam, String Aadhar,  String Phone, String RegisD, String IncidentD, String IncidentP, String IncidentT, String Criminal, String CaseStat, String Casenot,String sp1) {
        this.Firno = Fir;
        this.Location = P;
        this.Name = Loc;
        this.Police_ID = Phone;
        this.Aadhar_No = Nam;
        this.PhoneNumber = Aadhar;
        this.Regis_Date = RegisD;
        this.Incident_Date = IncidentD;
        this.Incident_Time = IncidentT;
        this.Incident_Place = IncidentP;
        this.District = Criminal;


        this.CaseNotation = Casenot;
        if (Casenot.startsWith("43")) {
            sp1="Complete";
            CaseStat="Not Initiated Yet waiting for Medical Reports for further investigation";
            this.status_of_Payment_1=sp1;
            this.Status_of_case = CaseStat;
            status_of_Payment_2="Initialise";
            status_of_Payment_3="Initialise";

        }
        else
        {
            status_of_Payment_1=sp1;
            status_of_Payment_2="Initialise";
            status_of_Payment_3="Initialise";
            this.Status_of_case = CaseStat;
        }

    }
}

/*
    private void addValidationToViews() {

        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.phonenumber, "^[2-9]{2}[0-9]{8}$", R.string.phoneerror);
        awesomeValidation.addValidation(this, R.id.policelocation, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.plerror);
        awesomeValidation.addValidation(this, R.id.adharno, "^[0-9]{15}$", R.string.adhrnoerror);
        awesomeValidation.addValidation(this, R.id.Address, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.addresserror);
        awesomeValidation.addValidation(this, R.id.Registrationdate, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.regiserror);
        awesomeValidation.addValidation(this, R.id.IncidentDate, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.Incidentderror);
        // awesomeValidation.addValidation(this, R.id.incidentTime, "^[01]?[0-9]|2[0-3]):[0-5][0-9]$", R.string.incidentterror);
        awesomeValidation.addValidation(this, R.id.Incidentplace, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.incidentperror);
        awesomeValidation.addValidation(this, R.id.criminalname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.crimanalerror);
        awesomeValidation.addValidation(this, R.id.statuscase, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.statuscaseerror);
        awesomeValidation.addValidation(this, R.id.casenotation, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.casenotationerror);



    }
*/

/*
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsubmit:
                submitForm();
                break;
        }
    }
    */




















/*
package com.example.admin.tabdemo;

        import android.app.DatePickerDialog;
        import android.app.TimePickerDialog;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.ScrollView;
        import android.widget.TimePicker;
        import android.widget.Toast;



        import java.util.Calendar;



public class tab1 extends Fragment {
    EditText date, date1, time;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    protected EditText Name, Mobile, police,adharno,casenoatation, firno, address, registration, incidentdate, incidenttime, incidentplace, criminal, casestatus;
   protected Button buttonSubmit;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab1, container, false);
        date= view.findViewById(R.id.registrationdatenew);
        date1 = view.findViewById(R.id.IncidentDate);
        time = view.findViewById(R.id.incidentTime);
        firno=view.findViewById(R.id.firnumber);
        police=view.findViewById(R.id.policelocation);
        Name=view.findViewById(R.id.name);
        address=view.findViewById(R.id.Address);
        Mobile=view.findViewById(R.id.phonenumber);
        adharno=view.findViewById(R.id.adharno);
        incidentplace=view.findViewById(R.id.Incidentplace);
        criminal=view.findViewById(R.id.criminalname);
        casestatus=view.findViewById(R.id.statuscase);
        casenoatation=view.findViewById(R.id.casenotation);


        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

// date picker dialog
                datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date1.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR); // current hour
                int mMinute = c.get(Calendar.MINUTE); // current minute
                // time picker dialog
                timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hour,
                                                  int minute) {
                                // set day of month , month and year value in the edit text
                                time.setText(hour + ":"
                                        + minute);

                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }


        });

        buttonSubmit=(Button)view.findViewById(R.id.btnsubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String regdate=date.getText().toString();
                String inc_date=date1.getText().toString();
                String inc_time=time.getText().toString();
                String fir_no=firno.getText().toString();
                String police_station=police.getText().toString();
                String name=Name.getText().toString();
                String mobile=Mobile.getText().toString();
                String Address=address.getText().toString();
                String Adharno=adharno.getText().toString();
                String inc_place=incidentplace.getText().toString();
                String criminalname=criminal.getText().toString();
                String status=casestatus.getText().toString();
                String casenotation=casenoatation.getText().toString();
                int i =0;
                if(regdate.equals(""))
                {date.setError("Please enter registration date");
                    i =1;}
                if(inc_date.equals(""))
                {date1.setError("Please enter incident date");
                    i=1;}
                if(inc_time.equals(""))
                {time.setError("Please enter incident time");
                    i=1;}
                if (fir_no.length()==0) {
                    firno.setError("Please enter fir no");
                    i=1; }
                if(police_station.length()<5) {
                    police.setError("Police station location should be atleast 5 characters long");
                    i=1;}
                if(name.length()<=2) {
                    Name.setError("Name should be atleast 3 characters long");
                    i=1;}
                if(mobile.length()<10) {
                    Mobile.setError("Mobile no should be atleast 12 characters long");
                    i=1;}
                if (Address.length()<5) {
                    address.setError("Address should be atleast 5 characters long");
                    i=1;}
                if(Adharno.length()<12) {
                    adharno.setError("Aadhar no should be atleast 12 characters long");
                    i=1;}
                if(inc_place.length()<3)
                    incidentplace.setError("Incident place should be atleast 3 characters long");
                if(criminalname.length()<3) {
                    criminal.setError("Criminal name should be atleast 3 characters long");
                    i=1;}
                if(status.equals("")) {
                    casestatus.setError("Please enter status");
                    i=1;}
                if(casenotation.equals(""))
                { casenoatation.setError("Please enter case notation");
                    i=1;}
                //if (i!=1)

            }
        });

        return view;
    }


/*
    private void addValidationToViews() {

        //adding validation to edittexts
        awesomeValidation.addValidation(this, R.id.name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.phonenumber, "^[2-9]{2}[0-9]{8}$", R.string.phoneerror);
        awesomeValidation.addValidation(this, R.id.policelocation, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.plerror);
        awesomeValidation.addValidation(this, R.id.adharno, "^[0-9]{15}$", R.string.adhrnoerror);
        awesomeValidation.addValidation(this, R.id.Address, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.addresserror);
        awesomeValidation.addValidation(this, R.id.Registrationdate, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.regiserror);
        awesomeValidation.addValidation(this, R.id.IncidentDate, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.Incidentderror);
        // awesomeValidation.addValidation(this, R.id.incidentTime, "^[01]?[0-9]|2[0-3]):[0-5][0-9]$", R.string.incidentterror);
        awesomeValidation.addValidation(this, R.id.Incidentplace, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.incidentperror);
        awesomeValidation.addValidation(this, R.id.criminalname, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.crimanalerror);
        awesomeValidation.addValidation(this, R.id.statuscase, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.statuscaseerror);
        awesomeValidation.addValidation(this, R.id.casenotation, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.casenotationerror);

    }
*/

/*
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnsubmit:
                submitForm();
                break;
        }
    }
    */
//}