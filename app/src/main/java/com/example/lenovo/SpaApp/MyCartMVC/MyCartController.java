package com.example.lenovo.SpaApp.MyCartMVC;

import android.os.Bundle;
import android.view.View;

import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;

/**
 * Created by divyanshu.jain on 6/1/2016.
 */
public class MyCartController extends MyCartActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myCartRV.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        }));
    }
}
