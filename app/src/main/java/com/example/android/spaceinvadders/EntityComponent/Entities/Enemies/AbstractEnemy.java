package com.example.android.spaceinvadders.EntityComponent.Entities.Enemies;

import com.example.android.spaceinvadders.EntityComponent.Components.AIComponent;
import com.example.android.spaceinvadders.EntityComponent.Components.ComponentType;
import com.example.android.spaceinvadders.EntityComponent.Components.DeathComponent;
import com.example.android.spaceinvadders.EntityComponent.Components.PositionComponent;
import com.example.android.spaceinvadders.EntityComponent.Components.VelocityComponent;
import com.example.android.spaceinvadders.EntityComponent.Entities.Bullets.BadBulletEntity;
import com.example.android.spaceinvadders.EntityComponent.Entities.General.AbstractEntity;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public abstract class AbstractEnemy extends AbstractEntity {


    public AbstractEnemy(){
        super();
        myComponents.put(ComponentType.AI, new AIComponent());
        myComponents.put(ComponentType.Death, new DeathComponent());
    }

    public BadBulletEntity shoot(){
        PositionComponent enemyPos = (PositionComponent) this.getComponent(ComponentType.Position);
        BadBulletEntity myBullet = new BadBulletEntity(enemyPos.getX() +50, enemyPos.getY());
        VelocityComponent bulletVC = (VelocityComponent) myBullet.getComponent(ComponentType.Velocity);
        return myBullet;
    }
}
