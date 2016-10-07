package com.example.lenovo.SpaApp.HowItWorksMVC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.textview.TextView;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu on 9/4/2016.
 */
public class HowItWorksChildFragment extends GlobalFragment {
    @InjectView(R.id.stepIconIV)
    ImageView stepIconIV;
    @InjectView(R.id.stepTextTV)
    TextView stepTextTV;

    public static HowItWorksChildFragment getInstance(String name, int icon) {
        HowItWorksChildFragment howItWorksChildFragment = new HowItWorksChildFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putInt("resource", icon);
        howItWorksChildFragment.setArguments(bundle);

        return howItWorksChildFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.how_it_works_child_frament, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            stepIconIV.setImageResource(getArguments().getInt("resource"));
            stepTextTV.setText(getArguments().getString("name"));
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
