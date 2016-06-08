// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AppointmentDescriptionActivity$$ViewInjector<T extends com.example.lenovo.SpaApp.AppointmentDescriptionActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558520, "field 'categoryTV'");
    target.categoryTV = finder.castView(view, 2131558520, "field 'categoryTV'");
    view = finder.findRequiredView(source, 2131558521, "field 'productTV'");
    target.productTV = finder.castView(view, 2131558521, "field 'productTV'");
    view = finder.findRequiredView(source, 2131558519, "field 'categoriesLL'");
    target.categoriesLL = finder.castView(view, 2131558519, "field 'categoriesLL'");
    view = finder.findRequiredView(source, 2131558522, "field 'priceTV'");
    target.priceTV = finder.castView(view, 2131558522, "field 'priceTV'");
    view = finder.findRequiredView(source, 2131558524, "field 'descriptionTV'");
    target.descriptionTV = finder.castView(view, 2131558524, "field 'descriptionTV'");
    view = finder.findRequiredView(source, 2131558526, "field 'confirmTV' and method 'onClick'");
    target.confirmTV = finder.castView(view, 2131558526, "field 'confirmTV'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558518, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131558518, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131558525, "field 'durationTV'");
    target.durationTV = finder.castView(view, 2131558525, "field 'durationTV'");
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
