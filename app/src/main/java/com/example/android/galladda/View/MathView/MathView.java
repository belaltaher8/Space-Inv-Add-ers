package com.example.android.galladda.View.MathView;

import android.content.Context;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * Created by Belal Taher on 8/19/2017.
 */

public class MathView extends LinearLayout {

    private int answer;

    public MathView(Context context){
        super(context);
        setOrientation(LinearLayout.VERTICAL);
        setUpQuestion();
        setUpQuestionScreen(context);
        //setUpSubmitButtons(context);
    }

    private void setUpQuestion(){
        Random rand = new Random();
        int firstNum = rand.nextInt(21);
        int secondNum = rand.nextInt(21);
        int operation = rand.nextInt(3);
        int answer;
        if(operation == 0){  //ADDITION
            answer = firstNum + secondNum;
        }
        if(operation == 1) { //SUBTRACTION
            answer = firstNum - secondNum;
        }
        if(operation == 2){ //MULTIPLICATION
            answer = firstNum * secondNum;
        }
    }

    private void setUpQuestionScreen(Context context){

    }

    private void setUpAnswerButtons(Context context){

    }
}
