
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNReactNativeWayneBadgeModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNReactNativeWayneBadgeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNReactNativeWayneBadge";
  }

  @ReactMethod
  public void applyCount(int badgeCount){
      if (reactContext != null){
          if(Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")){
              XiaoMiBadge.getInstance().applyCount(reactContext, badgeCount);
          }else {
              ShortcutBadger.applyCount(reactContext, badgeCount);
          }
      }
  }

  @ReactMethod
  public void removeCount(){
      if (reactContext != null){
          ShortcutBadger.removeCount(reactContext);
      }
  }
}
