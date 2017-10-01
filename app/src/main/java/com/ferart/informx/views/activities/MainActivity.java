package com.ferart.informx.views.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ferart.informx.ApplicationManager;
import com.ferart.informx.R;
import com.ferart.informx.presenters.MainPresenter;
import com.ferart.informx.presenters.common.BasePresenter;
import com.ferart.informx.views.common.BaseActivity;
import com.ferart.informx.views.common.ViewController;
import com.ferart.informx.views.controllers.MainController;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements MainController {

    @Inject
    MainPresenter mainPresenter;



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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void createInjection() {
        ((ApplicationManager)getApplicationContext()).getMainComponent().inject(this);
    }

    @Override
    public void attachToPresenter() {
        mainPresenter.onAttached(this);
    }

}
