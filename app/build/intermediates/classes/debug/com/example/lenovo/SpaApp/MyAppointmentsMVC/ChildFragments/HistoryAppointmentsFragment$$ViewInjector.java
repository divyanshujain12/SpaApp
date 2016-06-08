// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HistoryAppointmentsFragment$$ViewInjector<T extends com.example.lenovo.SpaApp.MyAppointmentsMVC.ChildFragments.HistoryAppointmentsFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558536, "field 'appointmentsRV'");
    target.appointmentsRV = finder.castView(view, 2131558536, "field 'appointmentsRV'");
    view = finder.findRequiredView(source, 2131558535, "field 'progressBar'");
    target.progressBar = finder.castView(view, 2131558535, "field 'progressBar'");
    view = finder.findRequiredView(source, 2131558537, "field 'noItemTV'");
    target.noItemTV = finder.castView(view, 2131558537, "field 'noItemTV'");
  }

  @Override public void reset(T target) {
    target.appointmentsRV = null;
    target.progressBar = null;
    target.noItemTV = null;
  }
}
