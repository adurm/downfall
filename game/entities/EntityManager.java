package downfall.game.entities;

import downfall.main.Handler;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class EntityManager {

    private Handler handler;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler) {
        this.handler = handler;
        entities = new ArrayList<>();
    }

    public void tick() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(g);
        }
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public Entity getEntity(int index) {
        return entities.get(index);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public Entity removeEntities(int index) {
        return entities.remove(index);
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }

   

}
