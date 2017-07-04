package com.example.lenovo.SpaApp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingController;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.example.lenovo.SpaApp.Models.ProductModel;
import com.example.lenovo.SpaApp.Models.ServiceModel;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.example.lenovo.SpaApp.Utils.SingeltonClass;
import com.neopixl.pixlui.components.textview.TextView;

import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by divyanshu.jain on 5/27/2016.
 */
public class AppointmentDescriptionActivity extends GlobalActivity {

    @InjectView(R.id.categoryIV)
    TextView categoryTV;
    @InjectView(R.id.subCategoryTV)
    TextView productTV;
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
    int pos = 0;
    ProductModel productModel;
    @InjectView(R.id.durationTV)
    TextView durationTV;
    @InjectView(R.id.timeAndDuratinLL)
    LinearLayout timeAndDurationLL;
    String[] availableDurations;
    String[] availableCost;
    View selectedView = null;
    public ServiceModel serviceModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        setContentView(R.layout.appointment_activity);
        ButterKnife.inject(this);
        InitViews();

    }

    private void InitViews() {
        setToolBar();
        pos = getIntent().getIntExtra(Constants.POS, -1);
        serviceModel = getIntent().getParcelableExtra(Constants.DATA);
        productModel = serviceModel.getProducts().get(pos);
        if (productModel != null) {
            setDataToView();
        } else
            finish();

    }

    private void setDataToView() {
        categoryTV.setText(serviceModel.getName());
        productTV.setText(productModel.getName());
        priceTV.setText("$ " + productModel.getCost());
        descriptionTV.setText(productModel.getDescription());
        durationTV.setText(productModel.getDuration());
        addTimeAndDurationView();
    }

    private void setToolBar() {
        toolbar.InitToolbar(this, "DESCRIPTION");
    }


    @OnClick({R.id.confirmTV})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirmTV:
                if (MySharedPereference.getInstance().getBoolean(this, Constants.LOGGED_IN)) {
                    Intent intent = new Intent(this, AppointmentBookingController.class);
                    intent.putExtra(Constants.DATA,serviceModel);
                    intent.putExtra(Constants.POS,pos);
                    startActivity(intent);
                } else {
                    goForLogin();
                   /* AlertMessage.showAlertDialogWithCallBack(this, "LOGIN ALERT", getString(R.string.log_in_alert_msg), this);*/
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onResume() {
        super.onResume();
        toolbar.setProductCount();
    }

    @Override
    public void doAction() {
        super.doAction();


    }

    private void goForLogin() {
        SingeltonClass.getInstance().AFTER_LOGIN_ACTION = 1;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    private void addTimeAndDurationView() {

        String catID = serviceModel.getCategory_id();
        if (catID.equals(Constants.MASSAGE_CATEGORY_ONE) || catID.equals(Constants.MASSAGE_CATEGORY_TWO)) {
            availableDurations = getResources().getStringArray(R.array.massage_duration_array);
            availableCost = getResources().getStringArray(R.array.massage_duration_cost);
        } else {
            availableDurations = productModel.getDuration().trim().split(",");
            availableCost = productModel.getCost().trim().split(",");
        }
        for (int i = 0; i < availableDurations.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.product_duration_and_cost_view, null);
            TextView durationTV = (TextView) view.findViewById(R.id.durationTV);
            TextView priceTV = (TextView) view.findViewById(R.id.priceTV);

            durationTV.setText(availableDurations[i]);
            priceTV.setText(getString(R.string.doller_symbol)+availableCost[i]);

            view.setId(i);
            timeAndDurationLL.addView(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = v.getId();
                    productModel.setDuration(availableDurations[pos]);
                    productModel.setCost(availableCost[pos]);
                    v.setBackgroundColor(getResources().getColor(R.color.background_bottom_color));
                    if (selectedView != null) {
                        selectedView.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                    }
                    selectedView = v;

                }
            });
        }
    }
}
