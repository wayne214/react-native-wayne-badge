#import <Foundation/Foundation.h>
#import "RNReactNativeWayneBadge.h"

//本地角标
#define APP_BADGE @"appBadge"

@implementation RNReactNativeWayneBadge

RCT_EXPORT_MODULE(RNWayneBadge);

RCT_EXPORT_METHOD(setBadge:(NSDictionary *)params)
{
    if (params[APP_BADGE]) {
        NSNumber *number = params[APP_BADGE];
        if(number < 0) return;
        dispatch_async(dispatch_get_main_queue(), ^{
            [UIApplication sharedApplication].applicationIconBadgeNumber = [number integerValue];
        });
    }
}

@end
