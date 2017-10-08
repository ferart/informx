package com.ferart.informx.models.data.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ferart.informx.models.data.entities.Candidate;

import java.util.List;

/**
 * Created by Ferart on 10/7/2017.
 */
@Dao
public interface CandidateDao {
    @Insert
    List<Long> insertAll(List<Candidate> candidates);

    @Delete
    void delete(Candidate candidate);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Candidate candidate);

    @Update
    void update(Candidate candidate);

    @Query("SELECT * from candidate WHERE idCandidate = :candidateId")
    Candidate findByCandidateId(int candidateId);
}
