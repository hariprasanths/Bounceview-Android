package hari.bounceviewsample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hari on 8/6/18.
 */

public class CustomPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mFragmentTitles;

    public CustomPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mFragmentTitles = new ArrayList<>();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    public void addFragmentsList(List<Fragment> fragments, List<String> titles) {
        mFragments = fragments;
        mFragmentTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }

}
