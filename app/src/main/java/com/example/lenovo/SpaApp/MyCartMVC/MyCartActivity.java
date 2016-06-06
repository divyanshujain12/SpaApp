package com.example.lenovo.SpaApp.MyCartMVC;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.SpaApp.Adapters.MyCartAdapter;
import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingModel;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ModelToJson;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;
import com.neopixl.pixlui.components.textview.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import io.realm.Realm;

/**
 * Created by divyanshu.jain on 6/1/2016.
 */
public class MyCartActivity extends GlobalActivity {

    @InjectView(R.id.myCartRV)
    protected RecyclerView myCartRV;
    @InjectView(R.id.customToolbar)
    protected ToolbarWithBackButton customToolbar;
    protected MyCartAdapter myCartAdapter;
    protected ArrayList<AppointmentBookingModel> myCartModels = new ArrayList<>();
    protected Realm realm;
    @InjectView(R.id.contentRL)
    RelativeLayout contentRL;
    @InjectView(R.id.noItemLL)
    LinearLayout noItemLL;
    @InjectView(R.id.confirmTV)
    TextView confirmTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.my_cart_activity);
        ButterKnife.inject(this);

        InitViews();
    }

    private void InitViews() {
        customToolbar.InitToolbar(this, getString(R.string.my_cart));
        customToolbar.hideCartView(true);
        myCartRV.setLayoutManager(new LinearLayoutManager(this));
        realm = Realm.getDefaultInstance();
        myCartModels.addAll(realm.allObjects(AppointmentBookingModel.class));
        myCartAdapter = new MyCartAdapter(this, myCartModels, this);
        myCartRV.setAdapter(myCartAdapter);

        if (myCartModels.size() <= 0)
            hideContentLayout(true);
        else
            hideContentLayout(false);

    }

    public void hideContentLayout(boolean b) {
        noItemLL.setVisibility(b ? View.VISIBLE : View.GONE);
        contentRL.setVisibility(b ? View.GONE : View.VISIBLE);
    }


    @Override
    public void onJsonObjectSuccess(JSONObject object) {
        super.onJsonObjectSuccess(object);

    }

    @OnClick(R.id.confirmTV)
    public void onClick() {
    }

  /*  protected JSONObject getJSONObjectForCheckout() {

        for (AppointmentBookingModel appointmentBookingModel : myCartModels) {
            JSONObject jsonObject = ModelToJson.getInstance().createJSONFromModelClass(appointmentBookingModel);

        }
    }*/
}
