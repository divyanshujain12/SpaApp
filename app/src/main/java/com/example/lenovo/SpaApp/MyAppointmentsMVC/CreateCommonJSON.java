package com.example.lenovo.SpaApp.MyAppointmentsMVC;

import android.content.Context;

import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by divyanshu.jain on 6/13/2016.
 */
public class CreateCommonJSON {
    private static CreateCommonJSON createCommonCancelOrderJSON = null;

    public static CreateCommonJSON getInstance() {
        if (createCommonCancelOrderJSON == null)
            createCommonCancelOrderJSON = new CreateCommonJSON();
        return createCommonCancelOrderJSON;
    }

    public JSONObject createJsonObjectForCancelOrder(Context context, String order_id) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(Constants.EMAIL, MySharedPereference.getInstance().getString(context, Constants.EMAIL));
            jsonObject.put(Constants.ORDER_ID, order_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public JSONObject createJSONForGetAppointments(Context context, String type) {

        String emailID = MySharedPereference.getInstance().getString(context, Constants.EMAIL);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(Constants.EMAIL, emailID);
            jsonObject.put(Constants.TYPE, type);
            return jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}