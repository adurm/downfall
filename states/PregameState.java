package downfall.states;

import downfall.game.graphics.Assets;
import downfall.game.graphics.Text;
import downfall.main.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/**
 *
 * @author adam
 */
public class PregameState extends State {

    private int level;
    private boolean hover = false;

    public PregameState(Handler handler, int level) {
        super(handler);
        this.level = level;
    }

    @Override
    public void tick() {
        int mousex = handler.getMouseManager().getMouseX();
        int mousey = handler.getMouseManager().getMouseY();
        if (mousex >= 330 && mousex <= 940 && mousey >= 740 && mousey <= 950) {
            hover = true;
        } else {
            hover = false;
        }

        if (hover && handler.getMouseManager().buttonJustPressed(MouseEvent.BUTTON1)) {
            if (level==1) {
                handler.getGame().resetPoints();
            }
            State.setState(new GameState(handler, level));
        }
    }

    @Override
    public void render(Graphics g) {
        switch (level) {
            case 1:
                if (hover) {
                    g.drawImage(Assets.lvl1prehover, 0, 0, null);
                } else {
                    g.drawImage(Assets.lvl1pre, 0, 0, null);
                }

                break;
            case 2:
                if (hover) {
                    g.drawImage(Assets.lvl2prehover, 0, 0, null);
                } else {
                    g.drawImage(Assets.lvl2pre, 0, 0, null);
                }
                
                Text.drawString(g, "Player  1", 200, 105, true, Color.BLACK, Assets.font64);
                Text.drawString(g, ""+handler.getGame().getPoints1(), 200, 165, true, Color.BLACK, Assets.font64);
                Text.drawString(g, "Player  2", 1080, 105, true, Color.BLACK, Assets.font64);
                Text.drawString(g, ""+handler.getGame().getPoints2(), 1080, 165, true, Color.BLACK, Assets.font64);

                break;
            case 3:
                if (hover) {
                    g.drawImage(Assets.lvl3prehover, 0, 0, null);
                } else {
                    g.drawImage(Assets.lvl3pre, 0, 0, null);
                }
                Text.drawString(g, "Player  1", 200, 105, true, Color.BLACK, Assets.font64);
                Text.drawString(g, ""+handler.getGame().getPoints1(), 200, 165, true, Color.BLACK, Assets.font64);
                Text.drawString(g, "Player  2", 1080, 105, true, Color.BLACK, Assets.font64);
                Text.drawString(g, ""+handler.getGame().getPoints2(), 1080, 165, true, Color.BLACK, Assets.font64);
                break;
            default:
                break;
        }
    }

}
