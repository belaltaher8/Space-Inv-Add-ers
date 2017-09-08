package com.example.android.galladda.Model.Engines;

import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;

/**
 * Created by Belal Taher on 9/7/2017.
 */

public class LevelEngine extends AbstractEngine {

    private boolean nextLevel = false;

    public LevelEngine(EntityManager aEM){
        super(aEM);
    }

    @Override
    public void update() {
        if(myEM.getAllEnemies().size() == 0){
            nextLevel = true;
        }
    }

    public void reset(){
        nextLevel = false;
    }

    public boolean checkIfNextLevel(){
        return nextLevel;
    }
}
