package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.lenovo.SpaApp.Interfaces.CallBackInterface;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;
import com.example.lenovo.SpaApp.Utils.SingeltonClass;
import com.imanoweb.calendarview.CalendarListener;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by divyanshu on 5/29/2016.
 */
public class AppointmentBookingController extends AppointmentBookingActivity {
    View previousView = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        timingGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (previousView != null)
                    previousView.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLACK);
                previousView = view;
                timeString = ((TextView) view).getText().toString();
            }
        });


        calendarView.setCalendarListener(new CalendarListener() {
            @Override
            public void onDateSelected(Date date) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                dateString = df.format(date);
                getAvailableSlots(dateString);
             //   Toast.makeText(AppointmentBookingController.this, dateString, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMonthChanged(Date date) {
                SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
                Toast.makeText(AppointmentBookingController.this, df.format(date), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @OnClick({R.id.confirmTV})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmTV:

                if (checkFields())
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

    private boolean checkFields() {


        categoryNameString = serviceTV.getText().toString();
        nameString = nameET.getText().toString();
        numberString = numberET.getText().toString();
        emailString = emailET.getText().toString();
        addressString = addressET.getText().toString();
        additionalString = additionalET.getText().toString();

        if (categoryNameString.isEmpty())
            return false;
        else if (nameString.isEmpty()) {
            nameET.setError(getString(R.string.err_msg_name));
            nameET.requestFocus();
            return false;
        } else if (!CommonFunctions.isValidNumber(numberString)) {
            numberET.setError(getString(R.string.err_msg_number));
            nameET.requestFocus();
            return false;
        } else if (!CommonFunctions.isValidEmail(emailString)) {
            emailET.setError(getString(R.string.err_msg_email));
            nameET.requestFocus();
            return false;
        } else if (addressString.isEmpty()) {
            addressET.setError(getString(R.string.err_msg_address));
            nameET.requestFocus();
            return false;
        }

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        appointmentBookingModel = realm.createObject(AppointmentBookingModel.class);

        appointmentBookingModel.setCategory_id(SingeltonClass.getInstance().serviceModel.getCategory_id());
        appointmentBookingModel.setCategory_name(SingeltonClass.getInstance().serviceModel.getName());
        appointmentBookingModel.setProduct_name(SingeltonClass.getInstance().productModel.getName());
        appointmentBookingModel.setDuration(SingeltonClass.getInstance().productModel.getDuration());
        appointmentBookingModel.setCity_id(SingeltonClass.getInstance().productModel.getCity_id());
        appointmentBookingModel.setProduct_id(SingeltonClass.getInstance().productModel.getId());
        appointmentBookingModel.setCost(SingeltonClass.getInstance().productModel.getCost());
        appointmentBookingModel.setName(nameString);
        appointmentBookingModel.setNumber(numberString);
        appointmentBookingModel.setEmail_id(emailString);
        appointmentBookingModel.setAddress(addressString);
        appointmentBookingModel.setDate(dateString);
        appointmentBookingModel.setTime(timeString);
        appointmentBookingModel.setAdditional_notes(additionalString);

        realm.commitTransaction();
        RealmResults<AppointmentBookingModel> bookingModels = realm.allObjects(AppointmentBookingModel.class);
        Log.d("tag", bookingModels.toString());

        return true;
    }
}

