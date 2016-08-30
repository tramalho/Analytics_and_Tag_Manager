package com.example.android.dinnerapp;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class AnalyticsUtil {

    public void trackScreen(String screen, Application application) {
        MyApplication app = (MyApplication) application;
        Tracker tracker = app.getTracker();
        tracker.setScreenName(screen);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
