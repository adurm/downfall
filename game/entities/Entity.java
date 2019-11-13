package downfall.game.entities;

import downfall.main.Handler;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author adam
 */
public abstract class Entity {

    public static int playerWidth = 50, playerHeight = 100;
    
    protected Handler handler;
    protected float x, x2, y;
    protected int width, height;
    protected BufferedImage image;
    protected Rectangle bounds;
    protected boolean active;
    protected int pointsPerHit;

    public Entity(Handler handler, BufferedImage image, float x, float y, int width, int height, int points) {
        
        this.handler = handler;
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.pointsPerHit = points;
        bounds = new Rectangle(0, 0, width, height);
        active = true;
    }
    
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
    
    public BufferedImage getImage(){
        return image;
    }

    public float getX() {
        return x;
    }
    
    public float getX2(){
        return x2;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getPointsPerHit() {
        return pointsPerHit;
    }
    
    

}
