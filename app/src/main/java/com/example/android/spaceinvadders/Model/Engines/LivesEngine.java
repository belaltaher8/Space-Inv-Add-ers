package com.example.android.spaceinvadders.Model.Engines;

import com.example.android.spaceinvadders.EntityComponent.Components.ComponentType;
import com.example.android.spaceinvadders.EntityComponent.Components.LivesComponent;
import com.example.android.spaceinvadders.EntityComponent.Entities.General.EntityManager;
import com.example.android.spaceinvadders.EntityComponent.Entities.Player.PlayerEntity;

/**
 * Created by Belal Taher on 9/7/2017.
 */

public class LivesEngine extends AbstractEngine {

    private boolean playerDied = false;

    public LivesEngine(EntityManager myEM){
        super(myEM);
    }

    @Override
    public void update() {
        PlayerEntity myPlayer = myEM.getPlayerOne();
        LivesComponent myLives = (LivesComponent) myPlayer.getComponent(ComponentType.Lives);
        if(myLives.getLives() <= 0){
            playerDied = true;
        }
    }

    public boolean checkIfPlayerDied(){
        return playerDied;
    }

    public void reset(){
        playerDied = false;
        PlayerEntity myPlayer = myEM.getPlayerOne();
        LivesComponent myLives = (LivesComponent) myPlayer.getComponent(ComponentType.Lives);
        myLives.resetLives();
    }
}
