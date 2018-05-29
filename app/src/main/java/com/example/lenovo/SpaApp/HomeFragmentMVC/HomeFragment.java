package com.example.lenovo.SpaApp.HomeFragmentMVC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.lenovo.SpaApp.Models.ServiceModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeFragment extends GlobalFragment {

    protected View mParent;
    protected FrameLayout mBluePair;
    protected float startBlueX;
    protected float startBlueY;
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
    public ArrayList<ServiceModel> serviceModelArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transitionloop, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ButterKnife.inject(this, getView());
        if (savedInstanceState == null) {
            initView(view);
        }
    }

    private void initView(View view) {
        CallWebService.getInstance(getActivity(), true).hitJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.GET_CATEGORY, createJsonForGetCategories(), this);
        HomeActivity.headerText.setText("SERVICES");
        servicesRV = (RecyclerView) view.findViewById(R.id.servicesRV);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        servicesRV.setHasFixedSize(true);
        servicesRV.setLayoutManager(gridLayoutManager
        );
        sheetsView = (LinearLayout) view.findViewById(R.id.sheetsView);
        mParent = view;
        mBluePair = (FrameLayout) view.findViewById(R.id.transition_blue_pair);
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) throws JSONException {
        super.onJsonObjectSuccess(object);
        serviceModelArrayList = (ParsingResponse.getInstance().parseJsonArrayWithJsonObject(object.getJSONArray(Constants.DATA), ServiceModel.class));
        servicesRV.setAdapter(new HomeServiceCategoryAdapter(getActivity(), this, serviceModelArrayList));
    }

    @Override
    public void onFailure(String str) {
        super.onFailure(str);
    }

    private HashMap createJsonForGetCategories() {
        HashMap<String, String> jsonObject = new HashMap<>();
        try {
            jsonObject.put(Constants.CITY_ID, MySharedPereference.getInstance().getString(getContext(), Constants.CITY_ID));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
