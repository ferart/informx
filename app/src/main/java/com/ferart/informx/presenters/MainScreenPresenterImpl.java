package com.ferart.informx.presenters;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;

import com.ferart.informx.models.data.entities.User;
import com.ferart.informx.models.domain.usermanager.CreateUserInteractor;
import com.ferart.informx.models.domain.usermanager.UserLifeCycleCallback;
import com.ferart.informx.views.common.ViewController;
import com.ferart.informx.views.controllers.MainController;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * Created by Ferart on 9/16/2017.
 */

public class MainScreenPresenterImpl implements MainScreenPresenter {

    private WeakReference<MainController> mainControllerWeakReference;
    private CreateUserInteractor createUserInteractor;
    private MutableLiveData<User> userLiveData;
    private Lifecycle ownerLifecycle;

    @Inject
    public MainScreenPresenterImpl(CreateUserInteractor createUserInteractor) {
        this.createUserInteractor = createUserInteractor;
        userLiveData = new MutableLiveData<>();
    }

    @Override
    public void onAttached(ViewController viewController) {
        this.mainControllerWeakReference = new WeakReference<>((MainController) viewController);


    }

    @Override
    public void onDetached() {

    }

    @Override
    public void setOwnerLifecycle(Lifecycle lifecycle) {
        this.ownerLifecycle = lifecycle;
        ownerLifecycle.addObserver(this);
    }

    @Override
    public LiveData<User> getUser() {
        return userLiveData;
    }

    @Override
    public void getUserById(String id) {
        if (ownerLifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            createUserInteractor.setUser(new User("123", "fernando", "rocha", "ferart59@gmail.com"));
            createUserInteractor.setUserLifeCycleCallback(new UserLifeCycleCallback() {
                @Override
                public void onUserFound(User liveUser) {
                    userLiveData.setValue(liveUser);
                }
            });
            createUserInteractor.execute();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        Timber.d("do something on onStop");
    }
}
