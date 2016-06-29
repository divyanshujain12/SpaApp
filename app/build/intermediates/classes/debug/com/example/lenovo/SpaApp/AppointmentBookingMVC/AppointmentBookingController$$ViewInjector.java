// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class AppointmentBookingController$$ViewInjector<T extends com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingController> extends com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingActivity$$ViewInjector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    super.inject(finder, target, source);

    View view;
    view = finder.findRequiredView(source, 2131624062, "method 'onClick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  @Override public void reset(T target) {
    super.reset(target);

  }
}
