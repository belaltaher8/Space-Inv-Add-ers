package com.example.android.spaceinvadders.EntityComponent.Components;

/**
 * Created by Belal Taher on 9/7/2017.
 */

public class FrameComponent implements IComponent {

    public static final int ADJUSTMENT_FACTOR = 2;

    private int currentFrame;
    private int numOfFrames;

    private boolean repeat;

    public FrameComponent(int aNumOfFrames, boolean aRepeat){
        repeat = aRepeat;
        numOfFrames = aNumOfFrames;
        currentFrame = 1;
    }

    public void nextFrame(){
        currentFrame++;
    }

    public int getFrame(){
        return currentFrame/ADJUSTMENT_FACTOR;
    }

    public boolean isDone(){
        if(currentFrame/ADJUSTMENT_FACTOR >= numOfFrames){
            return true;
        }
        return false;
    }

    public boolean shouldRepeat(){
        return repeat;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.Frame;
    }
}
