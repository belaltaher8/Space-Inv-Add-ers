package com.example.android.galladda.Model.Handlers;

import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;
import com.example.android.galladda.Model.Engines.ChallengeEngine;

/**
 * @author Belal Taher
 * Created on 8/18/2017.
 * The ChallengeHandler class constantly checks the challenge engine to see if a challenge should be initiated
 */

public class ChallengeHandler {

    //The challenge handler checks the challenge engine to see if a challenge should occur
    private ChallengeEngine myChallengeEngine;


    public ChallengeHandler(EntityManager aEM, ChallengeEngine myCE){
        myChallengeEngine = myCE;
    }

    /**
     * This method is called every iteration of the main game thread to see if a challenge should occur
     *
     * @return Returns a boolean flag to indicate if a challenge should occur
     */
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

    /**
     * This method returns the challenge engine so the main game thread can call .reset() on it
     *
     * @return the challenge engine
     */
    public ChallengeEngine getMyChallengeEngine(){
        return myChallengeEngine;
    }

    /**
     * Each enemy type has a type of challenge associated with it. This method returns an EntityType so the game controller knows
     * which kind of challenge to initiate
     *
     * @return returns the EntityType associated with the challenge to initiate
     */
    public EntityType getMyChallengeType(){
        return myChallengeEngine.checkMyChallenge();
    }
}
