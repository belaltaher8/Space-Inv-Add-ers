package com.example.android.galladda.Model;

import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.Model.Engines.AbstractEngine;
import com.example.android.galladda.Model.Engines.AbstractEngine;
import com.example.android.galladda.Model.Engines.MovementEngine;

import java.util.ArrayList;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class GameModel {

    private ArrayList<AbstractEngine> myEngines;
    private LevelHandler myLevelHandler;

    public GameModel(){
        myEngines = new ArrayList<AbstractEngine>();
        initializeLevelHandler();
        attachEngines(myLevelHandler.getCurrentLevelEM());
    }

    private void attachEngines(EntityManager myEM){
        //myEngines.add(new MovementEngine(myEM));
    }

    private void initializeLevelHandler(){
        myLevelHandler = new LevelHandler();
    }
}
