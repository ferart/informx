package com.ferart.informx.models.domain;

import com.ferart.informx.models.data.daos.UserDao;
import com.ferart.informx.models.domain.thread.Executor;
import com.ferart.informx.models.domain.thread.MainThread;
import com.ferart.informx.models.domain.thread.MainThreadImpl;
import com.ferart.informx.models.domain.thread.ThreadExecutor;
import com.ferart.informx.models.domain.usermanager.CreateUserInteractor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ferart on 8/27/2017.
 */

@Module
public class DomainModule {

    @Provides
    @Singleton
    public Executor providesExecutor() {
        return new ThreadExecutor();
    }

    @Provides
    @Singleton
    MainThread providesMainThread() {
        return new MainThreadImpl();
    }

    @Provides
    CreateUserInteractor provideCreateUserInteractor(Executor executor, MainThread mainThread, UserDao userDao) {
        return new CreateUserInteractor(executor, mainThread, userDao);
    }

}
