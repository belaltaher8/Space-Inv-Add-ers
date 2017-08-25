package com.example.android.galladda.View.QuestionView;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.galladda.R;

import java.util.Random;

/**
 * Created by Belal Taher on 8/19/2017.
 */

public class MathView extends QuestionView {

    private int answer;
    private int firstNum;
    private int secondNum;
    private String operatorSymbol;

    public MathView(Context context){
        super(context);
    }

    protected void setUpQuestion(){
        rand = new Random();
        firstNum = rand.nextInt(21);
        secondNum = rand.nextInt(21);
        int operation = rand.nextInt(3);
        if(operation == 0){  //ADDITION
            answer = firstNum + secondNum;
            operatorSymbol = " + ";
        }
        if(operation == 1) { //SUBTRACTION
            answer = firstNum - secondNum;
            operatorSymbol = " - ";
        }
        if(operation == 2){ //MULTIPLICATION
            answer = firstNum * secondNum;
            operatorSymbol = " * ";
        }
    }

    protected void setUpQuestionScreen(Context context){
        super.setUpQuestionScreen(context);
        questionText.setText("What is the answer the following equation?");
        String equation = firstNum + operatorSymbol + secondNum;
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                2.0f
        );
        TextView equationText = new TextView(context);
        equationText.setText(equation);
        equationText.setLayoutParams(param);
        equationText.setTextColor(Color.WHITE);
        equationText.setGravity(Gravity.CENTER);
        this.addView(equationText);
    }


    protected void assignValuesToAnswerButtons(Button[] myButtons, int correctChoice){
        myButtons[correctChoice].setText("" + answer);
        for(int i = 0; i < myButtons.length; i++){
            if(!(myButtons[i].getText().equals("" + answer))){
                int offset = rand.nextInt(10)+1;
                int fakeAnswer = answer+offset;
                myButtons[i].setText("" + fakeAnswer);
            }
        }
    }
}
