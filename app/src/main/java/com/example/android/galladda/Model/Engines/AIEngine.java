package com.example.android.galladda.Model.Engines;

import com.example.android.galladda.EntityComponent.Entities.Enemies.AbstractEnemy;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;

import java.util.ArrayList;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class AIEngine extends AbstractEngine {

    public AIEngine(EntityManager aEM){
        super(aEM);
    }

    @Override
    public void update() {
        ArrayList<AbstractEntity> myEnemies = myEM.getAllEnemies();
        //TODO: implement enemy shooting
    }
}
