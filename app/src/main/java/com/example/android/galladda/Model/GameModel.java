package com.example.android.galladda.Model;

import com.example.android.galladda.Model.Engines.AbstractEngine;
import com.example.android.galladda.Model.Engines.MovementEngine;

import java.util.ArrayList;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class GameModel {

    private ArrayList<AbstractEngine> myEngines;

    public GameModel(){
        myEngines = new ArrayList<AbstractEngine>();
        initializeLevel();
        attachEngines();
    }

    private void attachEngines(){
        myEngines.add(new MovementEngine())
    }
}
