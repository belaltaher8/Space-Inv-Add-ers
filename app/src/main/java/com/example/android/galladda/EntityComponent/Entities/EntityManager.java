package com.example.android.galladda.EntityComponent.Entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class EntityManager{

    private HashMap<EntityType, ArrayList<AbstractEntity>> myEntities;

    public EntityManager(){
        myEntities = new HashMap<EntityType, ArrayList<AbstractEntity>>();
        for(EntityType ET : EntityType.values()){
            myEntities.put(ET, null);
        }
        addPlayer();
    }

    public ArrayList<AbstractEntity> getPlayers(){
        return myEntities.get(EntityType.Player);
    }

    public ArrayList<AbstractEntity> getMathEnemies(){
        return myEntities.get(EntityType.MathEnemy);
    }

    public ArrayList<AbstractEntity> getPuzzleEnemies(){
        return myEntities.get(EntityType.PuzzleEnemy);
    }

    public ArrayList<AbstractEntity> getShapesEnemies(){
        return myEntities.get(EntityType.ShapesEnemy);
    }

    public ArrayList<AbstractEntity> getAllEnemies(){
        ArrayList<AbstractEntity> allEnemies = new ArrayList<AbstractEntity>();
        allEnemies.addAll(this.getMathEnemies());
        allEnemies.addAll(this.getPuzzleEnemies());
        allEnemies.addAll(this.getShapesEnemies());
        return allEnemies;
    }

    private void addPlayer(){
        ArrayList<AbstractEntity> myPlayers = new ArrayList<AbstractEntity>();
        myPlayers.add(new PlayerEntity());
        myEntities.put(EntityType.Player, myPlayers);
    }
}
