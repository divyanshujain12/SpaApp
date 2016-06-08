// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.HowItWorksFragments;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FirstFragment$$ViewInjector<T extends com.example.lenovo.SpaApp.HowItWorksFragments.FirstFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558562, "field 'txtSkip' and method 'onClick'");
    target.txtSkip = finder.castView(view, 2131558562, "field 'txtSkip'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558564, "field 'txtSignIn' and method 'onClick'");
    target.txtSignIn = finder.castView(view, 2131558564, "field 'txtSignIn'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558565, "field 'txtSignUp' and method 'onClick'");
    target.txtSignUp = finder.castView(view, 2131558565, "field 'txtSignUp'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131558563, "field 'bottomViews'");
    target.bottomViews = finder.castView(view, 2131558563, "field 'bottomViews'");
    view = finder.findRequiredView(source, 2131558561, "field 'txtInstruction'");
    target.txtInstruction = finder.castView(view, 2131558561, "field 'txtInstruction'");
    view = finder.findRequiredView(source, 2131558560, "field 'contentRL'");
    target.contentRL = finder.castView(view, 2131558560, "field 'contentRL'");
    view = finder.findRequiredView(source, 2131558559, "field 'mainContainer'");
    target.mainContainer = finder.castView(view, 2131558559, "field 'mainContainer'");
  }

  @Override public void reset(T target) {
    target.txtSkip = null;
    target.txtSignIn = null;
    target.txtSignUp = null;
    target.bottomViews = null;
    target.txtInstruction = null;
    target.contentRL = null;
    target.mainContainer = null;
  }
}
