package com.ferart.informx.views.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ferart.informx.ApplicationManager;

/**
 * Created by Ferart on 9/16/2017.
 */

public abstract class BaseActivity extends AppCompatActivity implements ViewController {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createInjection();
        attachToPresenter();
    }
    public abstract void createInjection();


}
