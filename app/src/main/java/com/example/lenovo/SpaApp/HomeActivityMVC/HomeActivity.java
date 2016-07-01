package com.example.lenovo.SpaApp.HomeActivityMVC;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.example.lenovo.SpaApp.Adapters.MenuFragmentAdapter;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithHamburg;
import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.textview.TextView;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Lenovo on 01-03-2016.
 */
public class HomeActivity extends GlobalActivity {


    public static TextView headerText;
    protected RecyclerView menuRV;
    @InjectView(R.id.toolbar)
    ToolbarWithHamburg toolbar;
    private MenuFragmentAdapter menuFragmentAdapter;
    protected FragmentManager fragmentManager;
    @InjectView(R.id.root)
    FrameLayout root;
    GuillotineAnimation guillotineAnimation;
    private static final long RIPPLE_DURATION = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.home_activity);
        ButterKnife.inject(this);
        InitViews();
    }

    private void InitViews() {
        fragmentManager = getSupportFragmentManager();
        setupToolbar();

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.fragment_menu, null);
        root.addView(guillotineMenu);

        guillotineAnimation = new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), toolbar.getHamburgImage())
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

        toolbar.InitToolbar(this, getString(R.string.services));
        headerText = toolbar.getHeaderTextView();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
