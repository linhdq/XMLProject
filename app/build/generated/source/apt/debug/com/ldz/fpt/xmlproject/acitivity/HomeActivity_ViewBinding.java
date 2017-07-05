// Generated code from Butter Knife. Do not modify!
package com.ldz.fpt.xmlproject.acitivity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ldz.fpt.xmlproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeActivity_ViewBinding<T extends HomeActivity> implements Unbinder {
  protected T target;

  @UiThread
  public HomeActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.drawerLayout = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawerLayout'", DrawerLayout.class);
    target.btnProfile = Utils.findRequiredViewAsType(source, R.id.btn_view_profile, "field 'btnProfile'", Button.class);
    target.listViewDrawer = Utils.findRequiredViewAsType(source, R.id.list_drawer, "field 'listViewDrawer'", ListView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.drawerLayout = null;
    target.btnProfile = null;
    target.listViewDrawer = null;

    this.target = null;
  }
}
