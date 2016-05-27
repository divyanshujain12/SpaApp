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
public class NotificationsFragment extends Fragment{
    public static NotificationsFragment getInstance(String Name) {
        NotificationsFragment notificationsFragment = new NotificationsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        notificationsFragment.setArguments(bundle);
        return notificationsFragment;

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
