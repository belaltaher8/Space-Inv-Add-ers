package com.example.android.galladda.Model.Engines;

import android.util.Log;

import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.EntityType;

import java.util.HashMap;

/**
 * Created by Belal Taher on 8/18/2017.
 */

public class ChallengeEngine extends AbstractEngine {

    private boolean startChallenge;
    private ChallengeType myChallenge;


    public ChallengeEngine(EntityManager aEM){
        super(aEM);
        startChallenge = false;
        myChallenge = null;
    }

    @Override
    public void update() {
        HashMap<EntityType, Integer> enemyDeaths = myEM.getEnemyDeaths();
        if(enemyDeaths.get(EntityType.MathEnemy) >= 3){
            startChallenge = true;
            myChallenge = ChallengeType.Math;
            enemyDeaths.put(EntityType.MathEnemy, 0);
        }
        else if(enemyDeaths.get(EntityType.PuzzleEnemy) >= 3){
            startChallenge = true;
            myChallenge = ChallengeType.Puzzle;
            enemyDeaths.put(EntityType.PuzzleEnemy, 0);
        }
        else if(enemyDeaths.get(EntityType.ShapesEnemy) >= 3){
            startChallenge = true;
            myChallenge = ChallengeType.Shape;
            enemyDeaths.put(EntityType.ShapesEnemy, 0);
        }
    }

    public boolean checkStartChallenge(){
        return startChallenge;
    }

    public ChallengeType checkMyChallenge(){
        return myChallenge;
    }
}
