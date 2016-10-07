package com.example.lenovo.SpaApp.HomeActivityMVC;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.example.lenovo.SpaApp.ContactusMVC.ContactFragment;
import com.example.lenovo.SpaApp.CorporateEnquiriesMVC.CorporateFragmentController;
import com.example.lenovo.SpaApp.FAQFragmentMVC.FaqFragmentController;
import com.example.lenovo.SpaApp.HomeFragmentMVC.HomeFragmentControllers;
import com.example.lenovo.SpaApp.HowItWorksMVC.HowItWorksFragment;
import com.example.lenovo.SpaApp.Interfaces.SnackBarCallback;
import com.example.lenovo.SpaApp.MainActivity;
import com.example.lenovo.SpaApp.Models.UserDetailModel;
import com.example.lenovo.SpaApp.MyAccountMVC.MyAccountFragment;
import com.example.lenovo.SpaApp.MyAppointmentsMVC.MyAppointmentsFragment;
import com.example.lenovo.SpaApp.R;
import com.example.lenovo.SpaApp.SelectCityActivity;
import com.example.lenovo.SpaApp.Utils.AlertMessage;
import com.example.lenovo.SpaApp.Utils.Constants;
import com.example.lenovo.SpaApp.Utils.MySharedPereference;
import com.example.lenovo.SpaApp.Utils.RecyclerItemClickListener;

import io.realm.Realm;

/**
 * Created by divyanshu on 5/29/2016.
 */
public class HomeActivityController extends HomeActivity {
    PendingIntent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int flag = getIntent().getFlags();
        intent = PendingIntent.getActivity(getBaseContext(), 0,
                new Intent(getIntent()), flag);

        menuRV.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (MySharedPereference.getInstance().getBoolean(HomeActivityController.this, Constants.LOGGED_IN))
                    onLoginRVClick(position);
                else
                    onWithoutLoginRVClick(position);
                guillotineAnimation.close();
            }
        }));
        /*homeFragment = ServiceCategoriesFragment.getInstance("SERVICES");*/
        updateFragment(HomeFragmentControllers.getInstance());

      /*  Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable ex) {
                ex.printStackTrace();
                AlarmManager mgr = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
                mgr.set(AlarmManager.RTC, System.currentTimeMillis()+500, intent);
                System.exit(2);

            }
        });*/
    }

    private void onWithoutLoginRVClick(int position) {
        switch (position) {
            case 0:
                updateFragment(new HomeFragmentControllers());
                break;
            case 1:
                updateFragment(HowItWorksFragment.getInstance("How It Works"));
                break;
            case 2:
                updateFragment(FaqFragmentController.getInstance("FAQ'S"));
                break;
            case 3:
                updateFragment(CorporateFragmentController.getInstance("CORPORATE INQUIRIES"));
                break;
            case 4:
                updateFragment(ContactFragment.getInstance("CONTACTS"));
                break;
            case 5:
                logout();
                break;
        }

    }


    private void onLoginRVClick(int position) {
        switch (position) {
            case 0:
                updateFragment(new HomeFragmentControllers());
                break;
            case 1:
                checkLogin(MyAppointmentsFragment.getInstance("MY APPOINTMENTS"));
                break;
            case 2:
                checkLogin(HowItWorksFragment.getInstance("How It Works"));
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
                logout();
                break;
        }
    }

    private void logout() {
        MySharedPereference.getInstance().clearSharedPreference(HomeActivityController.this);
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.allObjects(UserDetailModel.class).clear();
        realm.commitTransaction();
        Intent intent = new Intent(HomeActivityController.this, SelectCityActivity.class);
        intent.putExtra("pos", 0);
        startActivity(intent);
        finish();
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

    private void checkLogin(final Fragment fragment) {
        if (MySharedPereference.getInstance().getBoolean(this, Constants.LOGGED_IN)) {
            updateFragment(fragment);
        } else {
            AlertMessage.showAlertDialogWithCallBack(this, getString(R.string.login_alert), getString(R.string.log_in_alert_msg), new SnackBarCallback() {
                @Override
                public void doAction() {
                    Intent intent = new Intent(HomeActivityController.this, MainActivity.class);
                    startActivity(intent);
                }
            });
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
