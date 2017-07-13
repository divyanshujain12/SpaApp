package com.example.lenovo.SpaApp.CorporateEnquiriesMVC;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Spinner;

import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.checkbox.CheckBox;
import com.neopixl.pixlui.components.edittext.EditText;
import com.neopixl.pixlui.components.textview.TextView;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by divyanshu.jain on 6/13/2016.
 */
public class CorporateFragment extends GlobalFragment implements CompoundButton.OnCheckedChangeListener {

    Context context;
    @InjectView(R.id.edtCompanyName)
    EditText edtCompanyName;
    @InjectView(R.id.edtLocation)
    EditText edtLocation;
    @InjectView(R.id.edtContactPerson)
    EditText edtContactPerson;
    @InjectView(R.id.edtContactMail)
    EditText edtContactMail;
    @InjectView(R.id.edtContactNumber)
    EditText edtContactNumber;
    @InjectView(R.id.monthSP)
    Spinner monthSP;
    @InjectView(R.id.yearSP)
    Spinner yearSP;
    @InjectView(R.id.fromSP)
    Spinner fromSP;
    @InjectView(R.id.toSP)
    Spinner toSP;
    @InjectView(R.id.edtApproxGest)
    EditText edtApproxGest;
    @InjectView(R.id.chairMassageCB)
    CheckBox chairMassageCB;
    @InjectView(R.id.edtChirMassageTech)
    EditText edtChirMassageTech;
    @InjectView(R.id.reflexologyCB)
    CheckBox reflexologyCB;
    @InjectView(R.id.edtReflexologyTech)
    EditText edtReflexologyTech;
    @InjectView(R.id.shiatsuCB)
    CheckBox shiatsuCB;
    @InjectView(R.id.edtShiatsuTech)
    EditText edtShiatsuTech;
    @InjectView(R.id.aromaCB)
    CheckBox aromaCB;
    @InjectView(R.id.edtAromaTech)
    EditText edtAromaTech;
    @InjectView(R.id.reikiCB)
    CheckBox reikiCB;
    @InjectView(R.id.edtReikiTech)
    EditText edtReikiTech;
    @InjectView(R.id.handFootCB)
    CheckBox handFootCB;
    @InjectView(R.id.edtHandFootTech)
    EditText edtHandFootTech;
    @InjectView(R.id.expManiCB)
    CheckBox expManiCB;
    @InjectView(R.id.edtExpManiTech)
    EditText edtExpManiTech;
    @InjectView(R.id.showShineCB)
    CheckBox showShineCB;
    @InjectView(R.id.edtShoeShineTech)
    EditText edtShoeShineTech;
    @InjectView(R.id.razorShaveCB)
    CheckBox razorShaveCB;
    @InjectView(R.id.edtRazorShaveTech)
    EditText edtRazorShaveTech;
    @InjectView(R.id.browBarCB)
    CheckBox browBarCB;
    @InjectView(R.id.edtBrowBarTech)
    EditText edtBrowBarTech;
    @InjectView(R.id.braidBarCB)
    CheckBox braidBarCB;
    @InjectView(R.id.edtBraidBarTech)
    EditText edtBraidBarTech;
    @InjectView(R.id.lashBarCB)
    CheckBox lashBarCB;
    @InjectView(R.id.edtLashBarTech)
    EditText edtLashBarTech;
    @InjectView(R.id.miniFacialCB)
    CheckBox miniFacialCB;
    @InjectView(R.id.edtMiniFacialTech)
    EditText edtMiniFacialTech;
    @InjectView(R.id.makeupCB)
    CheckBox makeupCB;
    @InjectView(R.id.edtMakeUpTech)
    EditText edtMakeUpTech;
    @InjectView(R.id.browThreadCB)
    CheckBox browThreadCB;
    @InjectView(R.id.edtBrowThreadingTech)
    EditText edtBrowThreadingTech;
    @InjectView(R.id.nutriConsultCB)
    CheckBox nutriConsultCB;
    @InjectView(R.id.edtNutriConsultTech)
    EditText edtNutriConsultTech;
    @InjectView(R.id.yogaClassesCB)
    CheckBox yogaClassesCB;
    @InjectView(R.id.edtYogaTech)
    EditText edtYogaTech;
    @InjectView(R.id.fitnessInstCB)
    CheckBox fitnessInstCB;
    @InjectView(R.id.edtFitnessInstructTech)
    EditText edtFitnessInstructTech;
    @InjectView(R.id.requestAQuote)
    TextView requestAQuote;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.corporate_enquiry, container, false);

        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        InitViews();
    }

    private void InitViews() {
        chairMassageCB.setOnCheckedChangeListener(this);
        reflexologyCB.setOnCheckedChangeListener(this);
        shiatsuCB.setOnCheckedChangeListener(this);
        aromaCB.setOnCheckedChangeListener(this);
        reikiCB.setOnCheckedChangeListener(this);
        handFootCB.setOnCheckedChangeListener(this);
        expManiCB.setOnCheckedChangeListener(this);
        showShineCB.setOnCheckedChangeListener(this);
        razorShaveCB.setOnCheckedChangeListener(this);
        browBarCB.setOnCheckedChangeListener(this);
        braidBarCB.setOnCheckedChangeListener(this);
        lashBarCB.setOnCheckedChangeListener(this);
        miniFacialCB.setOnCheckedChangeListener(this);
        makeupCB.setOnCheckedChangeListener(this);
        browThreadCB.setOnCheckedChangeListener(this);
        nutriConsultCB.setOnCheckedChangeListener(this);
        yogaClassesCB.setOnCheckedChangeListener(this);
        fitnessInstCB.setOnCheckedChangeListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick(R.id.requestAQuote)
    public void onClick() {
    }

    @Override
    public void onResume() {
        enableDisableEditText(edtChirMassageTech, false);
        enableDisableEditText(edtReflexologyTech, false);
        enableDisableEditText(edtAromaTech, false);
        enableDisableEditText(edtReikiTech, false);
        enableDisableEditText(edtHandFootTech, false);
        enableDisableEditText(edtExpManiTech, false);
        enableDisableEditText(edtShoeShineTech, false);
        enableDisableEditText(edtRazorShaveTech, false);
        enableDisableEditText(edtBrowBarTech, false);
        enableDisableEditText(edtBraidBarTech, false);
        enableDisableEditText(edtLashBarTech, false);
        enableDisableEditText(edtMiniFacialTech, false);
        enableDisableEditText(edtMakeUpTech, false);
        enableDisableEditText(edtBrowThreadingTech, false);
        enableDisableEditText(edtNutriConsultTech, false);
        enableDisableEditText(edtYogaTech, false);
        enableDisableEditText(edtFitnessInstructTech, false);
        super.onResume();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.chairMassageCB:
                enableDisableEditText(edtChirMassageTech, isChecked);
                break;
            case R.id.reflexologyCB:
                enableDisableEditText(edtReflexologyTech, isChecked);
                break;
            case R.id.shiatsuCB:
                enableDisableEditText(edtShiatsuTech, isChecked);
                break;
            case R.id.aromaCB:
                enableDisableEditText(edtAromaTech, isChecked);
                break;
            case R.id.reikiCB:
                enableDisableEditText(edtReikiTech, isChecked);
                break;
            case R.id.handFootCB:
                enableDisableEditText(edtHandFootTech, isChecked);
                break;
            case R.id.expManiCB:
                enableDisableEditText(edtExpManiTech, isChecked);
                break;
            case R.id.showShineCB:
                enableDisableEditText(edtShoeShineTech, isChecked);
                break;
            case R.id.razorShaveCB:
                enableDisableEditText(edtRazorShaveTech, isChecked);
                break;
            case R.id.browBarCB:
                enableDisableEditText(edtBrowBarTech, isChecked);
                break;
            case R.id.braidBarCB:
                enableDisableEditText(edtBraidBarTech, isChecked);
                break;
            case R.id.lashBarCB:
                enableDisableEditText(edtLashBarTech, isChecked);
                break;
            case R.id.miniFacialCB:
                enableDisableEditText(edtMiniFacialTech, isChecked);
                break;
            case R.id.makeupCB:
                enableDisableEditText(edtMakeUpTech, isChecked);
                break;
            case R.id.browThreadCB:
                enableDisableEditText(edtBrowBarTech, isChecked);
                break;
            case R.id.nutriConsultCB:
                enableDisableEditText(edtNutriConsultTech, isChecked);
                break;
            case R.id.yogaClassesCB:
                enableDisableEditText(edtYogaTech, isChecked);
                break;
            case R.id.fitnessInstCB:
                enableDisableEditText(edtFitnessInstructTech, isChecked);
                break;
        }
    }

    private void enableDisableEditText(EditText editText, boolean enable) {
        editText.setEnabled(enable);
    }
}
