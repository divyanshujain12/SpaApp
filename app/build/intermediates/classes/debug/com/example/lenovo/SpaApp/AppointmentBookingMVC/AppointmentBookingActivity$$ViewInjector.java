// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.AppointmentBookingMVC;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AppointmentBookingActivity$$ViewInjector<T extends com.example.lenovo.SpaApp.AppointmentBookingMVC.AppointmentBookingActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624069, "field 'timingGrid'");
    target.timingGrid = finder.castView(view, 2131624069, "field 'timingGrid'");
    view = finder.findRequiredView(source, 2131624054, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131624054, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131624064, "field 'nameET'");
    target.nameET = finder.castView(view, 2131624064, "field 'nameET'");
    view = finder.findRequiredView(source, 2131624065, "field 'numberET'");
    target.numberET = finder.castView(view, 2131624065, "field 'numberET'");
    view = finder.findRequiredView(source, 2131624066, "field 'emailET'");
    target.emailET = finder.castView(view, 2131624066, "field 'emailET'");
    view = finder.findRequiredView(source, 2131624067, "field 'addressET'");
    target.addressET = finder.castView(view, 2131624067, "field 'addressET'");
    view = finder.findRequiredView(source, 2131624062, "field 'confirmTV'");
    target.confirmTV = finder.castView(view, 2131624062, "field 'confirmTV'");
    view = finder.findRequiredView(source, 2131624063, "field 'serviceTV'");
    target.serviceTV = finder.castView(view, 2131624063, "field 'serviceTV'");
    view = finder.findRequiredView(source, 2131624070, "field 'additionalET'");
    target.additionalET = finder.castView(view, 2131624070, "field 'additionalET'");
    view = finder.findRequiredView(source, 2131624068, "field 'calendarView'");
    target.calendarView = finder.castView(view, 2131624068, "field 'calendarView'");
  }

  @Override public void reset(T target) {
    target.timingGrid = null;
    target.toolbar = null;
    target.nameET = null;
    target.numberET = null;
    target.emailET = null;
    target.addressET = null;
    target.confirmTV = null;
    target.serviceTV = null;
    target.additionalET = null;
    target.calendarView = null;
  }
}
