package com.ferart.informx.views.activities;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ferart.informx.ApplicationManager;
import com.ferart.informx.R;
import com.ferart.informx.models.data.entities.User;
import com.ferart.informx.presenters.MainScreenPresenter;
import com.ferart.informx.views.common.BaseActivity;
import com.ferart.informx.views.controllers.MainController;

import javax.inject.Inject;

import timber.log.Timber;

public class MainActivity extends BaseActivity implements MainController {

    @Inject
    MainScreenPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.getUserById("123");
            }
        });

        mainPresenter.getUser().observe(MainActivity.this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                Timber.d("User has changed" + user.getName());
            }
        });

    }

    @Override
    public void createInjection() {
        ((ApplicationManager) getApplicationContext()).getMainComponent().inject(this);
    }

    @Override
    protected void attachLifecycleToPresenter() {
        mainPresenter.setOwnerLifecycle(getLifecycle());
    }

    @Override
    public void attachToPresenter() {
        mainPresenter.onAttached(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
