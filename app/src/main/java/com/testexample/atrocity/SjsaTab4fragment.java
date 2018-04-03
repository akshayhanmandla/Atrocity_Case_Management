package com.testexample.atrocity;



import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SjsaTab4fragment extends Fragment {
    ListView listView;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    User2 userf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_newfir, container, false);
        listView = (ListView) view.findViewById(R.id.menu);
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference ref=database.getInstance().getReference("users");

        list =new ArrayList<>();
        adapter=new ArrayAdapter<String>(getActivity(),R.layout.activity_newfir,R.id.user1,list);
        Query qref = ref.orderByChild("Status_of_case").equalTo("2");
        qref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                adapter.notifyDataSetChanged();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    // String jafa=  ref.child("fir").orderByChild("fir_no").equalTo(1).getClass().toString();
                    //  for (ref.child("fir").child("fir_no").equals("1"))
                    //{
                    userf = ds.getValue(User2.class);
                    list.add(userf.Firno);
                }//}
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return view;
    }

}
