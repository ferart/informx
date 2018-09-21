package com.ferart.informx.views.activities.politicalinformation;

import com.ferart.informx.R;
import com.ferart.informx.views.common.BaseActivity;
import com.ferart.informx.views.controllers.CandidateViews;

import android.os.Bundle;

public class CreateCandidateActivity extends BaseActivity implements CandidateViews.CreateUpdateCandidateController{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_candidate);
    }

    @Override
    protected void createInjection() {

    }

    @Override
    protected void attachLifecycleToPresenter() {

    }

    @Override
    public void attachToPresenter() {

    }
}
