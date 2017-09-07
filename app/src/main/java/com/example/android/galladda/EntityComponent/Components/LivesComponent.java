package com.example.android.galladda.EntityComponent.Components;

/**
 * Created by Belal Taher on 9/7/2017.
 */

public class LivesComponent implements IComponent {

    private int lives;

    public LivesComponent(){
        lives = 3;
    }

    public void loseALife(){
        lives = lives -1;
    }

    public int getLives(){
        return lives;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.Lives;
    }
}
