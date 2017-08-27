package com.example.android.galladda.Model.Engines;

import com.example.android.galladda.EntityComponent.Components.AIComponent;
import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Entities.Bullets.BadBulletEntity;
import com.example.android.galladda.EntityComponent.Entities.Enemies.AbstractEnemy;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;

import java.util.ArrayList;

/**
 * Created by Belal Taher on 8/25/2017.
 */

public class AIEngine extends AbstractEngine {

    public AIEngine(EntityManager aEM){
        super(aEM);
    }

    @Override
    public void update() {
        ArrayList<AbstractEntity> myEnemies = myEM.getAllEnemies();
        for(int currentEnemyIndex = 0; currentEnemyIndex < myEnemies.size(); currentEnemyIndex++){
            AbstractEnemy currentEnemy = (AbstractEnemy) myEnemies.get(currentEnemyIndex);
            AIComponent AC = (AIComponent) currentEnemy.getComponent(ComponentType.AI);
            AC.setTime(AC.getTime()+1);
            if(AC.getTime() == AC.getTimeToShoot()){
                BadBulletEntity newBullet = currentEnemy.shoot();
                myEM.addBullet(newBullet);
            }
            if(AC.getTime() == AC.SHOOT_TIMER_RESET){
                AC.setTime(0);
            }
        }
    }
}
