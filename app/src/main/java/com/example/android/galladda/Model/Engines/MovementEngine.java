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

    private int LEFT_SIDE_OF_SCREEN = 0;
    private int RIGHT_SIDE_OF_SCREEN;
    private int TOP_OF_SCREEN = 0;
    private int BOTTOM_OF_SCREEN;


    public MovementEngine(EntityManager aEM){
        super(aEM);
    }

    public void update(){
        updateAll();
        checkBoundaries();
    }

    public void attachBoundaries(int[] boundaries){
        RIGHT_SIDE_OF_SCREEN = boundaries[0] - 150;
        BOTTOM_OF_SCREEN = boundaries[1];
    }

    private void updateAll(){
        ArrayList<AbstractEntity> allEntities = myEM.getAllEntities();
        for(AbstractEntity e : allEntities){
            PositionComponent myPC = (PositionComponent) e.getComponent(ComponentType.Position);
            VelocityComponent myVC = (VelocityComponent) e.getComponent(ComponentType.Velocity);
            myPC.setX(myPC.getX() + myVC.getX());
            myPC.setY(myPC.getY() + myVC.getY());
        }
    }

    private void checkBoundaries(){
        ArrayList<AbstractEntity> allEntities = myEM.getAllEntities();
        for(AbstractEntity e : allEntities){
            PositionComponent myPC = (PositionComponent) e.getComponent(ComponentType.Position);
            if(e.getMyEntityType().equals(EntityType.Player)){
                if(myPC.getX() < LEFT_SIDE_OF_SCREEN){
                    myPC.setX(LEFT_SIDE_OF_SCREEN);
                }
                else if (myPC.getX() > RIGHT_SIDE_OF_SCREEN){
                    myPC.setX(RIGHT_SIDE_OF_SCREEN);
                }
            }
            else if (e.getMyEntityType().equals(EntityType.Bullet)){
                if(myPC.getY() < TOP_OF_SCREEN){
                    myEM.getEntitiesOfType(EntityType.Bullet).remove(e);
                }
            }
            //TODO: ELSE IF FOR ENEMY BULLETS
        }
    }


}
