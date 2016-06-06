package com.example.lenovo.SpaApp.Adapters.AppointmentAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lenovo.SpaApp.MyAppointmentsMVC.Model.AppointmentsModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.example.lenovo.SpaApp.Interfaces.SnackBarCallback;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;

/**
 * Created by divyanshu.jain on 5/31/2016.
 */
public class HistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private ArrayList<AppointmentsModel> appointmentsModels;
    private Context context;
    private LayoutInflater layoutInflater;

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

    private void bindDefaultFeedItem(int position, AppointmentsViewHolder holder) {
        AppointmentsModel appointmentsModel = appointmentsModels.get(position);
        holder.serviceNameTV.setText(appointmentsModel.getService_name());
        holder.subServiceNameTV.setText(appointmentsModel.getSub_service_name());
        holder.durationTV.setText(appointmentsModel.getDuration());
        holder.amountTV.setText(appointmentsModel.getCost());
        holder.dateTV.setText(appointmentsModel.getDate());
        holder.removeTV.setId(position);
        holder.removeTV.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return appointmentsModels.size();
    }


    public static class AppointmentsViewHolder extends RecyclerView.ViewHolder {
        TextView serviceNameTV, subServiceNameTV, durationTV, amountTV, dateTV, removeTV;

        public AppointmentsViewHolder(View view) {
            super(view);

            serviceNameTV = (TextView) view.findViewById(R.id.serviceNameTV);
            subServiceNameTV = (TextView) view.findViewById(R.id.subServiceNameTV);
            durationTV = (TextView) view.findViewById(R.id.durationTV);
            amountTV = (TextView) view.findViewById(R.id.amountTV);
            dateTV = (TextView) view.findViewById(R.id.dateTV);
            removeTV = (TextView) view.findViewById(R.id.removeTV);
        }
    }

    @Override
    public void onClick(View v) {
        AlertMessage.showAlertDialogWithCallBack(context, context.getString(R.string.alert), context.getString(R.string.are_you_sure_cancel), new SnackBarCallback() {
            @Override
            public void doAction() {
                Toast.makeText(context, "Ok Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

