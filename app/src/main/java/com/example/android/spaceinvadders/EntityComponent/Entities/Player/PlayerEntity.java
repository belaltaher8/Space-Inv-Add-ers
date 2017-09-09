package com.example.android.spaceinvadders.EntityComponent.Entities.Player;

import com.example.android.spaceinvadders.EntityComponent.Components.ComponentType;
import com.example.android.spaceinvadders.EntityComponent.Components.LivesComponent;
import com.example.android.spaceinvadders.EntityComponent.Components.PointComponent;
import com.example.android.spaceinvadders.EntityComponent.Components.PositionComponent;
import com.example.android.spaceinvadders.EntityComponent.Components.VelocityComponent;
import com.example.android.spaceinvadders.EntityComponent.Entities.Enum.EntityType;
import com.example.android.spaceinvadders.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.spaceinvadders.EntityComponent.Entities.Bullets.GoodBulletEntity;

/**
 * Created by Belal Taher on 8/15/2017.
 */

public class PlayerEntity extends AbstractEntity {

    public PlayerEntity(){
        super();
        myComponents.put(ComponentType.Point, new PointComponent(0));
        myComponents.put(ComponentType.Lives, new LivesComponent());
        myEntityType = EntityType.Player;
    }

    public GoodBulletEntity shoot(){
        PositionComponent playerPos = (PositionComponent) this.getComponent(ComponentType.Position);
        GoodBulletEntity myBullet = new GoodBulletEntity(playerPos.getX() + 70 , playerPos.getY());
        VelocityComponent bulletVC = (VelocityComponent) myBullet.getComponent(ComponentType.Velocity);
        bulletVC.setY(-20);
        return myBullet;
    }

}
