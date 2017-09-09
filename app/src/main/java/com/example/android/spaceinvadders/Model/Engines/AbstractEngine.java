package com.example.android.spaceinvadders.Model.Engines;

import com.example.android.spaceinvadders.EntityComponent.Entities.General.EntityManager;

/**
 * @author Belal Taher
 * Created on 8/15/2017.
 * The AbstractEngine class is an abstract class that all engines extend. This makes holding a collection of/updating all engines
 * much easier.
 */

public abstract class AbstractEngine{

    //Every engine requires a reference to the entity manager to update the components that the engine deals with
    protected EntityManager myEM;

    public AbstractEngine(EntityManager aEM){
        myEM = aEM;
    }

    //Every engine updates in some way on each iteration
    public abstract void update();

}
