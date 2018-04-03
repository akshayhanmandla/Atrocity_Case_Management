package com.testexample.atrocity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Policeui extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policeui);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager(),
                Policeui.this));
        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        FloatingActionButton fab_download = (FloatingActionButton) findViewById(R.id.fab_download);
        fab_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //viewPager.setCurrentItem(1);
                //setClickFabMain();
                startActivity(new Intent(Policeui.this,Fakeform.class));
            }
        });
        FloatingActionButton fab_browser = (FloatingActionButton) findViewById(R.id.fab_browser);
        fab_browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //viewPager.setCurrentItem(2);
                //setClickFabMain();
                startActivity(new Intent(Policeui.this,Moreinfo.class));

            }
        });
        FloatingActionButton fab_retrive = (FloatingActionButton) findViewById(R.id.fab_Retrive);
        fab_retrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //viewPager.setCurrentItem(2);
                //setClickFabMain();
                startActivity(new Intent(Policeui.this,PoliceFloaternew.class));

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
}
