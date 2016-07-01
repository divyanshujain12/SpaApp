// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.HomeFragmentMVC;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class HomeFragment$$ViewInjector<T extends com.example.lenovo.SpaApp.HomeFragmentMVC.HomeFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624139, "field 'txtCancel'");
    target.txtCancel = finder.castView(view, 2131624139, "field 'txtCancel'");
  }

  @Override public void reset(T target) {
    target.txtCancel = null;
  }
}
