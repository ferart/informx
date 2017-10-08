package com.ferart.informx.models.data.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.ferart.informx.models.data.entities.CampaignProposal;

import java.util.List;

/**
 * Created by Ferart on 10/7/2017.
 */
@Dao
public interface CampaignProposalDao {
    @Insert
    List<Long> insertAll(List<CampaignProposal> campaignProposals);

    @Delete
    void delete(CampaignProposal campaignProposal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CampaignProposal campaignProposal);

    @Update
    void update(CampaignProposal campaignProposal);

    @Query("SELECT * from campaignproposal WHERE idProposal = :proposalId")
    CampaignProposal findByProposalId(int proposalId);
}
