package com.example.android.galladda.Model.Engines;

import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;

import java.util.HashMap;

/**
 * Created by Belal Taher on 8/18/2017.
 */

public class ChallengeEngine extends AbstractEngine {

    private boolean startChallenge;
    private EntityType myChallenge;


    public ChallengeEngine(EntityManager aEM){
        super(aEM);
        startChallenge = false;
        myChallenge = null;
    }

    @Override
    public void update() {
        HashMap<EntityType, Integer> enemyDeaths = myEM.getEnemyDeaths();
        for (EntityType e : EntityType.values()) {
            if (e.name().contains("Enemy")) {
                if (enemyDeaths.get(e) >= 3) {
                    startChallenge = true;
                    myChallenge = e;
                    enemyDeaths.put(e, 0);
                    return;
                }
            }
        }
    }

    public boolean checkStartChallenge(){
        return startChallenge;
    }

    public EntityType checkMyChallenge(){
        return myChallenge;
    }

    public void reset(){
        startChallenge = false;
        myChallenge = null;
    }
}
