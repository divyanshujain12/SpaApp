package com.example.lenovo.SpaApp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.SpaApp.Adapters.ServiceCategoryAdapter;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.FlipAnimation;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;

/**
 * Created by Lenovo on 23-03-2016.
 */
public class ServiceCategoriesFragment extends Fragment {
    private LinearLayout containerLL;
    private RecyclerView recyclerview;
    private Context instance;
    private int[] resorceArray = {R.drawable.spa1, R.drawable.spa3, R.drawable.spa3, R.drawable.spa4, R.drawable.spa1, R.drawable.spa2};
    private CommonFunctions commonFunctions;

    public static ServiceCategoriesFragment getInstance(String headerText) {
        ServiceCategoriesFragment contentFragment = new ServiceCategoriesFragment();
        Bundle bundle = new Bundle();
        bundle.putString("headerText", headerText);
        contentFragment.setArguments(bundle);
        return contentFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViews();
    }

    private void InitViews() {
        HomeActivity.headerText.setText(getArguments().getString("headerText"));

        instance = getActivity();
        commonFunctions = new CommonFunctions(instance);
        containerLL = (LinearLayout) getView().findViewById(R.id.containerLL);
        addChildInContainer();
    }

    private void addChildInContainer() {
        LayoutInflater layoutInflater;
        for (int i = 0; i < 6; i++) {
            layoutInflater = LayoutInflater.from(instance);
            View view = layoutInflater.inflate(R.layout.services_item, null);
            containerLL.addView(view);

            ImageView serviceImage = (ImageView) view.findViewById(R.id.serviceImage);
              serviceImage.setImageResource(resorceArray[i]);

         //   commonFunctions.StartAsyncTaskInParallel(new CreateBlurredImage(instance, serviceImage, resorceArray[i]));
            recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
            recyclerview.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
            recyclerview.setAdapter(new ServiceCategoryAdapter(instance));
            recyclerview.addOnItemTouchListener(new RecyclerItemClickListener(instance, new RecyclerItemClickListener.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    View parentView = (View) view.getParent().getParent();
                    flipCard(parentView);
                }
            }));

        }
    }

    public void onCardClick(View view) {
        flipCard(view);
    }

    private void flipCard(View view) {

        final View rootLayout = (View) view.getParent();
        final View cardFace = rootLayout.findViewById(R.id.main_activity_card_face);
        final View cardBack = rootLayout.findViewById(R.id.main_activity_card_back);
        final FlipAnimation flipAnimation = new FlipAnimation(cardFace, cardBack);

        if (cardFace.getVisibility() == View.GONE) {
            flipAnimation.reverse();
        }
        rootLayout.startAnimation(flipAnimation);
    }


}
