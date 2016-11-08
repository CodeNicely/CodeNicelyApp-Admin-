package com.codenicely.project.groceryappadmin.orders.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Meghal on 6/19/2016.
 */
class ViewPagerAdapter extends FragmentPagerAdapter {

    final int TAB_COUNT = 4;
    private String tabTitles[] = new String[]{"Placed", "Dispatched", "Delivered", "Cancel"};


    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return OrdersFragment.newInstance(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
