package com.ferart.informx.models.domain.thread;


import com.ferart.informx.models.domain.common.Interactor;

/**
 * Created by Ferart on 9/27/2017.
 */

public interface Executor {
    void run(final Interactor interactor);
}
