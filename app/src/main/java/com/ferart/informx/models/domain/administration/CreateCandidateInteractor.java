package com.ferart.informx.models.domain.administration;

import com.ferart.informx.models.data.daos.CandidateDao;
import com.ferart.informx.models.data.daos.PoliticalPartyDao;
import com.ferart.informx.models.data.entities.Candidate;
import com.ferart.informx.models.data.entities.PoliticalParty;
import com.ferart.informx.models.domain.common.BaseInteractor;
import com.ferart.informx.models.domain.thread.Executor;
import com.ferart.informx.models.domain.thread.MainThread;

import javax.inject.Inject;


public class CreateCandidateInteractor extends BaseInteractor {

    private CandidateDao candidateDao;
    private PoliticalPartyDao politicalPartyDao;
    private Candidate candidate;

    @Inject
    public CreateCandidateInteractor(Executor executor, MainThread mainThread, CandidateDao candidateDao, PoliticalPartyDao politicalPartyDao) {
        super(executor, mainThread);
        this.candidateDao = candidateDao;
        this.politicalPartyDao = politicalPartyDao;
    }

    @Override
    public void run() {
        if (candidate == null){
            throw  new IllegalArgumentException("Candidate can not be null or empty");
        }
        candidateDao.registerCallback(key -> {
            //political parties are all ready created on firebase
            for (PoliticalParty politicalParty: candidate.getPoliticalParties()){
                politicalParty.setIdCandidate(key);
                politicalPartyDao.updatePoliticalPartyCandidate(politicalParty);
            }
        });

        candidateDao.insert(candidate);

    }

    @Override
    public void onExit() {
        candidateDao.unregisterCallback();
    }

    private void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
