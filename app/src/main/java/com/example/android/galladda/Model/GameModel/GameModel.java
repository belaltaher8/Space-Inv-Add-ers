package com.example.android.galladda.Model.GameModel;

import android.content.Context;

import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;
import com.example.android.galladda.Model.Handlers.ChallengeHandler;
import com.example.android.galladda.Model.Handlers.LevelHandler;
import com.example.android.galladda.Model.Engines.AbstractEngine;
import com.example.android.galladda.Model.Engines.ChallengeEngine;
import com.example.android.galladda.Model.Engines.CollisionEngine;
import com.example.android.galladda.Model.Engines.MovementEngine;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class GameModel {

    private int screenWidth;
    private int screenHeight;

    private ArrayList<AbstractEngine> myEngines;
    private EntityManager myEM;
    private LevelHandler myLevelHandler;
    private ChallengeHandler myChallengeHandler;

    public GameModel(Context myContext){
        myEngines = new ArrayList<AbstractEngine>();
        myLevelHandler = new LevelHandler(myContext);
        myEM = myLevelHandler.getCurrentLevelEM();
        attachEngines(myEM);
        myChallengeHandler = new ChallengeHandler(myLevelHandler.getCurrentLevelEM(), (ChallengeEngine) myEngines.get(2));
    }

    public void update(){
        for(AbstractEngine engine : myEngines){
            engine.update();
        }
    }

    public void takeInScreenDimensions(int[] screenDimensions){
        MovementEngine myMovementEngine = (MovementEngine) myEngines.get(0);
        myMovementEngine.attachBoundaries(screenDimensions);
        myLevelHandler.takeInScreenDimensions(screenDimensions);
    }

    private void attachEngines(EntityManager myEM){
        myEngines.add(new MovementEngine(myEM));
        myEngines.add(new CollisionEngine(myEM));
        myEngines.add(new ChallengeEngine(myEM));
    }

    public ChallengeHandler getMyChallengeHandler(){
        return myChallengeHandler;
    }

    public LevelHandler getMyLevelHandler(){ return myLevelHandler;}
}
