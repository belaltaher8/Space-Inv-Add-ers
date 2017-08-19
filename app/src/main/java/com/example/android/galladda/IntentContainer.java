package com.example.android.galladda;

import android.content.Intent;

import com.example.android.galladda.Model.Engines.ChallengeType;

/**
 * Created by Belal Taher on 8/19/2017.
 */

public class IntentContainer {

    private Intent myIntent;
    private ChallengeType myCT;

    public IntentContainer(Intent aIntent, ChallengeType aCT){
        myIntent = aIntent;
        myCT = aCT;
    }

    public Intent getMyIntent(){
        return myIntent;
    }

    public ChallengeType getMyCT(){
        return myCT;
    }
}
