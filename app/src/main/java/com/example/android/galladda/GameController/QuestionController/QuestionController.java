package com.example.android.galladda.GameController.QuestionController;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.android.galladda.MainActivity;
import com.example.android.galladda.Model.Engines.ChallengeType;
import com.example.android.galladda.QuestionActivity;
import com.example.android.galladda.View.QuestionView.MathView;
import com.example.android.galladda.View.QuestionView.QuestionView;

/**
 * Created by Belal Taher on 8/19/2017.
 */

public class QuestionController implements Runnable {

    private Thread questionThread = null;

    long fps;

    private long timeThisFrame;

    private volatile boolean playing;

    private QuestionView myQuestionView;

    private Context myContext;

    public QuestionController(Context context, ChallengeType CT){
        myContext = context;
        if(CT.equals(ChallengeType.Math)){
            myQuestionView = new MathView(context);
        }
        else if(CT.equals(ChallengeType.Shape)){
         //   myQuestionView = new ShapeView(context);
        }
        else if(CT.equals(ChallengeType.Puzzle)){
          //  myQuestionView = new PuzleView(context);
        }
    }

    public QuestionView getMyQuestionView(){
        return myQuestionView;
    }

    public void run(){
        while (playing){
            boolean answered = playGame();
            if(answered == true){
                ((Activity) myContext).finish();
            }
        }
    }

    private boolean playGame(){
        long startFrameTime = System.currentTimeMillis();
        boolean answered = myQuestionView.checkIfQuestionAnswered();
        timeThisFrame = System.currentTimeMillis() - startFrameTime;
        if(timeThisFrame > 0){
            fps = 1000/timeThisFrame;
        }
        return answered;
    }

    public void pause(){
        playing = false;
        try{
            questionThread.join();
        } catch (InterruptedException e){
            Log.e("Error:", "joining thread");
        }
    }

    public void resume(){
        playing = true;
        questionThread = new Thread(this);
        questionThread.start();
    }


}
