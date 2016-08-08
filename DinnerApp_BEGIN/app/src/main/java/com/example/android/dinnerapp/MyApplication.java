package com.example.android.dinnerapp;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by trama on 08/08/16.
 */
public class MyApplication extends Application{

    private Tracker mTracker;

    public void startTracking(){

        if(mTracker == null){
            GoogleAnalytics instance = GoogleAnalytics.getInstance(this);
            mTracker = instance.newTracker(R.xml.track_app);
            instance.enableAutoActivityReports(this);
        }
    }

    public Tracker getTracker() {
        startTracking();
        return mTracker;
    }
}
