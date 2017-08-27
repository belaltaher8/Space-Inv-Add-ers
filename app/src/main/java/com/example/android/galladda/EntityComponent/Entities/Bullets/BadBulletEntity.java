package com.example.android.galladda.EntityComponent.Entities.Bullets;

import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Components.PositionComponent;
import com.example.android.galladda.EntityComponent.Components.VelocityComponent;
import com.example.android.galladda.EntityComponent.Entities.Enum.EntityType;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.Model.Engines.AbstractEngine;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class BadBulletEntity extends BulletEntity {

    public BadBulletEntity(float x, float y){
        super(x,y);
        myEntityType = EntityType.BadBullet;
    }
}
