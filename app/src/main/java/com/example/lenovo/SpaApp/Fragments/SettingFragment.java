package com.example.lenovo.SpaApp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.HomeActivity;
import com.example.lenovo.SpaApp.R;

/**
 * Created by deii on 3/25/2016.
 */
public class SettingFragment extends Fragment {
    public static SettingFragment getInstance(String Name) {
        SettingFragment settingFragment = new SettingFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        settingFragment.setArguments(bundle);
        return settingFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViews();
    }

    private void InitViews() {
        HomeActivity.headerText.setText(getArguments().getString("name"));
    }
}
