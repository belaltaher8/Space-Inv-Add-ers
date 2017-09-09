package com.example.android.spaceinvadders.Model.Engines;

import com.example.android.spaceinvadders.EntityComponent.Components.ComponentType;
import com.example.android.spaceinvadders.EntityComponent.Components.PositionComponent;
import com.example.android.spaceinvadders.EntityComponent.Components.VelocityComponent;
import com.example.android.spaceinvadders.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.spaceinvadders.EntityComponent.Entities.General.EntityManager;
import com.example.android.spaceinvadders.EntityComponent.Entities.Enum.EntityType;

import java.util.ArrayList;


/**
 * @author Belal Taher
 * Created on 8/15/2017.
 * The MovementEngine class handles updating the position component of entities using the velocity component. It also deals with removing
 * entities from the entity manager after they go past the screen boundaries.
 */

public class MovementEngine extends AbstractEngine {

    //Instance variables that hold the boundaries of the screen
    private int LEFT_SIDE_OF_SCREEN = 0;
    private int RIGHT_SIDE_OF_SCREEN;
    private int TOP_OF_SCREEN = 0;
    private int BOTTOM_OF_SCREEN;

    private int increaseBulletSpeedBy = 0;


    public MovementEngine(EntityManager aEM){
        super(aEM);
    }

    /**
     * This method updates the position component of all entities and checks to see if the update moved any of the entities
     * out of bounds.
     */
    public void update(){
        updateAll();
        checkBoundaries();
    }

    /**
     * This method sets the boundaries of of the screen
     *
     * @param boundaries an 2D array with 2 indices, screenDimensions[0] is the width and screenDimensions[1] is the height
     */
    public void attachBoundaries(int[] boundaries){
        RIGHT_SIDE_OF_SCREEN = boundaries[0];
        BOTTOM_OF_SCREEN = boundaries[1];
    }

    /**
     * This method updates the position of all entities according to the entities' current velocities
     */
    private void updateAll(){
        ArrayList<AbstractEntity> allEntities = myEM.getAllEntities();
        for(AbstractEntity e : allEntities){
            if(e.getExploding() != true) {
                PositionComponent myPC = (PositionComponent) e.getComponent(ComponentType.Position);
                VelocityComponent myVC = (VelocityComponent) e.getComponent(ComponentType.Velocity);
                myPC.setX(myPC.getX() + myVC.getX());
                myPC.setY(myPC.getY() + myVC.getY());
            }
        }
    }

    /**
     * This method checks to see if the last update that occured moved any entities out of bounds. If the entity is a player,
     * it adjusts the position so that the player is still in bounds. If the entity is a bullet, it removes the bullet from the
     * entity manager.
     */
    private void checkBoundaries(){
        ArrayList<AbstractEntity> allEntities = myEM.getAllEntities();
        for(AbstractEntity e : allEntities){
            PositionComponent myPC = (PositionComponent) e.getComponent(ComponentType.Position);

            if(e.getMyEntityType().equals(EntityType.Player)){
                if(myPC.getX() < LEFT_SIDE_OF_SCREEN){
                    myPC.setX(LEFT_SIDE_OF_SCREEN);
                }
                else if (myPC.getX() +150 > RIGHT_SIDE_OF_SCREEN){
                    myPC.setX(RIGHT_SIDE_OF_SCREEN - 150);
                }
            }
            else if (e.getMyEntityType().equals(EntityType.GoodBullet)){
                if(myPC.getY() < TOP_OF_SCREEN){
                    myEM.getEntitiesOfType(EntityType.GoodBullet).remove(e);
                }
            }
            else if (e.getMyEntityType().equals(EntityType.BadBullet)){
                if(myPC.getY() > BOTTOM_OF_SCREEN){
                    myEM.getEntitiesOfType(EntityType.BadBullet).remove(e);
                }
            }
            else if(e.getMyEntityType().name().contains("Enemy")){
                if(myPC.getX() < LEFT_SIDE_OF_SCREEN || myPC.getX() + 120 > RIGHT_SIDE_OF_SCREEN){
                    VelocityComponent myVC = (VelocityComponent) e.getComponent(ComponentType.Velocity);
                    myVC.setX(myVC.getX() * (-1));
                }
            }
        }
    }


}
