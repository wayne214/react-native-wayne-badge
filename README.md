# react-native-wayne-badge
跨平台设置Android和iOS平台应用角标

## 开始

`$ npm install react-native-wayne-badge --save`

or

`$ yarn add react-native-wayne-badge`

ios端

`pod install`

## 使用
```javascript
// 导入包
import RNWayneBadge from 'react-native-wayne-badge';

// 使用包
RNWayneBadge.setBadge(1);
```
## 注意事项
### Android端需要添加通知权限
```
private void setupNotificationChannel() {
    NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    Notification notification = null;
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel channel = new NotificationChannel("com.chengfenghuoyun.crm", "notification_channel",
                NotificationManager.IMPORTANCE_HIGH);
        mNotificationManager.createNotificationChannel(channel);
        notification = new Notification.Builder(getApplicationContext(), "com.chengfenghuoyun.crm")
                .setContentTitle("")
                .setContentText("")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
    } else {
        notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("")
                .setContentText("")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();
    }
    mNotificationManager.notify(1, notification);
}
```
### ios端需要申请通知权限
```
在AppDelegate.m文件中
1. 导入UNUserNotificationCenter
#import <UserNotifications/UNUserNotificationCenter.h>
2. 在AppDelegate中引用
@interface AppDelegate () <RCTBridgeDelegate, UNUserNotificationCenterDelegate>
3. 申请通知权限
  UNUserNotificationCenter *center = [UNUserNotificationCenter currentNotificationCenter];
    center.delegate = self;
    [center requestAuthorizationWithOptions:(UNAuthorizationOptionSound | UNAuthorizationOptionAlert | UNAuthorizationOptionBadge) completionHandler:^(BOOL granted, NSError * _Nullable error) {
    }];
```
