package com.testexample.atrocity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

public class PoliceLogin1 extends AppCompatActivity {
    private Button btnLogin;
    private Button btnLinkToRegisterScreen;
    private EditText Email;
    private EditText Password;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    View view;
    String name1,email;
    @Override


    // Login button Click Event
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_login1);

        // Locate the button in activity_main.xml
        Email = (EditText) findViewById(R.id.email);
        Password = (EditText) findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLinkToRegisterScreen = (Button) findViewById(R.id.btnLinkToRegisterScreen);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //if (user != null){
          //  finish();
           // startActivity(new Intent(PoliceLogin1.this, UserProfile.class));
        //}

        progressDialog = new ProgressDialog(this);
        // Capture button clicks
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = Email.getText().toString();
                String password = Password.getText().toString();
                if(username.length() != 0 && password.length() != 0) {
                    validate(username, password);
                }else{
                    Toast.makeText(PoliceLogin1.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });

    }
    private void validate(String userEmail,String userPassword){
        progressDialog.setMessage("wait till you are being verified");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    progressDialog.dismiss();
                    Toast.makeText(PoliceLogin1.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(PoliceLogin1.this, UserProfile.class));
                } else {
                    Toast.makeText(PoliceLogin1.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                }
            }
        });

    }

}
