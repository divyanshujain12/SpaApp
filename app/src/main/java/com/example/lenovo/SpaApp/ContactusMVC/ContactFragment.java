package com.example.lenovo.SpaApp.ContactusMVC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.Interfaces.SnackBarCallback;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.neopixl.pixlui.components.edittext.EditText;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by deii on 3/25/2016.
 */
public class ContactFragment extends GlobalFragment {
    @InjectView(R.id.edtName)
    EditText edtName;
    @InjectView(R.id.edtEmail)
    EditText edtEmail;
    @InjectView(R.id.edtNumber)
    EditText edtNumber;
    @InjectView(R.id.edtSubject)
    EditText edtSubject;
    @InjectView(R.id.edtMessage)
    EditText edtMessage;
    @InjectView(R.id.submitTV)
    TextView submitTV;

    protected String nameString, emailString, numberString, subjectString, messageString;

    public static ContactFragment getInstance(String Name) {
        ContactFragment contactFragment = new ContactFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        contactFragment.setArguments(bundle);
        return contactFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_us, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViews();
    }

    private void InitViews() {
        HomeActivity.headerText.setText(getArguments().getString("name"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.submitTV)
    public void onClick() {
        nameString = CommonFunctions.getEditTextValue(edtName);
        emailString = CommonFunctions.getEditTextValue(edtEmail);
        numberString = CommonFunctions.getEditTextValue(edtNumber);
        subjectString = CommonFunctions.getEditTextValue(edtSubject);
        messageString = CommonFunctions.getEditTextValue(edtMessage);

        if (checkFields()) return;
        else
            CallWebService.getInstance(getActivity(), true).hitWithJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.CONTACT_US, createJsonForSendingQuery(), this);

    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) throws JSONException {
        super.onJsonObjectSuccess(object);

        AlertMessage.showAlertDialogWithOkCallBack(getActivity(), getString(R.string.alert), object.getString(Constants.MESSAGE), new SnackBarCallback() {
            @Override
            public void doAction() {
                getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });
    }

    private boolean checkFields() {
        if (nameString.isEmpty()) {
            edtName.setError(getString(R.string.err_msg_name));
            edtName.requestFocus();
            return true;
        } else if (!CommonFunctions.isValidEmail(emailString)) {
            edtEmail.setError(getString(R.string.err_msg_email));
            edtEmail.requestFocus();
            return true;
        } else if (!CommonFunctions.isValidNumber(numberString)) {
            edtNumber.setError(getString(R.string.err_msg_number));
            edtNumber.requestFocus();
            return true;
        } else if (subjectString.isEmpty()) {
            edtSubject.setError(getString(R.string.err_msg_address));
            edtSubject.requestFocus();
            return true;
        } else if (messageString.isEmpty()) {
            edtMessage.setError(getString(R.string.err_msg_address));
            edtMessage.requestFocus();
            return true;
        }
        return false;
    }

    private JSONObject createJsonForSendingQuery() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(Constants.EMAIL, emailString);
            jsonObject.put(Constants.NAME, nameString);
            jsonObject.put(Constants.PHONE_NUMBER, numberString);
            jsonObject.put(Constants.SUBJECT, subjectString);
            jsonObject.put(Constants.MESSAGE, messageString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
