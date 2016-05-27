package com.example.lenovo.SpaApp.CustomViews;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;


import com.example.lenovo.SpaApp.R;
import com.neopixl.pixlui.components.textview.TextView;

/**
 * Created by divyanshu.jain on 5/27/2016.
 */
public class ToolbarWithBackButton extends LinearLayout {
    Toolbar toolbar;
    TextView toolbar_title;

    public ToolbarWithBackButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        InitToolbar(context);
    }

    private void InitToolbar(final Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View customToolbarView = inflater.inflate(R.layout.custom_toolbar, this);
        toolbar = (Toolbar) customToolbarView.findViewById(R.id.toolbarView);
        toolbar_title = (TextView) customToolbarView.findViewById(R.id.toolbar_title);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.back_arrow));
        toolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //What to do on back clicked
                ((Activity) context).finish();
            }
        });
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

}
