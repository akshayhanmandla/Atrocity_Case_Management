package com.testexample.atrocity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class DistrictView extends AppCompatActivity
{
    EditText district;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_districtview);
        district=(EditText)findViewById(R.id.district);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String district1=district.getText().toString().toLowerCase();
                changeChart(district1);
            }
        });
         /*
        final ListView districts=(ListView)findViewById(R.id.district);
        districts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(districtlist.this,Graph.class);
                String selectedFromList =(String) districts.getItemAtPosition(i);
                intent.putExtra("district",selectedFromList);
                startActivity(intent);
            }


        });
        */
        String[] country = { "pune", "thane", "nashik", "mumbai"  };
/*        final Spinner spin = (Spinner) findViewById(R.id.spinner1);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                String selectedFromList =(String) spin.getItemAtPosition(i);
                changeChart(selectedFromList);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        */

    }

    void changeChart(final String district)
    {
        final PieChart piechart;

        piechart=(PieChart) findViewById(R.id.piechart);
        piechart.setUsePercentValues(true);
        piechart.getDescription().setEnabled(false);
        piechart.setExtraOffsets(5,10,5,5);
        piechart.setDragDecelerationFrictionCoef(0.95f);
        piechart.setDrawHoleEnabled(true);
        piechart.setHoleColor(Color.WHITE);
        piechart.setTransparentCircleRadius(61f);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference ref=database.getReference("users");
        //Bundle bundle = getIntent().getExtras();
        //  final String district1 = bundle.getString("district");
        Query query=ref.orderByChild("District").equalTo(district);

        query.addValueEventListener(new ValueEventListener() {
            float total,complete,notComplete;

            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                total=0;
                complete=0;
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                   // User2 userref = ds.getValue(User2.class);
                    total++;
                   String dis = ds.child("Status_of_case").getValue().toString();
                    if (dis.equals("Complete"))
                        complete++;
                }
                Log.d("check", "onDataChange: Total "+total+"\nComplete"+complete+"  "+district);
                //main.setText(String.valueOf(total)+" "+String.valueOf(complete)+" "+String.valueOf(pre));
                //float complete=70f;
                float notcompleted=total-complete;
                ArrayList<PieEntry> yValues = new ArrayList<>();
             /*   yValues.add(new PieEntry
             (34f,"india"));
                yValues.add(new PieEntry(23f,"new york"));
                yValues.add(new PieEntry(15f,"london"));
                yValues.add(new PieEntry(35,"swizerland"));
                yValues.add(new PieEntry(40,"Russia"));
                yValues.add(new PieEntry(23,"japan"));
                */
                // if(complete!=0)
                if( total == 0 )
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(
                            DistrictView.this).create();
                    // Setting Dialog Title
                    alertDialog.setTitle("No district");
                    // Setting Dialog Message
                    alertDialog.setMessage("Sorry ! we don't have records of the selected district");
                    // Setting Icon to Dialog
                    alertDialog.setIcon(R.drawable.ic_launcher_background);
                    // Setting OK Button
                    alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Write your code here to execute after dialog closed
                            // Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Showing Alert Message
                    alertDialog.show();
                }
                else if(complete==total)
                    yValues.add(new PieEntry(100f,"completed"));
                else if(complete==0)
                    yValues.add(new PieEntry(100f,"not completed"));
                else
                {
                    yValues.add(new PieEntry((complete/total)*100, "completed"));
                    yValues.add(new PieEntry((notcompleted/total)*100, "not completed"));
                }


                //  if(complete!=0)
                //    yValues.add(new PieEntry((complete/total)*100,"completed"));
                //   else
                //       yValues.add(new PieEntry(0f,"completed"));

                //  if(notcompleted!=0)
                // if(noncompleted)
                //  yValues.add(new PieEntry(0.0f,"not completed"));

                //   yValues.add(new PieEntry((notcompleted/total)*100,"not completed"));
                PieDataSet dataSet=new PieDataSet(yValues,district);
                dataSet.setSliceSpace(3f);
                dataSet.setSelectionShift(5f);
                dataSet.setColors(ColorTemplate.JOYFUL_COLORS);
                PieData data = new PieData((dataSet));
                data.setValueTextSize(10f);
                data.setValueTextColor(Color.CYAN);
                piechart.setData(data);
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
    }

}
