package com.ferart.informx.models.data;

import android.content.SharedPreferences;

import com.ferart.informx.models.data.preferences.AccessPreferencesDAO;
import com.ferart.informx.models.data.preferences.AccessPreferencesDAOImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ferart on 8/27/2017.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    AccessPreferencesDAO providesAccessPreferences(SharedPreferences sharedPreferences){
        return new AccessPreferencesDAOImpl(sharedPreferences);
    }
}
