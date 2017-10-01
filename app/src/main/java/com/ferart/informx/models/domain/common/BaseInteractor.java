package com.ferart.informx.models.domain.common;


import com.ferart.informx.models.domain.thread.Executor;
import com.ferart.informx.models.domain.thread.MainThread;

/**
 * Created by Ferart on 9/25/16.
 */

public abstract  class BaseInteractor implements Interactor {
    protected final Executor executor;
    private final MainThread mainThread;


    public BaseInteractor(Executor executor, MainThread mainThread) {
        this.executor = executor;
        this.mainThread = mainThread;
    }

    public abstract void run();

    public void execute() {
        this.executor.run(this);
    }

    protected final void postOnMainThread(final Runnable runnable) {
        mainThread.post(runnable);
    }


}
