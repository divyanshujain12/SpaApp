package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.lenovo.SpaApp.CustomViews.ExpandableHeightGridView;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CommonFunctions;
import com.imanoweb.calendarview.CustomCalendarView;
import com.neopixl.pixlui.components.edittext.EditText;
import com.neopixl.pixlui.components.textview.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu.jain on 5/27/2016.
 */
public class AppointmentBookingActivity extends AppCompatActivity {

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

        //Initialize calendar with date
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

        //Show monday as first date of week
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

        //Show/hide overflow days of a month
        calendarView.setShowOverflowDate(false);

        //call refreshCalendar to update calendar the view
        calendarView.refreshCalendar(currentCalendar);

        calendarView.setCustomTypeface(Typeface.createFromAsset(getAssets(),"fonts/Titillium-Regular.otf"));

        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter<CharSequence>(this, R.layout.single_textview, getResources().getStringArray(R.array.timing_array));
        timingGrid.setAdapter(arrayAdapter);

    }

    private void setToolBar() {
        toolbar.InitToolbar(this, getString(R.string.booking));
    }

    protected void submitClickedOK() {
        CommonFunctions.showSnackBarWithoutAction(timingGrid, "SUBMIT CLICKED!");
    }
}
