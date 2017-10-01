package com.ferart.informx.models.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * Created by Ferart on 10/1/2017.
 */

@Entity(indices={@Index(value="uid", unique=true)})
public class User {

    @PrimaryKey
    @NonNull
    protected String uid;
    protected String name;
    protected String lastName;
    protected String email;

    //todo: remove ignore annotation once figured out how to get image from profile
    @Ignore
    protected Uri picture;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Uri getPicture() {
        return picture;
    }

    public void setPicture(Uri picture) {
        this.picture = picture;
    }
}
