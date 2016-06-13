package com.example.lenovo.SpaApp.FAQFragmentMVC;

import android.os.Bundle;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;

/**
 * Created by divyanshu.jain on 6/13/2016.
 */
public class FaqFragmentController extends FaqFragment {

    public static FaqFragmentController getInstance(String Name) {
        FaqFragmentController fragment = new FaqFragmentController();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        fragment.setArguments(bundle);
        return fragment;

    }

    public void onResume() {
        super.onResume();
        HomeActivity.headerText.setText(getArguments().getString("name"));
    }
}
