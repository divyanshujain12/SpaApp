package com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lenovo.SpaApp.MyAppointmentsMVC.AppointmentAdapters.UpcomingAdapter;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.CreateCommonJSON;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Model.AppointmentsModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AddEventAndReminder;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu.jain on 5/31/2016.
 */
public class UpcomingAppointmentsFragment extends GlobalFragment {

    @InjectView(R.id.myUpcomingAppointmentsRV)
    protected RecyclerView appointmentsRV;
    protected UpcomingAdapter upcomingAdapter;
    protected ArrayList<AppointmentsModel> appointmentsModels;
    @InjectView(R.id.progressBar)
    ProgressBar progressBar;
    @InjectView(R.id.noItemTV)
    TextView noItemTV;

    private int selectedAddReminderID = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.appointments_fragments, null);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        appointmentsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        appointmentsModels = new ArrayList<>();
        CallWebService.getInstance(getActivity(), false).hitWithJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.MY_SERVICES, CreateCommonJSON.getInstance().createJSONForGetAppointments(getActivity(), "1"), this);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) {
        try {

            ItemAvailable(true, "");
            JSONArray data = object.getJSONArray(Constants.DATA);
            appointmentsModels = ParsingResponse.getInstance().parseJsonArrayWithJsonObject(data, AppointmentsModel.class);
            upcomingAdapter = new UpcomingAdapter(getActivity(), appointmentsModels);
            if (getUserVisibleHint())
                appointmentsRV.setAdapter(upcomingAdapter);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(String str) {
        super.onFailure(str);
        if (isAdded())
            ItemAvailable(false, str);
    }

    private void ItemAvailable(boolean b, String Text) {
        if (progressBar != null)
            progressBar.setVisibility(View.GONE);

        if (!b) {
            noItemTV.setText(Text);
            appointmentsRV.setVisibility(View.GONE);
            noItemTV.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && appointmentsRV != null && upcomingAdapter != null)
            appointmentsRV.setAdapter(upcomingAdapter);
    }
}
