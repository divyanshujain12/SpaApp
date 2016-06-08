package com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.lenovo.SpaApp.Adapters.AppointmentAdapters.CanceledAdapter;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Model.AppointmentsModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu.jain on 6/7/2016.
 */
public class CanceledFragment extends GlobalFragment {
    @InjectView(R.id.myUpcomingAppointmentsRV)
    protected RecyclerView appointmentsRV;
    protected CanceledAdapter canceledAdapter;
    protected ArrayList<AppointmentsModel> appointmentsModels;
    @InjectView(R.id.progressBar)
    ProgressBar progressBar;
    @InjectView(R.id.noItemTV)
    TextView noItemTV;

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
            canceledAdapter = new CanceledAdapter(getActivity(), appointmentsModels);
            appointmentsRV.setAdapter(canceledAdapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onFailure(String str) {
        super.onFailure(str);
        ItemAvailable(false, str);
    }

    private void ItemAvailable(boolean b, String Text) {
        progressBar.setVisibility(View.GONE);
        if (!b) {
            noItemTV.setText(Text);
            appointmentsRV.setVisibility(View.GONE);
            noItemTV.setVisibility(View.VISIBLE);
        }
    }
}
