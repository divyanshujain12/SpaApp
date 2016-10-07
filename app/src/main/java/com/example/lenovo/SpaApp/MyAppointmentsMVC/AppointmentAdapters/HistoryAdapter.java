package com.example.lenovo.SpaApp.MyAppointmentsMVC.AppointmentAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.Interfaces.CallBackInterface;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.CreateCommonJSON;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Model.AppointmentsModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.example.lenovo.SpaApp.Interfaces.SnackBarCallback;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by divyanshu.jain on 5/31/2016.
 */
public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, CallBackInterface {

    private ArrayList<AppointmentsModel> appointmentsModels;
    private Context context;
    private LayoutInflater layoutInflater;
    private int id;

    public HistoryAdapter(Context context, ArrayList<AppointmentsModel> appointmentsModels) {
        this.context = context;
        this.appointmentsModels = appointmentsModels;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View view = layoutInflater.inflate(R.layout.appointments_recycler_view_items, parent, false);

        return new AppointmentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AppointmentsViewHolder appointmentsViewHolder = (AppointmentsViewHolder) holder;
        bindDefaultFeedItem(position, appointmentsViewHolder);
    }


    @Override
    public int getItemCount() {
        return appointmentsModels.size();
    }


    public static class AppointmentsViewHolder extends RecyclerView.ViewHolder {
        TextView descTV, titleTV, durationTV, amountTV, dateTV, removeTV;

        public AppointmentsViewHolder(View view) {
            super(view);
            descTV = (TextView) view.findViewById(R.id.descTV);
            titleTV = (TextView) view.findViewById(R.id.titleTV);
            durationTV = (TextView) view.findViewById(R.id.durationTV);
            amountTV = (TextView) view.findViewById(R.id.amountTV);
            dateTV = (TextView) view.findViewById(R.id.dateTV);
            removeTV = (TextView) view.findViewById(R.id.removeTV);
        }
    }

    private void bindDefaultFeedItem(int position, AppointmentsViewHolder holder) {
        AppointmentsModel appointmentsModel = appointmentsModels.get(position);
        holder.descTV.setText(appointmentsModel.getDescription());
        holder.titleTV.setText(appointmentsModel.getTitle());
        holder.durationTV.setText(appointmentsModel.getOrder_time());
        holder.amountTV.setText(appointmentsModel.getPrice());
        holder.dateTV.setText(appointmentsModel.getOrder_date());
        holder.removeTV.setId(position);
        holder.removeTV.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        id = v.getId();
        AlertMessage.showAlertDialogWithCallBack(context, context.getString(R.string.alert), context.getString(R.string.are_you_sure_cancel), new SnackBarCallback() {
            @Override
            public void doAction() {

                CallWebService.getInstance(context, true).hitWithJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.CANCEL_ORDER, CreateCommonJSON.getInstance().createJsonObjectForCancelOrder(context, appointmentsModels.get(id).getOrder_id()), HistoryAdapter.this);
            }
        });
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) throws JSONException {
        appointmentsModels.remove(id);
        notifyItemRemoved(id);
    }

    @Override
    public void onJsonArrarSuccess(JSONArray array) {

    }

    @Override
    public void onFailure(String str) {

    }
}

