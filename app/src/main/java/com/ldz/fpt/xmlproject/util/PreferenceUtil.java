package com.ldz.fpt.xmlproject.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by linhdq on 7/1/17.
 */

public class PreferenceUtil {
    private static final String APP_NAME = "loto";
    private static final String REMEMBER_ME = "remember_me";
    private static final String PRICE_ON_EACH_POINT_LO = "lo_price";
    private static SharedPreferences sharedPreferences;

    public PreferenceUtil(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE);
    }

    private static PreferenceUtil inst;

    public static PreferenceUtil getInst(Context context) {
        if (inst == null) {
            inst = new PreferenceUtil(context);
        }
        return inst;
    }

    public void setRememberMe(boolean isRemember) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(REMEMBER_ME, isRemember);
        editor.commit();
    }

    public boolean isRememberMe() {
        return sharedPreferences.getBoolean(REMEMBER_ME, false);
    }

    public void setLoPrice(float price) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(PRICE_ON_EACH_POINT_LO, price);
        editor.commit();
    }

    public float getLoPrice() {
        return sharedPreferences.getFloat(PRICE_ON_EACH_POINT_LO, 0);
    }

    public String getLastTimeUpdated(String key) {
        return sharedPreferences.getString(key, "Chưa cập nhật");
    }

    public void setLastTimeUpdated(String key, String time) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, time);
        editor.commit();
    }
}
