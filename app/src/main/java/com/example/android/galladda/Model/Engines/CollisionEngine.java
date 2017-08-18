package com.example.android.galladda.Model.Engines;

import android.graphics.Bitmap;
import android.graphics.Rect;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Entities.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.BulletEntity;
import com.example.android.galladda.EntityComponent.Entities.EnemyEntity;
import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.EntityType;

import java.util.ArrayList;

/**
 * Created by Belal Taher on 8/17/2017.
 */

public class CollisionEngine extends AbstractEngine {
    
    public CollisionEngine(EntityManager aEM){
        super(aEM);
    }

    
    @Override
    public void update() {
        boolean killed = false;
        ArrayList<AbstractEntity> myBullets =  myEM.getEntitiesOfType(EntityType.Bullet);
        ArrayList<AbstractEntity> myEnemies = myEM.getEntitiesOfType(EntityType.MathEnemy);
        int currentBulletIndex = 0;
        while(currentBulletIndex < myBullets.size()){
            BulletEntity currentBullet = (BulletEntity) myBullets.get(currentBulletIndex);
            PositionComponent bulletPos = (PositionComponent) currentBullet.getComponent(ComponentType.Position);
            Bitmap bulletBitmap = myEM.getBitmap(EntityType.Bullet);
            Rect myBulletCollisionSensor = new Rect((int) bulletPos.getX(), (int) bulletPos.getY(), (int) bulletPos.getX()+bulletBitmap.getWidth(), (int) bulletPos.getY() + bulletBitmap.getHeight());
            int currentEnemyIndex = 0;
            while(currentEnemyIndex < myEnemies.size()){
                EnemyEntity currentEnemy = (EnemyEntity) myEnemies.get(currentEnemyIndex);
                PositionComponent enemyPos = (PositionComponent) currentEnemy.getComponent(ComponentType.Position);
                Bitmap enemyBitmap = myEM.getBitmap(EntityType.MathEnemy);
                Rect myEnemyCollisionSensor = new Rect((int) enemyPos.getX(), (int) enemyPos.getY(), (int) enemyPos.getX() + enemyBitmap.getWidth(), (int) enemyPos.getY() + enemyBitmap.getHeight());
                if(myEnemyCollisionSensor.intersect(myBulletCollisionSensor)){
                    myBullets.remove(currentBullet);
                    myEnemies.remove(currentEnemy);
                    killed = true;
                    break;
                }
                else{
                    currentEnemyIndex++;
                }
            }
            if(killed == false){
                currentBulletIndex++;
            }
            else{
                killed = false;
            }

        }
    }
}
