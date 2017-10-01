package com.ferart.informx.models.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Ferart on 10/1/2017.
 */
@Entity(indices={@Index(value="idProposal", unique=true)}, foreignKeys =
        {@ForeignKey(entity = Candidate.class,
        parentColumns = "idCandidate",
        childColumns = "candidate_id",
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = CategoryCatalog.class,
        parentColumns = "idCategory",
        childColumns = "category_id",
        onUpdate = ForeignKey.CASCADE)})
public class CampaignProposal {
    @PrimaryKey(autoGenerate=true)
    @NonNull
    private int idProposal;
    @ColumnInfo(name = "candidate_id")
    private int idCandidate;
    @ColumnInfo(name = "category_id")
    private int idCategory;
    private String title;
    private String content;
    private float metascore;

    @Ignore
    private List<Evaluation> evaluations;

    @NonNull
    public int getIdProposal() {
        return idProposal;
    }

    public void setIdProposal(@NonNull int idProposal) {
        this.idProposal = idProposal;
    }

    public int getIdCandidate() {
        return idCandidate;
    }

    public void setIdCandidate(int idCandidate) {
        this.idCandidate = idCandidate;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getMetascore() {
        return metascore;
    }

    public void setMetascore(float metascore) {
        this.metascore = metascore;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }
}
