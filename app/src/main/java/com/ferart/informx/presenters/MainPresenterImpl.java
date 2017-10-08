package com.ferart.informx.presenters;

import com.ferart.informx.views.common.ViewController;
import com.ferart.informx.views.controllers.MainController;

import java.lang.ref.WeakReference;

/**
 * Created by Ferart on 9/16/2017.
 */

public class MainPresenterImpl implements MainPresenter {

    private WeakReference<MainController> mainControllerWeakReference;

    @Override
    public void onAttached(ViewController viewController) {
        this.mainControllerWeakReference = new WeakReference<>((MainController) viewController);
    }

    @Override
    public void onDetached() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onBackPress() {

    }

    @Override
    public void onDestroy() {

    }
}
