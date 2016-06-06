package com.example.lenovo.SpaApp.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.lenovo.SpaApp.Interfaces.SnackBarCallback;
import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.edittext.EditText;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by deii on 10/12/2015.
 */
public class CommonFunctions {
    private Context context;
    private static Snackbar snackbar = null;

    public CommonFunctions(Context context) {
        this.context = context;

    }

    public static float centerX(View view) {
        return ViewHelper.getX(view) + view.getWidth() / 2;
    }

    public static float centerY(View view) {
        return ViewHelper.getY(view) + view.getHeight() / 2;
    }

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidNumber(String number) {
        return !TextUtils.isEmpty(number) && Patterns.PHONE.matcher(number).matches();
    }

    public void requestFocus(View view) {
        if (view.requestFocus()) {
            ((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public boolean validateName(EditText inputName, TextInputLayout inputLayoutName) {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(((Activity) context).getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    public boolean validatePhone(EditText inputPhone, TextInputLayout inputLayoutPhone) {
        try {
            if (Integer.parseInt(inputPhone.getText().toString().trim()) < 10) {
                inputLayoutPhone.setError(((Activity) context).getString(R.string.err_msg_number));
                requestFocus(inputPhone);
                return false;
            } else {
                inputLayoutPhone.setErrorEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    public static void showSnackBarWithAction(View view, String message, final SnackBarCallback callback) {

        snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                        callback.doAction();
                    }
                });

        // Changing message text color
        snackbar.setActionTextColor(Color.WHITE);
        View textView = snackbar.getView();
        TextView tv = (TextView) textView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackbar.show();
    }

    public static void showSnackBarWithoutAction(View view, String message) {

        snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);

        // Changing message text color
        snackbar.setActionTextColor(Color.WHITE);
        View textView = snackbar.getView();
        TextView tv = (TextView) textView.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackbar.show();
    }
}
