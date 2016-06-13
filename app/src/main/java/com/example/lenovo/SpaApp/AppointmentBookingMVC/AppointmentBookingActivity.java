package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import com.example.lenovo.SpaApp.CustomViews.ExpandableHeightGridView;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivityController;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.example.lenovo.SpaApp.Utils.SingeltonClass;
import com.imanoweb.calendarview.CustomCalendarView;
import com.neopixl.pixlui.components.edittext.EditText;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu.jain on 5/27/2016.
 */
class AppointmentBookingActivity extends GlobalActivity {

    @InjectView(R.id.timingGrid)
    protected ExpandableHeightGridView timingGrid;
    @InjectView(R.id.toolbar)
    protected ToolbarWithBackButton toolbar;
    @InjectView(R.id.nameET)
    protected EditText nameET;
    @InjectView(R.id.numberET)
    protected EditText numberET;
    @InjectView(R.id.emailET)
    protected EditText emailET;
    @InjectView(R.id.addressET)
    protected EditText addressET;
    @InjectView(R.id.confirmTV)
    protected TextView confirmTV;
    @InjectView(R.id.serviceTV)
    TextView serviceTV;
    @InjectView(R.id.additionalET)
    EditText additionalET;
    @InjectView(R.id.calendar_view)
    CustomCalendarView calendarView;
    private boolean ifExpand = true;
    protected ArrayList<String> availableTimeSlotsArray = new ArrayList<>();
    protected AppointmentBookingModel appointmentBookingModel = null;
    protected ArrayAdapter<CharSequence> arrayAdapter;
    protected String categoryNameString, nameString, numberString, emailString, addressString, dateString, timeString, additionalString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.appointment_booking);
        ButterKnife.inject(this);


        InitViews();
    }

    private void InitViews() {

        serviceTV.setText(SingeltonClass.getInstance().serviceModel.getName());

        toolbar.InitToolbar(this, getString(R.string.booking));

        timingGrid.setExpanded(true);

        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        calendarView.setShowOverflowDate(false);

        calendarView.refreshCalendar(currentCalendar);

        calendarView.setCustomTypeface(Typeface.createFromAsset(getAssets(), "fonts/Titillium-Regular.otf"));

    }


    protected void submitClickedOK() {
        toolbar.setProductCount();
        CommonFunctions.showSnackBarWithoutAction(timingGrid, getString(R.string.successfully_added));
        Intent intent = new Intent(this, HomeActivityController.class);
        startActivity(intent);
        finish();
    }

    public void onResume() {
        super.onResume();
        toolbar.setProductCount();

    }

    protected HashMap<String, String> createMapForGetAvailableTimeSlots(String date) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Constants.EMAIL, MySharedPereference.getInstance().getString(this, Constants.EMAIL));
        hashMap.put(Constants.CITY_ID, SingeltonClass.getInstance().serviceModel.getCity_id());
        hashMap.put(Constants.CATEGORY_ID, SingeltonClass.getInstance().serviceModel.getCategory_id());
        hashMap.put(Constants.ID, SingeltonClass.getInstance().productModel.getId());
        hashMap.put(Constants.DATE, date);
        return hashMap;

    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) {
        super.onJsonObjectSuccess(object);
    }
}
