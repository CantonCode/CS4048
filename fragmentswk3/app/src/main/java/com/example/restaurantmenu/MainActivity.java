package com.example.restaurantmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;
    public String order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        order = "";
        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);

        setUpViewPager(mViewPager);
    }

    private void setUpViewPager(ViewPager viewPager)
    {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new home());
        adapter.addFragment(new lunch());
        adapter.addFragment(new starter());
        adapter.addFragment(new dinner());
        adapter.addFragment(new drinks());
        adapter.addFragment(new summary());

        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNum)
    {
        mViewPager.setCurrentItem(fragmentNum);
    }

}
