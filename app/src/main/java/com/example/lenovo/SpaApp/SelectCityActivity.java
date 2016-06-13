package com.example.lenovo.SpaApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivityController;

/**
 * Created by divyanshu on 4/3/2016.
 */

public class SelectCityActivity extends AppCompatActivity {
    ImageView imgNewYork, imgLondon, imgLosAngles;
    private Animation fade_in, fade_out;
    private ViewFlipper backgroundFlipper;
    private View previousView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_city_activity);

        InitViews();
    }

    private void InitViews() {
        fade_in = new AlphaAnimation(0, 1);
        fade_in.setInterpolator(new DecelerateInterpolator());
        fade_in.setDuration(500);
        fade_out = new AlphaAnimation(1, 0);
        fade_out.setInterpolator(new AccelerateInterpolator());
        // fade_out.setStartOffset(1000);
        fade_out.setDuration(500);

        backgroundFlipper = (ViewFlipper) findViewById(R.id.backgroundFlipper);
        backgroundFlipper.setInAnimation(fade_in);
        backgroundFlipper.setOutAnimation(fade_out);
        imgNewYork = (ImageView) findViewById(R.id.imgNewYork);
        imgLondon = (ImageView) findViewById(R.id.imgLondon);
        imgLosAngles = (ImageView) findViewById(R.id.imgLosAngles);

        previousView = findViewById(R.id.txtNewYork);
    }

    public void ChangeCity(View view) {
        switch (view.getId()) {
            case R.id.txtNewYork:
                backgroundFlipper.setDisplayedChild(0);
                break;
            case R.id.txtLondon:
                backgroundFlipper.setDisplayedChild(1);
                break;
            case R.id.txtLosAngeles:
                backgroundFlipper.setDisplayedChild(2);
                break;
        }
        switch (previousView.getId()) {
            case R.id.txtNewYork:
                previousView.setBackgroundResource(R.drawable.new_york);
                break;
            case R.id.txtLondon:
                previousView.setBackgroundResource(R.drawable.london);
                break;
            case R.id.txtLosAngeles:
                previousView.setBackgroundResource(R.drawable.los_angles);
                break;
        }
        view.setBackgroundResource(R.drawable.selected_city);
        previousView = view;
    }

    public void ConfirmCity(View view) {
        int pos = getIntent().getIntExtra("pos", -1);
        Intent i = new Intent(this, HomeActivityController.class);
        if (pos > -1) {
            i = new Intent(this, MainActivity.class);
            i.putExtra("pos", pos);
        }
        startActivity(i);
        finish();
    }
}
