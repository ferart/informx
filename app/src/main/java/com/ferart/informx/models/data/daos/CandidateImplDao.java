package com.ferart.informx.models.data.daos;

import com.google.firebase.database.DatabaseReference;

import com.ferart.informx.models.data.AppDatabase;
import com.ferart.informx.models.data.entities.Candidate;
import com.ferart.informx.models.domain.administration.AdministrationContract;

import java.util.List;

import javax.inject.Inject;

public class CandidateImplDao implements CandidateDao {

    private DatabaseReference firebaseReference;
    private AppDatabase internalDB;
    private String NODE = "candidate";
    private AdministrationContract.CandidateCallbackDAO callbackDAO;

    @Inject
    public CandidateImplDao(DatabaseReference firebaseReference, AppDatabase internalDB) {
        this.firebaseReference = firebaseReference;
        this.internalDB = internalDB;
    }

    @Override
    public List<Long> insertAll(List<Candidate> candidates) {
        return null;
    }

    @Override
    public void delete(Candidate candidate) {

    }

    @Override
    public void insert(Candidate candidate) {

       DatabaseReference databaseReference =  firebaseReference.child(NODE).push();
       databaseReference.setValue(candidate, ((databaseError, databaseReference1) -> {
           String key = databaseReference1.getKey();
           candidate.setIdCandidate(key);
           internalDB.candidateDao().insert(candidate);
           if (callbackDAO!= null){
               callbackDAO.insertedKey(key);
           }
       }));
    }

    @Override
    public void update(Candidate candidate) {

    }

    @Override
    public Candidate findByCandidateId(int candidateId) {
        return null;
    }

    @Override
    public void registerCallback(AdministrationContract.CandidateCallbackDAO callback) {
        this.callbackDAO = callback;
    }

    @Override
    public void unregisterCallback() {
        callbackDAO = null;
    }
}
