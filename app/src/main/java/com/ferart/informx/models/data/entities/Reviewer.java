package com.ferart.informx.models.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;

import java.util.List;

/**
 * Created by Ferart on 10/1/2017.
 */

@Entity(inheritSuperIndices = true)
public class Reviewer extends User {

    protected String academicInstitution;
    protected String employer;
    protected String personalWeb;

    @Ignore
    protected List<Evaluation> evaluations;

    //todo: userFriends, verified


    public String getAcademicInstitution() {
        return academicInstitution;
    }

    public void setAcademicInstitution(String academicInstitution) {
        this.academicInstitution = academicInstitution;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getPersonalWeb() {
        return personalWeb;
    }

    public void setPersonalWeb(String personalWeb) {
        this.personalWeb = personalWeb;
    }
}
