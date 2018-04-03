package com.testexample.atrocity;

/**
 * Created by DHANANJAY on 22-03-2018.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainFragmentPagerAdapter5 extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] {  "payment initilised", "payment processed" , "payment collected"};
    private Context context;
    public MainFragmentPagerAdapter5(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
    @Override
    public Fragment getItem(int arg0) {
        Bundle data = new Bundle();
        switch(arg0){
            /** tab1 is selected */
           // case 0:
             //   paymentstage31fragment paymentfragment1 = new paymentstage31fragment();
               // return paymentfragment1;
            /** tab2 is selected */
            case 0:
                paymentstage32fragment paymentfragment2 = new paymentstage32fragment();
                return paymentfragment2;
            /** tab3 is selected */
            case 1:
                Paymentstage33fragment paymentfragment3 = new Paymentstage33fragment();
                return paymentfragment3;

            case 2:
                Paymentstage34fragment paymentfragment4 = new Paymentstage34fragment();
                return paymentfragment4;
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}

