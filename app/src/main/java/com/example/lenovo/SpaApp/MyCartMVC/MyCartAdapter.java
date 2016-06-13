package com.example.lenovo.SpaApp.MyCartMVC;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingModel;
import com.example.lenovo.SpaApp.MyCartMVC.MyCartActivity;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.example.lenovo.SpaApp.Interfaces.SnackBarCallback;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;

import io.realm.Realm;

/**
 * Created by divyanshu.jain on 6/1/2016.
 */
public class MyCartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private ArrayList<AppointmentBookingModel> myCartModels;
    private Context context;
    private LayoutInflater layoutInflater;
    private Realm realm;
    private MyCartActivity instance;

    public MyCartAdapter(Context context, ArrayList<AppointmentBookingModel> myCartModels, MyCartActivity instance) {
        this.context = context;
        this.myCartModels = myCartModels;
        layoutInflater = LayoutInflater.from(context);
        realm = Realm.getDefaultInstance();
        this.instance = instance;
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

        AppointmentBookingModel appointmentsModel = myCartModels.get(position);
        holder.serviceNameTV.setText(appointmentsModel.getCategory_id());
        holder.subServiceNameTV.setText(appointmentsModel.getProduct_name());
        holder.durationTV.setText(appointmentsModel.getTime());
        holder.amountTV.setText(appointmentsModel.getCost());
        holder.dateTV.setText(appointmentsModel.getDate());
        holder.removeTV.setId(position);
        holder.removeTV.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return myCartModels.size();
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
        final int pos = v.getId();
        AlertMessage.showAlertDialogWithCallBack(context, context.getString(R.string.alert), context.getString(R.string.are_you_sure_remove), new SnackBarCallback() {
            @Override
            public void doAction() {
                realm.beginTransaction();
                realm.where(AppointmentBookingModel.class).findAll().remove(pos);
                realm.commitTransaction();
                removeItem(pos);
                Toast.makeText(context, "Ok Clicked!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void removeItem(int pos) {
        myCartModels.remove(pos);
        notifyItemRemoved(pos);
        if (myCartModels.size() == 0)
            instance.hideContentLayout(true);
        else instance.hideContentLayout(false);
    }

}
