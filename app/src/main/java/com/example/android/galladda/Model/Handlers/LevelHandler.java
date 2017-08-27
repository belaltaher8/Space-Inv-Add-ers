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

    public void initializeEnemiesForLevel(int level){
        resetPlayerOne();
        if(level == 1){
            ArrayList<AbstractEntity> myEnemies = currentLevelEM.getEntitiesOfType(EntityType.MathEnemy);
            for(int i = 1 ; i < 4; i++){
                MathEnemyEntity enemyToAdd = new MathEnemyEntity();
                PositionComponent enemyPC = (PositionComponent) enemyToAdd.getComponent(ComponentType.Position);
                enemyPC.setY(100*i);
                enemyPC.setX(screenWidth/2);
                MathEnemyEntity enemyToAdd2 = new MathEnemyEntity();
                PositionComponent enemyPC2 = (PositionComponent) enemyToAdd2.getComponent(ComponentType.Position);
                enemyPC2.setY(100*i);
                enemyPC2.setX(screenWidth/2+200);
                MathEnemyEntity enemyToAdd3 = new MathEnemyEntity();
                PositionComponent enemyPC3 = (PositionComponent) enemyToAdd3.getComponent(ComponentType.Position);
                enemyPC3.setY(100*i);
                enemyPC3.setX(screenWidth/2-200);
                myEnemies.add(enemyToAdd);
                myEnemies.add(enemyToAdd2);
                myEnemies.add(enemyToAdd3);

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
