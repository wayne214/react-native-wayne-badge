#import <Foundation/Foundation.h>
#import "RNReactNativeWayneBadge.h"

//本地角标
#define APP_BADGE @"appBadge"

@implementation RNReactNativeWayneBadge

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_MODULE(RNWayneBadge);

RCT_EXPORT_METHOD(start) {
    //  do nothing (兼容安卓的 start 方法)
}

RCT_EXPORT_METHOD(setBadge:(NSInteger *)number)
{
        if(number < 0) return;
        dispatch_async(dispatch_get_main_queue(), ^{
            [[UIApplication sharedApplication] setApplicationIconBadgeNumber:(NSInteger)number];
        });

}

@end
