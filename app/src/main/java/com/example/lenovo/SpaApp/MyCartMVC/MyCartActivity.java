package com.example.lenovo.SpaApp.MyCartMVC;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.SpaApp.Adapters.MyCartAdapter;
import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingModel;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AddEventAndReminder;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import io.realm.Realm;

/**
 * Created by divyanshu.jain on 6/1/2016.
 */
public class MyCartActivity extends GlobalActivity {

    @InjectView(R.id.myCartRV)
    protected RecyclerView myCartRV;
    @InjectView(R.id.customToolbar)
    protected ToolbarWithBackButton customToolbar;
    protected MyCartAdapter myCartAdapter;
    protected ArrayList<AppointmentBookingModel> myCartModels = new ArrayList<>();
    protected Realm realm;
    @InjectView(R.id.contentRL)
    RelativeLayout contentRL;
    @InjectView(R.id.noItemLL)
    LinearLayout noItemLL;
    @InjectView(R.id.confirmTV)
    TextView confirmTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.my_cart_activity);
        ButterKnife.inject(this);

        InitViews();
    }

    private void InitViews() {
        customToolbar.InitToolbar(this, getString(R.string.my_cart));
        customToolbar.hideCartView(true);
        myCartRV.setLayoutManager(new LinearLayoutManager(this));
        realm = Realm.getDefaultInstance();
        myCartModels.addAll(realm.allObjects(AppointmentBookingModel.class));
        myCartAdapter = new MyCartAdapter(this, myCartModels, this);
        myCartRV.setAdapter(myCartAdapter);


        if (myCartModels.size() <= 0)
            hideContentLayout(true);
        else
            hideContentLayout(false);

    }

    public void hideContentLayout(boolean b) {
        if (b) {
            noItemLL.setVisibility(b ? View.VISIBLE : View.GONE);
            contentRL.setVisibility(b ? View.GONE : View.VISIBLE);
        }

    }


    @Override
    public void onJsonObjectSuccess(JSONObject object) {
        super.onJsonObjectSuccess(object);

        AlertMessage.showAlertDialogWithCallBack(this, "Congratulation!", "Add To Reminder!", this);

    }

    @Override
    public void doAction() {
        super.doAction();

        for (AppointmentBookingModel appointmentBookingModel : myCartModels) {
            long timeInMS = 0;
            String date = appointmentBookingModel.getDate();
            String address = appointmentBookingModel.getAddress();
            String title = appointmentBookingModel.getName();
            String desc = appointmentBookingModel.getProduct_name();
            String time = appointmentBookingModel.getTime();
            SimpleDateFormat Formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm aa", Locale.ENGLISH);
            Formatter.setTimeZone(TimeZone.getDefault());

            try {
                time = "3:42 PM";
                date = "2016-06-10" + " " + time;
             /*   Date timeD = Formatter.parse(time.toUpperCase());
                Formatter = new SimpleDateFormat("", Locale.ENGLISH);*/
                Date dateD = Formatter.parse(date);
                //  timeInMS = CombineDateAnTime(dateD, timeD);
                timeInMS = dateD.getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }


            AddEventAndReminder.getInstance(this).addEventsToCalender(title, desc, address, timeInMS);

        }
        myCartModels.clear();
        myCartAdapter.notifyDataSetChanged();
        hideContentLayout(true);

    }

    private long CombineDateAnTime(Date date, Date time) {
        /*Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int yearInt = cal.get(Calendar.YEAR);
        int monthInt = cal.get(Calendar.MONTH);
        int dayInt = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(time);
        int hoursInt = cal.get(Calendar.HOUR);
        int minutesInt = cal.get(Calendar.MINUTE);*/

        long sum = date.getTime() + time.getTime();

        Date combinedDate = new Date(sum);
        /*cal.setTime(combinedDate);*/
        return combinedDate.getTime();
    }
}
