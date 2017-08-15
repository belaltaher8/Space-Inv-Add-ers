package com.example.android.galladda.Model;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.PlayerEntity;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class LevelHandler {

    EntityManager currentLevelEM;

    public LevelHandler(){
        currentLevelEM = new EntityManager();
        initializeLevelOne();
        //TODO: Add XML compatibility
    }

    private void initializeLevelOne(){
        PlayerEntity myPlayer = (PlayerEntity) currentLevelEM.getPlayers().get(0);
        PositionComponent playerPos = (PositionComponent) myPlayer.getComponent(ComponentType.Position);
        playerPos.setX(0);
        playerPos.setY(0);
    }

    public EntityManager getCurrentLevelEM(){
        return currentLevelEM;
    }
}
