package com.ferart.informx.models.data.daos;

import com.ferart.informx.models.data.entities.PoliticalParty;
import com.ferart.informx.models.domain.administration.AdministrationContract;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Ferart on 10/7/2017.
 */
@Dao
public interface PoliticalPartyDao {


    @Delete
    void delete(PoliticalParty politicalParty);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PoliticalParty politicalParty);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<PoliticalParty> politicalParties);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updatePoliticalPartyCandidate(PoliticalParty politicalParty);

    @Query("SELECT * from politicalparty WHERE name LIKE :politicalPartyName")
    PoliticalParty findByPoliticalPartyName(String politicalPartyName);

    @Query("SELECT * from politicalparty")
    List<PoliticalParty> findAllPoliticalParties();


    void findAllPoliticalPartiesAsync(AdministrationContract.PoliticalPartyCallback politicalPartyCallback);
}
