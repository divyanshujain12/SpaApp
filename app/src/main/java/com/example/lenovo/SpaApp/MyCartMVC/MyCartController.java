package com.example.lenovo.SpaApp.MyCartMVC;

import android.os.Bundle;
import android.view.View;

import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.OnClick;

/**
 * Created by divyanshu.jain on 6/1/2016.
 */
public class MyCartController extends MyCartActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myCartRV.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        }));
    }

    @OnClick(R.id.confirmTV)
    public void onClick() {

        CallWebService.getInstance(this, true).hitWithJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.CHECKOUT, getJSONObjectForCheckout(), this);

    }

    protected JSONObject getJSONObjectForCheckout() {
        JSONObject outerObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        try {
            for (AppointmentBookingModel appointmentBookingModel : myCartModels) {
                JSONObject object = new JSONObject();

                object.put(Constants.CATEGORY_ID, appointmentBookingModel.getCategory_id());
                object.put(Constants.CITY_ID, appointmentBookingModel.getCity_id());
                object.put(Constants.ID, appointmentBookingModel.getProduct_id());
                object.put(Constants.DATE, appointmentBookingModel.getDate());
                object.put(Constants.TIME, appointmentBookingModel.getTime());
                object.put(Constants.PRICE, appointmentBookingModel.getCost());
                object.put(Constants.ADDITIONAL_NOTES, appointmentBookingModel.getAdditional_notes());
                object.put(Constants.ADDRESS, appointmentBookingModel.getAddress());
                object.put(Constants.QUANTITY, appointmentBookingModel.getQuantity());
                object.put(Constants.DURATION, appointmentBookingModel.getDuration());
                jsonArray.put(object);
            }
            outerObject.put(Constants.EMAIL, MySharedPereference.getInstance().getString(this, Constants.EMAIL));
            outerObject.put(Constants.NAME, MySharedPereference.getInstance().getString(this, Constants.NAME));
            outerObject.put(Constants.NUMBER, MySharedPereference.getInstance().getString(this, Constants.PHONE_NUMBER));
            outerObject.put(Constants.ADDRESS, "");
            outerObject.put(Constants.MENU, jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return outerObject;
    }
}
