package com.example.android.spaceinvadders.EntityComponent.Components;

import java.util.Random;

/**
 * @author Belal Taher
 * Created on 8/25/2017.
 * The AIComponent class is used with the EnemyEngine to simulate pseudo-random shooting patterns for the enemy entities
 */

public class AIComponent implements IComponent {

    //This constant adjusts the rate at which enemy entities shoot
    public final int SHOOT_TIMER_RESET = 250;

    //These instance variable are used to indicate the current time for the entity holding this component
    //and the time at which the entity holding this component will shoot
    //timeToShoot should always be a value between 0 and SHOOT_TIMER_RESET
    private int time;
    private int timeToShoot;
    private Random myRand;

    public AIComponent(){
        time = 0;
        myRand = new Random();
        timeToShoot =  myRand.nextInt(250) + 1;
    }

    /**
     * Returns the component type of this component
     * @return the enum indicating this is an AI component
     */
    @Override
    public ComponentType getComponentType() {
        return ComponentType.AI;
    }

    /**
     * Returns the current time value of this component
     *
     * @return the current tiem value of this component
     */
    public int getTime(){
        return time;
    }

    /**
     * Sets the new time value of this component
     *
     * @param newTime the new time to store into the instance variable time
     */
    public void setTime(int newTime){
        time = newTime;
    }

    /**
     * Gets the time at which the entity that has this component should shoot at
     *
     * @return the time at which the entity that has this component should shoot at
     */
    public int getTimeToShoot(){
        return timeToShoot;
    }

}
