package com.ferart.informx.presenters.common;


import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;

import com.ferart.informx.views.common.ViewController;

/**
 * Created by Ferart on 9/25/16.
 * Base presenter to implement on all presenters,
 * this simplified lifecycle can be used by the MainActivity and/or Controllers
 */

public  interface BasePresenter extends LifecycleObserver {
    /*Simplified lifecycle of the activity or fragment
     */
      void onAttached(ViewController viewController);
      void onDetached();
      void setOwnerLifecycle(Lifecycle lifecycle);
}
