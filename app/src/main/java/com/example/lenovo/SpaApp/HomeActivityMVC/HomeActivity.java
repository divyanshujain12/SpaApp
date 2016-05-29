package com.example.lenovo.SpaApp.HomeActivityMVC;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.example.lenovo.SpaApp.Adapters.MenuFragmentAdapter;
import com.example.lenovo.SpaApp.Fragments.AppointmentsFragment;
import com.example.lenovo.SpaApp.Fragments.BuyServicesFragment;
import com.example.lenovo.SpaApp.Fragments.ContactFragment;
import com.example.lenovo.SpaApp.Fragments.SettingFragment;
import com.example.lenovo.SpaApp.HomeFragmentMVC.HomeFragment;
import com.example.lenovo.SpaApp.HomeFragmentMVC.HomeFragmentControllers;
import com.example.lenovo.SpaApp.HowToWork;
import com.example.lenovo.SpaApp.MainActivity;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;
import com.neopixl.pixlui.components.textview.TextView;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Lenovo on 01-03-2016.
 */
public class HomeActivity extends GlobalActivity {

    public Toolbar toolbar;
    public static TextView headerText;
    protected RecyclerView menuRV;
    private MenuFragmentAdapter menuFragmentAdapter;
    protected FragmentManager fragmentManager;
    @InjectView(R.id.root)
    FrameLayout root;
    @InjectView(R.id.content_hamburger)
    View contentHamburger;
    GuillotineAnimation guillotineAnimation;
    private static final long RIPPLE_DURATION = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        ButterKnife.inject(this);
        InitViews();
    }

    private void InitViews() {
        fragmentManager = getSupportFragmentManager();
        setupToolbar();

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.fragment_menu, null);
        root.addView(guillotineMenu);

        guillotineAnimation = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();


        menuRV = (RecyclerView) guillotineMenu.findViewById(R.id.menuRV);
        menuRV.setLayoutManager(new LinearLayoutManager(this));
        menuFragmentAdapter = new MenuFragmentAdapter(this);
        menuRV.setAdapter(menuFragmentAdapter);


    }

    protected void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        headerText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

    }



   /* public void onCardClick(View view) {
        homeFragment.onCardClick(view);
    }*/
}
