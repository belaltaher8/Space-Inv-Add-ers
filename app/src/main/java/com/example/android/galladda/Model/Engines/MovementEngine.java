package com.example.android.galladda.Model.Engines;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.EntityType;

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
        updateBullets();
       // updateEnemies();
    }

    private void updatePlayer(){
        ArrayList<AbstractEntity> players = myEM.getEntitiesOfType(EntityType.Player);
        for(AbstractEntity e : players){
            PositionComponent myPC = (PositionComponent) e.getComponent(ComponentType.Position);
            VelocityComponent myVC = (VelocityComponent) e.getComponent(ComponentType.Velocity);
            myPC.setX(myPC.getX() + myVC.getX());
            myPC.setY(myPC.getY() + myVC.getY());
            checkIfInBoundary(myPC);
        }
    }

    private void updateBullets(){
        ArrayList<AbstractEntity> bullets = myEM.getEntitiesOfType(EntityType.Bullet);
        int currentBullet = 0;
        while(currentBullet < bullets.size()) {
            PositionComponent myPC = (PositionComponent) bullets.get(currentBullet).getComponent(ComponentType.Position);
            if (myPC.getY() < 0) {
                bullets.remove(currentBullet);
            } else {
                VelocityComponent myVC = (VelocityComponent) bullets.get(currentBullet).getComponent(ComponentType.Velocity);
                myPC.setX(myPC.getX() + myVC.getX());
                myPC.setY(myPC.getY() + myVC.getY());
                currentBullet++;
            }
        }
    }

    private void checkIfInBoundary(PositionComponent entityPosition){
        if(entityPosition.getX() < 0){
            entityPosition.setX(0);
        }
    }

    private void updateEnemies() {
        //TODO: implement enemy movement
    }

}
