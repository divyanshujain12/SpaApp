package com.example.lenovo.SpaApp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.lenovo.SpaApp.Adapters.HowItWorksPagerAdapter;
import com.example.lenovo.SpaApp.HowItWorksFragments.FirstFragment;
import com.example.lenovo.SpaApp.HowItWorksFragments.SecondFragment;
import com.example.lenovo.SpaApp.Utils.CirclePageIndicator;
import butterknife.ButterKnife;


/**
 * Created by Lenovo on 01-03-2016.
 */
public class HowItWork extends AppCompatActivity{
    /*@InjectView(R.id.appLogo)
    ImageView appLogo;*/
    private ViewPager viewpager;
    private int[] imageViewResources = {R.drawable.spa1, R.drawable.spa2, R.drawable.spa3, R.drawable.spa4};
    private String[] imageTexts = new String[4];
    private HowItWorksPagerAdapter viewPagerAdapter;
    private CirclePageIndicator pagerIndicator;
    private Animation splashLogoAnimation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.how_to_work);
        ButterKnife.inject(this);
        InitViews();
    }

    private void InitViews() {
        pagerIndicator = (CirclePageIndicator) findViewById(R.id.pagerIndicator);
        for (int i = 0; i < 4; i++)
            imageTexts[i] = getString(R.string.dummy_text);

        viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewPagerAdapter = new HowItWorksPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FirstFragment(), "");
        viewPagerAdapter.addFragment(new SecondFragment(), "");
        viewpager.setAdapter(viewPagerAdapter);
        pagerIndicator.setViewPager(viewpager, 0);
        pagerIndicator.setVisibility(View.VISIBLE);
        pagerIndicator.startAnimation(AnimationUtils.loadAnimation(HowItWork.this, R.anim.fade_in_animation));

      /*  splashLogoAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_logo_animation);

        splashLogoAnimation.setAnimationListener(this);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (MySharedPereference.getInstance().getBoolean(HowItWork.this, Constants.LOGGED_IN)) {
                    Intent i = new Intent(HowItWork.this, HomeActivity.class);
                    startActivity(i);
                    finish();
                } else
                    appLogo.startAnimation(splashLogoAnimation);
            }
        }, 3000);*/
    }

   /* Handler handler = new Handler();

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }*/
}