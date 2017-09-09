package com.example.android.spaceinvadders.EntityComponent.Entities.Bullets;

import com.example.android.spaceinvadders.EntityComponent.Entities.Enum.EntityType;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class BadBulletEntity extends BulletEntity {

    public BadBulletEntity(float x, float y){
        super(x,y);
        myEntityType = EntityType.BadBullet;
    }
}
