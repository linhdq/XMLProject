package com.ldz.fpt.xmlproject.fragment;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ldz.fpt.xmlproject.R;
import com.ldz.fpt.xmlproject.acitivity.HomeActivity;
import com.ldz.fpt.xmlproject.adapter.ListUserAdapter;
import com.ldz.fpt.xmlproject.database.DBContext;
import com.ldz.fpt.xmlproject.model.User;
import com.ldz.fpt.xmlproject.model.ResponseModel;
import com.ldz.fpt.xmlproject.network.GetService;
import com.ldz.fpt.xmlproject.network.ServiceFactory;
import com.ldz.fpt.xmlproject.network.model.XMLLoginSendForm;
import com.ldz.fpt.xmlproject.network.model.XmlDeleteAccount;
import com.ldz.fpt.xmlproject.util.Constant;
import com.ldz.fpt.xmlproject.xml_parser.XMLParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by linhdq on 7/4/17.
 */

public class SuperAdminHomeFragment extends Fragment {
    private static final String TAG = SuperAdminHomeFragment.class.getSimpleName();
    //view
    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;
    //
    private Context context;
    //
    private ListUserAdapter listUserAdapter;
    //
    private List<User> listUser;
    //
    private DBContext dbContext;
    //
    private GetService getService;
    private XMLParser xmlParser;
    private XMLLoginSendForm sendForm;
    private XmlDeleteAccount xmlDeleteAccount;
    private User user;
    //
    private HomeActivity homeActivity;
    //
    private boolean isFirst;
    //
    private Paint paint;
    private AlertDialog.Builder alertDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_super_admin_home, container, false);
        ButterKnife.bind(this, view);
        init(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        configRecyclerView();
        if (user == null) {
            user = dbContext.checkLoginSuccess();
        }
        if (isFirst && user != null) {
            sendForm = new XMLLoginSendForm(user.getUsername(), user.getPassword());
            getAllAdmins(sendForm.getRequestBody());
            isFirst = false;
        }
    }

    private void init(View view) {
        homeActivity = (HomeActivity) getActivity();
        context = view.getContext();
        //
        dbContext = new DBContext(context);
        xmlParser = XMLParser.getInst();
        //network
        getService = ServiceFactory.getInstance().createService(GetService.class);
        //
        isFirst = true;
        listUser = new ArrayList<>();
        //
        paint = new Paint();
    }

    private void configRecyclerView() {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        listUserAdapter = new ListUserAdapter(context, listUser);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listUserAdapter);
        initSwipe();
    }

    private void getAllAdmins(RequestBody data) {
        Call<ResponseBody> call = getService.callXmlGetAllAdmins(data);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == Constant.OK_STATUS) {
                    try {
                        String xml = response.body().string();
                        listUser.addAll(xmlParser.getAllAdmins(xml));
                        listUserAdapter.notifyDataSetChanged();
                        Log.d(TAG, "onResponse: " + listUser.size());
                        Log.d(TAG, "onResponse: " + listUser.get(0).getFullName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    homeActivity.showToast("Login failed! Please try again.");
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                homeActivity.showToast("Login failed! Please check your connection.");
            }
        });
    }

    private void initSwipe() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                if (direction == ItemTouchHelper.LEFT) {
                    initDialog(dbContext.getUserModel().getUsername(), listUser.get(position).getUsername(), position);
                } else {
                    callToUser(listUser.get(position).getPhoneNumber());
                }
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                Bitmap icon;

                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;

                    if (dX > 0) {
                        paint.setColor(Color.parseColor("#388E3C"));
                        RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX, (float) itemView.getBottom());
                        c.drawRect(background, paint);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_phone_white_48dp);
                        RectF icon_dest = new RectF((float) itemView.getLeft() + width, (float) itemView.getTop() + width, (float) itemView.getLeft() + 2 * width, (float) itemView.getBottom() - width);
                        c.drawBitmap(icon, null, icon_dest, paint);
                    } else {
                        paint.setColor(Color.parseColor("#FF0000"));
                        RectF backGround = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(backGround, paint);
                        icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_delete_white_48dp);
                        RectF icon_dest = new RectF((float) itemView.getRight() - 2 * width, (float) itemView.getTop() + width, (float) itemView.getRight() - width, (float) itemView.getBottom() - width);
                        c.drawBitmap(icon, null, icon_dest, paint);
                    }
                }

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void callToUser(String phoneNumber) {
        Uri call = Uri.parse("tel:" + phoneNumber);
        Intent callIntent = new Intent(Intent.ACTION_CALL, call);
        startActivity(callIntent);
    }

    private void reloadData(ResponseModel responseModel, int position) {
        if (responseModel.isStatus()) {
            listUserAdapter.removeItem(position);
        }
        homeActivity.showToast(responseModel.getMessage());
    }

    private void deleteAccountService(RequestBody requestBody, final int position) {
        Call<ResponseBody> call = getService.callDeleteAccountAdmin(requestBody);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == Constant.OK_STATUS) {
                    try {
                        String xml = response.body().string();
                        ResponseModel responseModel = xmlParser.getResponseModel(xml);
                        reloadData(responseModel, position);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    homeActivity.showToast("Something went wrong! Please try again later.");
                    configRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                homeActivity.showToast("Login failed! Please check your connection.");
            }
        });
    }

    private void initDialog(final String userNameRequest, final String userNameDelete, final int position) {
        alertDialog = new AlertDialog.Builder(context);
        alertDialog.setTitle("Delete Account")
                .setMessage("Are you sure you want to delete this account?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        xmlDeleteAccount = new XmlDeleteAccount(userNameRequest, userNameDelete);
                        deleteAccountService(xmlDeleteAccount.getRequestBody(), position);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        configRecyclerView();
                    }
                })
                .show();
    }

}
