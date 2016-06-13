package com.example.lenovo.SpaApp.CorporateEnquiriesMVC;

import android.os.Bundle;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;

/**
 * Created by divyanshu.jain on 6/13/2016.
 */
public class CorporateFragmentController extends CorporateFragment {
    public static CorporateFragmentController getInstance(String Name) {
        CorporateFragmentController fragment = new CorporateFragmentController();
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
