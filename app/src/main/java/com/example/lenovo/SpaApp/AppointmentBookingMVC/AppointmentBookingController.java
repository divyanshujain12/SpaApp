package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.example.lenovo.SpaApp.Utils.SingeltonClass;
import com.imanoweb.calendarview.CalendarListener;
import com.neopixl.pixlui.components.textview.TextView;

import java.text.SimpleDateFormat;
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
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                dateString = df.format(date);
                Toast.makeText(AppointmentBookingController.this, dateString, Toast.LENGTH_SHORT).show();
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

    private boolean checkFields() {

        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        appointmentBookingModel = realm.createObject(AppointmentBookingModel.class);
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
            return false;
        } else if (!CommonFunctions.isValidNumber(numberString)) {
            numberET.setError(getString(R.string.err_msg_number));
            return false;
        } else if (!CommonFunctions.isValidEmail(emailString)) {
            emailET.setError(getString(R.string.err_msg_email));
            return false;
        } else if (addressString.isEmpty()) {
            addressET.setError(getString(R.string.err_msg_address));
            return false;
        }

        appointmentBookingModel.setCategory_id(SingeltonClass.getInstance().serviceModel.getCategory_id());
        appointmentBookingModel.setProduct_id(SingeltonClass.getInstance().productModel.getId());
        appointmentBookingModel.setCategory_name(SingeltonClass.getInstance().serviceModel.getName());
        appointmentBookingModel.setProduct_name(SingeltonClass.getInstance().productModel.getName());
        appointmentBookingModel.setDuration(SingeltonClass.getInstance().productModel.getDuration());
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

