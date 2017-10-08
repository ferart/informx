package com.ferart.informx.models.data.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ferart.informx.models.data.entities.Reviewer;

import java.util.List;

/**
 * Created by Ferart on 10/7/2017.
 */
@Dao
public interface ReviewerDao {

    @Insert
    List<Long> insertAll(List<Reviewer> reviewers);

    @Delete
    void delete(Reviewer reviewer);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Reviewer reviewer);

    @Update
    void update(Reviewer reviewer);

    @Query("SELECT * from reviewer WHERE uid LIKE :reviewerId")
    Reviewer findByReviewerId(String reviewerId);
}
