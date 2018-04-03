package com.testexample.atrocity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import static android.speech.RecognizerIntent.ACTION_RECOGNIZE_SPEECH;



public class StatusFir extends AppCompatActivity{
Button btn;
EditText et, txvResult, ed2;
    //private TextView txvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statusfir);
        txvResult = (EditText) findViewById(R.id.firnu);
        ed2 = (EditText) findViewById(R.id.bolo);


        Log.i("Activity2 Log", "Fir:"+String.valueOf(et));

        btn= (Button) findViewById(R.id.btnsubmit);

        FloatingActionButton fab_browser = (FloatingActionButton) findViewById(R.id.fab_browser);
        fab_browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //viewPager.setCurrentItem(2);
                //setClickFabMain();
                startActivity(new Intent(StatusFir.this,Moreinfo.class));

            }
        });

        FloatingActionButton fab_help = (FloatingActionButton) findViewById(R.id.fab_help);
        fab_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //viewPager.setCurrentItem(2);
                //setClickFabMain();
                startActivity(new Intent(StatusFir.this,HelpActivity.class));

            }
        });

        FloatingActionButton fab_map = (FloatingActionButton) findViewById(R.id.fab_map);
        fab_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //viewPager.setCurrentItem(2);
                //setClickFabMain();
                startActivity(new Intent(StatusFir.this,MapsActivity.class));

            }
        });
    }
    private void setClickFabMain() {
        FloatingActionButton fab_main = (FloatingActionButton) findViewById(R.id.fab_main);
        fab_main.performClick();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void getSpeechInput(View view) {

        Intent intent = new Intent(ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        Intent intent1 = new Intent(ACTION_RECOGNIZE_SPEECH);
        intent1.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent1.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent1, 11);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                }
            case 11:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    ed2.setText(result.get(0));
                }
                break;
        }
        if (ed2.getText().toString().equals("submit")) {
           // btn.setOnClickListener(new View.OnClickListener() {
             //   @Override
               // public void onClick(View v) {
                    final String Fr = txvResult.getText().toString();
                    //    Log.i("Activity2 Log", "Fir:"+Fr);
                    startActivity(new Intent(StatusFir.this, GetInfo.class).putExtra("Fir", Fr));


                    //  Log.i("Activity2 Log", "Fir:"+Fr);
                    //startActivity(intent);
                    //intent.putExtra("Fir",Fr);


                }



            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String Fr = txvResult.getText().toString();
                    //    Log.i("Activity2 Log", "Fir:"+Fr);
                    startActivity(new Intent(StatusFir.this, GetInfo.class).putExtra("Fir", Fr));

                }});
        }

    }