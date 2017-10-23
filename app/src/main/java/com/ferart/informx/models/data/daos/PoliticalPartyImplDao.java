package com.ferart.informx.models.data.daos;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import com.ferart.informx.models.data.AppDatabase;
import com.ferart.informx.models.data.entities.PoliticalParty;
import com.ferart.informx.models.domain.administration.AdministrationContract;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class PoliticalPartyImplDao implements PoliticalPartyDao {

    private DatabaseReference firebaseReference;
    private AppDatabase internalDB;
    private String NODE = "politicalparty";
    private AdministrationContract.PoliticalPartyCallback politicalPartyCallback;

    @Inject
    public PoliticalPartyImplDao(DatabaseReference firebaseReference, AppDatabase internalDB) {
        this.firebaseReference = firebaseReference;
        this.internalDB = internalDB;
    }


    @Override
    public void delete(PoliticalParty politicalParty) {

    }

    @Override
    public void insert(PoliticalParty politicalParty) {

    }

    @Override
    public void updatePoliticalPartyCandidate(PoliticalParty politicalParty) {
        firebaseReference.child(NODE).child(politicalParty.getIdPoliticalParty()).child("idCandidate_fk").setValue(politicalParty.getIdCandidate(), (databaseError, databaseReference) -> {
            internalDB.politicalPartyDao().updatePoliticalPartyCandidate(politicalParty);
        });
    }

    @Override
    public PoliticalParty findByPoliticalPartyName(String politicalPartyName) {
        return null;
    }

    @Override
    public List<PoliticalParty> findAllPoliticalParties() {
        return internalDB.politicalPartyDao().findAllPoliticalParties();
    }

    @Override
    public void insert(List<PoliticalParty> politicalParties) {

    }

    @Override
    public void findAllPoliticalPartiesAsync(AdministrationContract.PoliticalPartyCallback politicalPartyCallback) {
        List<PoliticalParty> politicalParties = Collections.emptyList();
        firebaseReference.child(NODE).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    for (DataSnapshot child: dataSnapshot.getChildren()){
                        politicalParties.add(child.getValue(PoliticalParty.class));
                    }
                    internalDB.politicalPartyDao().insert(politicalParties);
                }
                politicalPartyCallback.onAllPoliticalPartiesFound(politicalParties);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                politicalPartyCallback.onError();
            }
        });
    }

}
