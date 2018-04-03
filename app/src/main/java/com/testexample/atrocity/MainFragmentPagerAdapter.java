package com.testexample.atrocity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 4;
    private String tabTitles[] = new String[] { "FirForm", "Update", "Fake" , "Complete"  };
    private Context context;
    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
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
                Tab1fragment fragmentpage1 = new Tab1fragment();
                return fragmentpage1;
            /** tab2 is selected */
            case 1:
                Tab2fragment fragmentpage2 = new Tab2fragment();
                return fragmentpage2;
            /** tab3 is selected */
            case 2:
                Tab3fragment fragmentpage3 = new Tab3fragment();
                return fragmentpage3;

            case 3:
                Tab4fragment fragmentpage4 = new Tab4fragment();
                return fragmentpage4;
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
