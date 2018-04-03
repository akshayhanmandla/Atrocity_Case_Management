package com.testexample.atrocity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
*/
/*
    public class Notify extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_notify);

            Button mShowDialog = (Button) findViewById(R.id.angry_btn);
            mShowDialog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(Notify.this);
                    View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
                    final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
                    final EditText mPassword = (EditText) mView.findViewById(R.id.etPassword);
                    final TextView txt=(TextView)mView.findViewById(R.id.textView);

                    Button mLogin = (Button) mView.findViewById(R.id.btnLogin);

                    mBuilder.setView(mView);
                    txt.setText("Police");
                    final AlertDialog dialog = mBuilder.create();
                    dialog.show();
                    mLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                           // if(!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
                                if(mEmail.getText().toString().equals("a") && mPassword.getText().toString().equals("1"))
                            { Toast.makeText(Notify.this,
                                        R.string.success_login_msg,
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Notify.this, Policeui.class));
                                dialog.dismiss();
                            }else{
                                Toast.makeText(Notify.this,
                                        R.string.error_login_msg,
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });
        }
    }

*/

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SjsaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjsalogin);
        final EditText mEmail = (EditText) findViewById(R.id.editText2);
        Button mLogin = (Button) findViewById(R.id.button);
        final EditText mPassword = (EditText) findViewById(R.id.editText3);


        // Button mShowDialog = (Button) findViewById(R.id.button);
        // mShowDialog.setOnClickListener(new View.OnClickListener() {
        //   @Override
        // public void onClick(View view) {
               /* AlertDialog.Builder mBuilder = new AlertDialog.Builder(Notify.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_login, null);
                final EditText mEmail = (EditText) mView.findViewById(R.id.etEmail);
                final EditText mPassword = (EditText) mView.findViewById(R.id.etPassword);
                final TextView txt=(TextView)mView.findViewById(R.id.textView);*/
        // mBuilder.setView(mView);
        //txt.setText("Police");
        //final AlertDialog dialog = mBuilder.create();
        //dialog.show();
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //i00f(!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()){
                    //if(mEmail.getText().toString().equals("a") && mPassword.getText().toString().equals("1"))
                    Toast.makeText(SjsaLogin.this,
                            R.string.success_login_msg,
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SjsaLogin.this, Sjsaui.class));
                    // dialog.dismiss();
                //{
                  //  Toast.makeText(SjsaLogin.this,
                    //        R.string.error_login_msg,
                      //      Toast.LENGTH_SHORT).show();
                //}
            }
        });
    }

}





