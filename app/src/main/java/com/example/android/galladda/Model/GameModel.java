package com.example.android.galladda.Model;

import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.Model.Engines.AbstractEngine;
import com.example.android.galladda.Model.Engines.AbstractEngine;
import com.example.android.galladda.Model.Engines.CollisionEngine;
import com.example.android.galladda.Model.Engines.MovementEngine;

import java.util.ArrayList;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class GameModel {

    private ArrayList<AbstractEngine> myEngines;
    private EntityManager myEM;

    public GameModel(EntityManager aEM){
        myEngines = new ArrayList<AbstractEngine>();
        myEM = aEM;
        attachEngines(myEM);
    }

    public void update(){
        for(AbstractEngine engine : myEngines){
            engine.update();
        }
    }

    private void attachEngines(EntityManager myEM){
        myEngines.add(new MovementEngine(myEM));
        myEngines.add(new CollisionEngine(myEM));
    }
}
