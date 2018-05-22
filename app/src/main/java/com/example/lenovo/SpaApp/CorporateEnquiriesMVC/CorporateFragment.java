package com.example.lenovo.SpaApp.CorporateEnquiriesMVC;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lenovo.SpaApp.Models.ValidationModel;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.Validation;
import com.neopixl.pixlui.components.checkbox.CheckBox;
import com.neopixl.pixlui.components.edittext.EditText;
import com.neopixl.pixlui.components.textview.TextView;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.json.JSONObject;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import GlobalClasses.GlobalFragment;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by divyanshu.jain on 6/13/2016.
 */
public class CorporateFragment extends GlobalFragment implements CompoundButton.OnCheckedChangeListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

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
    //    @InjectView(R.id.fromSP)
//    Spinner fromSP;
//    @InjectView(R.id.toSP)
//    Spinner toSP;
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
    Validation validation;
    HashMap<View, String> hashMap;
    @InjectView(R.id.preferredDateTV)
    TextView preferredDateTV;
    @InjectView(R.id.fromTimeTV)
    TextView fromTimeTV;
    @InjectView(R.id.toTimeTV)
    TextView toTimeTV;
    public static final String TIME_FORMAT = "hh:mm a";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    Calendar mcurrentDate, mCurrentTime;


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
        validation = new Validation();
        validation.addValidationField(new ValidationModel(edtCompanyName, Validation.TYPE_EMPTY_FIELD_VALIDATION, "Company name cant left blank"));
        validation.addValidationField(new ValidationModel(edtLocation, Validation.TYPE_EMPTY_FIELD_VALIDATION, "Location cant left blank"));
        validation.addValidationField(new ValidationModel(edtContactPerson, Validation.TYPE_EMPTY_FIELD_VALIDATION, "Contact person cant left blank"));
        validation.addValidationField(new ValidationModel(edtContactMail, Validation.TYPE_EMAIL_VALIDATION, "Invalid Email Address"));
        validation.addValidationField(new ValidationModel(edtContactNumber, Validation.TYPE_PHONE_VALIDATION, "Invalid phone number"));
        validation.addValidationField(new ValidationModel(preferredDateTV, Validation.TYPE_EMPTY_FIELD_VALIDATION, "Please select a date"));
        validation.addValidationField(new ValidationModel(fromTimeTV, Validation.TYPE_EMPTY_FIELD_VALIDATION, "Please select your service starting time"));
        validation.addValidationField(new ValidationModel(toTimeTV, Validation.TYPE_EMPTY_FIELD_VALIDATION, "Please select your service ending time"));

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

        disableAllFields();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }


    private HashMap createJsonForGetCategories() {
        HashMap<String, String> jsonObject = new HashMap<>();
        try {
            jsonObject.put(Constants.COMPANY_NAME, hashMap.get(edtCompanyName));
            jsonObject.put(Constants.LOCATION_OF_SERVICE, hashMap.get(edtLocation));
            jsonObject.put(Constants.CONTACT_PERSON, hashMap.get(edtContactPerson));
            jsonObject.put(Constants.EMAIL, hashMap.get(edtContactMail));
            jsonObject.put(Constants.PHONE, hashMap.get(edtContactNumber));
            jsonObject.put(Constants.PREFERRED_DATE, hashMap.get(preferredDateTV));
            jsonObject.put(Constants.TIME_FROM, hashMap.get(fromTimeTV));
            jsonObject.put(Constants.TIME_TO, hashMap.get(toTimeTV));
            jsonObject.put(Constants.NUMBER_OF_GUESTS, edtApproxGest.getText().toString());
            jsonObject.put(Constants.CHAIR_MASSAGE, edtChirMassageTech.getText().toString());
            jsonObject.put(Constants.REFLEXOLOGY, edtReflexologyTech.getText().toString());
            jsonObject.put(Constants.SHIATSU_STRETCHING, edtShiatsuTech.getText().toString());
            jsonObject.put(Constants.AROMATHERAPY, edtAromaTech.getText().toString());
            jsonObject.put(Constants.REIKI, edtReikiTech.getText().toString());
            jsonObject.put(Constants.HAND_FOOT_MASSAGE, edtHandFootTech.getText().toString());
            jsonObject.put(Constants.EXPRESS_MANICRE, edtExpManiTech.getText().toString());
            jsonObject.put(Constants.SHOE_SHINE, edtShoeShineTech.getText().toString());
            jsonObject.put(Constants.RAZOR_SHAVE, edtRazorShaveTech.getText().toString());
            jsonObject.put(Constants.BROW_BAR, edtBrowBarTech.getText().toString());
            jsonObject.put(Constants.BRAID_BAR, edtBraidBarTech.getText().toString());
            jsonObject.put(Constants.LASH_BAR, edtLashBarTech.getText().toString());
            jsonObject.put(Constants.MINI_FACIAL, edtMiniFacialTech.getText().toString());
            jsonObject.put(Constants.MAKEUP_TOUCH_UPS, edtMakeUpTech.getText().toString());
            jsonObject.put(Constants.BROW_THREADING, edtBrowThreadingTech.getText().toString());
            jsonObject.put(Constants.NUTRITION_CONSULTATION, edtNutriConsultTech.getText().toString());
            jsonObject.put(Constants.YOGA_CLASSES, edtYogaTech.getText().toString());
            jsonObject.put(Constants.FITNESS_INSTRUCTION, edtFitnessInstructTech.getText().toString());
            new JSONObject(jsonObject);


        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    @Override
    public void onResume() {

        super.onResume();
    }

    private void disableAllFields() {
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


    private String getDataFromEditText(EditText editText) {
        return editText.getText().toString();
    }

    private void enableDisableEditText(EditText editText, boolean enable) {
        editText.setEnabled(enable);
    }

    @OnClick({R.id.preferredDateTV, R.id.fromTimeTV, R.id.toTimeTV, R.id.requestAQuote})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.preferredDateTV:
                openSelectTimePicker();
                break;
            case R.id.fromTimeTV:

                if (mcurrentDate != null) {
                    openFromTimePicker();
                } else {
                    Toast.makeText(getContext(), "Please Select Date First", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.toTimeTV:
                break;
            case R.id.requestAQuote:
                hashMap = validation.validate(getContext());
                if (hashMap != null) {
                    createJsonForGetCategories();
                }
                break;
        }
    }

    private void openSelectTimePicker() {
        mcurrentDate = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                this,
                mcurrentDate.get(Calendar.YEAR),
                mcurrentDate.get(Calendar.MONTH),
                mcurrentDate.get(Calendar.DAY_OF_MONTH)
        );

        if (mcurrentDate.get(Calendar.HOUR_OF_DAY) > 20)
            mcurrentDate.add(Calendar.DATE, +1);

        dpd.setMinDate(mcurrentDate);

        dpd.show(getActivity().getFragmentManager(), "Date Dialog");
    }

    private void openFromTimePicker() {
        mCurrentTime = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                this,
                mCurrentTime.get(Calendar.HOUR_OF_DAY),
                mCurrentTime.get(Calendar.MINUTE),
                false
        );
        if (mcurrentDate.getTime().after(mCurrentTime.getTime()))
            tpd.setMinTime(8, 0, 0);

        else
            tpd.setMinTime(mCurrentTime.get(Calendar.HOUR_OF_DAY), mCurrentTime.get(Calendar.MINUTE), mCurrentTime.get(Calendar.SECOND));
        tpd.setMaxTime(19, 0, 0);
        tpd.setTimeInterval(1);
        tpd.show(getActivity().getFragmentManager(), "1");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        mcurrentDate.set(year, monthOfYear, dayOfMonth);
        preferredDateTV.setText(formatDateAndTime(mcurrentDate.getTimeInMillis(), DATE_FORMAT));
    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
        Time time = new Time(hourOfDay, minute, second);
        mCurrentTime.setTimeInMillis(time.getTime());
        fromTimeTV.setText(formatDateAndTime(mCurrentTime.getTimeInMillis(), TIME_FORMAT));
        openToTimePicker();


    }


    private void openToTimePicker() {
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
                        Time time = new Time(hourOfDay, minute, second);
                        mCurrentTime.setTimeInMillis(time.getTime());
                        toTimeTV.setText(formatDateAndTime(mCurrentTime.getTimeInMillis(), TIME_FORMAT));
                    }
                },
                mCurrentTime.get(Calendar.HOUR_OF_DAY),
                mCurrentTime.get(Calendar.MINUTE),
                false
        );
        mCurrentTime.add(Calendar.MINUTE, +30);
        tpd.setMinTime(mCurrentTime.get(Calendar.HOUR_OF_DAY), mCurrentTime.get(Calendar.MINUTE), mCurrentTime.get(Calendar.SECOND));
        tpd.setMaxTime(20, 0, 0);
        tpd.setTimeInterval(1);
        tpd.show(getActivity().getFragmentManager(), "1");
    }


    private String formatDateAndTime(long date, String format) {
        Date dt = new Date(date);
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        return sdf.format(dt);
    }
}
