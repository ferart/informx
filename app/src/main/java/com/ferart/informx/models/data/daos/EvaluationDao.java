package com.ferart.informx.models.data.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ferart.informx.models.data.entities.Evaluation;

import java.util.List;

/**
 * Created by Ferart on 10/7/2017.
 */
@Dao
public interface EvaluationDao {
    @Insert
    List<Long> insertAll(List<Evaluation> evaluations);

    @Delete
    void delete(Evaluation evaluation);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Evaluation evaluation);

    @Update
    void update(Evaluation evaluation);

    @Query("SELECT * from evaluation WHERE idEvaluation = :evaluationId")
    Evaluation findByEvaluationId(int evaluationId);
}
