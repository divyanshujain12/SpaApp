package com.example.lenovo.SpaApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.neopixl.pixlui.components.textview.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by divyanshu.jain on 5/27/2016.
 */
public class AppointmentDescriptionActivity extends AppCompatActivity {

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
    @InjectView(R.id.toolbar_title)
    TextView toolbarTitle;

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

        setSupportActionBar(toolbar.getToolbar());
        toolbar.setHeaderText("DESCRIPTION");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");

    }


    @OnClick({ R.id.confirmTV})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmTV:
                break;
        }
    }


}
