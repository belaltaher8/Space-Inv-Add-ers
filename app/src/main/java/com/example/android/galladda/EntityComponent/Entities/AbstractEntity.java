package com.example.android.galladda.EntityComponent.Entities;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.IComponent;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public abstract class AbstractEntity {

    protected HashMap<ComponentType, IComponent> myComponents;

    public IComponent getComponent(ComponentType myType) {
        if (myComponents.get(myType) != null) {
            return myComponents.get(myType);
        } else {
            return null;
        }
    }

}
