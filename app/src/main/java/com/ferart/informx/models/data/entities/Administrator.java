package com.ferart.informx.models.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;

/**
 * Created by Ferart on 10/1/2017.
 */

@Entity(indices = {@Index(value = "uid", unique = true)}, primaryKeys = {"uid"})
public class Administrator extends Reviewer {

    private int phone;

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
