// Generated code from Butter Knife. Do not modify!
package com.ldz.fpt.xmlproject.acitivity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ldz.fpt.xmlproject.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProfileActivity_ViewBinding<T extends ProfileActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ProfileActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.imvProfile = Utils.findRequiredViewAsType(source, R.id.imv_profile, "field 'imvProfile'", CircleImageView.class);
    target.txtRole = Utils.findRequiredViewAsType(source, R.id.txt_role, "field 'txtRole'", TextView.class);
    target.edtUsername = Utils.findRequiredViewAsType(source, R.id.edt_username, "field 'edtUsername'", EditText.class);
    target.edtFullName = Utils.findRequiredViewAsType(source, R.id.edt_fullname, "field 'edtFullName'", EditText.class);
    target.edtPhoneNumber = Utils.findRequiredViewAsType(source, R.id.edt_phone_number, "field 'edtPhoneNumber'", EditText.class);
    target.viewFlipper = Utils.findRequiredViewAsType(source, R.id.view_fliper, "field 'viewFlipper'", ViewFlipper.class);
    target.btnChangePassword = Utils.findRequiredViewAsType(source, R.id.btn_change_password, "field 'btnChangePassword'", Button.class);
    target.btnUpdateProfile = Utils.findRequiredViewAsType(source, R.id.btn_update_profile, "field 'btnUpdateProfile'", Button.class);
    target.btnChange = Utils.findRequiredViewAsType(source, R.id.btn_change, "field 'btnChange'", Button.class);
    target.btnSave = Utils.findRequiredViewAsType(source, R.id.btn_save, "field 'btnSave'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.imvProfile = null;
    target.txtRole = null;
    target.edtUsername = null;
    target.edtFullName = null;
    target.edtPhoneNumber = null;
    target.viewFlipper = null;
    target.btnChangePassword = null;
    target.btnUpdateProfile = null;
    target.btnChange = null;
    target.btnSave = null;

    this.target = null;
  }
}
