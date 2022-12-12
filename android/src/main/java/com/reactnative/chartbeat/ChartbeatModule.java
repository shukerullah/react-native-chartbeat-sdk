package com.reactnative.chartbeat;

import android.content.Context;
import androidx.annotation.NonNull;
import com.chartbeat.androidsdk.Tracker;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = ChartbeatModule.NAME)
public class ChartbeatModule extends ReactContextBaseJavaModule {
  public static final String NAME = "Chartbeat";

  private final Context context;

  public ChartbeatModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.context = reactContext.getApplicationContext();
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  /**
    * initializes the tracker. If the tracker has already been initialized,
    * this call will be ignored.
    *
    * @param accountId
    *            your account id on the Chartbeat system. e.g. 12345
    * @param domain
    *            the chartbeat dashboard domain name you want to report analytics data to, e.g.
    *            "mynewspaper.com".
    */
  @ReactMethod
  public void setupTracker(Double accountId, String domain) {
    Tracker.setupTracker(accountId + "", domain, context);
  }

  /**
    * Call this to set the app referrer. This is a referrer that is external to
    * the app, such as another app or website. This should be called
    * immediately before calling trackView. If the tracker has not been
    * initialized, this call will be ignored.
    *
    * @param appReferrer
    *            the string representing the appReferrer.
    */
  @ReactMethod
  public void setAppReferrer(String appReferrer) {
    Tracker.setAppReferrer(appReferrer);
  }

  /**
    * Call this to set the app's push referrer. This is the id of the push alert referrer
    * This should be called
    * immediately before calling trackView. If the tracker has not been
    * initialized, this call will be ignored.
    *
    * @param pushReferrer
    *            the string representing the pushReferrer.
    */
  @ReactMethod
  public void setPushReferrer(String pushReferrer) {
    Tracker.setPushReferrer(pushReferrer);
  }

  /**
    * Stops the tracker if one has been previously started. Most apps will not
    * need to call this function.
    */
  @ReactMethod
  public void stopTracker() {
    Tracker.stopTracker();
  }

  /**
    * Pauses the tracker for idle applications
    */
  @ReactMethod
  public void pauseTracker() {
    Tracker.pauseTracker();
  }

  /**
    * Pauses the tracker for idle applications
    */
  @ReactMethod
  public void backgroundTracker() {
    Tracker.backgroundTracker();
  }

  /**
    * Call this whenever you display a new view. Use this in views where you are not tracking position.
    *  If the tracker has not been initialized, this call will be ignored.
    *
    * @param viewId
    *            the id of the view being displayed. Must not be null.
    * @param viewTitle
    *            the title of the view. may be null.
    */
  @ReactMethod
  public void trackView(String viewId, String viewTitle) {
    Tracker.trackView(context, viewId, viewTitle);
  }

  /**
    * Call this whenever you display a new view. Use this in views where you are tracking position.
    *  If the tracker has not been
    * initialized, this call will be ignored.
    *
    * @param viewId
    *            the id of the view being displayed. Must not be null.
    * @param viewTitle
    *            the title of the view. may be null.
    * @param scrollPositionTop
    *            Scroll Position Top
    * @param scrollWindowHeight
    *            Scroll Window Height
    * @param totalContentHeight
    *            Total Content Height
    * @param fullyRenderedDocWidth
    *            Width of the document fully rendered
    */
  // @ReactMethod
  // public void trackView(String viewId, String viewTitle,
  //                               int scrollPositionTop, int scrollWindowHeight,
  //                               int totalContentHeight, int fullyRenderedDocWidth) {
  //   Tracker.trackView(context, viewId, viewTitle, scrollPositionTop, scrollWindowHeight,
  //             totalContentHeight, fullyRenderedDocWidth);
  // }

  /**
    * Call this whenever the user leaves an activity. This will be used as a
    * hint that the user might have left the app. If the tracker has not been
    * initialized, this call will be ignored.
    */
  @ReactMethod
  public void userLeftView(String viewId) {
    Tracker.userLeftView(viewId);
  }

