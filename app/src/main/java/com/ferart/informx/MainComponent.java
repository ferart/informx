package com.ferart.informx;

import com.ferart.informx.models.data.DataModule;
import com.ferart.informx.models.data.preferences.AccessPreferencesDAO;
import com.ferart.informx.models.domain.DomainModule;
import com.ferart.informx.models.domain.usermanager.CreateUserInteractor;
import com.ferart.informx.presenters.MainScreenPresenter;
import com.ferart.informx.presenters.PresentersModule;
import com.ferart.informx.views.ViewsModule;
import com.ferart.informx.views.activities.MainActivity;
import com.ferart.informx.views.common.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ferart on 8/27/2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ViewsModule.class, PresentersModule.class, DomainModule.class, DataModule.class})
public interface MainComponent {
     /*
     * MVP injections
     */

    /**
     * Views Layer
     */
    void inject(BaseActivity baseActivity);
    void inject(MainActivity mainActivity);

    /**
     *Presentation Layer
     */
    void inject(MainScreenPresenter mainPresenter);

    /**
     * Domain Layer
     */
    void inject(CreateUserInteractor createUserInteractor);

    /**
     * Data Layer
     */
    void inject(AccessPreferencesDAO accessPreferences);
}
