// Generated code from Butter Knife. Do not modify!
package com.example.lenovo.SpaApp.MyAccountMVC;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class MyAccountFragment$$ViewInjector<T extends com.example.lenovo.SpaApp.MyAccountMVC.MyAccountFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624165, "field 'logo'");
    target.logo = finder.castView(view, 2131624165, "field 'logo'");
    view = finder.findRequiredView(source, 2131624166, "field 'emailLL' and method 'onClick'");
    target.emailLL = finder.castView(view, 2131624166, "field 'emailLL'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624168, "field 'nameLL' and method 'onClick'");
    target.nameLL = finder.castView(view, 2131624168, "field 'nameLL'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624170, "field 'numberLL' and method 'onClick'");
    target.numberLL = finder.castView(view, 2131624170, "field 'numberLL'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624172, "field 'passwordLL' and method 'onClick'");
    target.passwordLL = finder.castView(view, 2131624172, "field 'passwordLL'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624174, "field 'submitTV' and method 'onClick'");
    target.submitTV = finder.castView(view, 2131624174, "field 'submitTV'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624167, "field 'emailTV'");
    target.emailTV = finder.castView(view, 2131624167, "field 'emailTV'");
    view = finder.findRequiredView(source, 2131624169, "field 'nameTV'");
    target.nameTV = finder.castView(view, 2131624169, "field 'nameTV'");
    view = finder.findRequiredView(source, 2131624171, "field 'numberTV'");
    target.numberTV = finder.castView(view, 2131624171, "field 'numberTV'");
    view = finder.findRequiredView(source, 2131624173, "field 'passwordTV'");
    target.passwordTV = finder.castView(view, 2131624173, "field 'passwordTV'");
  }

  @Override public void reset(T target) {
    target.logo = null;
    target.emailLL = null;
    target.nameLL = null;
    target.numberLL = null;
    target.passwordLL = null;
    target.submitTV = null;
    target.emailTV = null;
    target.nameTV = null;
    target.numberTV = null;
    target.passwordTV = null;
  }
}
