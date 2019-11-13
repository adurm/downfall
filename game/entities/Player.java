package downfall.game.entities;

import downfall.main.Handler;
import downfall.game.graphics.Assets;
import downfall.game.graphics.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author adam
 */
public class Player extends Entity {

    private final int maxHealth = 3;
    private final float speed = 6.0f;
    private final int width = Assets.WIDTH, height = Assets.HEIGHT;
    private int playerNo;

    protected int health, score;
    protected float xMove;
    protected float xMove2;

    public Player(Handler handler, BufferedImage image, float x, float y, int width, int height, int playerNo) {

        super(handler, image, x, y, width, height, 0);
        health = maxHealth;
        xMove = 0;
        xMove2 = 0;
        score = 0;
        this.playerNo = playerNo;
        if (playerNo == 1){
            super.x = 580;
        } else if (playerNo == 2){
            super.x2 = 640;
        }
    }

    public void move() {
        moveX();
        moveX2();
    }

    public void moveX() {
        x += xMove;
        if (x < -5 || x > handler.getWidth() - 55){
            x -= xMove;
        }
    }

    public void moveX2() {
        //System.out.println(x2);
        x2 += xMove2;
        if (x2 < -5 || x2 > handler.getWidth() - 55){
            x2 -= xMove2;
        }
    }

    private void getInput() {

        xMove = 0;
        xMove2 = 0;
        if (playerNo == 1) {
            if (handler.getKeyManager().left) {
                xMove = -speed;
            }
            if (handler.getKeyManager().right) {
                xMove = speed;
            }
        } else if (playerNo == 2) {
            if (handler.getKeyManager().a) {
                xMove2 = -speed;
            }
            if (handler.getKeyManager().d) {
                xMove2 = speed;
            }
        }
    }

    @Override
    public void tick() {
        getInput();
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        if (playerNo == 1) {
            g.drawImage(image, (int) x, (int) y, width, height, null);
            Text.drawString(g, "P1", (int)x+(playerWidth/2)+5, (int)y+playerHeight+42, true, Color.white, Assets.font20);
            
        } else if (playerNo == 2) {
            g.drawImage(image, (int) x2, (int) y, width, height, null);
            Text.drawString(g, "P2", (int)x2+(playerWidth/2)+5, (int)y+playerHeight+42, true, Color.white, Assets.font20);
        }
    }
    
    public void updateScore(int s){
        this.score = s;
    }
    
    public int getScore(int s){
        return score;
    }

}
