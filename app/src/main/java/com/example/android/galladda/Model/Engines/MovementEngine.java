package com.example.android.galladda.Model.Engines;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.EntityManager;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;


/**
 * Created by Belal Taher on 8/15/2017.
 */

public class MovementEngine extends AbstractEngine {

    public MovementEngine(EntityManager aEM){
        super(aEM);
    }

    public void update(){
        updatePlayer();
        updateEnemies();
    }

    private void updatePlayer(){
        ArrayList<AbstractEntity> players = myEM.getPlayers();
        for(AbstractEntity e : players){
            PositionComponent myPC = (PositionComponent) e.getComponent(ComponentType.Position);
            VelocityComponent myVC = (VelocityComponent) e.getComponent(ComponentType.Velocity);

            myPC.setX(myPC.getX() + myVC.getX());
        }
    }

    private void updateEnemies() {
        //TODO: implement enemy movement
    }

}
