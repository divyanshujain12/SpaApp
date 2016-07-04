package com.example.lenovo.SpaApp.FAQFragmentMVC;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    ArrayList<FaqModel> faqModels;
    ArrayList<String> questionArray;
    HashMap<String, String> answersMap;
    @InjectView(R.id.faqRV)
    RecyclerView faqRV;
    /*@InjectView(R.id.contentLL)
    LinearLayout contentLL;*/

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

        faqRV.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
