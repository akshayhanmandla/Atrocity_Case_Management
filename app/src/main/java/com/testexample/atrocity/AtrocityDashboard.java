package com.testexample.atrocity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

    public class AtrocityDashboard extends AppCompatActivity implements View.OnClickListener{
        private CardView powerCard,notifyCard,sjsaCard,paymentCard,specialCard;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_atrocitydashboard);
            powerCard = (CardView) findViewById(R.id.power_card);
            notifyCard = (CardView) findViewById(R.id.notify_card);
            sjsaCard = (CardView) findViewById(R.id.sjsa_card);
            paymentCard = (CardView) findViewById(R.id.payment_card);
            specialCard = (CardView) findViewById(R.id.special_card);
            powerCard.setOnClickListener(this);
            notifyCard.setOnClickListener(this);
            sjsaCard.setOnClickListener(this);
            paymentCard.setOnClickListener(this);
            specialCard.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            Intent i;

            switch (v.getId()) {
                case R.id.power_card : i = new Intent(this,StatusFir.class);startActivity(i); break ;
                case R.id.notify_card : i = new Intent(this,Notify.class);startActivity(i); break ;
                case R.id.sjsa_card : i = new Intent(this,SjsaLogin.class);startActivity(i); break ;
                case R.id.payment_card : i = new Intent(this,PaymentLogin.class);startActivity(i); break ;
                case R.id.special_card : i = new Intent(this,specialui.class);startActivity(i); break ;

                default:break;
            }
        }

    }

