package com.ferart.informx;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ferart on 15/10/2016.
 */
@Module
public class ApplicationModule {

    private Application context;

    public ApplicationModule(Application context) {
        this.context = context;
    }

    @Provides
    SharedPreferences providesSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

}
