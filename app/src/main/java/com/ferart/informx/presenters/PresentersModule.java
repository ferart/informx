package com.ferart.informx.presenters;

import com.ferart.informx.models.domain.usermanager.CreateUserInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ferart on 8/27/2017.
 */

@Module
public class PresentersModule {

    @Provides
    public MainScreenPresenter providesMainPresenter(CreateUserInteractor createUserInteractor){
        return new MainScreenPresenterImpl(createUserInteractor);
    }

}
