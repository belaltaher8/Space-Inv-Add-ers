package com.example.android.spaceinvadders.EntityComponent.Entities.Bullets;

import com.example.android.spaceinvadders.EntityComponent.Components.ComponentType;
import com.example.android.spaceinvadders.EntityComponent.Components.PositionComponent;
import com.example.android.spaceinvadders.EntityComponent.Entities.General.AbstractEntity;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public abstract class BulletEntity extends AbstractEntity {

    public BulletEntity(float x, float y){
        super();
        myComponents.put(ComponentType.Position, new PositionComponent(x,y));
    }
}
