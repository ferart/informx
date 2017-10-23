package com.ferart.informx.models.data.daos;

import com.ferart.informx.models.data.entities.User;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

/**
 * Created by Ferart on 10/7/2017.
 */

@Dao
public interface UserDao {

    @Delete
    void delete(User user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User user);

    void update(User user);

    @Query("SELECT * from user WHERE uid LIKE :userId")
    User findByUserId(String userId);



}
