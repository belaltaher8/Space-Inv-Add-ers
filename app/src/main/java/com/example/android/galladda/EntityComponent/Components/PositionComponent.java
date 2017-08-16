package com.example.android.galladda.EntityComponent.Components;

/**
 * Created by Belal Taher on 8/15/2017.
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

    @Override
    public ComponentType getComponentType() {
        return ComponentType.Position;
    }
}
