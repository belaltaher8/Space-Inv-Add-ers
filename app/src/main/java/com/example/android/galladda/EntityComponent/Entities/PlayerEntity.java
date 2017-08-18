package com.example.android.galladda.EntityComponent.Entities;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PointComponent;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class PlayerEntity extends AbstractEntity {

    public PlayerEntity(){
        super();
        myComponents.put(ComponentType.Position, new PositionComponent(0,0));
        myComponents.put(ComponentType.Velocity, new VelocityComponent(0,0));
        myComponents.put(ComponentType.Point, new PointComponent(0));
    }

    public BulletEntity shoot(){
        PositionComponent playerPos = (PositionComponent) this.getComponent(ComponentType.Position);
        BulletEntity myBullet = new BulletEntity(playerPos.getX() +70 , playerPos.getY());
        return myBullet;
    }
}
