
#import "RNReactNativeWayneBadge.h"

#define BADGE      @"badge"
//本地角标
#define APP_BADGE @"appBadge"

@implementation RNWayneBadge

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE(RNWayneBadge);
RCT_EXPORT_METHOD(applyCount:(NSDictionary *)params)
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
