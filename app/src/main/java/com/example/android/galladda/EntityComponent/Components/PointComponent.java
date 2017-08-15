package com.example.android.galladda.EntityComponent.Components;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class PointComponent implements IComponent {

    private int points;

    public PointComponent(int startingPoints){
        points = startingPoints;
    }

    public int getPoints(){
        return points;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.Point;
    }
}
