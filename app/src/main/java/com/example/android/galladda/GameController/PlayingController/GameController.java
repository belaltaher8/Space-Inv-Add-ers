package com.example.android.galladda.GameController.PlayingController;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.android.galladda.QuestionActivity;
import com.example.android.galladda.Model.Engines.ChallengeType;
import com.example.android.galladda.Model.GameModel;
import com.example.android.galladda.View.QuestionView.MathView;
import com.example.android.galladda.View.PlayingView.GameView;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class GameController implements Runnable{

    private volatile boolean playing;

    private GameView myGameView;
    private GameModel myGameModel;
    private MathView myMathView;
    private LevelHandler myLevelHandler;
    private ChallengeHandler myChallengeHandler;

    private Thread gameThread = null;

    long fps;

    private long timeThisFrame;

    Context myContext;

    public GameController(Context context){
        playing = true;
        myContext = context;
        myLevelHandler = new LevelHandler(myContext);
        myGameView = new GameView(myContext, myLevelHandler.getCurrentLevelEM());
        myLevelHandler.takeInScreenDimensions(myGameView.getScreenDimensions());
        myLevelHandler.resetPlayerOne();
        myGameModel = new GameModel(myLevelHandler.getCurrentLevelEM());
        myChallengeHandler = new ChallengeHandler(myLevelHandler.getCurrentLevelEM(), myGameModel.getMyChallengeEngine());
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
            if(myChallengeHandler.checkIfChallengeOccured()!=null){
                executeChallengeOfType(myChallengeHandler.checkIfChallengeOccured());
            }
        }
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


    private void executeChallengeOfType(ChallengeType CT){
        myChallengeHandler.getMyChallengeEngine().reset();
        pause();
        Intent intent = new Intent();
        intent.setClass(myContext, QuestionActivity.class); //TODO: add info to this so it knows what kind of challenge
        myContext.startActivity(intent);
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

    public boolean checkPlaying(){
        return playing;
    }

}

