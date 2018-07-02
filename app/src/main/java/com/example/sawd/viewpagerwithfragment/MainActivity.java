package com.example.sawd.viewpagerwithfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int MAX_PAGE = 3;

    Fragment currentFragment = new Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setAdapter(new SawdFragmentAdatper(getSupportFragmentManager()));

    }

    class SawdFragmentAdatper extends FragmentPagerAdapter {

        private SawdFragmentAdatper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position < 0 || MAX_PAGE <= position)
                return null;

            switch (position) {
                case 0:
                    currentFragment = new SawdFragment1();
                    break;
                case 1:
                    currentFragment = new SawdFragment2();
                    break;
                case 2:
                    currentFragment = new SawdFragment3();
                    break;
            }

            return currentFragment;
        }

        @Override
        public int getCount() {
            return MAX_PAGE;
        }
    }
}
