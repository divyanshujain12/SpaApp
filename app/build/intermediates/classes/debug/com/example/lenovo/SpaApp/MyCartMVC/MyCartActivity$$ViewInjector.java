// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.MyCartMVC;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MyCartActivity$$ViewInjector<T extends com.example.lenovo.SpaApp.MyCartMVC.MyCartActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558599, "field 'myCartRV'");
    target.myCartRV = finder.castView(view, 2131558599, "field 'myCartRV'");
    view = finder.findRequiredView(source, 2131558598, "field 'customToolbar'");
    target.customToolbar = finder.castView(view, 2131558598, "field 'customToolbar'");
    view = finder.findRequiredView(source, 2131558563, "field 'contentRL'");
    target.contentRL = finder.castView(view, 2131558563, "field 'contentRL'");
    view = finder.findRequiredView(source, 2131558600, "field 'noItemLL'");
    target.noItemLL = finder.castView(view, 2131558600, "field 'noItemLL'");
    view = finder.findRequiredView(source, 2131558526, "field 'confirmTV'");
    target.confirmTV = finder.castView(view, 2131558526, "field 'confirmTV'");
  }

  @Override public void reset(T target) {
    target.myCartRV = null;
    target.customToolbar = null;
    target.contentRL = null;
    target.noItemLL = null;
    target.confirmTV = null;
  }
}
