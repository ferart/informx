package com.ferart.informx;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by Ferart on 8/27/2017.
 */

public class ApplicationManager extends Application {

    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        mainComponent= DaggerMainComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
