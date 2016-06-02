package com.example.lenovo.SpaApp.CustomViews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingModel;
import com.example.lenovo.SpaApp.MyCartMVC.MyCartController;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.neopixl.pixlui.components.textview.TextView;

import io.realm.Realm;

/**
 * Created by divyanshu.jain on 6/2/2016.
 */
public class ToolbarWithHamburg extends LinearLayout implements View.OnClickListener {
    Toolbar toolbar;
    TextView toolbar_title, badgeTV;
    RelativeLayout cartRL;
    ImageView content_hamburger;
    AppCompatActivity activity;
    Realm realm;


    public ToolbarWithHamburg(Context context, AttributeSet attrs) {
        super(context, attrs);

        //InitToolbar(context);
    }

    public void InitToolbar(AppCompatActivity context, String name) {
        realm = Realm.getDefaultInstance();
      //  realm.beginTransaction();
        this.activity = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View customToolbarView = inflater.inflate(R.layout.view_feed_toolbar, this);

        toolbar = (Toolbar) findViewById(R.id.customToolbar);
        content_hamburger = (ImageView) findViewById(R.id.content_hamburger);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        badgeTV = (TextView) findViewById(R.id.badgeTV);
        cartRL = (RelativeLayout) findViewById(R.id.cartRL);
        cartRL.setOnClickListener(this);

        toolbar_title.setText(name);
        setProductCount();

        context.setSupportActionBar(toolbar);
        context.getSupportActionBar().setTitle("");

    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public TextView getHeaderTextView() {
        return toolbar_title;
    }

    public void setHeaderText(String text) {
        toolbar_title.setText(text);
    }

    public void setProductCount() {
        int size = realm.allObjects(AppointmentBookingModel.class).size();
        if (size > 0) {
            badgeTV.setVisibility(View.VISIBLE);
            badgeTV.setText(String.valueOf(size));
        }
        else
            badgeTV.setVisibility(View.GONE);

      /*  try {
            realm.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    public ImageView getHamburgImage() {
        return content_hamburger;
    }

    @Override
    public void onClick(View v) {
        if (v == cartRL) {
            Intent intent = new Intent(activity, MyCartController.class);
            activity.startActivity(intent);
        } else
            activity.onBackPressed();

    }

    public void hideCartView(boolean status) {
        cartRL.setVisibility(status ? View.GONE : View.VISIBLE);
    }
}