package com.example.lenovo.SpaApp.HomeActivityMVC;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.lenovo.SpaApp.ContactusMVC.ContactFragment;
import com.example.lenovo.SpaApp.CorporateEnquiriesMVC.CorporateFragmentController;
import com.example.lenovo.SpaApp.FAQFragmentMVC.FaqFragmentController;
import com.example.lenovo.SpaApp.HomeFragmentMVC.HomeFragmentControllers;
import com.example.lenovo.SpaApp.HowItWork;
import com.example.lenovo.SpaApp.MainActivity;
import com.example.lenovo.SpaApp.Models.UserDetailModel;
import com.example.lenovo.SpaApp.MyAccountMVC.MyAccountFragment;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.MyAppointmentsFragment;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;

import io.realm.Realm;

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
                        updateFragment(new HomeFragmentControllers());
                        break;
                    case 1:
                        checkLogin(MyAppointmentsFragment.getInstance("MY APPOINTMENTS"));
                        break;
                    case 2:
                        Intent intent1 = new Intent(HomeActivityController.this, HowItWork.class);
                        startActivity(intent1);
                        finish();
                        break;
                    case 3:
                        updateFragment(FaqFragmentController.getInstance("FAQ'S"));
                        break;
                    case 4:
                        checkLogin(MyAccountFragment.getInstance("MY ACCOUNT"));
                        break;
                    case 5:
                        updateFragment(CorporateFragmentController.getInstance("CORPORATE INQUIRIES"));
                        break;
                    case 6:
                        checkLogin(ContactFragment.getInstance("CONTACTS"));
                        break;
                    case 7:
                        MySharedPereference.getInstance().clearSharedPreference(HomeActivityController.this);
                        Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        realm.allObjects(UserDetailModel.class).clear();
                        realm.commitTransaction();
                        Intent intent = new Intent(HomeActivityController.this, MainActivity.class);
                        startActivity(intent);
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
        boolean isPopped = fragmentManager.popBackStackImmediate(name, 0);
        if (fragment != null && !isPopped && fragmentManager.findFragmentByTag(name) == null) {
            if (fragment instanceof HomeFragmentControllers)
                fragmentTransaction.replace(R.id.frameLayout, fragment);
            else {
                fragmentTransaction.replace(R.id.frameLayout, fragment, name);
                fragmentTransaction.addToBackStack(name);
            }
            fragmentTransaction.commit();
        }

    }

    public void onResume() {


        super.onResume();
        toolbar.setProductCount();
    }

    private void checkLogin(Fragment fragment) {
        if (MySharedPereference.getInstance().getBoolean(this, Constants.LOGGED_IN)) {
            updateFragment(fragment);
        } else {
            AlertMessage.showAlertDialogWithCallBack(this, "LOGIN ALERT", getString(R.string.log_in_alert_msg), this);
        }
    }

    @Override
    public void onBackPressed() {
       /* if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStack();
        } else {*/
        super.onBackPressed();
        // }
    }
}
