package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.view.View;

import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;

import butterknife.OnClick;
import sun.bob.mcalendarview.listeners.OnDateClickListener;
import sun.bob.mcalendarview.listeners.OnMonthChangeListener;
import sun.bob.mcalendarview.vo.DateData;

/**
 * Created by divyanshu on 5/29/2016.
 */
public class AppointmentBookingController extends AppointmentBookingActivity {


    public void onResume() {
        super.onResume();

        calendarExp.setOnDateClickListener(dateClickListener);
        calendarExp.setOnMonthChangeListener(new OnMonthChangeListener() {
            @Override
            public void onMonthChange(int year, int month) {
                mainYYMMTv.setText(String.valueOf(year) + "-" + String.valueOf(month));
            }
        });
    }

    OnDateClickListener dateClickListener = new OnDateClickListener() {
        @Override
        public void onDateClick(View view, DateData date) {

            String clickedDate = date.getDayString() + "/" + date.getMonthString() + "/" + String.valueOf(date.getYear());
            CommonFunctions.showSnackBarWithoutAction(mainExpandIV, clickedDate);

        }
    };

    @OnClick({R.id.calendarLeftIV, R.id.calendarrightIV, R.id.confirmTV})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmTV:

                if (checkFields())
                    submitClickedOK();
                break;
            case R.id.calendarLeftIV:
                if (calendarExp.getCurrentItem() > 0)
                    calendarExp.setCurrentItem(calendarExp.getCurrentItem() - 1);
                break;
            case R.id.calendarrightIV:
                calendarExp.setCurrentItem(calendarExp.getCurrentItem() + 1);
                break;
        }
    }

    private boolean checkFields() {
        return true;
    }
}

