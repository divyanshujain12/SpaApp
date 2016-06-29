// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.MyAppointmentsMVC;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MyAppointmentsFragment$$ViewInjector<T extends com.example.lenovo.SpaApp.MyAppointmentsMVC.MyAppointmentsFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624175, "field 'tabLayout'");
    target.tabLayout = finder.castView(view, 2131624175, "field 'tabLayout'");
    view = finder.findRequiredView(source, 2131624176, "field 'viewPager'");
    target.viewPager = finder.castView(view, 2131624176, "field 'viewPager'");
  }

  @Override public void reset(T target) {
    target.tabLayout = null;
    target.viewPager = null;
  }
}
