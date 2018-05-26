package com.example.lenovo.SpaApp.coveredLocationsFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.Adapters.CoveredLocationAdapter;
import com.example.lenovo.SpaApp.ContactusMVC.ContactFragment;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.Models.SelectCityModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;

import org.json.JSONObject;

import java.util.ArrayList;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshuPC on 5/26/2018.
 */

public class ConveredLocationFragment extends GlobalFragment {

    @InjectView(R.id.coveredLocationRV)
    RecyclerView coveredLocationRV;
    private ArrayList<SelectCityModel> selectCityModels;
    private CoveredLocationAdapter coveredLocationAdapter;

    public static ConveredLocationFragment getInstance(String Name) {
        ConveredLocationFragment converedLocationFragment = new ConveredLocationFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        converedLocationFragment.setArguments(bundle);
        return converedLocationFragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.covered_location_fragment, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HomeActivity.headerText.setText(getArguments().getString("name"));

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
        coveredLocationRV.setLayoutManager(new LinearLayoutManager(getContext()));
        CallWebService.getInstance(getActivity(), false).hitWithJSONObjectVolleyWebService(CallWebService.GET, Constants.WebServices.GET_CITY, null, this);
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) {
        try {
            selectCityModels = ParsingResponse.getInstance().parseJsonArrayWithJsonObject(object.getJSONArray(Constants.DATA), SelectCityModel.class);
            coveredLocationAdapter = new CoveredLocationAdapter(getActivity(), this, selectCityModels);
            coveredLocationRV.setAdapter(coveredLocationAdapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
