package com.example.android.dinnerapp;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class AnalyticsUtil {

    public void trackScreen(String screen, Application application) {
        Tracker tracker = getTracker(application);
        tracker.setScreenName(screen);
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public void trackEvent(UtilEvent utilEvent, Application application) {
        Tracker tracker = getTracker(application);

        HitBuilders.EventBuilder eventBuilder = new HitBuilders.EventBuilder();
        eventBuilder
                .setCategory(utilEvent.category)
                .setAction(utilEvent.action)
                .setLabel(utilEvent.label);

        tracker.send(eventBuilder.build());
    }


    private Tracker getTracker(Application application) {
        MyApplication app = (MyApplication) application;
        return app.getTracker();
    }

    public static class UtilEvent{

        String category;
        String label;
        String action;

        public UtilEvent(String category, String label, String action) {
            this.category = category;
            this.label = label;
            this.action = action;
        }
    }

}
