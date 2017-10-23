package com.ferart.informx.models.domain.administration;

import com.ferart.informx.models.data.entities.PoliticalParty;
import com.ferart.informx.utils.SimpleResponseCallback;

import java.util.List;

public interface AdministrationContract {

    interface PoliticalPartyCallback  extends SimpleResponseCallback{
        void onAllPoliticalPartiesFound(List<PoliticalParty> politicalParties);
    }

    interface CandidateCallbackDAO {
        void insertedKey(String key);
    }
}
