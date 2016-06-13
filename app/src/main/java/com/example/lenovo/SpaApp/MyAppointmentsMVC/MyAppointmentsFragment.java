package com.example.lenovo.SpaApp.MyAppointmentsMVC;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments.InProgressFragment;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Controllers.CanceledFragmentController;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Controllers.HistoryAppointmentsController;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Controllers.InProgressFragmentController;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Controllers.UpcomingAppointmentsController;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by deii on 3/25/2016.
 */
public class MyAppointmentsFragment extends Fragment {
    @InjectView(R.id.tab_layout)
    TabLayout tabLayout;
    @InjectView(R.id.view_pager)
    ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private int modeFixed;
    private static Context context;

    public static MyAppointmentsFragment getInstance(String Name) {
        MyAppointmentsFragment appointmentsFragment = new MyAppointmentsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        appointmentsFragment.setArguments(bundle);
        return appointmentsFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.my_appointments, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViews();
    }

    private void InitViews() {
        HomeActivity.headerText.setText(getArguments().getString("name"));
        FragmentManager fragmentManager = getChildFragmentManager();
        pagerAdapter = new PagerAdapter(fragmentManager);
        viewPager.setAdapter(pagerAdapter);
        //set tablayout with viewpager
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(modeFixed);
        tabLayout.setTabTextColors(Color.GRAY, Color.WHITE);
        viewPager.setOffscreenPageLimit(4);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment frag = null;
            switch (position) {
                case 0:
                    frag = new UpcomingAppointmentsController();
                    break;
                case 1:
                    frag = new HistoryAppointmentsController();
                    break;
                case 2:
                    frag = new CanceledFragmentController();
                    break;
                case 3:
                    frag = new InProgressFragmentController();
                    break;

            }
            return frag;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = " ";
            switch (position) {
                case 0:
                    title = "UPCOMING";
                    break;
                case 1:
                    title = "HISTORY";
                    break;
                case 2:
                    title = "CANCELLED";
                    break;
                case 3:
                    title = "IN PROGRESS";
                    break;

            }

            return title;
        }
    }


}
