package com.ferart.informx.models.domain.administration;

import com.ferart.informx.models.data.daos.PoliticalPartyDao;
import com.ferart.informx.models.data.daos.ResponseCallbackDAO;
import com.ferart.informx.models.data.entities.PoliticalParty;
import com.ferart.informx.models.domain.common.BaseInteractor;
import com.ferart.informx.models.domain.thread.Executor;
import com.ferart.informx.models.domain.thread.MainThread;

import java.util.List;

import javax.inject.Inject;


public class QueryPoliticalPartiesInteractor extends BaseInteractor implements ResponseCallbackDAO<AdministrationContract.PoliticalPartyCallback> {

    private PoliticalPartyDao politicalPartyDao;
    private PoliticalParty politicalParty;
    private AdministrationContract.PoliticalPartyCallback politicalPartyCallback;


    @Inject
    public QueryPoliticalPartiesInteractor(Executor executor, MainThread mainThread, PoliticalPartyDao politicalPartyDao) {
        super(executor, mainThread);
        this.politicalPartyDao = politicalPartyDao;
    }

    @Override
    public void run() {
        if (politicalParty == null) {
            throw new IllegalArgumentException("PoliticalParty can not be null or empty");
        }

        politicalPartyDao.findAllPoliticalPartiesAsync(new AdministrationContract.PoliticalPartyCallback() {
            @Override
            public void onAllPoliticalPartiesFound(List<PoliticalParty> politicalParties) {
                if (politicalPartyCallback != null) {
                    postOnMainThread(() -> politicalPartyCallback.onAllPoliticalPartiesFound(politicalParties));
                }
            }

            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                if (politicalPartyCallback != null) {
                    postOnMainThread(() -> politicalPartyCallback.onError());
                }
            }
        });
    }

    @Override
    public void onExit() {

    }

    private void setPoliticalParty(PoliticalParty politicalParty) {

        this.politicalParty = politicalParty;
    }


    @Override
    public void registerCallback(AdministrationContract.PoliticalPartyCallback callback) {
        this.politicalPartyCallback = callback;
    }

    @Override
    public void unregisterCallback() {
        politicalPartyCallback = null;
    }
}
