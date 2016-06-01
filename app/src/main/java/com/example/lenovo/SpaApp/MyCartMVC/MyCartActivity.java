package com.example.lenovo.SpaApp.MyCartMVC;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.example.lenovo.SpaApp.Adapters.MyCartAdapter;
import com.example.lenovo.SpaApp.CustomViews.ToolbarWithBackButton;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import GlobalClasses.DummyJsons;
import GlobalClasses.GlobalActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu.jain on 6/1/2016.
 */
public class MyCartActivity extends GlobalActivity {

    @InjectView(R.id.myCartRV)
    protected RecyclerView myCartRV;
    @InjectView(R.id.customToolbar)
    protected ToolbarWithBackButton customToolbar;
    protected MyCartAdapter myCartAdapter;
    protected ArrayList<MyCartModel> myCartModels = new ArrayList<>();

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
        myCartRV.setLayoutManager(new LinearLayoutManager(this));
        try {
            onJsonObjectSuccess(new JSONObject(DummyJsons.appointmentJSON));
        } catch (JSONException e) {

        }
    }


    @Override
    public void onJsonObjectSuccess(JSONObject object) {
        super.onJsonObjectSuccess(object);
        try {
            myCartModels = ParsingResponse.getInstance().parseJsonArrayWithJsonObject(object.getJSONArray(Constants.DATA), MyCartModel.class);
            myCartAdapter = new MyCartAdapter(this, myCartModels);
            myCartRV.setAdapter(myCartAdapter);

        } catch (JSONException e) {

        }
    }
}
