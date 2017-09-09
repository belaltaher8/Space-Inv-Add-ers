package com.example.android.spaceinvadders.EntityComponent.Entities.General;

import com.example.android.spaceinvadders.EntityComponent.Components.ComponentType;
import com.example.android.spaceinvadders.EntityComponent.Components.IComponent;
import com.example.android.spaceinvadders.EntityComponent.Components.PositionComponent;
import com.example.android.spaceinvadders.EntityComponent.Components.VelocityComponent;
import com.example.android.spaceinvadders.EntityComponent.Entities.Enum.EntityType;

import java.util.HashMap;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public abstract class AbstractEntity {

    protected boolean exploding = false;

    protected HashMap<ComponentType, IComponent> myComponents;

    protected EntityType myEntityType;

    public AbstractEntity(){
        myComponents = new HashMap<ComponentType, IComponent>();
        myComponents.put(ComponentType.Position, new PositionComponent(0,0));
        myComponents.put(ComponentType.Velocity, new VelocityComponent(0,0));
    }

    public IComponent getComponent(ComponentType myType) {
        if (myComponents.get(myType) != null) {
            return myComponents.get(myType);
        } else {
            return null;
        }
    }


    public void explode(){
        exploding = true;
    }

    public boolean getExploding(){
        if(exploding == true){
            exploding = false;
            return true;
        }
        return false;
    }

    public EntityType getMyEntityType(){
        return myEntityType;
    }

}
