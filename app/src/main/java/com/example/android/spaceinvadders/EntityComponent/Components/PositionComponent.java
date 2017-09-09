package com.example.android.spaceinvadders.EntityComponent.Components;

/**
 * @author Belal Taher
 * Created on 8/15/2017.
 * The PositionComponent class holds the current X and Y position of an entity's top left corner
 */

public class PositionComponent implements IComponent {

    private float myX;
    private float myY;

    public PositionComponent(float x, float y){
        myX = x;
        myY = y;
    }

    public void setX(float newX){
        myX = newX;
    }

    public void setY(float newY){
        myY = newY;
    }

    public float getX(){
        return myX;
    }

    public float getY(){
        return myY;
    }

    /**
     * Returns the component type of this component
     *
     * @return the enum indicating that this is a Position Component
     */
    @Override
    public ComponentType getComponentType() {
        return ComponentType.Position;
    }
}
