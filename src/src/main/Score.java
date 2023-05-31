package main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Score {

    static int gameWidth;
    static int gameHeight;
    static int player1;
    static int player2;

    Color white = new Color(251, 255, 246);

    public Score(int gameWidth, int gameHeight) {
        Score.gameWidth = gameWidth;
        Score.gameHeight = gameHeight;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(white);
        g.setFont(new Font("Dialog", Font.PLAIN, 60));

        Stroke dashed = new BasicStroke(4, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{25}, 30);
        g2d.setStroke(dashed);
        g2d.drawLine(gameWidth/2, 0, gameWidth/2, gameHeight);

        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (gameWidth/2)-85, 50);
        g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (gameWidth/2)+20, 50);
    }

    @Override
    public String toString() {
        return "Player1 " + player1 + " : " + player2 + " Player2";
    }
}
