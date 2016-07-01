package com.example.lenovo.SpaApp.FAQFragmentMVC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.example.lenovo.SpaApp.R;

import java.util.ArrayList;
import java.util.HashMap;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by divyanshu.jain on 6/13/2016.
 */
public class FaqFragment extends GlobalFragment {

    @InjectView(R.id.expandedLV)
    ExpandableListView expandedLV;
    ArrayList<FaqModel> faqModels;
    ArrayList<String> questionArray;
    HashMap<String, String> answersMap;
    CustomExpandableListAdapter customExpandableListAdapter;
    @InjectView(R.id.contentLL)
    LinearLayout contentLL;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.faq_fragment, container, false);

        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViews();
    }

    private void InitViews() {
        faqModels = new ArrayList<>();
        questionArray = new ArrayList<>();
        answersMap = new HashMap<>();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
