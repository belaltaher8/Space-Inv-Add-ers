package com.example.android.galladda.EntityComponent.Entities.Bullets;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;

/**
 * Created by Belal Taher on 8/17/2017.
 */

public class BulletEntity extends AbstractEntity {

    public BulletEntity(float x, float y){
        super();
        myComponents.put(ComponentType.Position, new PositionComponent(x,y));
        myComponents.put(ComponentType.Velocity, new VelocityComponent(0,0));
        myEntityType = EntityType.Bullet;
    }

}
