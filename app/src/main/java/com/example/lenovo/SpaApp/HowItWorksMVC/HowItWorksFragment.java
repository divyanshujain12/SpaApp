package com.example.lenovo.SpaApp.HowItWorksMVC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CirclePageIndicator;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu on 8/5/2016.
 */
public class HowItWorksFragment extends GlobalFragment {

    @InjectView(R.id.view_pager)
    ViewPager viewPager;
    String[] stepsName;
    int[] stepsIcon;
    @InjectView(R.id.indicator)
    CirclePageIndicator indicator;

    public static HowItWorksFragment getInstance(String Name) {
        HowItWorksFragment fragment = new HowItWorksFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        fragment.setArguments(bundle);
        return fragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeActivity.headerText.setText(getArguments().getString("name"));


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.how_it_works_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {

        }

    }

    private void initViews() {
        stepsName = new String[]{getString(R.string.step_1), getString(R.string.step_2), getString(R.string.step_3), getString(R.string.step_4), getString(R.string.step_5)};
        stepsIcon = new int[]{R.drawable.service, R.drawable.calender, R.drawable.mail, R.drawable.card, R.drawable.chair};

        PagerAdapter pagerAdapter = new PagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        indicator.setViewPager(viewPager);

    }

    @Override
    public void onResume() {
        super.onResume();
        initViews();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return HowItWorksChildFragment.getInstance(stepsName[position], stepsIcon[position]);
        }

        @Override
        public int getCount() {
            return stepsIcon.length;
        }

    }
}
