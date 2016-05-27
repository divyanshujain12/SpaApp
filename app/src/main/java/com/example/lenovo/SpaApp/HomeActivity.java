package com.example.lenovo.SpaApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.SpaApp.Adapters.MenuFragmentAdapter;
import com.example.lenovo.SpaApp.Fragments.AppointmentsFragment;
import com.example.lenovo.SpaApp.Fragments.BuyServicesFragment;
import com.example.lenovo.SpaApp.Fragments.ContactFragment;
import com.example.lenovo.SpaApp.Fragments.NotificationsFragment;
import com.example.lenovo.SpaApp.Fragments.ServiceCategoriesFragment;
import com.example.lenovo.SpaApp.Fragments.SettingFragment;
import com.example.lenovo.SpaApp.Fragments.TransitionLoopFragment;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.neopixl.pixlui.components.textview.TextView;
import com.yalantis.guillotine.animation.GuillotineAnimation;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Lenovo on 01-03-2016.
 */
public class HomeActivity extends AppCompatActivity {

    public Toolbar toolbar;
    public static TextView headerText;
    private RecyclerView menuRV;
    private MenuFragmentAdapter menuFragmentAdapter;
    private FragmentManager fragmentManager;
    private ServiceCategoriesFragment homeFragment;
    // private ShimmerFrameLayout shimmerFrameLayout;
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
        menuRV.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        updateFragment(AppointmentsFragment.getInstance("APPOINTMENTS"));
                        break;
                    case 1:
                        updateFragment(BuyServicesFragment.getInstance("BUY SERVICES"));
                        break;
                    case 2:
                        updateFragment(new TransitionLoopFragment());
                        break;
                    case 3:
                        updateFragment(ContactFragment.getInstance("CONTACTS"));
                        break;
                    case 4:
                        updateFragment(NotificationsFragment.getInstance("NOTIFICATIONS"));
                        break;
                    case 5:
                        updateFragment(SettingFragment.getInstance("SETTINGS"));
                        break;
                    case 6:
                        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 7:
                        Intent intent1 = new Intent(HomeActivity.this, HowToWork.class);
                        startActivity(intent1);
                        finish();
                        break;
                }
                guillotineAnimation.close();
            }
        }));
        //shimmerFrameLayout = (ShimmerFrameLayout) guillotineMenu.findViewById(R.id.shimmerlayout);
        //shimmerFrameLayout.startShimmerAnimation();
        homeFragment = ServiceCategoriesFragment.getInstance("SERVICES");
        updateFragment(new TransitionLoopFragment());

    }

    protected void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        headerText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

    }

    public void updateFragment(Fragment fragment) {
        String name = fragment.getClass().getName();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        boolean isPopped = fragmentManager.popBackStackImmediate(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        if (fragment != null && !isPopped) {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            if (!(fragment instanceof TransitionLoopFragment))
                fragmentTransaction.addToBackStack(name);
            fragmentTransaction.commit();
        }

    }

    public void onCardClick(View view) {
        homeFragment.onCardClick(view);
    }
}
