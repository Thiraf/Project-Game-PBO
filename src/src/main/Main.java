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

public class Main extends JFrame {

    static final int screenWidth = 1000;
    static final int screenHeight = (int)(screenWidth * (0.5555));
    static final Dimension screenSize = new Dimension(screenWidth,screenHeight);

    Font maruMonica;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        try{
            maruMonica = Font.createFont(Font.TRUETYPE_FONT, new File("/font/x12y16pxMaruMonica.ttf")).deriveFont((float) 300);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("/font/x12y16pxMaruMonica.ttf")));
        }
        catch(IOException | FontFormatException e){

        }

        Color grey = new Color(17, 17, 17);

        JFrame frame = new JFrame();
        frame.setTitle("Pong");
        frame.setSize(screenSize);
        frame.setBackground(grey);

        JPanel gameMenu = new JPanel();
        gameMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
        gameMenu.setLayout(new BorderLayout());

        gameMenu.setBackground(grey);

        JPanel layout = new JPanel(new GridBagLayout());
        layout.setBorder(new EmptyBorder(5, 5, 75, 5));
        layout.setBackground(grey);

        JPanel btnPanel = new JPanel(new GridLayout(2, 1, 10, 20));
        btnPanel.setBackground(grey);

        // * Game Title
        JLabel gameTitle = new JLabel("PONG", SwingConstants.CENTER);
        gameTitle.setForeground(Color.white);
//        gameTitle.setFont(maruMonica);
        gameTitle.setFont(new Font("Dialog", Font.BOLD, 100));
        gameMenu.add(gameTitle, BorderLayout.CENTER);

        // * Start button
        JButton startButton = new JButton("START GAME");
        startButton.setFont(new Font("Dialog", Font.BOLD, 15));
        startButton.setBackground(grey);
        startButton.setForeground(Color.WHITE);
        startButton.setPreferredSize(new Dimension(250, 80));
        startButton.setFocusable(false);
        startButton.addActionListener(actionEvent -> {
            frame.dispose();
            new GameFrame();
        });

        // * Quit button
        JButton quitButton = new JButton("QUIT");
        quitButton.setFont(new Font("Dialog", Font.BOLD, 15));
        quitButton.setBackground(grey);
        quitButton.setForeground(Color.WHITE);
        quitButton.setPreferredSize(new Dimension(250, 80));
        quitButton.setFocusable(false);
        quitButton.addActionListener(actionEvent -> {
            frame.dispose();
        });

        btnPanel.add(startButton);
        btnPanel.add(quitButton);
        layout.add(btnPanel);

        gameMenu.add(layout, BorderLayout.SOUTH);

        frame.add(gameMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}
