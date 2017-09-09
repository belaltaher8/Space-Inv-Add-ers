package com.example.android.spaceinvadders.EntityComponent.Components;

/**
 * Created by Belal Taher on 9/7/2017.
 */

public class DeathComponent implements IComponent {

    private boolean dead;

    public DeathComponent(){
        dead = false;
    }

    public void die(){
        dead = true;
    }

    public boolean checkIfDead(){
        return dead;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.Death;
    }
}
