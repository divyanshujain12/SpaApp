package com.example.lenovo.SpaApp.AppIntro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;

import com.example.lenovo.SpaApp.Adapters.HowItWorksPagerAdapter;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivityController;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.SelectCityActivity;
import com.example.lenovo.SpaApp.Utils.CirclePageIndicator;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;

import butterknife.ButterKnife;
import butterknife.OnClick;
import tyrantgit.explosionfield.ExplosionField;


/**
 * Created by Lenovo on 01-03-2016.
 */
public class AppIntroActivity extends AppCompatActivity {
    /*@InjectView(R.id.appLogo)
    ImageView appLogo;*/
    private ViewPager viewpager;
    private String[] imageTexts = new String[4];
    private HowItWorksPagerAdapter viewPagerAdapter;
    private CirclePageIndicator pagerIndicator;
    private ExplosionField mExplosionField;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (MySharedPereference.getInstance().getBoolean(this, Constants.LOGGED_IN)) {
            Intent i = new Intent(this, HomeActivityController.class);
            startActivity(i);

        }
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.how_to_work);
        ButterKnife.inject(this);
        InitViews();
    }

    private void InitViews() {

        mExplosionField = ExplosionField.attach2Window(this);
        pagerIndicator = (CirclePageIndicator) findViewById(R.id.pagerIndicator);
        for (int i = 0; i < 4; i++)
            imageTexts[i] = getString(R.string.dummy_text);

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewPagerAdapter = new HowItWorksPagerAdapter(getSupportFragmentManager());
        //viewPagerAdapter.addFragment(new FirstFragment(), "");
        viewPagerAdapter.addFragment(new SecondFragment(), "");
        viewPagerAdapter.addFragment(new ThirdFragment(), "");
        viewpager.setAdapter(viewPagerAdapter);
        pagerIndicator.setViewPager(viewpager, 0);
        pagerIndicator.setVisibility(View.VISIBLE);
        pagerIndicator.startAnimation(AnimationUtils.loadAnimation(AppIntroActivity.this, R.anim.fade_in_animation));
        viewpager.setOffscreenPageLimit(3);

    }

    @OnClick({R.id.txtSkip, R.id.txtSignIn, R.id.txtSignUp})
    public void onClick(View view) {
        mExplosionField.explode(view);
        intent = new Intent(this, SelectCityActivity.class);
        switch (view.getId()) {
            case R.id.txtSkip:
                intent.putExtra("pos", -1);
                break;
            case R.id.txtSignIn:
                intent.putExtra("pos", 0);
                break;
            case R.id.txtSignUp:
                intent.putExtra("pos", 1);
                break;
        }
        handler.postDelayed(runnable, 1000);
    }

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            startActivity(intent);
            finish();
        }
    };
}