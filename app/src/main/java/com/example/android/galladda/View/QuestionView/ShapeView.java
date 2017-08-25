package com.example.android.galladda.View.QuestionView;

import android.content.Context;
import android.widget.Button;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class ShapeView extends QuestionView {

    private String shape = "";

    public ShapeView(Context myContext){
        super(myContext);
    }

    @Override
    protected void setUpQuestion() {
        int shapeToUse = rand.nextInt(3);
        if(shapeToUse == 0){
            shape = "Square";
        }
        else if (shapeToUse == 1){
            shape = "";
        }
        else if (shapeToUse == 2){

        }
    }

    @Override
    protected void assignValuesToAnswerButtons(Button[] myButtons, int correctChoice) {

    }
}
