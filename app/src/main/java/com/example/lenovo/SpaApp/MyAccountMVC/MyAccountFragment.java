package com.example.lenovo.SpaApp.MyAccountMVC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by divyanshu.jain on 6/14/2016.
 */
public class MyAccountFragment extends GlobalFragment {

    protected static FragmentActivity context;
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
                controller.showAlertForUpdateData(getContext(), getString(R.string.old_email), emailTV.getText().toString(), getString(R.string.new_email), getString(R.string.enter_email), MyAccountFragmentController.EMAIL, emailTV);
                break;
            case R.id.nameLL:
                controller.showAlertForUpdateData(getContext(), getString(R.string.old_name), nameTV.getText().toString(), getString(R.string.new_name), getString(R.string.enter_name), MyAccountFragmentController.NAME, nameTV);
                break;
            case R.id.numberLL:
                controller.showAlertForUpdateData(getContext(), getString(R.string.old_number), numberTV.getText().toString(), getString(R.string.new_number), getString(R.string.enter_number), MyAccountFragmentController.NUMBER, numberTV);
                break;
            case R.id.passwordLL:
                controller.showAlertForChangePassword(getContext(), passwordTV);
                break;
            case R.id.submitTV:

                CallWebService.getInstance(getContext(), true).hitWithJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.CHANGE_PASSWORD, createJsonForUpdateAccount(), this);
                break;
        }
    }

    private JSONObject createJsonForUpdateAccount() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(Constants.EMAIL, emailTV.getText().toString());
            jsonObject.put(Constants.NAME, nameTV.getText().toString());
            jsonObject.put(Constants.PHONE_NUMBER, numberTV.getText().toString());
            jsonObject.put(Constants.PASSWORD, passwordTV.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) throws JSONException {
        super.onJsonObjectSuccess(object);
        AlertMessage.showAlertDialog(getContext(), "ALERT", object.getString(Constants.MESSAGE), false);

        MySharedPereference.getInstance().setString(getContext(), Constants.NAME, nameTV.getText().toString());
        MySharedPereference.getInstance().setString(getContext(), Constants.EMAIL, emailTV.getText().toString());
        MySharedPereference.getInstance().setString(getContext(), Constants.PHONE_NUMBER, numberTV.getText().toString());
        MySharedPereference.getInstance().setString(getContext(), Constants.PASSWORD, passwordTV.getText().toString());
    }
}
