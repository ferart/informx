package com.ferart.informx.models.domain.usermanager;

import com.ferart.informx.models.data.daos.UserDao;
import com.ferart.informx.models.data.entities.User;
import com.ferart.informx.models.domain.common.BaseInteractor;
import com.ferart.informx.models.domain.thread.Executor;
import com.ferart.informx.models.domain.thread.MainThread;

import javax.inject.Inject;

/**
 * Created by Ferart on 10/12/2017.
 */

public class CreateUserInteractor extends BaseInteractor {


    private UserDao userDao;
    private User user;
    private User liveUser;
    private UserLifeCycleCallback userLifeCycleCallback;


    @Inject
    public CreateUserInteractor(Executor executor, MainThread mainThread, UserDao userDao) {
        super(executor, mainThread);
        this.userDao = userDao;
    }

    @Override
    public void run() {
        if (user == null && userLifeCycleCallback != null) {
            throw  new IllegalArgumentException("User can not be null or empty");
        }

       liveUser = userDao.findByUserId(user.getUid());
       postOnMainThread(()->userLifeCycleCallback.onUserFound(liveUser));

    }

    @Override
    public void onExit() {
        userLifeCycleCallback = null;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserLifeCycleCallback(UserLifeCycleCallback userLifeCycleCallback) {
        this.userLifeCycleCallback = userLifeCycleCallback;
    }
}
