package com.example.lenovo.SpaApp.FAQFragmentMVC;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.SpaApp.Adapters.ViewPagerAdapter;
import com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity;
import com.example.lenovo.SpaApp.R;
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
    public void onJsonObjectSuccess(JSONObject object) throws JSONException {
        super.onJsonObjectSuccess(object);
        faqModels = ParsingResponse.getInstance().parseJsonArrayWithJsonObject(object.optJSONArray(Constants.DATA), FaqModel.class);
        addViewInScrollview();
       /* for (FaqModel faqModel : faqModels) {
            questionArray.add(faqModel.getQuestion());
            answersMap.put(faqModel.getQuestion(), faqModel.getAnswer());
        }
        customExpandableListAdapter = new CustomExpandableListAdapter(getActivity(), questionArray, answersMap);
        expandedLV.setAdapter(customExpandableListAdapter);*/
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HomeActivity.headerText.setText(getArguments().getString("name"));
        CallWebService.getInstance(getContext(), true).hitJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.FAQS, null, this);
    }

    private void addViewInScrollview() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        for (FaqModel faqModel : faqModels) {
            View view = inflater.inflate(R.layout.faq_content_view, null);
            TextView questionTV = (TextView) view.findViewById(R.id.questionTV);
            TextView answerTV = (TextView) view.findViewById(R.id.answerTV);

            questionTV.setText(faqModel.getQuestion());
            answerTV.setText(faqModel.getAnswer());

            contentLL.addView(view);

        }

    }
}
