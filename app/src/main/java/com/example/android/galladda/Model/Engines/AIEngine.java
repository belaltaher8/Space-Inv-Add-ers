package com.example.android.galladda.Model.Engines;

import com.example.android.galladda.EntityComponent.Components.AIComponent;
import com.example.android.galladda.EntityComponent.Components.ComponentType;
import com.example.android.galladda.EntityComponent.Entities.Bullets.BadBulletEntity;
import com.example.android.galladda.EntityComponent.Entities.Enemies.AbstractEnemy;
import com.example.android.galladda.EntityComponent.Entities.General.AbstractEntity;
import com.example.android.galladda.EntityComponent.Entities.General.EntityManager;

import java.util.ArrayList;

/**
 * @author Belal Taher
 * Created on 8/25/2017.
 * The AIEngine class updates the AI component of entities. It uses this component
 * to make the enemy entities shoot according to a pseudo-random algorithm
 */

public class AIEngine extends AbstractEngine {

    public AIEngine(EntityManager aEM){
        super(aEM);
    }

    /**
     * This method retrieves all the enemies from the entity manager and updates their AI component and if the condition to shoot
     * for that enemy's respective AI component is currently being satisfied, the engine makes the AI shoot a bullet
     */
    @Override
    public void update() {
        //TODO: make this algorithm better
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
