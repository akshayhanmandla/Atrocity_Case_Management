/**
 * Created by DHANANJAY on 20-03-2018.
 */
package com.testexample.atrocity;

import java.util.logging.LoggingPermission;

public class User2
{
    public String Firno,Aadhar_No,Address,CaseNotation,Criminal_Name,Incident_Date,Incident_Place,Incident_Time,Location,Name,PhoneNumber,Regis_Date,Status_of_case;
    public String status_of_Payment_1,status_of_Payment_2,status_of_Payment_3, Date_Punishment, Urgent,  Police_ID, District;
    public long rating;

    public User2()
    {

    }
    public User2(String Urgent,String Police_ID,long rating,String Firno,String Aadhar_No,String Address,String CaseNotation,String Date_Punishment,String Criminal_Name,String Incident_Date,String Incident_Place,String Incident_Time,String Location,String Name,String PhoneNumber,String Regis_Date,String Status_of_case,String sp1,String sp2,String sp3, String District)
    {
        this.Firno=Firno;
        this.District=District;
        this.Date_Punishment= Date_Punishment;
        this.Police_ID=Police_ID;
        this.Aadhar_No=Aadhar_No;
        this.Address=Address;
        this.rating=rating;
        this.Urgent=Urgent;
        this.CaseNotation=CaseNotation;
        this.Criminal_Name=Criminal_Name;
        this.Incident_Date=Incident_Date;
        this.Incident_Time=Incident_Time;
        this.Incident_Place=Incident_Place;
        this.Location= Location;
        this.PhoneNumber=PhoneNumber;
        this.Name=Name;
        this.Regis_Date=Regis_Date;
        this.Status_of_case=Status_of_case;
        this.status_of_Payment_1=sp1;
        this.status_of_Payment_2=sp2;
        this.status_of_Payment_3=sp3;
    }
}