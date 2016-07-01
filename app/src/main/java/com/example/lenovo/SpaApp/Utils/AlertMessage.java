package com.example.lenovo.SpaApp.Utils;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;

import com.example.lenovo.SpaApp.Interfaces.AlertDialogInterface;
import com.example.lenovo.SpaApp.Interfaces.SnackBarCallback;
import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.textview.TextView;


public class AlertMessage {

    @SuppressWarnings("deprecation")
    public static void showAlertDialog(Context context, String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context, R.style.MyAlertDialogStyle).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialog.show();
    }


    public static void showAlertDialogWithCallBack(Context context, String title, String message, final SnackBarCallback snackBarCallback) {
        AlertDialog alertDialog = new AlertDialog.Builder(context, R.style.MyAlertDialogStyle).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                snackBarCallback.doAction();
                dialog.dismiss();
            }
        });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }

    public static void showAlertDialogWithActions(Context context, String message, final AlertDialogInterface alertDialogInterface) {
        final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setCancelable(false);
        View view = ((Activity) context).getLayoutInflater().inflate(R.layout.custom_alert_dialog, null);
        alertDialog.setView(view);
        TextView contentTV = (TextView) view.findViewById(R.id.contentTV);
        TextView yesTV = (TextView) view.findViewById(R.id.yesTV);
        TextView noTV = (TextView) view.findViewById(R.id.noTV);

        contentTV.setText(message);

        yesTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogInterface.Yes();
                alertDialog.dismiss();
            }
        });
        noTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialogInterface.No();
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    public static void showAlertDialogWithOkCallBack(Context context, String title, String message, final SnackBarCallback snackBarCallback) {
        AlertDialog alertDialog = new AlertDialog.Builder(context, R.style.MyAlertDialogStyle).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                snackBarCallback.doAction();
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }


}
