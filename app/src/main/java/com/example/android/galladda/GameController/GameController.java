package com.example.android.galladda.GameController;

import android.content.Context;
import android.util.Log;

import com.example.android.galladda.Model.GameModel;
import com.example.android.galladda.View.GameView;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class GameController implements Runnable{

    GameView myGameView;
    GameModel myGameModel;
    LevelHandler myLevelHandler;

    private volatile boolean playing;

    private Thread gameThread = null;

    long fps;

    private long timeThisFrame;

    public GameController(Context context){
        playing = true;
        myLevelHandler = new LevelHandler(context);
        myGameView = new GameView(context, myLevelHandler.getCurrentLevelEM());
        myLevelHandler.takeInScreenDimensions(myGameView.getScreenDimensions());
        myLevelHandler.resetPlayerOne();
        myGameModel = new GameModel(myLevelHandler.getCurrentLevelEM());
    }

    public GameView getGameView(){
        return myGameView;
    }

    public GameModel getGameModel(){
        return myGameModel;
    }

    public void run(){
        while (playing){
            long startFrameTime = System.currentTimeMillis();
            myGameModel.update();
            myGameView.draw();
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if(timeThisFrame > 0){
                fps = 1000/timeThisFrame;
            }
        }
    }

    public void pause(){
        playing = false;
        try{
            gameThread.join();
        } catch (InterruptedException e){
            Log.e("Error:", "joining thread");
        }
    }

    public void resume(){
        playing = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

}

