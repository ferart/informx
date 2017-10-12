package com.ferart.informx.models.data.daos;

import android.arch.lifecycle.LiveData;
import android.support.annotation.WorkerThread;

import com.ferart.informx.models.data.AppDatabase;
import com.ferart.informx.models.data.entities.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import timber.log.Timber;

/**
 * Created by Ferart on 10/8/2017.
 */
@WorkerThread
public class UserImplDao implements UserDao {

    private DatabaseReference firebaseReference;
    private AppDatabase internalDB;

    public UserImplDao(DatabaseReference firebaseReference, AppDatabase internalDB) {
        this.firebaseReference = firebaseReference;
        this.internalDB = internalDB;
    }


    @Override
    public void delete(User user) {
        firebaseReference.child("user").child(user.getUid()).removeValue((databaseError, databaseReference) -> internalDB.userDao().delete(user));
    }

    @Override
    public void insert(User user) {
        firebaseReference.child("user").child(user.getUid()).setValue(user, (databaseError, databaseReference) -> internalDB.userDao().insert(user));
    }

    @Override
    public void update(User user) {
        firebaseReference.child("user").child(user.getUid()).setValue(user, (databaseError, databaseReference) -> internalDB.userDao().update(user));
    }

    @Override
    public LiveData<User> findByUserId(String userId) {
       return internalDB.userDao().findByUserId(userId);
    }
}
