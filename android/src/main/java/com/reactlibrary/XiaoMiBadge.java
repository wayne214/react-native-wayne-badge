package com.reactlibrary;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import com.facebook.react.bridge.ReactApplicationContext;
import com.reactlibrary.R;

import me.leolin.shortcutbadger.ShortcutBadger;

public class XiaoMiBadge {

    private static final String NOTIFICATION_CHANNEL = "com.rnproject.badge";
    private NotificationManager mNotificationManager;
    private int notificationId = 0;

    private volatile static XiaoMiBadge instance;

    private XiaoMiBadge(){}

    public static XiaoMiBadge getInstance(){
        if(instance == null){
            synchronized (XiaoMiBadge.class){
                if(instance == null){
                    instance = new XiaoMiBadge();
                }
            }
        }
        return instance;
    }

    public void applyCount(ReactApplicationContext reactContext, int badgeCount) {
        mNotificationManager = (NotificationManager) reactContext.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.cancel(notificationId);
        notificationId++;

        Notification.Builder builder = new Notification.Builder(reactContext)
                .setContentTitle("")
                .setContentText("")
                .setSmallIcon(R.drawable.ic_launcher)
                .setNumber(int badgeCount);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setupNotificationChannel();
            builder.setChannelId(NOTIFICATION_CHANNEL);
        }

        Notification notification = builder.build();
        ShortcutBadger.applyNotification(reactContext, notification, badgeCount);
        mNotificationManager.notify(notificationId, notification);
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void setupNotificationChannel() {
        NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL, "ShortcutBadger Sample",
                NotificationManager.IMPORTANCE_DEFAULT);

        mNotificationManager.createNotificationChannel(channel);
    }
}
