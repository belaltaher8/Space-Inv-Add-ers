package com.example.android.galladda.EntityComponent.Entities;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class EntityManager {

    Context myContext;

    private HashMap<EntityType, ArrayList<AbstractEntity>> myEntities;
    private HashMap<EntityType, Bitmap> entityBitmaps;

    public EntityManager(Context aContext){
        myContext = aContext;
        setUpBitmapHashMap();
        myEntities = new HashMap<EntityType, ArrayList<AbstractEntity>>();
        for(EntityType ET : EntityType.values()){
            myEntities.put(ET, new ArrayList<AbstractEntity>());
        }
    }

    private void setUpBitmapHashMap(){
        entityBitmaps = new HashMap<EntityType, Bitmap>();
        Bitmap bitmapShip = BitmapFactory.decodeResource(this.myContext.getResources(), R.drawable.ship);
        bitmapShip = bitmapShip.createScaledBitmap(bitmapShip,150,150,false);
        entityBitmaps.put(EntityType.Player, bitmapShip);
        entityBitmaps.put(EntityType.Bullet, BitmapFactory.decodeResource(this.myContext.getResources(), R.drawable.bullet));
        entityBitmaps.put(EntityType.MathEnemy, BitmapFactory.decodeResource(this.myContext.getResources(), R.drawable.mathenemy));
    }

    public Bitmap getBitmap(EntityType ET){
        return entityBitmaps.get(ET);
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
