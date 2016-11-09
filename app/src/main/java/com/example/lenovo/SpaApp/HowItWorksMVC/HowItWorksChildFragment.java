package com.example.lenovo.SpaApp.HowItWorksMVC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
    @InjectView(R.id.mainContainer)
    LinearLayout mainContainer;

    String[] stepsName;
    int[] stepsIcon, stepsBackground;
    @InjectView(R.id.stepFirstIconIV)
    ImageView stepFirstIconIV;

    public static HowItWorksChildFragment getInstance(int position) {
        HowItWorksChildFragment howItWorksChildFragment = new HowItWorksChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
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
        initializeArrays();
        int position = getArguments().getInt("position");
        if (savedInstanceState == null) {
            checkForFirstPos(position);
            stepTextTV.setText(stepsName[position]);
            mainContainer.setBackgroundResource(stepsBackground[position]);
        }

    }

    private void checkForFirstPos(int position) {
        if (position == 0) {
            stepFirstIconIV.setImageResource(stepsIcon[position]);
            stepFirstIconIV.setVisibility(View.VISIBLE);
            stepIconIV.setVisibility(View.GONE);
        } else
            stepIconIV.setImageResource(stepsIcon[position]);
    }

    private void initializeArrays() {
        stepsName = new String[]{getString(R.string.step_1), getString(R.string.step_2), getString(R.string.step_3), getString(R.string.step_4), getString(R.string.step_5)};
        //stepsIcon = new int[]{R.drawable.service, R.drawable.calender, R.drawable.mail, R.drawable.card, R.drawable.chair};
        stepsIcon = new int[]{R.drawable.logoblack_with_icons, R.drawable.icon_calender, R.drawable.icon_mail, R.drawable.icon_card, R.drawable.icon_relax};
        stepsBackground = new int[]{R.drawable.intro_login_bg, R.drawable.how_it_works_two, R.drawable.how_it_works_three, R.drawable.how_it_works_four, R.drawable.how_it_works_five};
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
