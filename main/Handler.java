package downfall.main;

import downfall.game.input.KeyManager;
import downfall.game.input.MouseManager;
import downfall.main.Game;

/**
 *
 * @author adam
 */
public class Handler {
    
    private Game game;
    
    public Handler(Game game){
        this.game = game;
    }
    
    public int getWidth() {
        return game.getWidth();
    }
    
    public int getHeight() {
        return game.getHeight();
    }

    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }
    
    
    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }
    
    public Game getGame(){
        return game;
    }
    
}
