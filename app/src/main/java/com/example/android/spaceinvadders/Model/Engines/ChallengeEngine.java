package com.example.android.spaceinvadders.Model.Engines;

import com.example.android.spaceinvadders.EntityComponent.Entities.General.EntityManager;
import com.example.android.spaceinvadders.EntityComponent.Entities.Enum.EntityType;

import java.util.HashMap;

/**
 * @author Belal Taher
 * Created on 8/18/2017.
 * The ChallengeEngine class checks the entity manager to see if the condition to start a challenge has been satisfied
 */

public class ChallengeEngine extends AbstractEngine {

    //Constant that holds the number of enemy deaths of a certain type required for a challenge of that type to occur
    public static final int CONDITION = 3;

    //Boolean flag to indicate if challenge is occuring and an enum to indicate what kind of challenge
    private boolean startChallenge;
    private EntityType myChallenge;


    public ChallengeEngine(EntityManager aEM){
        super(aEM);
        startChallenge = false;
        myChallenge = null;
    }

    /**
     * This method checks the entity manager every iteration to see if the condition for a challenge to occur has been satisfied.
     * If the condition has been satisfied, it sets the instance variable boolean flag to true and sets the instance variable
     * enum to indicate what kind of challenge to execute
     */
    @Override
    public void update() {
        HashMap<EntityType, Integer> enemyDeaths = myEM.getEnemyDeaths();
        for (EntityType e : EntityType.values()) {
            if (e.name().contains("Enemy")) {
                if (enemyDeaths.get(e) >= CONDITION) {
                    startChallenge = true;
                    myChallenge = e;
                    enemyDeaths.put(e, 0);
                    return;
                }
            }
        }
    }

    /**
     * This method returns the boolean flag to check if a challenge should occur
     *
     * @return the boolean flag that indiciates if a challenge should occur
     */
    public boolean checkStartChallenge(){
        return startChallenge;
    }

    /**
     * This method returns the enum to see what kind of challenge should execute
     *
     * @return the enum indicating what type of challenge should occur
     */
    public EntityType checkMyChallenge(){
        return myChallenge;
    }

    /**
     * This method resets the challenge engine by setting the boolean flag to false and the enum to null.
     * This prevents the flag from infinitely triggering a challenge.
     */
    public void reset(){
        startChallenge = false;
        myChallenge = null;
    }
}
