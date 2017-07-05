// Generated code from Butter Knife. Do not modify!
package com.ldz.fpt.xmlproject.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ldz.fpt.xmlproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AdminHomeFragment_ViewBinding<T extends AdminHomeFragment> implements Unbinder {
  protected T target;

  @UiThread
  public AdminHomeFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.txtDate = Utils.findRequiredViewAsType(source, R.id.txt_date, "field 'txtDate'", TextView.class);
    target.txtUpdateTime = Utils.findRequiredViewAsType(source, R.id.time_updated, "field 'txtUpdateTime'", TextView.class);
    target.viewSwitcherUpdate = Utils.findRequiredViewAsType(source, R.id.view_switcher_update, "field 'viewSwitcherUpdate'", ViewSwitcher.class);
    target.viewSwitcherDe = Utils.findRequiredViewAsType(source, R.id.view_switcher_de, "field 'viewSwitcherDe'", ViewSwitcher.class);
    target.viewSwitcher3Cang = Utils.findRequiredViewAsType(source, R.id.view_switcher_3_cang, "field 'viewSwitcher3Cang'", ViewSwitcher.class);
    target.viewSwitcherLo = Utils.findRequiredViewAsType(source, R.id.view_switcher_lo, "field 'viewSwitcherLo'", ViewSwitcher.class);
    target.viewSwitcherLoXien2 = Utils.findRequiredViewAsType(source, R.id.view_switcher_lo_xien_2, "field 'viewSwitcherLoXien2'", ViewSwitcher.class);
    target.viewSwitcherLoXien3 = Utils.findRequiredViewAsType(source, R.id.view_switcher_lo_xien_3, "field 'viewSwitcherLoXien3'", ViewSwitcher.class);
    target.viewSwitcherLoXien4 = Utils.findRequiredViewAsType(source, R.id.view_switcher_lo_xien_4, "field 'viewSwitcherLoXien4'", ViewSwitcher.class);
    target.recyclerViewDe = Utils.findRequiredViewAsType(source, R.id.recycler_view_de, "field 'recyclerViewDe'", RecyclerView.class);
    target.recyclerView3Cang = Utils.findRequiredViewAsType(source, R.id.recycler_view_3_cang, "field 'recyclerView3Cang'", RecyclerView.class);
    target.recyclerViewLo = Utils.findRequiredViewAsType(source, R.id.recycler_view_lo, "field 'recyclerViewLo'", RecyclerView.class);
    target.recyclerViewLoXien2 = Utils.findRequiredViewAsType(source, R.id.recycler_view_lo_xien_2, "field 'recyclerViewLoXien2'", RecyclerView.class);
    target.recyclerViewLoXien3 = Utils.findRequiredViewAsType(source, R.id.recycler_view_lo_xien_3, "field 'recyclerViewLoXien3'", RecyclerView.class);
    target.recyclerViewLoXien4 = Utils.findRequiredViewAsType(source, R.id.recycler_view_lo_xien_4, "field 'recyclerViewLoXien4'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.txtDate = null;
    target.txtUpdateTime = null;
    target.viewSwitcherUpdate = null;
    target.viewSwitcherDe = null;
    target.viewSwitcher3Cang = null;
    target.viewSwitcherLo = null;
    target.viewSwitcherLoXien2 = null;
    target.viewSwitcherLoXien3 = null;
    target.viewSwitcherLoXien4 = null;
    target.recyclerViewDe = null;
    target.recyclerView3Cang = null;
    target.recyclerViewLo = null;
    target.recyclerViewLoXien2 = null;
    target.recyclerViewLoXien3 = null;
    target.recyclerViewLoXien4 = null;

    this.target = null;
  }
}
