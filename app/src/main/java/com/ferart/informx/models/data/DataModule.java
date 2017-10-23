package com.ferart.informx.models.data;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.ferart.informx.models.data.daos.CandidateDao;
import com.ferart.informx.models.data.daos.CandidateImplDao;
import com.ferart.informx.models.data.daos.PoliticalPartyDao;
import com.ferart.informx.models.data.daos.PoliticalPartyImplDao;
import com.ferart.informx.models.data.daos.UserDao;
import com.ferart.informx.models.data.daos.UserImplDao;
import com.ferart.informx.models.data.preferences.AccessPreferencesDAO;
import com.ferart.informx.models.data.preferences.AccessPreferencesDAOImpl;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

/**
 * Created by Ferart on 8/27/2017.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    AccessPreferencesDAO providesAccessPreferences(SharedPreferences sharedPreferences) {
        return new AccessPreferencesDAOImpl(sharedPreferences);
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "devices")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Named("JSONMediaType")
    MediaType providesMediaType() {
        return MediaType.parse("application/json; charset=utf-8");
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient() {
        return new OkHttpClient();
    }


    @Provides
    DatabaseReference provideDatabaseReference() {
        return FirebaseDatabase.getInstance().getReference();
    }

    @Provides
    public UserDao provideUserDao(DatabaseReference databaseReference, AppDatabase internalDB) {
        return new UserImplDao(databaseReference, internalDB);
    }

    @Provides
    public PoliticalPartyDao providePoliticalPartyDao(DatabaseReference databaseReference, AppDatabase internalDB){
        return new PoliticalPartyImplDao(databaseReference, internalDB);
    }

    @Provides
    public CandidateDao provideCandidateDao(DatabaseReference databaseReference, AppDatabase internalDB){
        return new CandidateImplDao(databaseReference, internalDB);
    }

}
