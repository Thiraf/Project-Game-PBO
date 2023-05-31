package main;

import java.awt.*;

import static main.Main.pixelType;
import static main.Main.screenHeight;

public class Pause {

    static int gameWidth;
    static int gameHeight;

    GamePanel gp;
    Graphics2D g2;

    Color white = new Color(251, 255, 246);
    Color greyT = new Color(17, 17, 17, 71);

    public Pause(GamePanel gp) {
        this.gp = gp;

        gameWidth = GamePanel.screenWidth;
        gameHeight = GamePanel.screenHeight;
    }

    public void draw(Graphics2D g) {
        this.g2 = g;
        Graphics2D g2d = g;

        if (gp.gameState == GamePanel.pauseState) {
            String text = "PAUSED";
            int x = getXFontCenter(text);
            int y = screenHeight/2;

            g2d.setColor(greyT);
            g2d.fillRect(0,0, gameWidth, gameHeight);

            g2.setFont(new Font(pixelType.getName(), Font.PLAIN, 100));
            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);
        }

    }

    public int getXFontCenter(String text) {

        int x;
        int y = screenHeight/2;
        int length = (int)g2.getFontMetrics(new Font(pixelType.getName(), Font.PLAIN, 100)).getStringBounds(text, g2).getWidth();
        x = GamePanel.screenWidth/2 - length/2;

        return x;
    }
}
