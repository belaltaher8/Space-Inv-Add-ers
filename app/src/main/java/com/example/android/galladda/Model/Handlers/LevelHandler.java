package com.example.android.galladda.Model.Handlers;

import android.content.Context;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.Enemies.MathEnemyEntity;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.EntityComponent.Entities.Player.PlayerEntity;

import java.util.ArrayList;

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
    }

    public void takeInScreenDimensions(int[] screenDimensions){
        screenWidth = screenDimensions[0];
        screenHeight = screenDimensions[1];
        resetPlayerOne();
    }

    private void createPlayer(){
        ArrayList<AbstractEntity> myPlayers = currentLevelEM.getEntitiesOfType(EntityType.Player);
        myPlayers.add(new PlayerEntity());
    }

    private void initializeEnemiesForLevel(int level){
        resetPlayerOne();
        if(level == 1){
            ArrayList<AbstractEntity> myEnemies = currentLevelEM.getEntitiesOfType(EntityType.MathEnemy);
            for(int i = 1; i < 5; i ++){
                MathEnemyEntity enemyToAdd = new MathEnemyEntity();
                PositionComponent enemyPC = (PositionComponent) enemyToAdd.getComponent(ComponentType.Position);
                enemyPC.setY(20);
                enemyPC.setX(200*i);
                myEnemies.add(enemyToAdd);
            }
        }
    }

    private void resetPlayerOne(){
        PositionComponent playerPC = (PositionComponent)currentLevelEM.getPlayerOne().getComponent(ComponentType.Position);
        playerPC.setX(screenWidth/2-75);
        playerPC.setY(screenHeight/1.5f);
    }

    public EntityManager getCurrentLevelEM(){
        return currentLevelEM;
    }
}
