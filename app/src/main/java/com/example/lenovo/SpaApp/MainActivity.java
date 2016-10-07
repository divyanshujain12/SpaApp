package com.example.lenovo.SpaApp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;

import com.example.lenovo.SpaApp.Fragments.SignInFragment;
import com.example.lenovo.SpaApp.Fragments.SignUpFragment;
import com.example.lenovo.SpaApp.Interfaces.UpdateViewPagerPosition;
import com.example.lenovo.SpaApp.Utils.NonSwipeableViewPager;

import java.util.ArrayList;
import java.util.List;

import GlobalClasses.GlobalActivity;


public class MainActivity extends GlobalActivity implements UpdateViewPagerPosition {
    private NonSwipeableViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        viewPager = (NonSwipeableViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setCurrentItem(getIntent().getIntExtra("pos", 0));
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(getResources().getColor(R.color.button_color), getResources().getColor(android.R.color.white));
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SignInFragment(), getResources().getString(R.string.log_in));
        adapter.addFragment(new SignUpFragment(this), getResources().getString(R.string.sign_up));

        viewPager.setAdapter(adapter);
    }

    @Override
    public void updatePosition(int pos) {
        viewPager.setCurrentItem(pos);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }


    }
}
