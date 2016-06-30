package com.example.lenovo.SpaApp.MyAccountMVC;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.textview.TextView;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by divyanshu.jain on 6/14/2016.
 */
public class MyAccountFragment extends GlobalFragment {

    protected static Context context;
    @InjectView(R.id.logo)
    ImageView logo;
    @InjectView(R.id.emailLL)
    LinearLayout emailLL;
    @InjectView(R.id.nameLL)
    LinearLayout nameLL;
    @InjectView(R.id.numberLL)
    LinearLayout numberLL;
    @InjectView(R.id.passwordLL)
    LinearLayout passwordLL;
    @InjectView(R.id.submitTV)
    TextView submitTV;
    @InjectView(R.id.emailTV)
    TextView emailTV;
    @InjectView(R.id.nameTV)
    TextView nameTV;
    @InjectView(R.id.numberTV)
    TextView numberTV;
    @InjectView(R.id.passwordTV)
    TextView passwordTV;

    MyAccountFragmentController controller;

    public static MyAccountFragment getInstance(String Name) {
        MyAccountFragment fragment = new MyAccountFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.my_account, container, false);

        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViews();
    }

    private void InitViews() {
        controller = new MyAccountFragmentController();
        HomeActivity.headerText.setText(getArguments().getString("name"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.emailLL, R.id.nameLL, R.id.numberLL, R.id.passwordLL, R.id.submitTV})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.emailLL:
                controller.showAlertForUpdateData(getActivity(), getString(R.string.old_email), emailTV.getText().toString(), getString(R.string.new_email), getString(R.string.enter_email), MyAccountFragmentController.EMAIL, emailTV);
                break;
            case R.id.nameLL:
                controller.showAlertForUpdateData(getActivity(), getString(R.string.old_name), nameTV.getText().toString(), getString(R.string.new_name), getString(R.string.enter_name), MyAccountFragmentController.NAME, nameTV);
                break;
            case R.id.numberLL:
                controller.showAlertForUpdateData(getActivity(), getString(R.string.old_number), numberTV.getText().toString(), getString(R.string.new_number), getString(R.string.enter_number), MyAccountFragmentController.NUMBER, numberTV);
                break;
            case R.id.passwordLL:
                controller.showAlertForChangePassword(getActivity(), passwordTV);
                break;
            case R.id.submitTV:
                break;
        }
    }

}
