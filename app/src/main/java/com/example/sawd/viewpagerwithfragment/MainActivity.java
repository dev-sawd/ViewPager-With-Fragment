package com.example.sawd.viewpagerwithfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new SawdFragmentAdatper(getSupportFragmentManager()));

    }

    class SawdFragmentAdatper extends FragmentPagerAdapter {

        private ArrayList<Fragment> mFragment = new ArrayList<>();
        private SawdFragmentAdatper(FragmentManager fm) {
            super(fm);
            for(int i=0; i<5; i++) {
                mFragment.add(new SawdFragment());
            }
        }
        @Override
        public Fragment getItem(int position) {
            return mFragment.get(position);
        }
        @Override
        public int getCount() {
            return mFragment.size();
        }
    }
}
