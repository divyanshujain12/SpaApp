package com.example.lenovo.SpaApp.CustomViews;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * Created by divyanshu.jain on 5/27/2016.
 */
public class ToolbarWithBackButton extends LinearLayout implements OnClickListener {
    Toolbar toolbar;
    TextView toolbar_title;
    ImageView backIV;
    Context context;

    public ToolbarWithBackButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        //InitToolbar(context);
    }

    public void InitToolbar(Context context,String name) {
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View customToolbarView = inflater.inflate(R.layout.custom_toolbar, this);
        toolbar = (Toolbar) customToolbarView.findViewById(R.id.toolbarView);
        backIV = (ImageView) findViewById(R.id.backIV);
        toolbar_title = (TextView) customToolbarView.findViewById(R.id.toolbar_title);
        toolbar_title.setText(name);
        backIV.setOnClickListener(this);
        ((AppCompatActivity)context).setSupportActionBar(toolbar);
        ((AppCompatActivity)context).getSupportActionBar().setTitle("");
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

    @Override
    public void onClick(View v) {
        ((Activity) context).finish();

    }
}
