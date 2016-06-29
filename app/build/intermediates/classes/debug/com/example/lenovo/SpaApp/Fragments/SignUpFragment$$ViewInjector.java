// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.Fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SignUpFragment$$ViewInjector<T extends com.example.lenovo.SpaApp.Fragments.SignUpFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624219, "field 'edtxtNumber'");
    target.edtxtNumber = finder.castView(view, 2131624219, "field 'edtxtNumber'");
    view = finder.findRequiredView(source, 2131624218, "field 'inpNumber'");
    target.inpNumber = finder.castView(view, 2131624218, "field 'inpNumber'");
  }

  @Override public void reset(T target) {
    target.edtxtNumber = null;
    target.inpNumber = null;
  }
}
