package com.example.android.galladda.EntityComponent.Components;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class AIComponent implements IComponent {

    private int timeToShoot;

    public AIComponent(){
        timeToShoot = 10;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.AI;
    }

    public int getTimeToShoot(){
        return timeToShoot;
    }

    public void setTimeToShoot(int newTime){
        timeToShoot = newTime;
    }

}
