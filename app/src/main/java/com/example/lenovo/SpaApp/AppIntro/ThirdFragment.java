package com.example.lenovo.SpaApp.AppIntro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.Adapters.SelectCityAdapter;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivityController;
import com.example.lenovo.SpaApp.Interfaces.RecyclerViewClick;
import com.example.lenovo.SpaApp.MainActivity;
import com.example.lenovo.SpaApp.Models.SelectCityModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu on 8/4/2016.
 */
public class ThirdFragment extends GlobalFragment implements RecyclerViewClick {

    @InjectView(R.id.cityRV)
    RecyclerView cityRV;
    ArrayList<SelectCityModel> selectCityModels;
    SelectCityAdapter selectCityAdapter;
    @InjectView(R.id.txtSubmit)
    TextView txtSubmit;
    private CardView card;
    private String selectedCityID = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.select_city_activity, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        InitViews();
    }

    private void InitViews() {
        selectCityModels = new ArrayList<>();
        cityRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        txtSubmit.setVisibility(View.GONE);
        CallWebService.getInstance(getActivity(), false).hitWithJSONObjectVolleyWebService(CallWebService.GET, Constants.WebServices.GET_CITY, null, this);
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) {
        try {
            selectCityModels = ParsingResponse.getInstance().parseJsonArrayWithJsonObject(object.getJSONArray(Constants.DATA), SelectCityModel.class);
            selectCityAdapter = new SelectCityAdapter(getActivity(), this, selectCityModels);
            cityRV.setAdapter(selectCityAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClickItem(int position, View view) {
        if (card != null)
            card.setCardBackgroundColor(getResources().getColor(R.color.background_medium_with_alpha));
        card = (CardView) view;
        card.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));

        selectedCityID = selectCityModels.get(position).getCity_id();

        if (selectedCityID.length() > 0) {
            MySharedPereference.getInstance().setString(getActivity(), Constants.CITY_ID, selectedCityID);
            int pos = getActivity().getIntent().getIntExtra("pos", -1);
            Intent i = new Intent(getActivity(), HomeActivityController.class);
            if (pos > -1) {
                i = new Intent(getActivity(), MainActivity.class);
                i.putExtra("pos", pos);
            }
            startActivity(i);
            getActivity().finish();
        } else {
            CommonFunctions.showSnackBarWithoutAction(cityRV, getString(R.string.select_city_alert));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}

