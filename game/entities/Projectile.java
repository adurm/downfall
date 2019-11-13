package downfall.game.entities;

import downfall.main.Handler;
import downfall.game.graphics.Assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Projectile extends Entity {

    protected int points;
    boolean hit = false;
    
    
    
    public Projectile(Handler handler, BufferedImage image, float x, float y, int width, int height, int points) {
        super(handler, image, x, y, width, height, points);
    }

    

    @Override
    public void tick() {
        y += 5;
        if (pointsPerHit>1){
            Random r = new Random();
            y += r.nextInt(7);
        }
    }

    @Override
    public void render(Graphics g) {
        if (isActive()){
            g.drawImage(image,(int) x,(int) y, null);
        }
        
    }

    public void setHit() {
        hit = true;
    }

    public boolean isHit() {
        return hit;
    }
    
    
    
}
