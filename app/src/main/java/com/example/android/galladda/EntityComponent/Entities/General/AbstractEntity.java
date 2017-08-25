package com.example.android.galladda.EntityComponent.Entities.General;

import android.graphics.Bitmap;
import android.support.constraint.solver.widgets.Rectangle;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.IComponent;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public abstract class AbstractEntity {

    protected HashMap<ComponentType, IComponent> myComponents;

    protected EntityType myEntityType;

    public AbstractEntity(){
        myComponents = new HashMap<ComponentType, IComponent>();
    }

    public IComponent getComponent(ComponentType myType) {
        if (myComponents.get(myType) != null) {
            return myComponents.get(myType);
        } else {
            return null;
        }
    }

    public EntityType getMyEntityType(){
        return myEntityType;
    }

}
