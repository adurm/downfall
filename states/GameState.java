package downfall.states;

import downfall.game.collisions.Collision;
import downfall.game.entities.Bird;
import downfall.main.Handler;
import downfall.game.entities.EntityManager;
import downfall.game.entities.Player;
import downfall.game.entities.Projectile;
import downfall.game.graphics.Assets;
import downfall.game.graphics.Text;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameState extends State {

    private final EntityManager entityManager;
    private Collision collision;
    private BufferedImage backgroundimg, p1img, p2img, proj1img, proj2img, proj3img;
    private final int level;
    private int counter;
    private final Random random = new Random();
    private boolean gameEnd = false;
    private int p1, p2;

    public GameState(Handler handler, int level) {
        super(handler);
        this.level = level;

        initLevelImages();

        entityManager = new EntityManager(handler);
        collision = new Collision(handler, entityManager);
        entityManager.addEntity(new Player(handler, p1img, 580, 748, Player.playerWidth, Player.playerHeight, 1));
        entityManager.addEntity(new Player(handler, p2img, 700, 748, Player.playerWidth, Player.playerHeight, 2));
        if (level == 3) {
            entityManager.addEntity(new Bird(handler, Assets.birdleft, 0, 0, 150, 50, 0));
        }
        gameEnd = false;
        p1 = 0;
        p2 = 0;

    }

    private void initLevelImages() {
        switch (level) {
            case 1:
                backgroundimg = Assets.level1bg;
                p1img = Assets.redSanta;
                p2img = Assets.greenSanta;
                proj1img = Assets.snowball;
                proj2img = Assets.snowflake;
                proj3img = null;
                break;
            case 2:
                backgroundimg = Assets.level2bg;
                p1img = Assets.astronaut1;
                p2img = Assets.astronaut2;
                proj1img = Assets.rocket;
                proj2img = Assets.shooting_star;
                proj3img = Assets.meteor;
                break;
            case 3:
                backgroundimg = Assets.level3bg;
                p1img = Assets.suitman;
                p2img = Assets.suitman2;
                proj1img = Assets.hotdog;
                proj2img = Assets.dollar;
                proj3img = Assets.birdpoop;
                break;
            default:
                break;
        }
    }

    @Override
    public void tick() {
        entityManager.tick();
        int mousex = handler.getMouseManager().getMouseX();
        int mousey = handler.getMouseManager().getMouseY();

        if (mousex >= 600 && mousex <= 680 && mousey >= 930 && mousey <= 970 && handler.getMouseManager().buttonJustPressed(MouseEvent.BUTTON1)) {
            State.setState(handler.getGame().getMenuState());
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(backgroundimg, 0, 0, null);
        Text.drawString(g, "Player  1:   " + handler.getGame().getPoints1(), 90, 925, true, Color.white, Assets.font20);
        Text.drawString(g, "Player  2:   " + handler.getGame().getPoints2(), 1190, 925, true, Color.white, Assets.font20);

        createProjectiles(g);
        entityManager.render(g);
        
        if (level == 1) {
            Text.drawString(g, "Objects Left: " + (25 - entityManager.getEntities().size() + 2),
                    640, 50, true, Color.red, Assets.font48);
        } else if (level >= 2) {
            Text.drawString(g, "Objects Left: " + (40 - entityManager.getEntities().size() + 2),
                    640, 50, true, Color.red, Assets.font48);
        }
        Text.drawString(g, "Quit?", 640, 950, true, Color.black, Assets.font20);
    }

    private void createProjectiles(Graphics g) {

        if (level == 1 && counter < 25) {
            if (random.nextInt(100) == 0) {
                Projectile proj1 = new Projectile(handler, proj1img, random.nextInt(1250), 0, 30, 30, 1);
                entityManager.addEntity(proj1);
                counter++;
            }
            if (random.nextInt(300) == 0) {
                Projectile proj2 = new Projectile(handler, proj2img, random.nextInt(1250), 0, 30, 30, 5);
                entityManager.addEntity(proj2);
                counter++;
            }
            if (proj3img != null) {
                if (level != 3) {
                    if (random.nextInt(400) == 0) {
                        Projectile proj3 = new Projectile(handler, proj3img, random.nextInt(1250), 0, 30, 30, -5);
                        entityManager.addEntity(proj3);
                        counter++;
                    }
                } else {
                    if (random.nextInt(250) == 0) {
                        Projectile proj3 = new Projectile(handler, proj3img, entityManager.getEntity(2).getX(),
                                entityManager.getEntity(2).getY() + 10, 30, 30, -10);
                        entityManager.addEntity(proj3);
                        counter++;
                    }

                }

            }
        } else if (level >= 2 && counter < 40) {
            if (random.nextInt(100) == 0) {
                Projectile proj1 = new Projectile(handler, proj1img, random.nextInt(1250), 0, 30, 30, 1);
                entityManager.addEntity(proj1);
                counter++;
            }
            if (random.nextInt(300) == 0) {
                Projectile proj2 = new Projectile(handler, proj2img, random.nextInt(1250), 0, 30, 30, 5);
                entityManager.addEntity(proj2);
                counter++;
            }
            if (proj3img != null) {
                if (level != 3) {
                    if (random.nextInt(400) == 0) {
                        Projectile proj3 = new Projectile(handler, proj3img, random.nextInt(1250), 0, 30, 30, -5);
                        entityManager.addEntity(proj3);
                        counter++;
                    }
                } else {
                    if (random.nextInt(250) == 0) {
                        Projectile proj3 = new Projectile(handler, proj3img, entityManager.getEntity(2).getX(),
                                entityManager.getEntity(2).getY() + 10, 30, 30, -10);
                        entityManager.addEntity(proj3);
                        counter++;
                    }

                }

            }
        } else {
            gameEnd = true;
            switch (level) {
                case 1:
                    State.setState(handler.getGame().getPreLevel2());
                    break;
                case 2:
                    State.setState(handler.getGame().getPreLevel3());
                    break;
                case 3:
                    State.setState(new gameOverState(handler));
                    break;
                default:
                    break;
            }

        }
        if (level == 3) {
            if (entityManager.getEntities().size() > 3) {
                for (int i = 3; i < entityManager.getEntities().size(); i++) {
                    collision.checkCollision(entityManager.getEntity(i), g);
                    if (820 <= entityManager.getEntity(i).getY()) {
                        entityManager.getEntity(i).setActive(false);
                    }
                }
            }
        } else {
            if (entityManager.getEntities().size() > 2) {
                for (int i = 2; i < entityManager.getEntities().size(); i++) {
                    collision.checkCollision(entityManager.getEntity(i), g);
                    if (820 <= entityManager.getEntity(i).getY()) {
                        entityManager.getEntity(i).setActive(false);
                    }
                }
            }
        }
    }

}
