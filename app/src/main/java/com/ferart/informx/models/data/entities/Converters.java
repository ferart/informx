package com.ferart.informx.models.data.entities;

import android.arch.persistence.room.TypeConverter;

import java.util.Arrays;

/**
 * Created by Ferart on 10/1/2017.
 */

public class Converters {

    @TypeConverter
    public String fromStringArray(String[] array) {
        return array == null ? null : Arrays.toString(array);
    }

    @TypeConverter
    public String[] stringToArray(String composeString) {
        return composeString.replace("\\[|\\]|\\s", "").split(",");
    }



}
