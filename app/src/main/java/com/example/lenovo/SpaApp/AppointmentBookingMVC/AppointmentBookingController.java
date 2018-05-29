package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.lenovo.SpaApp.Interfaces.CallBackInterface;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;
import com.github.badoualy.datepicker.DatePickerTimeline;
import com.imanoweb.calendarview.CalendarListener;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by divyanshu on 5/29/2016.
 */
public class AppointmentBookingController extends AppointmentBookingActivity implements AdapterView.OnItemSelectedListener {
    View previousView = null;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        timingGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                timeString = ((TextView) view).getText().toString();

                checkDate(view);
            }
        });

        quantitySP.setOnItemSelectedListener(this);
        availableDurationSP.setOnItemSelectedListener(this);

        calendarVW.setOnDateSelectedListener(new DatePickerTimeline.OnDateSelectedListener() {
            @Override
            public void onDateSelected(int year, int month, int day, int index) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                Date date = calendar.getTime();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                dateString = df.format(date);

                getAvailableSlots(dateString);

            }
        });

//        calendarView.setCalendarListener(new CalendarListener() {
//            @Override
//            public void onDateSelected(Date date) {
//                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//                dateString = df.format(date);
//
//                getAvailableSlots(dateString);
//                //   Toast.makeText(AppointmentBookingController.this, dateString, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onMonthChanged(Date date) {
//                SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
//                //   Toast.makeText(AppointmentBookingController.this, df.format(date), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void checkDate(View view) {
        if (isDateOK()) {
            if (previousView != null)
                previousView.setBackgroundColor(Color.TRANSPARENT);

            view.setBackgroundColor(getResources().getColor(R.color.background_bottom_color));
            previousView = view;

        } else {
            CommonFunctions.showSnackBarWithoutAction(timingGrid, getString(R.string.invalid_date));
            timeString = "";
        }
    }

    private boolean isDateOK() {
        SimpleDateFormat Formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm aa", Locale.ENGLISH);
        Formatter.setTimeZone(TimeZone.getDefault());

        String tempDateString = dateString + " " + timeString;
        Date dateD = null;
        try {
            dateD = Formatter.parse(tempDateString);
            double selectedTimeInMS = dateD.getTime();
            double currentTimeInMS = new Date().getTime();

            if (currentTimeInMS < selectedTimeInMS)
                return true;
            else
                return false;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    @OnClick({R.id.confirmTV})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmTV:

                if (checkAndSaveFields())
                    submitClickedOK();
                break;
        }
    }

    private void getAvailableSlots(String date) {
        CallWebService.getInstance(this, true).hitJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.AVAILABLE_SLOTS, createMapForGetAvailableTimeSlots(date), new CallBackInterface() {
            @Override
            public void onJsonObjectSuccess(JSONObject object) throws JSONException {
                ArrayList<CharSequence> slots = new ArrayList<CharSequence>();

                slots = ParsingResponse.getInstance().parseJsonArrayWithJsonObject(object.getJSONArray(Constants.DATA), String.class);
                arrayAdapter = new ArrayAdapter<CharSequence>(AppointmentBookingController.this, R.layout.single_textview, slots);
                timingGrid.setAdapter(arrayAdapter);
            }

            @Override
            public void onJsonArrarSuccess(JSONArray array) {

            }

            @Override
            public void onFailure(String str) {

            }
        });
    }

    private boolean checkAndSaveFields() {


        categoryNameString = serviceTV.getText().toString();
        nameString = nameET.getText().toString();
        numberString = numberET.getText().toString();
        emailString = emailET.getText().toString();
        addressString = addressET.getText().toString();
        additionalString = additionalET.getText().toString();
        zipCodeString = zipCodeET.getText().toString();
        if (checkFields()) return false;

        saveDataIntoDatabase();

        return true;
    }

    private boolean checkFields() {
        if (categoryNameString.isEmpty())
            return true;
        else if (nameString.isEmpty()) {
            nameET.setError(getString(R.string.err_msg_name));
            nameET.requestFocus();
            return true;
        } else if (!CommonFunctions.isValidNumber(numberString)) {
            numberET.setError(getString(R.string.err_msg_number));
            numberET.requestFocus();
            return true;
        } else if (!CommonFunctions.isValidEmail(emailString)) {
            emailET.setError(getString(R.string.err_msg_email));
            emailET.requestFocus();
            return true;
        } else if (addressString.isEmpty()) {
            addressET.setError(getString(R.string.err_msg_address));
            addressET.requestFocus();
            return true;
        } else if (zipCodeString.isEmpty()) {
            zipCodeET.setError(getString(R.string.zip_validation_error));
            zipCodeET.requestFocus();
            return true;
        } else if (timeString.isEmpty()) {
            CommonFunctions.showSnackBarWithoutAction(timingGrid, getString(R.string.invalid_date));
            return true;
        }
        return false;
    }

    private void saveDataIntoDatabase() {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        appointmentBookingModel = realm.createObject(AppointmentBookingModel.class);

        appointmentBookingModel.setCategory_id(serviceModel.getCategory_id());
        appointmentBookingModel.setCategory_name(serviceModel.getName());
        appointmentBookingModel.setProduct_name(productModel.getName());
        appointmentBookingModel.setDuration(productModel.getDuration());
        appointmentBookingModel.setCity_id(productModel.getCity_id());
        appointmentBookingModel.setProduct_id(productModel.getId());
        appointmentBookingModel.setCost(productModel.getCost());
        appointmentBookingModel.setName(nameString);
        appointmentBookingModel.setNumber(numberString);
        appointmentBookingModel.setEmail_id(emailString);
        appointmentBookingModel.setAddress(addressString);
        appointmentBookingModel.setDate(dateString);
        appointmentBookingModel.setTime(timeString);
        appointmentBookingModel.setAdditional_notes(additionalString);
        appointmentBookingModel.setQuantity(selectedQuantity);
        appointmentBookingModel.setDuration(selectedDuration);
        appointmentBookingModel.setTherapistType(therapistType);
        appointmentBookingModel.setZipCode(zipCodeString);

        realm.commitTransaction();
        RealmResults<AppointmentBookingModel> bookingModels = realm.allObjects(AppointmentBookingModel.class);
        Log.d("tag", bookingModels.toString());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent == quantitySP) {
            selectedQuantity = ((TextView) view).getText().toString();
        } else if (parent == availableDurationSP) {
            selectedDuration = ((TextView) view).getText().toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

