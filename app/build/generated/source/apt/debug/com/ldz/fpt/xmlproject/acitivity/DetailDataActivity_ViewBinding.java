// Generated code from Butter Knife. Do not modify!
package com.ldz.fpt.xmlproject.acitivity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ldz.fpt.xmlproject.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailDataActivity_ViewBinding<T extends DetailDataActivity> implements Unbinder {
  protected T target;

  @UiThread
  public DetailDataActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.viewFlipper = Utils.findRequiredViewAsType(source, R.id.view_fliper, "field 'viewFlipper'", ViewFlipper.class);
    target.txtDateDe = Utils.findRequiredViewAsType(source, R.id.txt_date_de, "field 'txtDateDe'", TextView.class);
    target.txtNumberDe = Utils.findRequiredViewAsType(source, R.id.txt_number_de, "field 'txtNumberDe'", TextView.class);
    target.txtPriceDe = Utils.findRequiredViewAsType(source, R.id.txt_price_de, "field 'txtPriceDe'", TextView.class);
    target.recyclerViewDe = Utils.findRequiredViewAsType(source, R.id.recycler_view_de, "field 'recyclerViewDe'", RecyclerView.class);
    target.txtDateBaCang = Utils.findRequiredViewAsType(source, R.id.txt_date_ba_cang, "field 'txtDateBaCang'", TextView.class);
    target.txtNumberBaCang = Utils.findRequiredViewAsType(source, R.id.txt_number_ba_cang, "field 'txtNumberBaCang'", TextView.class);
    target.txtPriceBaCang = Utils.findRequiredViewAsType(source, R.id.txt_price_ba_cang, "field 'txtPriceBaCang'", TextView.class);
    target.recyclerViewBaCang = Utils.findRequiredViewAsType(source, R.id.recycler_view_ba_cang, "field 'recyclerViewBaCang'", RecyclerView.class);
    target.txtDateLo = Utils.findRequiredViewAsType(source, R.id.txt_date_lo, "field 'txtDateLo'", TextView.class);
    target.txtNumberLo = Utils.findRequiredViewAsType(source, R.id.txt_number_lo, "field 'txtNumberLo'", TextView.class);
    target.txtPointLo = Utils.findRequiredViewAsType(source, R.id.txt_point_lo, "field 'txtPointLo'", TextView.class);
    target.recyclerViewLo = Utils.findRequiredViewAsType(source, R.id.recycler_view_lo, "field 'recyclerViewLo'", RecyclerView.class);
    target.txtDateLoXien2 = Utils.findRequiredViewAsType(source, R.id.txt_date_lo_xien_2, "field 'txtDateLoXien2'", TextView.class);
    target.txtNumberLoXien2 = Utils.findRequiredViewAsType(source, R.id.txt_number_lo_xien_2, "field 'txtNumberLoXien2'", TextView.class);
    target.txtPointLoXien2 = Utils.findRequiredViewAsType(source, R.id.txt_point_lo_xien_2, "field 'txtPointLoXien2'", TextView.class);
    target.recyclerViewLoXien2 = Utils.findRequiredViewAsType(source, R.id.recycler_view_lo_xien_2, "field 'recyclerViewLoXien2'", RecyclerView.class);
    target.txtDateLoXien3 = Utils.findRequiredViewAsType(source, R.id.txt_date_lo_xien_3, "field 'txtDateLoXien3'", TextView.class);
    target.txtNumberLoXien3 = Utils.findRequiredViewAsType(source, R.id.txt_number_lo_xien_3, "field 'txtNumberLoXien3'", TextView.class);
    target.txtPointLoXien3 = Utils.findRequiredViewAsType(source, R.id.txt_point_lo_xien_3, "field 'txtPointLoXien3'", TextView.class);
    target.recyclerViewLoXien3 = Utils.findRequiredViewAsType(source, R.id.recycler_view_lo_xien_3, "field 'recyclerViewLoXien3'", RecyclerView.class);
    target.txtDateLoXien4 = Utils.findRequiredViewAsType(source, R.id.txt_date_lo_xien_4, "field 'txtDateLoXien4'", TextView.class);
    target.txtNumberLoXien4 = Utils.findRequiredViewAsType(source, R.id.txt_number_lo_xien_4, "field 'txtNumberLoXien4'", TextView.class);
    target.txtPointLoXien4 = Utils.findRequiredViewAsType(source, R.id.txt_point_lo_xien_4, "field 'txtPointLoXien4'", TextView.class);
    target.recyclerViewLoXien4 = Utils.findRequiredViewAsType(source, R.id.recycler_view_lo_xien_4, "field 'recyclerViewLoXien4'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.viewFlipper = null;
    target.txtDateDe = null;
    target.txtNumberDe = null;
    target.txtPriceDe = null;
    target.recyclerViewDe = null;
    target.txtDateBaCang = null;
    target.txtNumberBaCang = null;
    target.txtPriceBaCang = null;
    target.recyclerViewBaCang = null;
    target.txtDateLo = null;
    target.txtNumberLo = null;
    target.txtPointLo = null;
    target.recyclerViewLo = null;
    target.txtDateLoXien2 = null;
    target.txtNumberLoXien2 = null;
    target.txtPointLoXien2 = null;
    target.recyclerViewLoXien2 = null;
    target.txtDateLoXien3 = null;
    target.txtNumberLoXien3 = null;
    target.txtPointLoXien3 = null;
    target.recyclerViewLoXien3 = null;
    target.txtDateLoXien4 = null;
    target.txtNumberLoXien4 = null;
    target.txtPointLoXien4 = null;
    target.recyclerViewLoXien4 = null;

    this.target = null;
  }
}
