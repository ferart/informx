package com.ferart.informx.views.common;

import android.arch.lifecycle.Lifecycle;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ferart.informx.presenters.common.BasePresenter;

import javax.annotation.Nonnull;

/**
 * Created by Ferart on 9/16/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements ViewController {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createInjection();
        attachToPresenter();
        attachLifecycleToPresenter();
    }

    protected abstract void createInjection();
    protected abstract void attachLifecycleToPresenter();

}
