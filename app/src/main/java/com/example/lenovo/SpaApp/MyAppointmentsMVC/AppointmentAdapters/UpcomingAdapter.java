package com.example.lenovo.SpaApp.MyAppointmentsMVC.AppointmentAdapters;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.SpaApp.Interfaces.CallBackInterface;
import com.example.lenovo.SpaApp.Interfaces.UpdateUiCallback;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.CreateCommonJSON;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.Model.AppointmentsModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AddEventAndReminder;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.example.lenovo.SpaApp.Interfaces.SnackBarCallback;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
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

/**
 * Created by divyanshu.jain on 5/31/2016.
 */
public class UpcomingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener, CallBackInterface {

    private ArrayList<AppointmentsModel> appointmentsModels;
    private Activity activity;
    private LayoutInflater layoutInflater;
    private int id;
    private boolean removeOrder = false;
    private TextView addReminderView = null;
    private UpdateUiCallback updateUiCallback;
    public static final int CALENDER_HELPER_PERMISSION_REQUEST_CODE = 99;

    public UpcomingAdapter(Activity context, ArrayList<AppointmentsModel> appointmentsModels) {
        this.activity = context;
        this.appointmentsModels = appointmentsModels;
        layoutInflater = LayoutInflater.from(context);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = layoutInflater.inflate(R.layout.upcoming_appointments_item, parent, false);
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
        TextView descTV, titleTV, durationTV, amountTV, dateTV, removeTV, addReminderTV;

        public AppointmentsViewHolder(View view) {
            super(view);

            descTV = (TextView) view.findViewById(R.id.descTV);
            titleTV = (TextView) view.findViewById(R.id.titleTV);
            durationTV = (TextView) view.findViewById(R.id.durationTV);
            amountTV = (TextView) view.findViewById(R.id.amountTV);
            dateTV = (TextView) view.findViewById(R.id.dateTV);
            removeTV = (TextView) view.findViewById(R.id.removeTV);
            addReminderTV = (TextView) view.findViewById(R.id.addReminderTV);
        }
    }

    private void bindDefaultFeedItem(int position, AppointmentsViewHolder holder) {

        AppointmentsModel appointmentsModel = appointmentsModels.get(position);
        holder.descTV.setText(appointmentsModel.getDescription());
        holder.titleTV.setText(appointmentsModel.getTitle());
        holder.durationTV.setText(appointmentsModel.getOrder_time());
        holder.amountTV.setText(activity.getResources().getString(R.string.doller_symbol)+appointmentsModel.getPrice());
        holder.dateTV.setText(appointmentsModel.getOrder_date());
        holder.removeTV.setText(activity.getString(R.string.cancel_appointment));
        holder.removeTV.setTag(position);

        holder.removeTV.setOnClickListener(this);
        if (appointmentsModel.getReminder().equals("0")) {
            holder.addReminderTV.setTag(position);
            holder.addReminderTV.setOnClickListener(this);
            changeAddReminderViewState(holder.addReminderTV, View.VISIBLE);
        } else {
            changeAddReminderViewState(holder.addReminderTV, View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        id = (Integer) v.getTag();
        switch (v.getId()) {
            case R.id.removeTV:
                removeOrder = true;
                showRemoveAlert();
                break;
            case R.id.addReminderTV:
                addReminder((TextView) v);
                break;
        }
    }

    private void showRemoveAlert() {
        AlertMessage.showAlertDialogWithCallBack(activity, activity.getString(R.string.alert), activity.getString(R.string.are_you_sure_cancel), new SnackBarCallback() {
            @Override
            public void doAction() {

                CallWebService.getInstance(activity, true).hitWithJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.CANCEL_ORDER, CreateCommonJSON.getInstance().createJsonObjectForCancelOrder(activity, appointmentsModels.get(id).getOrder_id()), UpcomingAdapter.this);
            }
        });
    }

    private void addReminder(TextView v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && (activity).checkSelfPermission(Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            requestCalendarReadWritePermission(activity);
        } else {
            addReminderView = v;
            removeOrder = false;
            CallWebService.getInstance(activity, true).hitWithJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.ORDER_REMINDER, createJsonForAddReminder(), UpcomingAdapter.this);
        }
    }


    private JSONObject createJsonForAddReminder() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(Constants.EMAIL, MySharedPereference.getInstance().getString(activity, Constants.EMAIL));
            jsonObject.put(Constants.ORDER_ID, appointmentsModels.get(id).getOrder_id());
            jsonObject.put(Constants.REMINDER, "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) throws JSONException {
        if (removeOrder) {
            appointmentsModels.remove(id);
            notifyItemRemoved(id);
        } else {
            changeAddReminderViewState(addReminderView, View.GONE);
            startAddingReminder();
        }


    }

    private void changeAddReminderViewState(TextView reminderView, int visibility) {
        reminderView.setVisibility(visibility);
    }

    @Override
    public void onJsonArrarSuccess(JSONArray array) {

    }

    @Override
    public void onFailure(String str) {

    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestCalendarReadWritePermission(Activity caller) {
        List<String> permissionList = new ArrayList<String>();
        if (caller.checkSelfPermission(Manifest.permission.WRITE_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_CALENDAR);
        }
        if (permissionList.size() > 0) {
            String[] permissionArray = new String[permissionList.size()];

            for (int i = 0; i < permissionList.size(); i++) {
                permissionArray[i] = permissionList.get(i);
            }
            caller.requestPermissions(permissionArray,
                    CALENDER_HELPER_PERMISSION_REQUEST_CODE);
        }

    }

    private void startAddingReminder() {
        long timeInMS = 0;
        AppointmentsModel appointmentsModel = appointmentsModels.get(id);
        String date = appointmentsModel.getOrder_date();
        String address = appointmentsModel.getAddress();
        String title = appointmentsModel.getTitle();
        String desc = appointmentsModel.getDescription();
        String time = appointmentsModel.getOrder_time();
        SimpleDateFormat Formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm aa", Locale.ENGLISH);
        Formatter.setTimeZone(TimeZone.getDefault());

        try {
            date = date + " " + time;
            Date dateD = Formatter.parse(date);
            timeInMS = dateD.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        AddEventAndReminder.getInstance(activity).addEventsToCalender(title, desc, address, timeInMS);
    }
}
