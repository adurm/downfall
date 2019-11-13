package downfall.main;

import downfall.game.graphics.Assets;
import downfall.game.input.KeyManager;
import downfall.game.input.MouseManager;
import downfall.states.GameState;
import downfall.states.MenuState;
import downfall.states.PregameState;
import downfall.states.SplashState;
import downfall.states.State;
import downfall.states.gameOverState;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game extends Canvas implements Runnable {

    //Game Display
    private Display display;
    private String title;
    private final int width, height;

    //Game Graphics
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;

    //Game States
    private State splashState;
    private State menuState;
    private GameState gameState;
    private State preLevel1;
    private State preLevel2;
    private State preLevel3;

    private Handler handler;
    private KeyManager keyManager;
    private MouseManager mouseManager;

    private int level = 1;
    private int points1 = 0, points2 = 0;

    public Game(String title, int width, int height) {

        this.title = title;
        this.width = width;
        this.height = height;

        handler = new Handler(this);
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        
        

    }
    
    public void resetPoints() {
        points1 = 0;
        points2 = 0;
    }
    
    public void setPoint(int player, int score){
        if (player==1) {
            points1 += score;
        } else if(player==2){
            points2 += score;
        } else if(player==3){
            setPoint(1, score);
            setPoint(2, score);
        }
    }
    
    public int getPoints1(){
        return points1;
    }
    
    public int getPoints2(){
        return points2;
    }

    private void init() {

        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addKeyListener(keyManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();

        splashState = new SplashState(handler);
        menuState = new MenuState(handler);
        gameState = new GameState(handler, level);
        preLevel1 = new PregameState(handler, 1);
        preLevel2 = new PregameState(handler, 2);
        preLevel3 = new PregameState(handler, 3);
        gameOverState g = new gameOverState(handler);

        State.setState(splashState);
    }

    private void tick() {

        keyManager.tick();
        mouseManager.tick();

        if (State.getState() != null) {
            State.getState().tick();
        }

    }

    private void render(Graphics g) {

        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        if (State.getState() != null) {
            State.getState().render(g);
        }

        bs.show();
        g.dispose();
    }

    //Game loop
    @Override
    public void run() {

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render(g);
                ticks++;
                display.getFrame().setTitle(""+fps);
                delta--;
            }

            if (timer >= 1000000000) {
                ticks = 0;
                timer = 0;
            }
        }
        stop();

    }

    public synchronized void start() {

        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {

        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {

        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public State getGameState() {
        return gameState;
    }

    public State getMenuState() {
        return menuState;
    }

    public int getLevel() {
        return level;
    }

    public State getPreLevel1() {
        return preLevel1;
    }

    public State getPreLevel2() {
        return preLevel2;
    }

    public State getPreLevel3() {
        return preLevel3;
    }

    public static void main(String[] args) {

        Game game = new Game("DownFall", 1280, 1000);
        game.start();
    }
}
