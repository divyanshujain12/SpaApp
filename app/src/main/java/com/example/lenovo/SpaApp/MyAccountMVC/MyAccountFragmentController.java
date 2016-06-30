package com.example.lenovo.SpaApp.MyAccountMVC;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.neopixl.pixlui.components.edittext.EditText;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * Created by divyanshu.jain on 6/14/2016.
 */
public class MyAccountFragmentController {
    final protected static int EMAIL = 0;
    final protected static int NAME = 1;
    final protected static int NUMBER = 2;

    TextView oldKeyTV;
    TextView oldValueTV;
    TextView newKeyTV;
    EditText newValueET;
    TextView yesTV;
    TextView noTV;
    EditText confirmPassET;
    EditText oldValueET;
    AlertDialog alertDialog;
    String finalValue;

    public void showAlertForUpdateData(final Context context, String oldKey, String oldValue, String newKey, String etHint, final int type, final TextView targetTV) {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setCancelable(false);
        View view = LayoutInflater.from(context).inflate(R.layout.update_account_dialog, null);
        alertDialog.setView(view);

        oldKeyTV = (TextView) view.findViewById(R.id.oldKeyTV);
        oldValueTV = (TextView) view.findViewById(R.id.oldValueTV);
        newKeyTV = (TextView) view.findViewById(R.id.newKeyTV);
        newValueET = (EditText) view.findViewById(R.id.newValueET);
        yesTV = (TextView) view.findViewById(R.id.yesTV);
        noTV = (TextView) view.findViewById(R.id.noTV);
        newValueET.setHint(etHint);

        switch (type) {
            case EMAIL:
                newValueET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
            case NAME:
                newValueET.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case NUMBER:
                newValueET.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
        }

        oldKeyTV.setText(oldKey);
        oldValueTV.setText(oldValue);
        newKeyTV.setText(newKey);

        yesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String errorMsg = "";
                finalValue = newValueET.getText().toString();
                switch (type) {
                    case EMAIL:
                        if (!isValidString(finalValue))
                            errorMsg = context.getString(R.string.err_msg_empty);
                        else if (!CommonFunctions.isValidEmail(finalValue))
                            errorMsg = context.getString(R.string.err_msg_email);
                        break;
                    case NAME:
                        if (!isValidString(finalValue))
                            errorMsg = context.getString(R.string.err_msg_name);
                        break;
                    case NUMBER:
                        if (!isValidString(finalValue))
                            errorMsg = context.getString(R.string.err_msg_empty);
                        else if (!CommonFunctions.isValidNumber(finalValue))
                            errorMsg = context.getString(R.string.err_msg_number);
                        break;
                }
                if (errorMsg.isEmpty()) {
                    targetTV.setText(finalValue);
                    alertDialog.dismiss();
                } else {
                    targetTV.setError(errorMsg);
                    targetTV.requestFocus();
                }

            }
        });

        noTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }


    public void showAlertForChangePassword(final Context context, final TextView targetTV) {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setCancelable(false);
        View view = LayoutInflater.from(context).inflate(R.layout.update_password_dialog, null);
        alertDialog.setView(view);

        oldValueET = (EditText) view.findViewById(R.id.oldValueET);
        newValueET = (EditText) view.findViewById(R.id.newValueET);
        confirmPassET = (EditText) view.findViewById(R.id.confirmPassET);
        yesTV = (TextView) view.findViewById(R.id.yesTV);
        noTV = (TextView) view.findViewById(R.id.noTV);

        yesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String errorMsg = "";
                String oldPass = oldValueET.getText().toString();
                String newPass = newValueET.getText().toString();
                String confirmPass = confirmPassET.getText().toString();

                if (!isValidString(oldPass)) {
                    oldValueET.setError(context.getString(R.string.err_msg_password));
                    oldValueET.requestFocus();
                    return;
                }
                if (!isValidString(newPass)) {
                    newValueET.setError(context.getString(R.string.err_msg_password));
                    newValueET.requestFocus();
                    return;
                }
                if (!isValidString(confirmPass)) {
                    confirmPassET.setError(context.getString(R.string.err_msg_password));
                    confirmPassET.requestFocus();
                    return;
                }

                if (!oldPass.equals(MySharedPereference.getInstance().getString(context, Constants.PASSWORD))) {
                    Toast.makeText(context, context.getString(R.string.old_pass_mismatch), Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!newPass.equals(confirmPass)) {
                    Toast.makeText(context, context.getString(R.string.new_pass_mismatch), Toast.LENGTH_SHORT).show();
                    return;
                }

                finalValue = newValueET.getText().toString();
                targetTV.setText(finalValue);
                alertDialog.dismiss();


            }
        });

        noTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private boolean isValidString(String string) {
        if (string.length() > 0)
            return true;
        else
            return false;
    }

}
