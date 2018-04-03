package com.testexample.atrocity;

/**
 * Created by DHANANJAY on 22-03-2018.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainFragmentPagerAdapter4 extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "fake", "complete"};
    private Context context;
    public MainFragmentPagerAdapter4(FragmentManager fm, Context context) {
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
                paymentfake1fragment paymentfragment1 = new paymentfake1fragment();
                return paymentfragment1;
            /** tab2 is selected */
            case 1:
                paymentfake2fragment paymentfragment2 = new paymentfake2fragment();
                return paymentfragment2;
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}

