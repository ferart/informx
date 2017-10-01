package com.ferart.informx.models.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Ferart on 10/1/2017.
 */
@Entity(indices = {@Index(value = {"idCategory", "name"}, unique = true)})
public class CategoryCatalog {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int idCategory;
    private String name;
    private String description;

    @NonNull
    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(@NonNull int idCategory) {
        this.idCategory = idCategory;
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
}
