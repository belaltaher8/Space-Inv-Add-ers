package com.example.android.galladda.Controller.GameController;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.android.galladda.Activities.QuestionActivity;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.Model.GameModel.GameModel;
import com.example.android.galladda.View.GameView.GameView;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class GameController implements Runnable{

    private volatile boolean playing;

    private GameView myGameView;
    private GameModel myGameModel;

    private Thread gameThread = null;

    long fps;

    private long timeThisFrame;

    Context myContext;

    public GameController(Context context){
        playing = false;
        myContext = context;
        myGameView = new GameView(myContext);
        myGameModel = new GameModel(myContext);
        myGameModel.takeInScreenDimensions(myGameView.getScreenDimensions());
        myGameView.attachEM(myGameModel.getMyLevelHandler().getCurrentLevelEM());
        myGameModel.getMyLevelHandler().initializeLevel(1);
    }

    public GameView getGameView(){
        return myGameView;
    }

    public GameModel getGameModel(){
        return myGameModel;
    }

    public void run(){
        while (playing){
            playGame();
            if(myGameModel.getMyChallengeHandler().checkIfChallengeOccured()==true){
                executeChallengeOfType(myGameModel.getMyChallengeHandler().getMyChallengeType());
                myGameModel.getMyChallengeHandler().getMyChallengeEngine().reset();
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

    private void playGame(){
        long startFrameTime = System.currentTimeMillis();
        myGameModel.update();
        myGameView.draw();
        timeThisFrame = System.currentTimeMillis() - startFrameTime;
        if(timeThisFrame > 0){
            fps = 1000/timeThisFrame;
        }
    }


    private void executeChallengeOfType(EntityType CT){
        Intent intent = new Intent();
        intent.putExtra("Challenge Type", CT.name());
        intent.setClass(myContext, QuestionActivity.class);
        myContext.startActivity(intent);
    }



}

