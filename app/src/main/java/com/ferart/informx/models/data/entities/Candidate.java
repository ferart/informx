package com.ferart.informx.models.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ferart on 10/1/2017.
 */
@Entity(indices = {@Index(value = "idCandidate", unique = true)})
public class Candidate {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idCandidate;
    private String fullName;
    private String profileBackground;
    private String personalWebUrl;
    private float meanMetascore;   //mean of all metascores received from his/her proposals's evaluations
    private boolean isIndependent; // independent from political party

    @Ignore
    private List<PoliticalParty> politicalParties;

    @NonNull
    public int getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(@NonNull int idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfileBackground() {
        return profileBackground;
    }

    public void setProfileBackground(String profileBackground) {
        this.profileBackground = profileBackground;
    }

    public String getPersonalWebUrl() {
        return personalWebUrl;
    }

    public void setPersonalWebUrl(String personalWebUrl) {
        this.personalWebUrl = personalWebUrl;
    }

    public float getMeanMetascore() {
        return meanMetascore;
    }

    public void setMeanMetascore(float meanMetascore) {
        this.meanMetascore = meanMetascore;
    }

    public List<PoliticalParty> getPoliticalParties() {
        return politicalParties;
    }

    public void setPoliticalParties(List<PoliticalParty> politicalParties) {
        this.politicalParties = politicalParties;
    }

    public boolean isIndependent() {
        return isIndependent;
    }

    public void setIndependent(boolean independent) {
        isIndependent = independent;
        if (independent){
            politicalParties = Collections.emptyList();
        }
    }
}
