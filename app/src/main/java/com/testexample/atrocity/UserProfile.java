package com.testexample.atrocity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class UserProfile extends AppCompatActivity {
    private TextView editp;
    private Button button;
    String playerMoves;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        //Bundle bundle = getIntent().getExtras();
        editp= (TextView)findViewById(R.id.email_field);
        button = (Button) findViewById(R.id.getstarted);
        //if (bundle != null)
        //{
//            String UName = bundle.getString("userneame");
        //  playerMoves = bundle.getString("Email_Address");

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            //String name = user.getDisplayName();
            String email = user.getEmail();

            for (UserInfo userInfo : user.getProviderData()) {
                // String name=userInfo.getDisplayName();
                //if (name == null && userInfo.getDisplayName() != null) {
                //   name1 = userInfo.getDisplayName();
                //}
                if (email == null && userInfo.getEmail() != null) {
                    email = userInfo.getEmail();
                }
            }
            //Log.w("jhj", email);
            //  System.out.print(""+name);
            editp.setText(email);

            System.out.print(email);
            //  Intent intent = new Intent(PoliceLogin.this, AtrocityDashboard.class);

            //intent.putExtra("Email_Address", email);

            //   startActivity(intent);

        }else{}
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent1 = new Intent(UserProfile.this,AtrocityDashboard.class);
                startActivity(myIntent1);
            }

        });
        //Log.w("jhj", playerMoves);
        //}
        // Log.w("jhj", playerMoves);
        //edit.setText(Name);

        // System.out.print(Name1);

        // System.out.println(Name1);

    }
}