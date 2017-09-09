package com.example.android.spaceinvadders.View.QuestionView;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author Belal Taher
 * Created on 8/19/2017.
 * The MathView class is the view that's loaded when a math challenge is executed
 */

public class MathView extends QuestionView {

    //All the necessary components of a math equation
    private int answer;
    private int firstNum;
    private int secondNum;
    private String operatorSymbol;

    public MathView(Context context){
        super(context);
    }

    /**
     * This method randomly generates and stores the math question
     */
    protected void setUpQuestion(){

        //The first and second number are any random number from 0-20
        firstNum = rand.nextInt(21);
        secondNum = rand.nextInt(21);

        //The operation is one of three: addition, subtraction, or multiplcation
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

    /**
     * This method sets up question screen
     * @param context context for this activity
     */
    protected void setUpQuestionScreen(Context context){
        super.setUpQuestionScreen(context);

        //Sets the prompt text and equation text and adds it to the view
        questionText.setText("What is the answer to the following equation?");
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

    /**
     * This method assigns generates false values for the answer buttons and assigns them to all but one button. That one
     * button is assigned the correct answer choice
     */
    protected void assignValuesToAnswerButtons(){
        //Sets the text for the correct choice as the answer
        myButtons[correctChoice].setText("" + answer);
        int[] choicesUsed = new int[4];
        choicesUsed[correctChoice] = answer;
        //Iterates through the other answer buttons and adds a random offset between 1-10 to the answer to generate fake answers
        for(int i = 0; i < myButtons.length; i++){
            if(!(myButtons[i].getText().equals("" + answer))){

                int fakeAnswer;
                boolean repeat;
                do {
                    repeat = false;
                    int offset = rand.nextInt((10) + 1) - 5;
                    fakeAnswer = answer + offset;

                    for (int j = 0; j < choicesUsed.length; j++) {
                        if (choicesUsed[j] == fakeAnswer) {
                            repeat = true;
                        }
                    }
                }while(repeat);

                choicesUsed[i] = fakeAnswer;
                myButtons[i].setText("" + fakeAnswer);

            }
        }
    }
}
