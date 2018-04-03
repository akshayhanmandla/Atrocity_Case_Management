package com.testexample.atrocity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PoliceFloaternew extends AppCompatActivity {
    ListView listView1;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User2 userf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_floaternew);
        listView1 = (ListView) findViewById(R.id.menu1);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference ref=database.getInstance().getReference("Councellor");

        list =new ArrayList<>();
        adapter=new ArrayAdapter<String>(PoliceFloaternew.this,R.layout.activity_newfir,R.id.user1,list);
        //Query qref = ref.orderByChild("status_of_Payment_1").equalTo("Initialise");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                adapter.notifyDataSetChanged();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    userf = ds.getValue(User2.class);
                    // if (userf.sp1.equals("Initialize"))
                    list.add(userf.Firno);
                }//}
                listView1.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //startActivity(new Intent(PoliceFloaternew.this, Policeui.class));
                Intent in = new Intent(PoliceFloaternew.this, LISTDATA1.class);
                Bundle bundle = new Bundle();
               // bundle.putString("status", statu1);
               // bundle.putString("pymentsta",pymentsta);
                in.putExtra("fir_no", listView1.getItemAtPosition(i).toString());
                in.putExtras(bundle);
                startActivity(in);
            }
        });
    }
}