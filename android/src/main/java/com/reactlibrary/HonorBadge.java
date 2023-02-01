package com.reactlibrary;
import android.app.NotificationManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import com.facebook.react.bridge.ReactApplicationContext;

public class HonorBadge {

    private volatile static HonorBadge instance;

    private HonorBadge(){}

    public static HonorBadge getInstance(){
        if(instance == null){
            synchronized (HonorBadge.class){
                if(instance == null){
                    instance = new HonorBadge();
                }
            }
        }
        return instance;
    }

    public void applyCount(ReactApplicationContext reactContext, int num) {
        String URI_OLD = "content://com.huawei.android.launcher.settings/badge/";
        String URI_NEW = "content://com.hihonor.android.launcher.settings/badge/";
        Uri uri = Uri.parse(URI_NEW);
        String type = reactContext.getContentResolver().getType(uri);
        if (TextUtils.isEmpty(type)) {
            uri = Uri.parse(URI_OLD);
            type = reactContext.getContentResolver().getType(uri);
            if (TextUtils.isEmpty(type)) {
                uri = null;
            }
        }
        try {
            Bundle extra = new Bundle();
            extra.putString("package", "com.rnproject");
            extra.putString("class", "com.rnproject.MainActivity");
            extra.putInt("badgenumber", num);
            if (uri != null) {
                reactContext.getContentResolver().call(uri, "change_badge", null, extra);
            }
        } catch (Exception e) {
            e.printStackTrace(); }
    }
}
