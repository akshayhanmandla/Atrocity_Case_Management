/*package com.testexample.atrocity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import java.util.Map;
*/
/*public class Paymentstage2fragment extends Fragment {
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User2 userf;
    String statu1="Initialise";
    String pymentstax="status_of_Payment_2";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_newfir, container, false);
        listView = (ListView) view.findViewById(R.id.menu);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference ref=database.getInstance().getReference("users");

        list =new ArrayList<>();
        adapter=new ArrayAdapter<String>(getActivity(),R.layout.activity_newfir,R.id.user1,list);
        Query qref = ref.orderByChild("status_of_Payment_2").equalTo("Not Initialised");
        qref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                adapter.notifyDataSetChanged();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    // String jafa=  ref.child("fir").orderByChild("fir_no").equalTo(1).getClass().toString();
                    //  for (ref.child("fir").child("fir_no").equals("1"))
                    //{*
                    // Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue(User2.class);
                    userf = ds.getValue(User2.class);
                    //String address = ds.child("Firno").getValue().toString();
                    //String Statusofpayment = ds.child("status_of_Payment_2").getValue().toString();
                    //String Statusofcase = ds.child("Status_of_case").getValue().toString();
                    if ((userf.status_of_Payment_1.equals("complete")) && ((userf.Status_of_case.equals("2"))||(userf.Status_of_case.equals("complete"))))
                        list.add(userf.Firno);
                }//}
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(getActivity(), listdata.class);
                Bundle bundle = new Bundle();
                bundle.putString("status", statu1);
                bundle.putString("pymentsta",pymentstax);
                in.putExtra("fir_no", listView.getItemAtPosition(i).toString());
                in.putExtras(bundle);
                startActivity(in);
            }
        });
        return view;
    }

}
*/