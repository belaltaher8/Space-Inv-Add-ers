package com.example.android.spaceinvadders.EntityComponent.Components;

/**
 * @author Belal Taher
 * Created on 8/15/2017.
 * The PointComponent class keeps track of the amount of points that the player has accumulated by destroying enemies and answering questions
 */

public class PointComponent implements IComponent {

    private int points;

    public PointComponent(int startingPoints){
        points = startingPoints;
    }

    public int getPoints(){
        return points;
    }

    /**
     * Returns the component type of this component
     *
     * @return the enum indicating that this is a Point Component
     */
    @Override
    public ComponentType getComponentType() {
        return ComponentType.Point;
    }
}
