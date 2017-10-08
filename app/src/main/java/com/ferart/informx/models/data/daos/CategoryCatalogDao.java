package com.ferart.informx.models.data.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ferart.informx.models.data.entities.CategoryCatalog;

import java.util.List;

/**
 * Created by Ferart on 10/7/2017.
 */

@Dao
public interface CategoryCatalogDao {
    @Insert
    List<Long> insertAll(List<CategoryCatalog> catalog);

    @Delete
    void delete(CategoryCatalog category);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CategoryCatalog category);

    @Update
    void update(CategoryCatalog category);

    @Query("SELECT * from categorycatalog WHERE idCategory = :categoryId")
    CategoryCatalog findByCategoryId(int categoryId);
}
