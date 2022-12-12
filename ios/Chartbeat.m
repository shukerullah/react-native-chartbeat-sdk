#import "Chartbeat.h"
#import "CBTracker.h"

@implementation Chartbeat

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_METHOD(setupTracker:(int)uid domain:(NSString *)domain) {
    [[CBTracker sharedTracker] setupTrackerWithAccountId:uid
                                                  domain:domain];
}

RCT_EXPORT_METHOD(stopTracker) {
    [[CBTracker sharedTracker] stopTracker];
}

RCT_EXPORT_METHOD(setAuthors:(NSString *)authors) {
    [[CBTracker sharedTracker] setAuthors:authors];
}

RCT_EXPORT_METHOD(setSections:(NSString *)sections) {
    [[CBTracker sharedTracker] setSections:sections];
}

RCT_EXPORT_METHOD(trackView:(NSString *)viewId title:(NSString *)title) {
    UIView *rootView = [UIApplication sharedApplication].keyWindow.rootViewController.view;
    [[CBTracker sharedTracker] trackView:rootView
                                  viewId:viewId
                                   title:title];
}

RCT_EXPORT_METHOD(setDomain:(NSString *)domain) {
    [[CBTracker sharedTracker] setDomain:domain];
}

RCT_EXPORT_METHOD(setSubDomain:(NSString *)subDomain) {
    [[CBTracker sharedTracker] setSubDomain:subDomain];
}

RCT_EXPORT_METHOD(setUserPaid) {
    [[CBTracker sharedTracker] setUserPaid];
}

RCT_EXPORT_METHOD(setUserLoggedIn) {
    [[CBTracker sharedTracker] setUserLoggedIn];
}

RCT_EXPORT_METHOD(setUserAnonymous) {
    [[CBTracker sharedTracker] setUserAnonymous];
}

RCT_EXPORT_MODULE()

@end
