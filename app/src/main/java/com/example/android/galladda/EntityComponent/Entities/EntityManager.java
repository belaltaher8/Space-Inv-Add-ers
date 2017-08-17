package com.example.android.galladda.EntityComponent.Entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class EntityManager {

    private HashMap<EntityType, ArrayList<AbstractEntity>> myEntities;

    public EntityManager(){
        myEntities = new HashMap<EntityType, ArrayList<AbstractEntity>>();
        for(EntityType ET : EntityType.values()){
            myEntities.put(ET, new ArrayList<AbstractEntity>());
        }
    }

    public ArrayList<AbstractEntity> getEntitiesOfType(EntityType ET){
        return myEntities.get(ET);
    }

    public void addBullet(BulletEntity myBullet){
        ArrayList<AbstractEntity> myBullets = myEntities.get(EntityType.Bullet);
        myBullets.add(myBullet);
    }


    public PlayerEntity getPlayerOne(){
        return (PlayerEntity) myEntities.get(EntityType.Player).get(0);
    }


}
