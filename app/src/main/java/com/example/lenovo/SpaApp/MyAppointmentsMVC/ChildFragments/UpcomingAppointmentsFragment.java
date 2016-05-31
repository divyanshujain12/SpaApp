package com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.Adapters.AppointmentAdapters.UpcomingAdapter;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Model.AppointmentsModel;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.MyAppointmentsFragment;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu.jain on 5/31/2016.
 */
public class UpcomingAppointmentsFragment extends GlobalFragment {

    @InjectView(R.id.myUpcomingAppointmentsRV)
   protected RecyclerView myUpcomingAppointmentsRV;
    protected UpcomingAdapter upcomingAdapter;
    protected ArrayList<AppointmentsModel> appointmentsModels;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.upcoming_appointments_fragments, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myUpcomingAppointmentsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        appointmentsModels = new ArrayList<>();
        upcomingAdapter = new UpcomingAdapter(getActivity(),appointmentsModels);
        try {
            onJsonObjectSuccess(new JSONObject(MyAppointmentsFragment.dummyJSON));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) {
        try {
            JSONArray data = object.getJSONArray(Constants.DATA);
            appointmentsModels = ParsingResponse.getInstance().parseJsonArrayWithJsonObject(data,AppointmentsModel.class);
            upcomingAdapter = new UpcomingAdapter(getActivity(),appointmentsModels);
            myUpcomingAppointmentsRV.setAdapter(upcomingAdapter);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

    }
}
