 package com.testexample.atrocity;
 import android.content.Intent;
 import android.net.Uri;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.Button;

 public class HelpActivity extends AppCompatActivity {
     Button fb,twit,hindi,english;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_help);
         fb=(Button)findViewById(R.id.btngtw);
         hindi=(Button)findViewById(R.id.btnhindi);
         english=(Button)findViewById(R.id.btnenglish);
         fb.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://annihilatecaste.in/"));
                 startActivity(intent);
             }
         });

         hindi.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://khabar.ndtv.com/topic/atrocity/news"));
                 startActivity(intent);
             }
         });

         english.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ndtv.com/topic/atrocity"));
                 startActivity(intent);
             }
         });
     }
 }

