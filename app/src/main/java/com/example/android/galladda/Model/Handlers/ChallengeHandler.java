package com.example.android.galladda.Model.Handlers;

import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;
import com.example.android.galladda.Model.Engines.ChallengeEngine;

/**
 * Created by Belal Taher on 8/18/2017.
 */

public class ChallengeHandler {

    private ChallengeEngine myChallengeEngine;


    public ChallengeHandler(EntityManager aEM, ChallengeEngine myCE){
        myChallengeEngine = myCE;
    }

    public boolean checkIfChallengeOccured(){
        boolean startChallenge = myChallengeEngine.checkStartChallenge();
        EntityType myChallenge = myChallengeEngine.checkMyChallenge();
        if(startChallenge == false || myChallenge == null){
            return false;
        }
        else{
            return true;
        }
    }

    public ChallengeEngine getMyChallengeEngine(){
        return myChallengeEngine;
    }

    public EntityType getMyChallengeType(){
        return myChallengeEngine.checkMyChallenge();
    }
}
