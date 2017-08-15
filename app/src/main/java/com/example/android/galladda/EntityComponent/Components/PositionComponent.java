package com.example.android.galladda.EntityComponent.Components;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class PositionComponent implements IComponent {

    private int myX;
    private int myY;

    public PositionComponent(int x, int y){
        myX = x;
        myY = y;
    }

    public void setX(int newX){
        myX = newX;
    }

    public void setY(int newY){
        myY = newY;
    }

    public int getX(){
        return myX;
    }

    public int getY(){
        return myY;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.Position;
    }
}
