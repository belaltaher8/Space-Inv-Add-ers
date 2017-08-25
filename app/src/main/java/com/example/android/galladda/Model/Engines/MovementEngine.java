package com.example.android.galladda.Model.Engines;

import android.content.Entity;
import android.util.Log;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;

import java.util.ArrayList;


/**
 * Created by Belal Taher on 8/15/2017.
 */

public class MovementEngine extends AbstractEngine {

    public final int LEFT_SIDE_OF_SCREEN = 0;

    public final int TOP_OF_SCREEN = 0;

    public MovementEngine(EntityManager aEM){
        super(aEM);
    }

    public void update(){
        updateAll();
        checkBoundaries();
    }

    private void updateAll(){
        ArrayList<AbstractEntity> allEntities = getAllEntities();

        for(AbstractEntity e : allEntities){
            PositionComponent myPC = (PositionComponent) e.getComponent(ComponentType.Position);
            VelocityComponent myVC = (VelocityComponent) e.getComponent(ComponentType.Velocity);
            myPC.setX(myPC.getX() + myVC.getX());
            myPC.setY(myPC.getY() + myVC.getY());
        }
    }

    private void checkBoundaries(){
        ArrayList<AbstractEntity> allEntities = getAllEntities();

        for(AbstractEntity e : allEntities){
            PositionComponent myPC = (PositionComponent) e.getComponent(ComponentType.Position);
            if(e.getMyEntityType().equals(EntityType.Player)){
                if(myPC.getX() < LEFT_SIDE_OF_SCREEN){
                    myPC.setX(LEFT_SIDE_OF_SCREEN);
                }
                //TODO: ADD RIGHT BOUNDARY FIND A WAY TO PASS SCREEN SIZE TO MOVEMENT ENGINE
            }
            else if (e.getMyEntityType().equals(EntityType.Bullet)){
                if(myPC.getY() < TOP_OF_SCREEN){
                    myEM.getEntitiesOfType(EntityType.Bullet).remove(e);
                }
            }
        }
    }

    private ArrayList<AbstractEntity> getAllEntities(){
        ArrayList<AbstractEntity> allEntities = new ArrayList<AbstractEntity>();
        for(EntityType e : EntityType.values()){
            allEntities.addAll(myEM.getEntitiesOfType(e));
        }
        return allEntities;
    }

}
