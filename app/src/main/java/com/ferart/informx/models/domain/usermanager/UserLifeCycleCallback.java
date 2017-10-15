package com.ferart.informx.models.domain.usermanager;

import android.arch.lifecycle.LiveData;

import com.ferart.informx.models.data.entities.User;

/**
 * Created by Ferart on 10/12/2017.
 */

public interface UserLifeCycleCallback {

    void onUserFound(User liveUser);
}
