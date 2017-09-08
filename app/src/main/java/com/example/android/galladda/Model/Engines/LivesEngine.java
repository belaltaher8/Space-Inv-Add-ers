package com.example.android.galladda.Model.Engines;

import android.util.Log;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.LivesComponent;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;
import com.example.android.galladda.EntityComponent.Entities.Player.PlayerEntity;

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
            Log.d("PLAYER", "PLAYER IS DEAD");
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