  /**
    * Call this whenever the user interacts with your app. If the tracker has
    * not been initialized, this call will be ignored. You will likely want to
    * put this in your onUserInteraction() function of your activity.
    */
  @ReactMethod
  public static void userInteracted() {
    Tracker.userInteracted();
  }

  /**
    * Call this whenever the user is writing/typing. If the tracker has not
    * been initialized, this call will be ignored.
    */
  @ReactMethod
  public void userTyped() {
    Tracker.userTyped();
  }

  /**
    * Call this method to set the domain for the current view. This will only need be done if
    * the app needs to send data to different dashboards depending on the view. See our main
    * documentation about domain/subdomain settings for clarification, if you think you may need
    * to use this setting.
    *
    * @param domain
    *            the domain name that the current view should track under.
    */
  @ReactMethod
  public void setDomain(String domain) {
    Tracker.setDomain(domain);
  }

  /**
    * Call this method to set the subdomain for the current view. This will not
    * be necessary in most situations since the subdomain will automatically default
    * to the domain setting. See our main documentation about domain/subdomain settings
    * for clarification, if you think you may need to use this setting.
    *
    * @param subdomain
    *            the subdomain name that the current view should track under.
    */
  @ReactMethod
  public void setSubdomain(String subdomain) {
    Tracker.setSubdomain(subdomain);
  }

  /**
    * Call this method to set the zone(s) for the current view. This data will
    * be purged when changing the view, so be sure to call this after
    * calling trackView().
    *
    * @param zones
    *            a comma-delimited list of zones.
    */
  @ReactMethod
  public void setZones(String zones) {
    Tracker.setZones(zones);
  }

  /**
    * Call this method to set the user as a paid subscriber.
    * This should be called once per execution of the app or
    * whenever the user's state changes.
    */
  @ReactMethod
  public void setUserPaid() {
    Tracker.setUserPaid();
  }

  /**
    * Call this method to set the user as a logged in user.
    * This should be called once per execution of the app or
    * whenever the user's state changes.
    */
  @ReactMethod
  public void setUserLoggedIn() {
    Tracker.setUserLoggedIn();
  }

  /**
    * Call this method to set the user as an anonymous user.
    * This should be called once per execution of the app or
    * whenever the user's state changes.
    */
  @ReactMethod
  public void setUserAnonymous() {
    Tracker.setUserAnonymous();
  }

  /**
    * Call this method to set the author(s) for the current view. This data
    * will be purged when changing the view, so be sure to call this after
    * calling trackView().
    *
    * @param authors
    *            a comma-delimited list of authors.
    */
  @ReactMethod
  public void setAuthors(String authors) {
    Tracker.setAuthors(authors);
  }

  /**
    * Call this method to set the section(s) for the current view. This data
    * will be purged when changing the view, so be sure to call this after
    * calling trackView().
    *
    * @param sections
    *            a comma-delimited list of sections.
    */
  @ReactMethod
  public void setSections(String sections) {
    Tracker.setSections(sections);
  }

  /**
    * Call this to set the load time of the current page/view. This data will
    * be purged when changing the view, so be sure to call this after
    * calling trackView().
    */
  @ReactMethod
  public void setViewLoadTime(float pageLoadTime) {
    Tracker.setViewLoadTime(pageLoadTime);
  }

  /**
    * sets the position of the current view, assuming it scrolls. If it does
    * not scroll, don't call this function. Negative values will not be passed
    * to the server.
    *
    * @param scrollPositionTop
    *            Scroll Position Top
    * @param scrollWindowHeight
    *            Scroll Window Height
    * @param totalContentHeight
    *            Total Content Height
    * @param fullyRenderedDocWidth
    *            Width of the document fully rendered
    */
  @ReactMethod
  public void setPosition(int scrollPositionTop, int scrollWindowHeight, int totalContentHeight, int fullyRenderedDocWidth) {
    Tracker.setPosition(scrollPositionTop, scrollWindowHeight, totalContentHeight, fullyRenderedDocWidth);
  }
}