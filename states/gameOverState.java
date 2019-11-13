package downfall.states;

import downfall.game.graphics.Assets;
import downfall.game.graphics.Text;
import downfall.main.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author adam
 */
public class gameOverState extends State {

    private boolean hoverRestart = false;
    private boolean hoverQuit = false;

    public gameOverState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        int mousex = handler.getMouseManager().getMouseX();
        int mousey = handler.getMouseManager().getMouseY();

        if (mousex >= 330 && mousex <= 950 && mousey >= 550 && mousey <= 700) {
            hoverRestart = true;

        } else if (mousex >= 330 && mousex <= 950 && mousey >= 740 && mousey <= 940) {
            hoverQuit = true;
        } else {
            hoverQuit = false;
            hoverRestart = false;
        }

        if (hoverQuit && handler.getMouseManager().buttonJustPressed(MouseEvent.BUTTON1)) {
            State.setState(new MenuState(handler));
        } else if (hoverRestart && handler.getMouseManager().buttonJustPressed(MouseEvent.BUTTON1)) {
            State.setState(handler.getGame().getPreLevel1());
        }
    }

    @Override
    public void render(Graphics g) {
        if (hoverQuit) {
            g.drawImage(Assets.gameoverquit, 0, 0, null);
        } else if (hoverRestart) {
            g.drawImage(Assets.gameoverrestart, 0, 0, null);
        } else {
            g.drawImage(Assets.gameover, 0, 0, null);
        }
        if (handler.getGame().getPoints1() > handler.getGame().getPoints2()) {
            Text.drawString(g, "One", 710, 210, true, Color.black, Assets.font64);
            Text.drawString(g, handler.getGame().getPoints1()+"", 900, 310, true, Color.green, Assets.font64);
        Text.drawString(g, handler.getGame().getPoints2()+"", 900, 395, true, Color.RED, Assets.font64);
        } else if(handler.getGame().getPoints1() < handler.getGame().getPoints2()){
            Text.drawString(g, "Two", 710, 210, true, Color.BLACK, Assets.font64);
            Text.drawString(g, handler.getGame().getPoints1()+"", 900, 310, true, Color.red, Assets.font64);
        Text.drawString(g, handler.getGame().getPoints2()+"", 900, 395, true, Color.green, Assets.font64);
        } else{
            Text.drawString(g, "Both", 710, 210, true, Color.BLACK, Assets.font64);
            Text.drawString(g, handler.getGame().getPoints1()+"", 900, 310, true, Color.green, Assets.font64);
        Text.drawString(g, handler.getGame().getPoints2()+"", 900, 395, true, Color.green, Assets.font64);
        }
        
        
    }

    

}
