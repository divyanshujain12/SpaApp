package com.example.lenovo.SpaApp.HomeActivityMVC;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.lenovo.SpaApp.MyAppointmentsMVC.MyAppointmentsFragment;
import com.example.lenovo.SpaApp.Fragments.BuyServicesFragment;
import com.example.lenovo.SpaApp.Fragments.ContactFragment;
import com.example.lenovo.SpaApp.Fragments.SettingFragment;
import com.example.lenovo.SpaApp.HomeFragmentMVC.HomeFragment;
import com.example.lenovo.SpaApp.HomeFragmentMVC.HomeFragmentControllers;
import com.example.lenovo.SpaApp.HowItWork;
import com.example.lenovo.SpaApp.MainActivity;
import com.example.lenovo.SpaApp.MyCartMVC.MyCartActivity;
import com.example.lenovo.SpaApp.MyCartMVC.MyCartController;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;

import butterknife.OnClick;

/**
 * Created by divyanshu on 5/29/2016.
 */
public class HomeActivityController extends HomeActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        menuRV.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                switch (position) {
                    case 0:
                        updateFragment(MyAppointmentsFragment.getInstance("MY APPOINTMENTS"));
                        break;
                    case 1:
                        updateFragment(BuyServicesFragment.getInstance("BUY SERVICES"));
                        break;
                    case 2:
                        updateFragment(ContactFragment.getInstance("CONTACTS"));
                        break;
                    case 3:
                        updateFragment(SettingFragment.getInstance("SETTINGS"));
                        break;
                    case 4:
                        MySharedPereference.getInstance().clearSharedPreference(HomeActivityController.this);
                        Intent intent = new Intent(HomeActivityController.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;
                    case 5:
                        Intent intent1 = new Intent(HomeActivityController.this, HowItWork.class);
                        startActivity(intent1);
                        finish();
                        break;
                }
                guillotineAnimation.close();
            }
        }));
        /*homeFragment = ServiceCategoriesFragment.getInstance("SERVICES");*/
        updateFragment(new HomeFragmentControllers());
    }

    public void updateFragment(Fragment fragment) {

        String name = fragment.getClass().getName();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        boolean isPopped = fragmentManager.popBackStackImmediate(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        if (fragment != null && !isPopped) {
            fragmentTransaction.replace(R.id.frameLayout, fragment);
            if (!(fragment instanceof HomeFragment))
                fragmentTransaction.addToBackStack(name);
            fragmentTransaction.commit();
        }

    }

    public void onResume() {
        super.onResume();
        toolbar.setProductCount();
    }
}
