package com.example.lenovo.SpaApp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.Utils.ConnectionDetector;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;

public class SplashActivity extends AppCompatActivity {
    public static boolean gpscheck;
    LinearLayout l_backGround;
    int delayMillis;
    Boolean isInternetPresent = false;
    SharedPreferences preferences;
    ConnectionDetector cdr;
    String logflag;


    //file system ;
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splash);
        cdr = new ConnectionDetector(this);
        isInternetPresent = cdr.isConnectingToInternet();
        if (isInternetPresent) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = null;
                    if (MySharedPereference.getInstance().getBoolean(SplashActivity.this, Constants.LOGGED_IN)) {
                        i = new Intent(SplashActivity.this, HomeActivity.class);

                    } else {
                        i = new Intent(SplashActivity.this, HowToWork.class);
                    }
                    startActivity(i);
                    finish();
                }
            }, 3000);

        } else {
            displayAlert();

        }


    }

    Handler handler = new Handler();

    public void displayAlert() {
        new AlertDialog.Builder(this).setMessage("Please Enable your Internet access")
                .setTitle("SPA")
                .setCancelable(true)
                .setNeutralButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                finish();
                                SplashActivity.this.finish();

                            }
                        })
                .show();
    }

}
