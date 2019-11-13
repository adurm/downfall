package downfall.game.graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;

/**
 *
 * @author adam
 */
public class Assets {
    
    public static final int WIDTH = 60, HEIGHT = 120;
    
    //Images
    public static BufferedImage redSanta, greenSanta, level1bg, snowball, snowflake;
    public static BufferedImage astronaut1, astronaut2, level2bg, meteor, rocket, shooting_star;
    public static BufferedImage dollar, hotdog, level3bg, birdleft, birdright, birdpoop, suitman, suitman2;
    public static BufferedImage lvl1pre, lvl1prehover, lvl2pre, lvl2prehover, lvl3pre, lvl3prehover;
    public static BufferedImage gameover, gameoverquit, gameoverrestart;
    
    //Fonts
    public static Font font20, font48, font128, font64, font32;
    
    
    
    public static void init(){
        
        
        font20 = FontLoader.loadFont("res/fonts/ConnectionBold.otf", 20);
        font64 = FontLoader.loadFont("res/fonts/ConnectionBold.otf", 64);
        font32 = FontLoader.loadFont("res/fonts/ConnectionBold.otf", 32);
        font128 = FontLoader.loadFont("res/fonts/ConnectionBold.otf", 128);
        font48 = FontLoader.loadFont("res/fonts/ConnectionBold.otf", 48);
        
        level1bg = ImageLoader.loadImage("/backgrounds/level_1_bg.jpg");
        redSanta = ImageLoader.loadImage("/characters/santa_red_front.png");
        greenSanta = ImageLoader.loadImage("/characters/santa_green_front.png");
        snowball = ImageLoader.loadImage("/projectiles/snowball.png");
        snowflake = ImageLoader.loadImage("/projectiles/snowflake.png");
        
        level2bg = ImageLoader.loadImage("/backgrounds/level_2_bg.jpg");
        astronaut1 = ImageLoader.loadImage("/characters/astronaut1.png");
        astronaut2 = ImageLoader.loadImage("/characters/astronaut2.png");
        meteor = ImageLoader.loadImage("/projectiles/meteor.png");
        rocket = ImageLoader.loadImage("/projectiles/rocket.png");
        shooting_star = ImageLoader.loadImage("/projectiles/shooting_star.png");
        
        dollar = ImageLoader.loadImage("/projectiles/dollar.png");
        hotdog = ImageLoader.loadImage("/projectiles/hotdog.png");
        level3bg = ImageLoader.loadImage("/backgrounds/level_3_bg.jpg");
        birdleft = ImageLoader.loadImage("/projectiles/seagull_left.png");
        birdright = ImageLoader.loadImage("/projectiles/seagull_right.png");
        birdpoop = ImageLoader.loadImage("/projectiles/poop.png");
        suitman = ImageLoader.loadImage("/characters/suitman.png");
        suitman2 = ImageLoader.loadImage("/characters/suitman2.png");
        
        lvl1pre = ImageLoader.loadImage("/pregame/level_one_points.jpg");
        lvl1prehover = ImageLoader.loadImage("/pregame/level_one_points_hover.jpg");
        lvl2pre = ImageLoader.loadImage("/pregame/level_two_points.jpg");
        lvl2prehover = ImageLoader.loadImage("/pregame/level_two_points2.jpg");
        lvl3pre = ImageLoader.loadImage("/pregame/level_three_points.jpg");
        lvl3prehover = ImageLoader.loadImage("/pregame/level_three_points2.jpg");
        gameover = ImageLoader.loadImage("/backgrounds/game_over.jpg");
        gameoverquit = ImageLoader.loadImage("/backgrounds/game_over_hover_return.jpg");
        gameoverrestart = ImageLoader.loadImage("/backgrounds/game_over_hover_restart.jpg");
        
    }
    
    
}
