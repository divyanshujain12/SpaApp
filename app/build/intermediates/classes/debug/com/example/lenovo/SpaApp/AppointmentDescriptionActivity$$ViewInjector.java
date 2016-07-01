// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AppointmentDescriptionActivity$$ViewInjector<T extends com.example.lenovo.SpaApp.AppointmentDescriptionActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624056, "field 'categoryTV'");
    target.categoryTV = finder.castView(view, 2131624056, "field 'categoryTV'");
    view = finder.findRequiredView(source, 2131624057, "field 'productTV'");
    target.productTV = finder.castView(view, 2131624057, "field 'productTV'");
    view = finder.findRequiredView(source, 2131624055, "field 'categoriesLL'");
    target.categoriesLL = finder.castView(view, 2131624055, "field 'categoriesLL'");
    view = finder.findRequiredView(source, 2131624058, "field 'priceTV'");
    target.priceTV = finder.castView(view, 2131624058, "field 'priceTV'");
    view = finder.findRequiredView(source, 2131624060, "field 'descriptionTV'");
    target.descriptionTV = finder.castView(view, 2131624060, "field 'descriptionTV'");
    view = finder.findRequiredView(source, 2131624062, "field 'confirmTV' and method 'onClick'");
    target.confirmTV = finder.castView(view, 2131624062, "field 'confirmTV'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624054, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131624054, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131624061, "field 'durationTV'");
    target.durationTV = finder.castView(view, 2131624061, "field 'durationTV'");
  }

  @Override public void reset(T target) {
    target.categoryTV = null;
    target.productTV = null;
    target.categoriesLL = null;
    target.priceTV = null;
    target.descriptionTV = null;
    target.confirmTV = null;
    target.toolbar = null;
    target.durationTV = null;
  }
}
