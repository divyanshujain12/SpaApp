// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class UpcomingAppointmentsFragment$$ViewInjector<T extends com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments.UpcomingAppointmentsFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624072, "field 'appointmentsRV'");
    target.appointmentsRV = finder.castView(view, 2131624072, "field 'appointmentsRV'");
    view = finder.findRequiredView(source, 2131624071, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131624071, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131624073, "field 'noItemTV'");
    target.noItemTV = finder.castView(view, 2131624073, "field 'noItemTV'");
  }

  @Override public void reset(T target) {
    target.appointmentsRV = null;
    target.progressBar = null;
    target.noItemTV = null;
  }
}
