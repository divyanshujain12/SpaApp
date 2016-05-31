package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.view.View;
import android.widget.Toast;

import com.example.lenovo.SpaApp.R;
import com.imanoweb.calendarview.CalendarListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.OnClick;

/**
 * Created by divyanshu on 5/29/2016.
 */
public class AppointmentBookingController extends AppointmentBookingActivity {


    public void onStart() {
        super.onStart();
        calendarView.setCalendarListener(new CalendarListener() {
            @Override
            public void onDateSelected(Date date) {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Toast.makeText(AppointmentBookingController.this, df.format(date), Toast.LENGTH_SHORT).show();
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
        return true;
    }
}

