package com.ferart.informx.presenters;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ferart on 8/27/2017.
 */

@Module
public class PresentersModule {

    @Provides
    @Singleton
    public MainPresenter providesMainPresenter(){
        return new MainPresenterImpl();
    }

}
