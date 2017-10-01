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
        childColumns = "candidate_id",
        onUpdate = ForeignKey.CASCADE))
public class PoliticalParty {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idPoliticalParty;
    @ColumnInfo(name = "candidate_id")
    private int idCandidate;
    private String name;
    private String description;
    private String webPageUrl;

    @NonNull
    public int getIdPoliticalParty() {
        return idPoliticalParty;
    }

    public void setIdPoliticalParty(@NonNull int idPoliticalParty) {
        this.idPoliticalParty = idPoliticalParty;
    }

    public int getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(int idCandidate) {
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
}
