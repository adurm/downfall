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
public class SplashState extends State {

    private boolean hover = false;

    public SplashState(Handler handler) {
        super(handler);
    }

    @Override
    public void tick() {
        int mousex = handler.getMouseManager().getMouseX();
        int mousey = handler.getMouseManager().getMouseY();

        if (mousex > 310
                && mousex < 970
                && mousey > 480
                && mousey < 680) {
            hover = true;
        } else {
            hover = false;
        }
        if (hover && handler.getMouseManager().buttonJustPressed(MouseEvent.BUTTON1)) {
            State.setState(handler.getGame().getMenuState());
        }
    }

    @Override
    public void render(Graphics g) {

        drawTitle(g);
        drawStartButton(g);
        drawCredits(g);
    }

    private void drawTitle(Graphics g) {

        g.setColor(new Color(204, 231, 248));
        g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
        Text.drawString(g, "DownFall", 640, 320, true, Color.darkGray, Assets.font128);
        Text.drawString(g, "Santa  was  harmed  in  the  making  of  this.",
                735, 380, true, Color.gray, Assets.font20);
    }

    private void drawStartButton(Graphics g) {

        if (hover) {
            g.setColor(Color.lightGray);
            g.fillRect(310, 480, 660, 200);
            Text.drawString(g, "ENTER", 640, 590, true, Color.darkGray, Assets.font128);
        } else {
            g.setColor(Color.darkGray);
            g.fillRect(310, 480, 660, 200);
            Text.drawString(g, "ENTER", 640, 590, true, new Color(204, 231, 248), Assets.font128);
        }

    }

    private void drawCredits(Graphics g) {
        Text.drawString(g, "Developed  by  Adam  &  Mustafa  |  V1.0", handler.getWidth() - 370, handler.getHeight() - 20, false, Color.darkGray, Assets.font20);
    }

}
