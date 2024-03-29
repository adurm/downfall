package downfall.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyManager implements KeyListener {

    private boolean[] keys, justPressed, cantPress;
    public boolean a, d, left, right;

    public KeyManager() {
        
        keys = new boolean[256];
        justPressed = new boolean[keys.length];
        cantPress = new boolean[keys.length];
    }

    public void tick() {

        for (int i = 0; i < keys.length; i++) {

            if (cantPress[i] && !keys[i]) {
                cantPress[i] = false;
            } else if (justPressed[i]) {
                cantPress[i] = true;
                justPressed[i] = false;
            }
            if (!cantPress[i] && keys[i]) {
                justPressed[i] = true;
            }
        }

        a = keys[KeyEvent.VK_A];
        d = keys[KeyEvent.VK_D];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        
    }

    public boolean keyJustPressed(int keyCode) {

        if (keyCode < 0 || keyCode >= keys.length) {
            return false;
        }
        return justPressed[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if (e.getKeyCode() < 0
                || e.getKeyCode() > 256) {
            return;
        }
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if (e.getKeyCode() < 0
                || e.getKeyCode() > 256) {
            return;
        }
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
