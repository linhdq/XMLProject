package com.ldz.fpt.xmlproject.acitivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.ldz.fpt.xmlproject.R;
import com.ldz.fpt.xmlproject.database.DBContext;
import com.ldz.fpt.xmlproject.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = ProfileActivity.class.getSimpleName();
    //view
    @BindView(R.id.imv_profile)
    protected CircleImageView imvProfile;
    @BindView(R.id.txt_role)
    protected TextView txtRole;
    @BindView(R.id.edt_username)
    protected EditText edtUsername;
    @BindView(R.id.edt_fullname)
    protected EditText edtFullName;
    @BindView(R.id.edt_phone_number)
    protected EditText edtPhoneNumber;
    @BindView(R.id.view_fliper)
    protected ViewFlipper viewFlipper;
    @BindView(R.id.btn_change_password)
    protected Button btnChangePassword;
    @BindView(R.id.btn_update_profile)
    protected Button btnUpdateProfile;
    @BindView(R.id.btn_change)
    protected Button btnChange;
    @BindView(R.id.btn_save)
    protected Button btnSave;
    //
    private User user;
    //database
    private DBContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //
        getSupportActionBar().setTitle("Thông tin cá nhân");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //
        ButterKnife.bind(this);
        //
        init();
        addListener();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void init() {
        //view
        imvProfile.setEnabled(false);
        //
        dbContext = new DBContext(this);
        user = dbContext.checkLoginSuccess();
        //
        String role = "";
        if (user.getRole() == 0) {
            role = "SuperAdmin";
        } else if (user.getRole() == 1) {
            role = "Admin";
        } else {
            role = "Client";
        }
        txtRole.setText(String.format("Role: %s", role));
        edtUsername.setText(user.getUsername());
        edtFullName.setText(user.getFullName());
        edtPhoneNumber.setText(user.getPhoneNumber());
    }

    private void addListener() {
        imvProfile.setOnClickListener(this);
        btnChange.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnChangePassword.setOnClickListener(this);
        btnUpdateProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_change:

                break;
            case R.id.btn_save:
                edtFullName.setEnabled(false);
                edtPhoneNumber.setEnabled(false);
                imvProfile.setEnabled(false);
                viewFlipper.setDisplayedChild(0);
                txtRole.requestFocus();
                break;
            case R.id.btn_change_password:

                break;
            case R.id.btn_update_profile:
                edtFullName.setEnabled(true);
                edtPhoneNumber.setEnabled(true);
                imvProfile.setEnabled(true);
                viewFlipper.setDisplayedChild(1);
                edtFullName.requestFocus();
                break;
            case R.id.imv_profile:

                break;
            default:
                break;
        }
    }
}
