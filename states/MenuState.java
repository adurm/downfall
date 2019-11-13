package downfall.states;

import downfall.game.graphics.Assets;
import downfall.game.graphics.Text;
import downfall.main.Handler;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 *
 * @author adam
 */
public class MenuState extends State {

    private boolean hoverStart = false;
    private boolean hoverScore = false;
    private boolean hoverExit = false;

    public MenuState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        int mousex = handler.getMouseManager().getMouseX();
        int mousey = handler.getMouseManager().getMouseY();

        if (mousex >= 360 && mousex <= 920 && mousey >= 235 && mousey <= 385) {
            hoverStart = true;

        } else if (mousex >= 360 && mousex <= 920 && mousey >= 490 && mousey <= 640) {
            hoverScore = true;
        } else if (mousex >= 360 && mousex <= 920 && mousey >= 745 && mousey <= 895) {
            hoverExit = true;
        } else {
            hoverStart = false;
            hoverScore = false;
            hoverExit = false;
        }
        if (hoverExit && handler.getMouseManager().buttonJustPressed(MouseEvent.BUTTON1)) {
            System.exit(0);
        } else if (hoverScore && handler.getMouseManager().buttonJustPressed(MouseEvent.BUTTON1)) {
        } else if (hoverStart && handler.getMouseManager().buttonJustPressed(MouseEvent.BUTTON1)) {
            
            State.setState(handler.getGame().getPreLevel1());
        }

    }

    @Override
    public void render(Graphics g) {

        g.setColor(new Color(204, 231, 248));
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());

        drawTitle(g);
        drawStartButton(g);
    }

    
    private void drawTitle(Graphics g) {

        Text.drawString(g, "DownFall", 640, 100, true, Color.darkGray, Assets.font128);
    }

    private void drawStartButton(Graphics g) {

        if (hoverStart) {
            g.setColor(Color.lightGray);
            g.fillRect(360, 235, 560, 150);
            Text.drawString(g, "Start", 640, 310, true, Color.DARK_GRAY, Assets.font48);
        } else {

            g.setColor(Color.darkGray);
            g.fillRect(360, 235, 560, 150);
            Text.drawString(g, "Start", 640, 310, true, new Color(204, 231, 248), Assets.font48);
        }
        if (hoverScore) {
            g.setColor(Color.lightGray);
            g.fillRect(360, 490, 560, 150);
            Text.drawString(g, "HiScore", 640, 565, true, Color.DARK_GRAY, Assets.font48
            );
        } else {
            g.setColor(Color.darkGray);
            g.fillRect(360, 490, 560, 150);
            Text.drawString(g, "HiScore", 640, 565, true, new Color(204, 231, 248), Assets.font48);
        }

        if (hoverExit) {
            g.setColor(Color.lightGray);
            g.fillRect(360, 745, 560, 150);
            Text.drawString(g, "Exit", 640, 820, true, Color.DARK_GRAY, Assets.font48);
        } else {
            g.setColor(Color.darkGray);
            g.fillRect(360, 745, 560, 150);
            Text.drawString(g, "Exit", 640, 820, true, new Color(204, 231, 248), Assets.font48);
        }
    }

    private void drawCredits(Graphics g) {
        Text.drawString(g, "Developed  by  Adam  &  Mustafa  |  V1.0", handler.getWidth() - 370, handler.getHeight() - 20, false, Color.darkGray, Assets.font20);
    }

}
