package com.ferart.informx.models.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.ferart.informx.models.data.daos.AdministratorDao;
import com.ferart.informx.models.data.daos.CampaignProposalDao;
import com.ferart.informx.models.data.daos.CandidateDao;
import com.ferart.informx.models.data.daos.CategoryCatalogDao;
import com.ferart.informx.models.data.daos.EvaluationDao;
import com.ferart.informx.models.data.daos.PoliticalPartyDao;
import com.ferart.informx.models.data.daos.ReviewerDao;
import com.ferart.informx.models.data.daos.UserDao;
import com.ferart.informx.models.data.entities.Administrator;
import com.ferart.informx.models.data.entities.CampaignProposal;
import com.ferart.informx.models.data.entities.Candidate;
import com.ferart.informx.models.data.entities.CategoryCatalog;
import com.ferart.informx.models.data.entities.Evaluation;
import com.ferart.informx.models.data.entities.PoliticalParty;
import com.ferart.informx.models.data.entities.Reviewer;
import com.ferart.informx.models.data.entities.User;

/**
 * Created by Ferart on 10/7/2017.
 */


@Database(entities = {User.class,
        Reviewer.class,
        Administrator.class,
        Evaluation.class,
        CampaignProposal.class,
        Candidate.class,
        CategoryCatalog.class,
        PoliticalParty.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract ReviewerDao reviewerDao();

    public abstract AdministratorDao administratorDao();

    public abstract EvaluationDao evaluationDao();

    public abstract CampaignProposalDao campaignProposalDao();

    public abstract CandidateDao candidateDao();

    public abstract CategoryCatalogDao categoryCatalogDao();

    public abstract PoliticalPartyDao politicalPartyDao();
}
