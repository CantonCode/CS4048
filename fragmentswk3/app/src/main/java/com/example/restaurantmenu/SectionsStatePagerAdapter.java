package com.example.restaurantmenu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionsStatePagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();

    public SectionsStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment frag)
    {
        mFragmentList.add(frag);
    }

    @Override
    public Fragment getItem(int pos)
    {
        return mFragmentList.get(pos);
    }

    @Override
    public int getCount()
    {
        return mFragmentList.size();
    }
}
