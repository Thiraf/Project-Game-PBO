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

public class Win {

    static int gameWidth;
    static int gameHeight;
    static int winnerId;

    public Win(int gameWidth, int gameHeight) {
        Score.gameWidth = gameWidth;
        Score.gameHeight = gameHeight;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.WHITE);
        g.setFont(new Font("Dialog", Font.BOLD, 60));

        if (winnerId == 1) {
            g.drawString(String.valueOf("WIN"), 170, 150);
            g.drawString(String.valueOf("LOSE"), 670, 150);
        }
        else if (winnerId == 2) {
            g.drawString(String.valueOf("LOSE"), 170, 150);
            g.drawString(String.valueOf("WIN"), 670, 150);
        }


    }

}
