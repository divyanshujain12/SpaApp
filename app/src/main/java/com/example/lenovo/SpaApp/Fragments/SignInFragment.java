package com.example.lenovo.SpaApp.Fragments;

/**
 * Created by Mangal on 2/5/2016.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivityController;
import com.example.lenovo.SpaApp.MyApplication;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CallBackInterface;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.ConnectionDetector;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.neopixl.pixlui.components.button.Button;
import com.neopixl.pixlui.components.edittext.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class SignInFragment extends Fragment implements View.OnClickListener, CallBackInterface {


    SharedPreferences preferences;
    Button signin;
    ConnectionDetector cdr;
    EditText edtemail, edtpassword;
    TextInputLayout tilEmail, tilpassword;
    View v;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = MyApplication.preference;
        cdr = new ConnectionDetector(getActivity());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.signin_layout, container, false);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViews();

    }

    private void InitViews() {

        signin = (com.neopixl.pixlui.components.button.Button) getView().findViewById(R.id.signin_button);
        edtemail = (EditText) getView().findViewById(R.id.edtEmail);
        edtpassword = (EditText) getView().findViewById(R.id.edtpassword);
        tilEmail = (TextInputLayout) getView().findViewById(R.id.tilEmail);
        tilpassword = (TextInputLayout) getView().findViewById(R.id.tilpassword);
        edtemail.addTextChangedListener(new MyTextWatcher(edtemail));
        edtpassword.addTextChangedListener(new MyTextWatcher(edtpassword));
        signin.setOnClickListener(this);
        signin.setEnabled(true);
    }


    @Override
    public void onJsonObjectSuccess(JSONObject object) {

        System.out.println("log in res ::" + object.toString());
        String message = "";
        try {
            message = object.getString(Constants.MESSAGE);
            JSONObject new_user = object.getJSONObject(Constants.DATA);
            MySharedPereference.getInstance().setString(getActivity(), Constants.NAME, new_user.getString(Constants.NAME));
            MySharedPereference.getInstance().setString(getActivity(), Constants.EMAIL, new_user.getString(Constants.EMAIL));
            MySharedPereference.getInstance().setBoolean(getActivity(), Constants.LOGGED_IN, true);
            Intent i = new Intent(getActivity(), HomeActivityController.class);
            startActivity(i);
            getActivity().finish();

        } catch (JSONException e) {
            e.printStackTrace();
            message = e.getMessage();

        }

        CommonFunctions.showSnackBarWithoutAction(getView(), message);

    }

    @Override
    public void onJsonArrarSuccess(JSONArray array) {


    }


    @Override
    public void onFailure(String str) {

    }

    public void signinclick() {


        if (edtemail.getText().toString().equals("") || edtpassword.getText().toString().equals("")) {
            submitForm();
        } else {
            CallWebService.getInstance(getActivity(), true).hitJSONObjectVolleyWebService(Request.Method.POST, Constants.WebServices.LOG_IN, createMapForPostingData(), SignInFragment.this);
        }


    }

    private void submitForm() {


        if (!validateEmail()) {
            return;
        }

        if (!validatePassword()) {
            return;
        }


    }


    private boolean validateEmail() {
        String email = edtemail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            tilEmail.setError(getString(R.string.err_msg_email));
            //requestFocus(edtemail);
            return false;
        } else {
            tilEmail.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean validatePassword() {
        if (edtpassword.getText().toString().trim().isEmpty()) {
            tilpassword.setError(getString(R.string.err_msg_password));
            // requestFocus(edtpassword);
            return false;
        } else {
            tilpassword.setErrorEnabled(false);
        }

        return true;
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.edtEmail:
                    validateEmail();
                    break;
                case R.id.edtpassword:
                    validatePassword();
                    break;
            }

        }
    }


    @Override
    public void onClick(View v) {
       /* Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
        getActivity().finish();*/
        signinclick();
    }

    private HashMap<String, String> createMapForPostingData() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Constants.EMAIL, edtemail.getText().toString());
        hashMap.put(Constants.PASSWORD, edtpassword.getText().toString());

        return hashMap;
    }
}