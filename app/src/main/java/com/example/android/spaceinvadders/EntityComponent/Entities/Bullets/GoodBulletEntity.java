package com.example.android.spaceinvadders.EntityComponent.Entities.Bullets;

import com.example.android.spaceinvadders.EntityComponent.Entities.Enum.EntityType;

/**
 * Created by Belal Taher on 8/17/2017.
 */

public class GoodBulletEntity extends BulletEntity {

    public GoodBulletEntity(float x, float y){
        super(x,y);
        myEntityType = EntityType.GoodBullet;
    }

}
