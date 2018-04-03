package com.testexample.atrocity;

/**
 * Created by DHANANJAY on 22-03-2018.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

    public class MainFragmentPagerAdapter2 extends FragmentPagerAdapter {
        final int PAGE_COUNT = 4;
        private String tabTitles[] = new String[] { "Query received", "payment initilised", "payment processed" , "payment collected"};
        private Context context;
        public MainFragmentPagerAdapter2(FragmentManager fm, Context context) {
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
                case 0:
                    Paymentstage1fragment paymentfragment1 = new Paymentstage1fragment();
                    return paymentfragment1;
                /** tab2 is selected */
                case 1:
                    Paymentstage12fragment paymentfragment2 = new Paymentstage12fragment();
                    return paymentfragment2;
                /** tab3 is selected */
                case 2:
                    Paymentstage13fragment paymentfragment3 = new Paymentstage13fragment();
                    return paymentfragment3;

                case 3:
                    Paymentstage14fragment paymentfragment4 = new Paymentstage14fragment();
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

