package com.example.android.galladda.EntityComponent.Entities.General;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.android.galladda.EntityComponent.Entities.Bullets.BulletEntity;
import com.example.android.galladda.EntityComponent.Entities.Bullets.GoodBulletEntity;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.EntityComponent.Entities.Player.PlayerEntity;
import com.example.android.galladda.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class EntityManager {

    Context myContext;

    private HashMap<EntityType, ArrayList<AbstractEntity>> myEntities;
    private HashMap<EntityType, Bitmap> entityBitmaps;
    private HashMap<EntityType, Integer> enemyDeaths;

    public EntityManager(Context aContext){
        myContext = aContext;
        setUpBitmapHashMap();
        setUpMyEntities();
        setUpEnemyDeaths();
    }

    public void addEnemyDeath(EntityType ET){
        Integer currentNumOfDeaths = enemyDeaths.get(ET);
        Integer newNumOfDeaths = currentNumOfDeaths + 1;
        enemyDeaths.put(ET, newNumOfDeaths);
    }

    public ArrayList<AbstractEntity> getAllEntities(){
        ArrayList<AbstractEntity> allEntities = new ArrayList<AbstractEntity>();
        for(EntityType e : EntityType.values()){
            allEntities.addAll(getEntitiesOfType(e));
        }
        return allEntities;
    }

    public ArrayList<AbstractEntity> getAllEnemies(){
        ArrayList<AbstractEntity> allEntities = new ArrayList<AbstractEntity>();
        for(EntityType e : EntityType.values()){
            if(e.name().contains("Enemy"))
                allEntities.addAll(getEntitiesOfType(e));
        }
        return allEntities;
    }

    public Bitmap getBitmap(EntityType ET){
        return entityBitmaps.get(ET);
    }

    public ArrayList<AbstractEntity> getEntitiesOfType(EntityType ET){
        return myEntities.get(ET);
    }

    public void addBullet(BulletEntity myBullet){
        EntityType typeOfBullet = myBullet.getMyEntityType();
        ArrayList<AbstractEntity> myBullets = myEntities.get(typeOfBullet);
        myBullets.add(myBullet);
    }


    public HashMap<EntityType, Integer> getEnemyDeaths(){
        return enemyDeaths;
    }

    public PlayerEntity getPlayerOne(){
        return (PlayerEntity) myEntities.get(EntityType.Player).get(0);
    }

    private void setUpEnemyDeaths(){
        enemyDeaths = new HashMap<EntityType, Integer>();
        for(EntityType enemyType : EntityType.values()){
            if(enemyType.name().contains("Enemy")) {
                enemyDeaths.put(enemyType, 0);
            }
        }
    }


    private void setUpMyEntities(){
        myEntities = new HashMap<EntityType, ArrayList<AbstractEntity>>();
        for(EntityType ET : EntityType.values()){
            myEntities.put(ET, new ArrayList<AbstractEntity>());
        }
    }

    private void setUpBitmapHashMap(){
        //TODO: Refactor and create an algorithm for automatically doing this
        entityBitmaps = new HashMap<EntityType, Bitmap>();
        Bitmap bitmapShip = BitmapFactory.decodeResource(this.myContext.getResources(), R.drawable.ship);
        bitmapShip = bitmapShip.createScaledBitmap(bitmapShip,150,150,false);
        entityBitmaps.put(EntityType.Player, bitmapShip);
        entityBitmaps.put(EntityType.GoodBullet, BitmapFactory.decodeResource(this.myContext.getResources(), R.drawable.bullet));
        entityBitmaps.put(EntityType.BadBullet, BitmapFactory.decodeResource(this.myContext.getResources(), R.drawable.badbullet));
        entityBitmaps.put(EntityType.MathEnemy, BitmapFactory.decodeResource(this.myContext.getResources(), R.drawable.mathenemy));
        entityBitmaps.put(EntityType.PuzzleEnemy, BitmapFactory.decodeResource(this.myContext.getResources(), R.drawable.shapeenemy));
        entityBitmaps.put(EntityType.ShapeEnemy, BitmapFactory.decodeResource(this.myContext.getResources(), R.drawable.puzzleenemy));
    }

}
