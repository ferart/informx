package com.ferart.informx.presenters.politicalinformation;

import com.ferart.informx.views.common.ViewController;

import android.arch.lifecycle.Lifecycle;


public class CandidateManagerImplPresenter implements PoliticalInformationContract.CandidateManagerPresenter {

    private Lifecycle ownerLifecycle;

    @Override
    public void onAttached(ViewController viewController) {

    }

    @Override
    public void onDetached() {

    }

    @Override
    public void setOwnerLifecycle(Lifecycle lifecycle) {
        this.ownerLifecycle = lifecycle;
        ownerLifecycle.addObserver(this);
    }
}
