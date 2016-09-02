package com.example.android.dinnerapp;

import android.app.Application;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;

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

    public void trackProduct(String description, Application application) {

        Product product = new Product()
                .setName("dinner")
                .setPrice(5)
                .setId(description)
                .setVariant(description)
                .setQuantity(1);


        HitBuilders.EventBuilder eventBuilder = new HitBuilders.EventBuilder();

        eventBuilder
                .setCategory("Shopping steps")
                .setAction("View Order Dinner Screen")
                .setLabel(description)
                .addProduct(product)
                .setProductAction(new ProductAction(ProductAction.ACTION_DETAIL));

        Tracker tracker = getTracker(application);
        tracker.send(eventBuilder.build());
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
