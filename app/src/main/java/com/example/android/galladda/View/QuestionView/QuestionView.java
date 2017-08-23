package com.example.android.galladda.View.QuestionView;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Belal Taher on 8/23/2017.
 */

public interface QuestionView {

    public void setUpQuestion();

    public void setUpQuestionScreen(Context myContext);

    public void setUpAnswerButtons(Context myContext);

    public void assignValuesToAnswerButtons(Button[] myButtons, int correctChoice);

    public void assignOnClickTowAnswerButtons(Button[] myButtons, int correctChoice);

    public void setButtonParams(Button[] myButtons, LinearLayout.LayoutParams param);

    public boolean checkIfQuestionAnswered();
}

