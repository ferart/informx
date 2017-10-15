package com.ferart.informx.presenters;

import android.arch.lifecycle.LiveData;

import com.ferart.informx.models.data.entities.User;
import com.ferart.informx.presenters.common.BasePresenter;

/**
 * Created by Ferart on 9/16/2017.
 */

public interface MainScreenPresenter extends BasePresenter {

    LiveData<User> getUser();
    void getUserById(String id);
}
