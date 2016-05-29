package com.example.lenovo.SpaApp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.R;

/**
 * Created by deii on 3/25/2016.
 */
public class BuyServicesFragment extends Fragment{
    public static BuyServicesFragment getInstance(String Name) {
        BuyServicesFragment buyServicesFragment = new BuyServicesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        buyServicesFragment.setArguments(bundle);
        return buyServicesFragment;

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
