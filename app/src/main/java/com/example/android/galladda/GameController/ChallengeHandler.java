package com.example.android.galladda.GameController;

import android.content.Entity;

import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.Model.Engines.ChallengeEngine;
import com.example.android.galladda.Model.Engines.ChallengeType;

/**
 * Created by Belal Taher on 8/18/2017.
 */

public class ChallengeHandler {

    private ChallengeEngine myChallengeEngine;


    public ChallengeHandler(EntityManager aEM, ChallengeEngine myCE){
        myChallengeEngine = myCE;
    }

    public ChallengeType checkIfChallengeOccured(){
        boolean startChallenge = myChallengeEngine.checkStartChallenge();
        ChallengeType myChallenge = myChallengeEngine.checkMyChallenge();
        if(startChallenge == false || myChallenge == null){
            return null;
        }
        else{
            return myChallenge;
        }
    }
}
