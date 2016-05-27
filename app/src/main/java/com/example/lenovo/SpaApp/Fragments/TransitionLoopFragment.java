package com.example.lenovo.SpaApp.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.example.lenovo.SpaApp.Adapters.ServiceCategoryAdapter;
import com.example.lenovo.SpaApp.HomeActivity;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import io.codetail.animation.arcanimator.ArcAnimator;
import io.codetail.animation.arcanimator.Side;
import tyrantgit.explosionfield.Utils;


public class TransitionLoopFragment extends Fragment implements View.OnClickListener {

    View mParent;
    FrameLayout mBluePair;
    float startBlueX;
    float startBlueY;
    RecyclerView recyclerview, servicesRV;
    int endBlueX;
    int endBlueY;
    View clickedView = null;
    private LinearLayout sheetsView;
    @InjectView(R.id.txtCancel)
    TextView txtCancel;
    final static AccelerateInterpolator ACCELERATE = new AccelerateInterpolator();
    final static DecelerateInterpolator DECELERATE = new DecelerateInterpolator();

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
        txtCancel.setOnClickListener(this);
        servicesRV = (RecyclerView) view.findViewById(R.id.servicesRV);
        servicesRV.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        servicesRV.setAdapter(new HomeServiceCategoryAdapter(getActivity()));
        sheetsView = (LinearLayout) view.findViewById(R.id.sheetsView);
        mParent = view;
        mBluePair = (FrameLayout) view.findViewById(R.id.transition_blue_pair);


        servicesRV.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                OnServiceClick(view);
            }
        }));

        recyclerview.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                disappearBluePair();

            }
        }));
    }


    void appearBluePair() {
        mBluePair.setVisibility(View.VISIBLE);

        float finalRadius = Math.max(mBluePair.getWidth(), mBluePair.getHeight()) * 1.5f;

        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(mBluePair, endBlueX, endBlueY, clickedView.getWidth() / 2f,
                finalRadius);
        animator.setDuration(500);
        animator.setInterpolator(ACCELERATE);
        animator.addListener(new SimpleListener() {
            @Override
            public void onAnimationEnd() {

            }
        });
        animator.start();
    }

    void disappearBluePair() {
        float finalRadius = Math.max(mBluePair.getWidth(), mBluePair.getHeight()) * 1.5f;

        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(mBluePair, endBlueX, endBlueY,
                finalRadius, clickedView.getWidth() / 2f);
        animator.setDuration(500);
        animator.addListener(new SimpleListener() {
            @Override
            public void onAnimationEnd() {
                sheetsView.setVisibility(View.VISIBLE);
                mBluePair.setVisibility(View.INVISIBLE);
                returnBlue();
            }
        });
        animator.setInterpolator(DECELERATE);
        animator.start();
    }

    void returnBlue() {
        clickedView.setVisibility(View.VISIBLE);
        ArcAnimator arcAnimator = ArcAnimator.createArcAnimator(clickedView, startBlueX,
                startBlueY, 90, Side.LEFT)
                .setDuration(500);
        arcAnimator.addListener(new SimpleListener() {
            @Override
            public void onAnimationEnd() {
                sheetsView.setVisibility(View.VISIBLE);
            }
        });
        arcAnimator.start();

    }

    @Override
    public void onClick(View v) {
        disappearBluePair();
    }

    private static class SimpleListener implements SupportAnimator.AnimatorListener, ObjectAnimator.AnimatorListener {

        @Override
        public void onAnimationStart() {

        }

        @Override
        public void onAnimationEnd() {

        }

        @Override
        public void onAnimationCancel() {

        }

        @Override
        public void onAnimationRepeat() {

        }

        @Override
        public void onAnimationStart(Animator animation) {

        }

        @Override
        public void onAnimationEnd(Animator animation) {

        }

        @Override
        public void onAnimationCancel(Animator animation) {

        }

        @Override
        public void onAnimationRepeat(Animator animation) {

        }
    }

    private void OnServiceClick(View view) {
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerview.setAdapter(new ServiceCategoryAdapter(getActivity()));
        clickedView = view;
        startBlueX = CommonFunctions.centerX(clickedView);
        startBlueY = CommonFunctions.centerY(clickedView);

        endBlueX = mParent.getRight() / 2;
        endBlueY = (int) (mParent.getBottom() * 0.95f);
        ArcAnimator arcAnimator = ArcAnimator.createArcAnimator(clickedView, endBlueX,
                endBlueY, 90, Side.LEFT)
                .setDuration(500);
        arcAnimator.addListener(new SimpleListener() {
            @Override
            public void onAnimationEnd(Animator animation) {
                sheetsView.setVisibility(View.INVISIBLE);
                clickedView.setVisibility(View.INVISIBLE);
                appearBluePair();
            }
        });
        arcAnimator.start();
    }
}
