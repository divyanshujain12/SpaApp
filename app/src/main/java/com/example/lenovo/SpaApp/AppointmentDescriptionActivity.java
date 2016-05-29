package com.example.lenovo.SpaApp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingActivity;
import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingController;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.neopixl.pixlui.components.textview.TextView;

import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by divyanshu.jain on 5/27/2016.
 */
public class AppointmentDescriptionActivity extends GlobalActivity {

    @InjectView(R.id.categoryTV)
    TextView categoryTV;
    @InjectView(R.id.subCategoryTV)
    TextView subCategoryTV;
    @InjectView(R.id.categoriesLL)
    LinearLayout categoriesLL;
    @InjectView(R.id.priceTV)
    TextView priceTV;
    @InjectView(R.id.descriptionTV)
    TextView descriptionTV;
    @InjectView(R.id.confirmTV)
    TextView confirmTV;
    @InjectView(R.id.toolbar)
    ToolbarWithBackButton toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.appointment_activity);
        ButterKnife.inject(this);

        setToolBar();
    }

    private void setToolBar() {
        toolbar.InitToolbar(this, "DESCRIPTION");
    }


    @OnClick({R.id.confirmTV})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmTV:
                Intent intent = new Intent(this, AppointmentBookingController.class);
                startActivity(intent);
                break;
        }
    }


}
