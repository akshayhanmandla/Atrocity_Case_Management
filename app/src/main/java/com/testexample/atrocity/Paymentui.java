package com.testexample.atrocity;

        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.CardView;
        import android.view.View;
        import android.widget.GridLayout;
        import android.widget.GridView;
        import android.widget.Toast;

public class Paymentui extends AppCompatActivity {

    GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentui);
        CardView ME,FM,TM,LL;
final CardView cardView;
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        ME = (CardView)findViewById(R.id.me);

        FM = (CardView)findViewById(R.id.Family);

        LL = (CardView)findViewById(R.id.lovely);

        TM = (CardView)findViewById(R.id.team);

        //Set Event
        //setSingleEvent(mainGrid);
        ME.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
        //        setToggleEvent(mainGrid);
                Intent intent = new Intent(Paymentui.this,paymentstage1tab.class);
                startActivity(intent);

            }
        });

        FM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
      //          setToggleEvent(mainGrid);
                Intent intent = new Intent(Paymentui.this,paymentstagetab2.class);
                startActivity(intent);

            }
        });

        LL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
    //            setToggleEvent(mainGrid);
                Intent intent = new Intent(Paymentui.this,paymentstagetab3.class);
                startActivity(intent);

            }
        });

        TM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
  //              setToggleEvent(mainGrid);
                Intent intent = new Intent(Paymentui.this,paymentfakeorcomplete.class);
                startActivity(intent);

            }
        });

    }
/*
    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(Paymentui.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(Paymentui.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
/*
    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Paymentui.this,paymentstage1tab.class);
                    startActivity(intent);

                }
            });
        }
    }*/
}
