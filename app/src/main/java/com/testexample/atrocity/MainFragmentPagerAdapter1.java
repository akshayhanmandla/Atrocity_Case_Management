package com.testexample.atrocity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainFragmentPagerAdapter1 extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "New Fir stage1", "stage 2", "stage 3" };
    private Context context;
    public MainFragmentPagerAdapter1(FragmentManager fm, Context context) {
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
                SjsaTab1fragment fragmentpage1 = new SjsaTab1fragment();
                return fragmentpage1;
            /** tab2 is selected */
            case 1:
                SjsaTab2fragment fragmentpage2 = new SjsaTab2fragment();
                return fragmentpage2;
            /** tab3 is selected */
            case 2:
                SjsaTab3fragment fragmentpage3 = new SjsaTab3fragment();
                return fragmentpage3;
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
