package com.ferart.informx.models.data.daos;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.ferart.informx.models.data.daos.DataOperation.CREATE;
import static com.ferart.informx.models.data.daos.DataOperation.DELETE;
import static com.ferart.informx.models.data.daos.DataOperation.RETRIEVE;
import static com.ferart.informx.models.data.daos.DataOperation.UPDATE;

@Retention(RetentionPolicy.SOURCE)
@IntDef({CREATE, RETRIEVE, UPDATE, DELETE})
public @interface DataOperation {
    int CREATE = 0;
    int RETRIEVE = 1;
    int UPDATE = 2;
    int DELETE = 3;
}