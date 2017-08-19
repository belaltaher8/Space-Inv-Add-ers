package com.example.android.galladda.GameController.QuestionController;

import android.content.Context;

import com.example.android.galladda.Model.Engines.ChallengeType;
import com.example.android.galladda.View.QuestionView.MathView;

/**
 * Created by Belal Taher on 8/19/2017.
 */

public class QuestionController {

    private QuestionView myQuestionView;

    public QuestionController(Context context, ChallengeType CT){
        if(CT.equals(ChallengeType.Math)){
            myQuestionView = new MathView(context);
        }
        else if(CT.equals(ChallengeType.Shape)){
            myQuestionView = new ShapeView(context);
        }
        else if(CT.equals(ChallengeType.Puzzle)){
            myQuestionView = new PuzleView(context);
        }
    }
}
