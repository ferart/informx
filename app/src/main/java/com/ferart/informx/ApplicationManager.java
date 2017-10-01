package com.ferart.informx;

import android.app.Application;

/**
 * Created by Ferart on 8/27/2017.
 */

public class ApplicationManager extends Application {

    private MainComponent mainComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mainComponent= DaggerMainComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public MainComponent getMainComponent() {
        return mainComponent;
    }
}
