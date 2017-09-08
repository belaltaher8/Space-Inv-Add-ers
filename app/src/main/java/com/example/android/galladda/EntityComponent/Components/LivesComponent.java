package com.example.android.galladda.EntityComponent.Components;

/**
 * Created by Belal Taher on 9/7/2017.
 */

public class LivesComponent implements IComponent {

    private int lives;

    public static final int AMOUNT_OF_LIVES = 15;

    public LivesComponent(){
        lives = AMOUNT_OF_LIVES;
    }

    public void loseALife(){
        lives = lives -1;
    }

    public int getLives(){
        return lives;
    }

    public void resetLives(){
        lives = AMOUNT_OF_LIVES;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.Lives;
    }
}
