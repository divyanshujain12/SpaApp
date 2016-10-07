package com.example.lenovo.SpaApp.FAQFragmentMVC;

import android.os.Bundle;

import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.ParsingResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by divyanshu.jain on 6/13/2016.
 */
public class FaqFragmentController extends FaqFragment {

    public static FaqFragmentController getInstance(String Name) {
        FaqFragmentController fragment = new FaqFragmentController();
        Bundle bundle = new Bundle();
        bundle.putString("name", Name);
        fragment.setArguments(bundle);
        return fragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeActivity.headerText.setText(getArguments().getString("name"));
        CallWebService.getInstance(getContext(), true).hitJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.FAQS, null, this);
    }

    @Override
    public void onJsonObjectSuccess(JSONObject object) throws JSONException {
        super.onJsonObjectSuccess(object);
        faqModels = ParsingResponse.getInstance().parseJsonArrayWithJsonObject(object.optJSONArray(Constants.DATA), FaqModel.class);

        ExpandableRecyclerViewAdapter expandableRecyclerViewAdapter = new ExpandableRecyclerViewAdapter(getActivity(), faqModels);
        faqRV.setAdapter(expandableRecyclerViewAdapter);
    }
}
