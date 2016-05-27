package com.example.lenovo.SpaApp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.lenovo.SpaApp.CustomViews.ExpandableHeightGridView;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import sun.bob.mcalendarview.CellConfig;
import sun.bob.mcalendarview.MarkStyle;
import sun.bob.mcalendarview.listeners.OnDateClickListener;
import sun.bob.mcalendarview.listeners.OnExpDateClickListener;
import sun.bob.mcalendarview.listeners.OnMonthScrollListener;
import sun.bob.mcalendarview.views.ExpCalendarView;
import sun.bob.mcalendarview.vo.DateData;

/**
 * Created by divyanshu.jain on 5/27/2016.
 */
public class AppointmentBookingActivity extends AppCompatActivity {

    @InjectView(R.id.main_YYMM_Tv)
    TextView mainYYMMTv;
    @InjectView(R.id.calendar_exp)
    ExpCalendarView calendarExp;
    @InjectView(R.id.main_expandIV)
    ImageView mainExpandIV;
    @InjectView(R.id.timingGrid)
    ExpandableHeightGridView timingGrid;
    private boolean ifExpand = true;
    ArrayList<String> availableTimeSlotsArray = new ArrayList<>();

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
        timingGrid.setExpanded(true);
        CellConfig.Month2WeekPos = CellConfig.middlePosition;
        CellConfig.ifMonth = false;
        calendarExp.shrink();


        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<CharSequence>(this, R.layout.single_textview, getResources().getStringArray(R.array.timing_array));
        timingGrid.setAdapter(arrayAdapter);
        calendarExp.setOnDateClickListener(dateClickListener).setOnDateClickListener(new OnExpDateClickListener()).setOnMonthScrollListener(new OnMonthScrollListener() {
            @Override
            public void onMonthChange(int year, int month) {
                mainYYMMTv.setText(String.format("%d-%d", year, month));
            }

            @Override
            public void onMonthScroll(float positionOffset) {
//                Log.i("listener", "onMonthScroll:" + positionOffset);
            }
        }).setMarkedStyle(MarkStyle.RIGHTSIDEBAR)
                .markDate(2016, 2, 1).markDate(2016, 3, 25)
                .markDate(2016, 2, 4)
                .markDate(new DateData(2016, 3, 1).setMarkStyle(new MarkStyle(MarkStyle.DOT, Color.GREEN)))
                .hasTitle(false);
    }

    private void expandAndCollapseCalendarView() {
        if (ifExpand) {
            CellConfig.Month2WeekPos = CellConfig.middlePosition;
            CellConfig.ifMonth = false;
            mainExpandIV.setImageResource(R.drawable.icon_arrow_down);
            calendarExp.shrink();
        } else {
            CellConfig.Week2MonthPos = CellConfig.middlePosition;
            CellConfig.ifMonth = true;
            mainExpandIV.setImageResource(R.drawable.icon_arrow_up);
            calendarExp.expand();
        }
        ifExpand = !ifExpand;
    }

OnDateClickListener dateClickListener = new OnDateClickListener() {
    @Override
    public void onDateClick(View view, DateData date) {
        String clickedDate = date.getDayString() + "/" + date.getMonthString() + "/" + String.valueOf(date.getYear());
        CommonFunctions.showSnackBarWithoutAction(mainExpandIV, clickedDate);

    }
};
}
