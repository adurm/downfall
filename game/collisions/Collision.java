package downfall.game.collisions;

import downfall.game.entities.Entity;
import downfall.game.entities.EntityManager;
import downfall.game.entities.Projectile;
import downfall.game.graphics.Assets;
import downfall.game.graphics.Text;
import downfall.main.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.TimerTask;
import javax.swing.Timer;

/**
 *
 * @author adam
 */
public class Collision {

    private Handler handler;
    private EntityManager entityManager;

    public Collision(Handler handler, EntityManager entityManager) {
        this.handler = handler;
        this.entityManager = entityManager;
    }

    public void checkCollision(Entity entity, Graphics g) {

        if (hitP1(entity) && hitP2(entity)) {

            Projectile temp = (Projectile) entityManager.getEntity(entityManager.getEntities().indexOf(entity));

            if (!temp.isHit()) {
                temp.setHit();
                handler.getGame().setPoint(3,entityManager.getEntity(entityManager.getEntities().indexOf(entity)).getPointsPerHit());
                entityManager.getEntity(entityManager.getEntities().indexOf(entity)).setActive(false);
                
            }
        }

        if (hitP1(entity)) {
            Projectile temp = (Projectile) entityManager.getEntity(entityManager.getEntities().indexOf(entity));

            if (!temp.isHit()) {
                temp.setHit();
                handler.getGame().setPoint(1,entityManager.getEntity(entityManager.getEntities().indexOf(entity)).getPointsPerHit());
                entityManager.getEntity(entityManager.getEntities().indexOf(entity)).setActive(false);
                entityManager.getEntity(entityManager.getEntities().indexOf(entity)).getPointsPerHit();
                
            }

        }

        if (hitP2(entity)) {

            Projectile temp = (Projectile) entityManager.getEntity(entityManager.getEntities().indexOf(entity));

            if (!temp.isHit()) {
                temp.setHit();
                handler.getGame().setPoint(2,entityManager.getEntity(entityManager.getEntities().indexOf(entity)).getPointsPerHit());
                entityManager.getEntity(entityManager.getEntities().indexOf(entity)).setActive(false);
                entityManager.getEntity(entityManager.getEntities().indexOf(entity)).getPointsPerHit();
            }

        }

    }

    private boolean hitP2(Entity entity) {
        return collision(entity,
                entityManager.getEntity(1).getX2(),
                entityManager.getEntity(entityManager.getEntities().indexOf(entity)).getX(),
                entityManager.getEntity(1).getY(),
                entityManager.getEntity(entityManager.getEntities().indexOf(entity)).getY())
                && entityManager.getEntities().indexOf(entity) > 1;
    }

    private boolean hitP1(Entity entity) {
        return collision(entity,
                entityManager.getEntity(0).getX(),
                entityManager.getEntity(entityManager.getEntities().indexOf(entity)).getX(),
                entityManager.getEntity(0).getY(),
                entityManager.getEntity(entityManager.getEntities().indexOf(entity)).getY())
                && entityManager.getEntities().indexOf(entity) > 1;
    }

    private boolean collision(Entity e, float x1, float x2, float y1, float y2) {

        return x2 >= x1 - e.getWidth()
                && x2 <= x1 + 50
                && y2 >= y1 - (e.getHeight() * 3 / 2)
                && y2 <= y1 + 100;

    }

}
