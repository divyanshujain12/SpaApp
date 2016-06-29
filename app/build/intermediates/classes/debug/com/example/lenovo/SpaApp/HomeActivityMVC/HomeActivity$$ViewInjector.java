// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.HomeActivityMVC;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HomeActivity$$ViewInjector<T extends com.example.lenovo.SpaApp.HomeActivityMVC.HomeActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624054, "field 'toolbar'");
    target.toolbar = finder.castView(view, 2131624054, "field 'toolbar'");
    view = finder.findRequiredView(source, 2131624149, "field 'root'");
    target.root = finder.castView(view, 2131624149, "field 'root'");
  }

  @Override public void reset(T target) {
    target.toolbar = null;
    target.root = null;
  }
}
