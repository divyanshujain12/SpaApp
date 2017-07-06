package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.lenovo.SpaApp.CustomViews.ExpandableHeightGridView;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivityController;
import com.example.lenovo.SpaApp.Interfaces.SnackBarCallback;
import com.example.lenovo.SpaApp.Models.ProductModel;
import com.example.lenovo.SpaApp.Models.ServiceModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.imanoweb.calendarview.CustomCalendarView;
import com.neopixl.pixlui.components.checkbox.CheckBox;
import com.neopixl.pixlui.components.edittext.EditText;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemSelected;

/**
 * Created by divyanshu.jain on 5/27/2016.
 */
class AppointmentBookingActivity extends GlobalActivity implements AdapterView.OnItemSelectedListener {

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
    @InjectView(R.id.availableDurationSP)
    Spinner availableDurationSP;
    @InjectView(R.id.quantitySP)
    Spinner quantitySP;
    @InjectView(R.id.therapistGenderSP)
    Spinner therapistGenderSP;
    @InjectView(R.id.massageTableSP)
    Spinner massageTableSP;
    @InjectView(R.id.bookingMassageLL)
    LinearLayout bookingMassageLL;
    @InjectView(R.id.timeFlexibleCB)
    CheckBox timeFlexibleCB;
    @InjectView(R.id.durationTV)
    TextView durationTV;
    @InjectView(R.id.priceTV)
    TextView priceTV;
    private boolean ifExpand = true;
    protected String[] availableDurations = null;
    protected AppointmentBookingModel appointmentBookingModel = null;
    protected ArrayAdapter<CharSequence> arrayAdapter;
    protected String categoryNameString, nameString, numberString, emailString, addressString, dateString, timeString, additionalString;
    String selectedDuration = "", selectedQuantity = "1";
    protected ServiceModel serviceModel;
    protected ProductModel productModel;
    protected String[] therapistArray;
    String therapistType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        setContentView(R.layout.appointment_booking);
        ButterKnife.inject(this);

        /*if (SingeltonClass.getInstance().serviceModel == null) {
            goToHome();
            return;
        }*/
        InitViews();
    }

    private void InitViews() {
        serviceModel = getIntent().getParcelableExtra(Constants.DATA);
        int pos = getIntent().getIntExtra(Constants.POS, 0);
        productModel = serviceModel.getProducts().get(pos);
        serviceTV.setText(serviceModel.getName());

        toolbar.InitToolbar(this, getString(R.string.booking));

        durationTV.setText(productModel.getDuration());

        priceTV.setText(getString(R.string.doller_symbol) + productModel.getCost());

        nameET.setText(MySharedPereference.getInstance().getString(this, Constants.NAME));

        numberET.setText(MySharedPereference.getInstance().getString(this, Constants.PHONE_NUMBER));

        emailET.setText(MySharedPereference.getInstance().getString(this, Constants.EMAIL));

        addressET.setText(MySharedPereference.getInstance().getString(this, Constants.ADDRESS));

        timingGrid.setExpanded(true);

        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        calendarView.setShowOverflowDate(false);

        calendarView.refreshCalendar(currentCalendar);

        calendarView.setCustomTypeface(Typeface.createFromAsset(getAssets(), "fonts/Titillium-Regular.otf"));

        availableDurations = productModel.getDuration().trim().split(",");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, R.layout.single_textview, getResources().getStringArray(R.array.service_booking_quantities));
        spinnerAdapter.setDropDownViewResource(R.layout.single_dropdown_textview);
        quantitySP.setAdapter(spinnerAdapter);

        spinnerAdapter = new ArrayAdapter<>(this, R.layout.single_textview, availableDurations);
        selectedDuration = availableDurations[0];
        spinnerAdapter.setDropDownViewResource(R.layout.single_dropdown_textview);
        availableDurationSP.setAdapter(spinnerAdapter);
        String catID = serviceModel.getCategory_id();
        if (catID.equals(Constants.MASSAGE_CATEGORY_ONE) || catID.equals(Constants.MASSAGE_CATEGORY_TWO))
            initDataForMassageCategory();
        else
            bookingMassageLL.setVisibility(View.GONE);

    }

    private void initDataForMassageCategory() {

        ArrayAdapter<String> spinnerAdapter;
        therapistGenderSP.setOnItemSelectedListener(this);
        therapistArray = getResources().getStringArray(R.array.therapist_gender_array);
        spinnerAdapter = new ArrayAdapter<>(this, R.layout.single_textview, therapistArray);
        //spinnerAdapter.setDropDownViewResource(R.layout.single_dropdown_textview);
        therapistGenderSP.setAdapter(spinnerAdapter);
    }

    protected void submitClickedOK() {
        toolbar.setProductCount();

        AlertMessage.showAlertDialogWithOkCallBack(this, getString(R.string.alert), getString(R.string.successfully_added), new SnackBarCallback() {
            @Override
            public void doAction() {
                goToHome();
            }
        });

    }

    public void onResume() {
        super.onResume();
        toolbar.setProductCount();

    }

    protected HashMap<String, String> createMapForGetAvailableTimeSlots(String date) {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Constants.EMAIL, MySharedPereference.getInstance().getString(this, Constants.EMAIL));
        hashMap.put(Constants.CITY_ID, serviceModel.getCity_id());
        hashMap.put(Constants.CATEGORY_ID, serviceModel.getCategory_id());
        hashMap.put(Constants.ID, productModel.getId());
        hashMap.put(Constants.DATE, date);
        return hashMap;

    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) {
        super.onJsonObjectSuccess(object);
    }


    private void goToHome() {
        Intent intent = new Intent(this, HomeActivityController.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        therapistType = therapistArray[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
