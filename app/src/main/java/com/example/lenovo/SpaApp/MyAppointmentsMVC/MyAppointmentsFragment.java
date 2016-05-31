package com.example.lenovo.SpaApp.MyAppointmentsMVC;

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
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Controllers.HistoryAppointmentsController;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Controllers.UpcomingAppointmentsController;
import com.example.lenovo.SpaApp.R;

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

            }
            return frag;
        }

        @Override
        public int getCount() {
            return 2;
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

            }

            return title;
        }
    }


    public static String dummyJSON = "{\n" +
            "\"data\":[\n" +
            "{\"id\":\"1\",\n" +
            "\"service_name\":\"SERVICE 1\",\n" +
            "\"sub_service_name\":\"sub service name 1\",\n" +
            "\"duration\":\"2 hr\",\n" +
            "\"cost\":\"$ 20\",\n" +
            "\"date\":\"31-05-2016\"\n" +
            "\n" +
            "},\n" +
            "{\"id\":\"2\",\n" +
            "\"service_name\":\"SERVICE 2\",\n" +
            "\"sub_service_name\":\"sub service name 2\",\n" +
            "\"duration\":\"2 hr\",\n" +
            "\"cost\":\"$ 30\",\n" +
            "\"date\":\"31-05-2016\"\n" +
            "\n" +
            "},\n" +
            "{\"id\":\"3\",\n" +
            "\"service_name\":\"SERVICE 3\",\n" +
            "\"sub_service_name\":\"sub service name 3\",\n" +
            "\"duration\":\"1.5 hr\",\n" +
            "\"cost\":\"$ 25\",\n" +
            "\"date\":\"31-05-2016\"\n" +
            "\n" +
            "},\n" +
            "{\"id\":\"4\",\n" +
            "\"service_name\":\"SERVICE 4\",\n" +
            "\"sub_service_name\":\"sub service name 4\",\n" +
            "\"duration\":\"3 hr\",\n" +
            "\"cost\":\"$ 40\",\n" +
            "\"date\":\"31-05-2016\"\n" +
            "\n" +
            "},\n" +
            "{\"id\":\"5\",\n" +
            "\"service_name\":\"SERVICE 5\",\n" +
            "\"sub_service_name\":\"sub service name 5\",\n" +
            "\"duration\":\"2 hr\",\n" +
            "\"cost\":\"$ 20\",\n" +
            "\"date\":\"4-06-2016\"\n" +
            "\n" +
            "},\n" +
            "{\"id\":\"6\",\n" +
            "\"service_name\":\"SERVICE 6\",\n" +
            "\"sub_service_name\":\"sub service name 6\",\n" +
            "\"duration\":\"2 hr\",\n" +
            "\"cost\":\"$ 20\",\n" +
            "\"date\":\"1-06-2016\"\n" +
            "\n" +
            "}\n" +
            "\n" +
            "]\n" +
            "}";
}
