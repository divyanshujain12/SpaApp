package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.lenovo.SpaApp.CustomViews.ExpandableHeightGridView;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.neopixl.pixlui.components.edittext.EditText;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
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
    protected TextView mainYYMMTv;
    @InjectView(R.id.calendar_exp)
    protected ExpCalendarView calendarExp;
    @InjectView(R.id.main_expandIV)
    protected ImageView mainExpandIV;
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
    @InjectView(R.id.calendarLeftIV)
    protected ImageView calendarLeftIV;
    @InjectView(R.id.calendarrightIV)
    protected ImageView calendarrightIV;
    private boolean ifExpand = true;
    protected ArrayList<String> availableTimeSlotsArray = new ArrayList<>();

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


        setToolBar();
        timingGrid.setExpanded(true);
        CellConfig.Month2WeekPos = CellConfig.middlePosition;
        CellConfig.ifMonth = false;
        calendarExp.shrink();

        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<CharSequence>(this, R.layout.single_textview, getResources().getStringArray(R.array.timing_array));
        timingGrid.setAdapter(arrayAdapter);

    }

    private void setToolBar() {
        toolbar.InitToolbar(this, "BOOKING");
    }

    protected void submitClickedOK() {
        CommonFunctions.showSnackBarWithoutAction(timingGrid, "SUBMIT CLICKED!");
    }
}
