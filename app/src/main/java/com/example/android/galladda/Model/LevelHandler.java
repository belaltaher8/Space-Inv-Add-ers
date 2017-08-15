package com.example.android.galladda.Model;

import com.example.android.galladda.EntityComponent.Entities.EntityManager;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class LevelHandler {

    EntityManager currentLevelEM;

    public LevelHandler(){
        currentLevelEM = new EntityManager();
        initializeLevelOne();
        //TODO: Add XML compatibility
    }

    private void initializeLevelOne(){

    }
}
