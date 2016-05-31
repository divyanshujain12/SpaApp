package com.example.lenovo.SpaApp.MyAppointmentsMVC.Controllers;

import android.view.View;

import com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments.UpcomingAppointmentsFragment;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;

/**
 * Created by divyanshu.jain on 5/31/2016.
 */
public class UpcomingAppointmentsController extends UpcomingAppointmentsFragment {
    @Override
    public void onResume() {
        super.onResume();
        myUpcomingAppointmentsRV.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        }));
    }
}
