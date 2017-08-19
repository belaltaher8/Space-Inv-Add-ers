package com.example.android.galladda.GameController.PlayingController;

import android.content.Context;
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

import static android.R.attr.width;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class LevelHandler {

    EntityManager currentLevelEM;

    private int screenWidth;
    private int screenHeight;

    public LevelHandler(Context myContext){
        currentLevelEM = new EntityManager(myContext);
        createPlayer();
        initializeEnemiesForLevel(1);
        //TODO: Add XML compatibility
    }

    public void resetPlayerOne(){
        PositionComponent playerPC = (PositionComponent)currentLevelEM.getPlayerOne().getComponent(ComponentType.Position);
        playerPC.setX(screenWidth/2-75);
        playerPC.setY(screenHeight/1.5f);
    }

    public void takeInScreenDimensions(int[] screenDimensions){
        screenWidth = screenDimensions[0];
        screenHeight = screenDimensions[1];
    }

    private void createPlayer(){
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
