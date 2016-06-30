package com.example.lenovo.SpaApp.CorporateEnquiriesMVC;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.R;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;

/**
 * Created by divyanshu.jain on 6/13/2016.
 */
class CorporateFragment extends GlobalFragment {

    Context context;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.corporate_inquiries_new, container, false);

        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViews();
    }

    private void InitViews() {

    }
}
