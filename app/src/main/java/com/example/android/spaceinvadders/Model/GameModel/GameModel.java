package com.example.android.spaceinvadders.Model.GameModel;

import android.content.Context;

import com.example.android.spaceinvadders.EntityComponent.Entities.General.EntityManager;
import com.example.android.spaceinvadders.Model.Engines.EnemyEngine;
import com.example.android.spaceinvadders.Model.Engines.ExplosionEngine;
import com.example.android.spaceinvadders.Model.Engines.LevelEngine;
import com.example.android.spaceinvadders.Model.Engines.LivesEngine;
import com.example.android.spaceinvadders.Model.Handlers.ChallengeHandler;
import com.example.android.spaceinvadders.Model.Handlers.LevelHandler;
import com.example.android.spaceinvadders.Model.Engines.AbstractEngine;
import com.example.android.spaceinvadders.Model.Engines.ChallengeEngine;
import com.example.android.spaceinvadders.Model.Engines.CollisionEngine;
import com.example.android.spaceinvadders.Model.Engines.MovementEngine;

import java.util.ArrayList;

import static android.media.CamcorderProfile.get;

/**
 * @author Belal Taher
 * Created on 8/15/2017.
 * The GameModel class updates all the engines and passes the screen dimensions from the Game View to the Level Handler
 */

public class GameModel {

    //An array list that contains all the engines for the back end
    private ArrayList<AbstractEngine> myEngines;

    //The game model has access to the entity manager to pass it to all the engines
    private EntityManager myEM;

    //The game model contains the level handler and challenge handler since they're both part of the model component
    //of the MVC paradigm
    private LevelHandler myLevelHandler;
    private ChallengeHandler myChallengeHandler;

    public GameModel(Context myContext){
        myEngines = new ArrayList<AbstractEngine>();
        myLevelHandler = new LevelHandler(myContext);
        myEM = myLevelHandler.getCurrentLevelEM();
        attachEngines(myEM);
        for(AbstractEngine e : myEngines){
            if(e instanceof ChallengeEngine){
                myChallengeHandler = new ChallengeHandler(myLevelHandler.getCurrentLevelEM(), (ChallengeEngine) e);
            }
            else if(e instanceof LivesEngine){
                myLevelHandler.attachLivesEngine((LivesEngine) e);
            }
            else if(e instanceof LevelEngine){
                myLevelHandler.attachLevelEngine((LevelEngine) e);
            }
        }
    }

    public void passNumOfTimesWrong(int num){

        //Finds the AI engine in the array list of myEngines
        EnemyEngine myAIEngine = null;
        for(AbstractEngine engine : myEngines){
            if(engine instanceof EnemyEngine){
                myAIEngine = (EnemyEngine) engine;
            }
        }
        myAIEngine.addNumOfTimesWrong(num);
    }

    /**
     * This method updates all the engines on the back end
     */
    public void update(){
        for(AbstractEngine engine : myEngines){
            engine.update();
        }
    }

    /**
     * This method passes the screen dimensions to the level handler and movement engine
     *
     * @param screenDimensions an 2D array with 2 indices, screenDimensions[0] is the width and screenDimensions[1] is the height
     */
    public void takeInScreenDimensions(int[] screenDimensions){

        //Finds the movement engine in the array list of myEngines
        MovementEngine myMovementEngine = null;
        for(AbstractEngine engine : myEngines){
            if(engine instanceof MovementEngine){
               myMovementEngine = (MovementEngine) engine;
            }
        }

        //Passes boundaries to movement engine (for preventing moving past boundaries) and level handler (for starting positions)
        myMovementEngine.attachBoundaries(screenDimensions);
        myLevelHandler.takeInScreenDimensions(screenDimensions);
    }

    /**
     * This method attaches all the engines to the model's array list of abstract engines
     *
     * @param myEM on construction, any engine requires a reference to the entity manager so the engine can
     *             access and update the appropriate components of entities
     */
    private void attachEngines(EntityManager myEM){
        myEngines.add(new MovementEngine(myEM));
        myEngines.add(new EnemyEngine(myEM));
        myEngines.add(new CollisionEngine(myEM));
        myEngines.add(new ChallengeEngine(myEM));
        myEngines.add(new LivesEngine(myEM));
        myEngines.add(new ExplosionEngine(myEM));
        myEngines.add((new LevelEngine(myEM)));
    }

    /**
     * This method returns the challenge handler so the main game thread can check if a challenge is occuring
     *
     * @return returns the challenge handler
     */
    public ChallengeHandler getMyChallengeHandler(){
        return myChallengeHandler;
    }

    /**
     * This method returns the level handler to the game controller that the game controller can initialize level 1 on construction
     *
     * @return returns the level handler
     */
    public LevelHandler getMyLevelHandler(){ return myLevelHandler;}

    public void passReplay(boolean replay){
        if(replay == true){
            myChallengeHandler.getMyChallengeEngine().reset();
            myEM.reset();
            myLevelHandler.initializeLevel(myLevelHandler.getLevel());
        }
    }
}
