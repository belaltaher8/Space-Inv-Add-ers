package com.example.android.galladda.View.QuestionView;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.galladda.R;

import java.util.ArrayList;
import java.util.Stack;

import static android.R.attr.shape;

/**
 * Created by Belal Taher on 9/8/2017.
 */

public class PuzzleView extends QuestionView {

    private String shape = "";

    public PuzzleView(Context myContext){
        super(myContext);
    }

    @Override
    protected void setUpQuestion() {
        int shapeToUse = rand.nextInt(4);
        if(shapeToUse == 0){
            shape = "Square";
        }
        else if(shapeToUse == 1){
            shape = "Triangle";
        }
        else if(shapeToUse == 2){
            shape = "Rectangle";
        }
        else if(shapeToUse == 3){
            shape = "Circle";
        }
    }

    /**
     * This method sets up question screen
     * @param context context for this activity
     */
    protected void setUpQuestionScreen(Context context){
        super.setUpQuestionScreen(context);

        //Sets the prompt text and equation text and adds it to the view
        questionText.setText("What is the name of the following shape?");


        FrameLayout myFrame = new FrameLayout(context);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                0,
                3.0f
        );
        myFrame.setLayoutParams(param);

        ImageView myImageView = new ImageView(context);
        if(shape.equals("Square")){
            myImageView.setBackgroundResource(R.drawable.square);
        }
        else if(shape.equals("Triangle")){
            myImageView.setBackgroundResource(R.drawable.triangle);
        }
        else if(shape.equals("Rectangle")){
            myImageView.setBackgroundResource(R.drawable.rectangle);
        }
        else if(shape.equals("Circle")){
            myImageView.setBackgroundResource(R.drawable.circle);
        }

        LinearLayout.LayoutParams param2 = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT
        );
        param2.gravity = Gravity.CENTER;
        myImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        myImageView.setAdjustViewBounds(true);

        myFrame.addView(myImageView);
        this.addView(myFrame);

    }

    @Override
    protected void assignValuesToAnswerButtons() {
        if(shape.equals("Square")){
            correctChoice = 0;
        }
        else if(shape.equals("Rectangle")){
            correctChoice = 1;
        }
        else if(shape.equals("Triangle")){
            correctChoice = 2;
        }
        else if(shape.equals("Circle")){
            correctChoice = 3;
        }
        myButtons[0].setText("Square");
        myButtons[1].setText("Rectangle");
        myButtons[2].setText("Triangle");
        myButtons[3].setText("Circle");

    }
}
