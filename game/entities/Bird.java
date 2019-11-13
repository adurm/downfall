package downfall.game.entities;

import downfall.game.graphics.Assets;
import downfall.main.Handler;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author adam
 */
public class Bird extends Entity {

    private boolean goingleft = false;

    public Bird(Handler handler, BufferedImage image, float x, float y, int width, int height, int points) {
        super(handler, image, x, y, width, height, points);
    }

    @Override
    public void tick() {
        Random r = new Random();
        x += r.nextInt(20);
        if (x > handler.getWidth()+10){
            x = -20;
        }
    }

    @Override
    public void render(Graphics g) {
        if (goingleft) {
            g.drawImage(Assets.birdleft, (int) x, 50, null);
        } else {
            g.drawImage(Assets.birdright, (int) x, 50, null);
        }

    }

}
