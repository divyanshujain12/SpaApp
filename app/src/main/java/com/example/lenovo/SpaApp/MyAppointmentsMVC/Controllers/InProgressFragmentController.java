package com.example.lenovo.SpaApp.MyAppointmentsMVC.Controllers;

import android.view.View;

import com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments.InProgressFragment;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.MyAppointmentsFragment;
import com.example.lenovo.SpaApp.Utils.CallWebService;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;

/**
 * Created by divyanshu.jain on 6/7/2016.
 */
public class InProgressFragmentController extends InProgressFragment{
    @Override
    public void onResume() {
        super.onResume();
        appointmentsRV.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        }));

        CallWebService.getInstance(getActivity(), false).hitWithJSONObjectVolleyWebService(CallWebService.POST, Constants.WebServices.MY_SERVICES, MyAppointmentsFragment.createJSONForgetAppointments("4"), this);
    }
}
