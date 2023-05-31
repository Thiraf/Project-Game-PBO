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

public class GameFrame extends JFrame {
    Color grey = new Color(17, 17, 17);
    Color green = new Color(125, 183, 86);

    public GameFrame() {

        GamePanel gamePanel = new GamePanel();
        this.add(gamePanel);
        this.pack();

        gamePanel.startGameThread(); //! Run game

        this.setBackground(green);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
