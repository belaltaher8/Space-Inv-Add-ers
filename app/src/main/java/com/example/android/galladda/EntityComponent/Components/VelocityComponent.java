package com.example.android.galladda.EntityComponent.Components;

/**
 * @author Belal Taher
 * Created on 8/15/2017.
 * The VelocityComponent class holds the current X and Y velocity of the entity
 */

public class VelocityComponent implements IComponent {

    //The current X and Y velocity of the entity
    private float myX;
    private float myY;

    /**
     * Constructs a new velocity component
     * @param x starting X velocity
     * @param y starting Y velocity
     */
    public VelocityComponent(float x, float y){
        myX = x;
        myY = y;
    }

    /**
     * This method is used to set a new X velocity
     * @param newX the new X velocity
     */
    public void setX(float newX){
        myX = newX;
    }


    /**
     * This method is used to set a new Y velocity
     * @param newY the new Y velocity
     */
    public void setY(float newY){
        myY = newY;
    }

    /**
     * This method returns the current X velocity
     * @return the current X velocity
     */
    public float getX(){
        return myX;
    }

    /**
     * This method returns the current Y velocity
     * @return the current Y velocity
     */
    public float getY(){
        return myY;
    }

    /**
     * Returns the component type of this component
     * @return the enum indicating that this is a Velocity Component
     */
    @Override
    public ComponentType getComponentType() {
        return ComponentType.Velocity;
    }
}
