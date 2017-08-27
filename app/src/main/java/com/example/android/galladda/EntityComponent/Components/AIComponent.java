package com.example.android.galladda.EntityComponent.Components;

import java.util.Random;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class AIComponent implements IComponent {

    public final int SHOOT_TIMER_RESET = 250;
    private int time;
    private int timeToShoot;
    private Random myRand;

    public AIComponent(){
        time = 0;
        myRand = new Random();
        timeToShoot =  myRand.nextInt(250) + 1;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.AI;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int newTime){
        time = newTime;
    }

    public int getTimeToShoot(){
        return timeToShoot;
    }

}
