package com.example.android.galladda.GameController;

import android.util.DisplayMetrics;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.EnemyEntity;
import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.EntityType;
import com.example.android.galladda.EntityComponent.Entities.PlayerEntity;

import java.util.ArrayList;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class LevelHandler {

    EntityManager currentLevelEM;

    public LevelHandler(){
        currentLevelEM = new EntityManager();
        resetPlayer();
        initializeLevelOne();
        //TODO: Add XML compatibility
    }

    private void initializeLevelOne(){
        PlayerEntity myPlayer = currentLevelEM.getPlayerOne();
        PositionComponent playerPos = (PositionComponent) myPlayer.getComponent(ComponentType.Position);
        playerPos.setX(0);
        playerPos.setY(0);
        initializeEnemiesForLevel(1);
    }

    private void resetPlayer(){
        ArrayList<AbstractEntity> myPlayers =currentLevelEM.getEntitiesOfType(EntityType.Player);
        myPlayers.add(new PlayerEntity());
    }

    private void initializeEnemiesForLevel(int level){
        if(level == 1){
            ArrayList<AbstractEntity> myEnemies = currentLevelEM.getEntitiesOfType(EntityType.MathEnemy);
            for(int i = 1; i < 4; i ++){
                EnemyEntity enemyToAdd = new EnemyEntity();
                PositionComponent enemyPC = (PositionComponent) enemyToAdd.getComponent(ComponentType.Position);
                enemyPC.setY(20);
                enemyPC.setX(200*i);
                myEnemies.add(enemyToAdd);
            }
        }
    }

    public EntityManager getCurrentLevelEM(){
        return currentLevelEM;
    }
}
