package com.ferart.informx.models.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;


/**
 * Created by Ferart on 10/1/2017.
 */

@Entity(indices = {@Index(value = "idEvaluation", unique = true)}, foreignKeys =
        {@ForeignKey(entity = Reviewer.class,
                parentColumns = "uid",
                childColumns = "reviewer_id",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = CampaignProposal.class,
                        parentColumns = "idProposal",
                        childColumns = "proposal_id",
                        onDelete = ForeignKey.CASCADE)})
@TypeConverters(Converters.class)
public class Evaluation {

    @PrimaryKey(autoGenerate=true)
    @NonNull
    private int idEvaluation;

    @ColumnInfo(name = "reviewer_id")
    private int reviewerId;
    @ColumnInfo(name = "proposal_id")
    private int idProposal;
    private int score; //(0-100]
    private String review;
    private String fullEvaluationURL;
    private String[] quizEvaluation; //approved or not approved for each question
    private String[] quizAnswers;

    @NonNull
    public int getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(@NonNull int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getFullEvaluationURL() {
        return fullEvaluationURL;
    }

    public void setFullEvaluationURL(String fullEvaluationURL) {
        this.fullEvaluationURL = fullEvaluationURL;
    }

    public String[] getQuizEvaluation() {
        return quizEvaluation;
    }

    public void setQuizEvaluation(String[] quizEvaluation) {
        this.quizEvaluation = quizEvaluation;
    }

    public String[] getQuizAnswers() {
        return quizAnswers;
    }

    public void setQuizAnswers(String[] quizAnswers) {
        this.quizAnswers = quizAnswers;
    }
}
