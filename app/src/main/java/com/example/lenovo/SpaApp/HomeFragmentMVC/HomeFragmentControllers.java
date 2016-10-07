package com.example.lenovo.SpaApp.HomeFragmentMVC;

import android.content.Intent;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.lenovo.SpaApp.Adapters.ProductsAdapter;
import com.example.lenovo.SpaApp.AppointmentDescriptionActivity;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivityController;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.SimpleListener;
import com.example.lenovo.SpaApp.Utils.SingeltonClass;
import com.nineoldandroids.animation.Animator;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import io.codetail.animation.arcanimator.ArcAnimator;
import io.codetail.animation.arcanimator.Side;

/**
 * Created by divyanshu on 5/29/2016.
 */
public class HomeFragmentControllers extends HomeFragment implements View.OnClickListener {


    public static HomeFragmentControllers getInstance() {
        HomeFragmentControllers homeFragmentControllers = new HomeFragmentControllers();
        return homeFragmentControllers;
    }

    public void onResume() {
        super.onResume();
        txtCancel.setOnClickListener(this);
    }

    public void onServiceSelected(View view, int pos) {
        recyclerview.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerview.setAdapter(new ProductsAdapter(getActivity(), SingeltonClass.getInstance().getProductsArrayList(pos), this));
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

    public void disappearBluePair() {
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

    private void OnServiceClick(View view, int pos) {

        onServiceSelected(view, pos);
    }

    @Override
    public void onClick(View v) {
        disappearBluePair();
    }

    @Override
    public void onClickItem(int position, View view) {

        View parentView = (View) view.getParent();
        if (parentView == servicesRV)
            OnServiceClick(view, position);

        else if (parentView == recyclerview) {
            disappearBluePair();
            Intent intent = new Intent(getActivity(), AppointmentDescriptionActivity.class);
            intent.putExtra(Constants.POS, position);
            startActivity(intent);
        }

    }
}
