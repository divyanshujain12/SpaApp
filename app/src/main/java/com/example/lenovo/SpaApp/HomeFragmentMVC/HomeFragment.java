package com.example.lenovo.SpaApp.HomeFragmentMVC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.SpaApp.Adapters.HomeServiceCategoryAdapter;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.R;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeFragment extends GlobalFragment {

    protected View mParent;
    protected FrameLayout mBluePair;
    protected float startBlueX;
    protected float startBlueY;
    protected RecyclerView recyclerview;
    protected RecyclerView servicesRV;
    protected int endBlueX;
    protected int endBlueY;
    protected View clickedView = null;
    protected LinearLayout sheetsView;
    @InjectView(R.id.txtCancel)
    protected
    TextView txtCancel;
    protected final static AccelerateInterpolator ACCELERATE = new AccelerateInterpolator();
    protected final static DecelerateInterpolator DECELERATE = new DecelerateInterpolator();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transitionloop, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ButterKnife.inject(this, getView());

        HomeActivity.headerText.setText("SERVICES");

        servicesRV = (RecyclerView) view.findViewById(R.id.servicesRV);
        servicesRV.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        servicesRV.setAdapter(new HomeServiceCategoryAdapter(getActivity()));

        sheetsView = (LinearLayout) view.findViewById(R.id.sheetsView);
        mParent = view;
        mBluePair = (FrameLayout) view.findViewById(R.id.transition_blue_pair);


    }
}
