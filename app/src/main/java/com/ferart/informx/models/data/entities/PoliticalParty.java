package com.ferart.informx.models.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Ferart on 10/1/2017.
 */
@Entity(indices = {@Index(value = "idPoliticalParty", unique = true)}, foreignKeys = @ForeignKey(entity = Candidate.class,
        parentColumns = "idCandidate",
        childColumns = "idCandidate_fk",
        onUpdate = ForeignKey.CASCADE))
public class PoliticalParty {
    @PrimaryKey
    @NonNull
    private String idPoliticalParty;
    @ColumnInfo(name = "idCandidate_fk")
    private String idCandidate;
    private String name;
    private String acronym;
    private String description;
    private String webPageUrl;
    private String logoUrl;
    private String address;
    private String phone;

    @NonNull
    public String getIdPoliticalParty() {
        return idPoliticalParty;
    }

    public void setIdPoliticalParty(@NonNull String idPoliticalParty) {
        this.idPoliticalParty = idPoliticalParty;
    }

    public String getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(String idCandidate) {
        this.idCandidate = idCandidate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebPageUrl() {
        return webPageUrl;
    }

    public void setWebPageUrl(String webPageUrl) {
        this.webPageUrl = webPageUrl;
    }

    private String getLogoUrl() {
        return logoUrl;
    }

    private void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
