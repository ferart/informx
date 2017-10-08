package com.ferart.informx.models.data.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ferart.informx.models.data.entities.Administrator;

import java.util.List;

/**
 * Created by Ferart on 10/7/2017.
 */
@Dao
public interface AdministratorDao {
    @Insert
    List<Long> insertAll(List<Administrator> administrators);

    @Delete
    void delete(Administrator reviewer);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Administrator administrator);

    @Update
    void update(Administrator administrator);

    @Query("SELECT * from administrator WHERE uid LIKE :administratorId")
    Administrator findByAdministratorId(String administratorId);
}
