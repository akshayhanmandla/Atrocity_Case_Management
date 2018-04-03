package com.testexample.atrocity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class PoliceReg extends Activity {
    private EditText userName,userPassword,userEmail;
    private Button btnRegister;
    private Button btnLinkToLogin;
    private FirebaseAuth firebaseAuth;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        setupUIView();

        firebaseAuth = FirebaseAuth.getInstance();

        // Locate the button in activity_main.xml
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);


        // Capture button clicks
        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                // Start NewActivity.class
                if (validate()){
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(PoliceReg.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                                Intent myIntent = new Intent(getApplicationContext(),PoliceLogin1.class);
                                startActivity(myIntent);
                            }else{
                                Toast.makeText(PoliceReg.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }
            }
        });

        btnLinkToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent1 = new Intent(getApplicationContext(),PoliceLogin.class);
                startActivity(myIntent1);
            }
        });
    }
    private void setupUIView(){
        userName = (EditText) findViewById(R.id.name);
        userEmail = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.password);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnLinkToLogin = (Button) findViewById(R.id.btnLinkToLoginScreen);

    }

    private Boolean validate(){
        Boolean result = false;
        String name = userName.getText().toString();
        String email = userEmail.getText().toString();
        String password = userPassword.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }
        return result;

    }
}