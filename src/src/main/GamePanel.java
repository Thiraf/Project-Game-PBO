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

public class GamePanel extends JPanel implements Runnable {

    // * SCREEN SETTINGS
    static final int screenWidth = 1000;
    static final int screenHeight = (int)(screenWidth * (0.5555));
    static final Dimension screenSize = new Dimension(screenWidth,screenHeight);
    static final int ballDiameter = 20;
    static final int paddleWidth = 25;
    static final int paddleHeight = 100;

    // * FPS
    int FPS = 60;

    // * Obeject
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Image image;
    Graphics graphics;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;
    Win playerWin;
    Color grey = new Color(17, 17, 17);

    // * call paddle and ball
    public void newPaddle() {

        paddle1 = new Paddle(0, (screenHeight/2)-(paddleHeight/2), paddleWidth, paddleHeight, 1);
        paddle2 = new Paddle(screenWidth-paddleWidth, (screenHeight/2)-(paddleHeight/2), paddleWidth, paddleHeight, 2);
    }

    public void newBall() {
        ball = new Ball((screenWidth / 2) - (ballDiameter / 2), (screenHeight / 2) - (ballDiameter / 2), ballDiameter, ballDiameter);
    }

    public GamePanel() {

        newPaddle();
        newBall();

        playerWin = new Win(screenWidth, screenHeight);
        score = new Score(screenWidth, screenHeight);
        this.setPreferredSize(screenSize);
        this.setBackground(grey);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void stopGameThread() {


        gameThread = null;
    }

    //! 1 UPDATE : update information such as character position
    //! 2 DRAW : draw the screen with updated information

    @Override // * Gameloop the core of our game (Delta loop)
    public void run() {

        double drawInterval = (double) 1000000000 /FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                checkCollision();
                repaint();
                delta--;
            }

        }
    }

    public void update() {

        if (keyH.WPressed) {
            paddle1.y -= paddle1.paddleSpeed;
        }
        if (keyH.SPressed) {
            paddle1.y += paddle1.paddleSpeed;
        }

        if (keyH.upPressed) {
            paddle2.y -= paddle2.paddleSpeed;
        }
        if (keyH.downPressed) {
            paddle2.y += paddle2.paddleSpeed;
        }

        ball.move();
    }

    public void checkCollision() {

    // * stops paddle from going out of bounds
        if (paddle1.y <= 0) {
            paddle1.y = 0;
        }
        if (paddle1.y >= (screenHeight - paddleHeight)) {
            paddle1.y = screenHeight - paddleHeight;
        }

        if (paddle2.y <= 0) {
            paddle2.y = 0;
        }
        if (paddle2.y >= (screenHeight - paddleHeight)) {
            paddle2.y = screenHeight - paddleHeight;
        }

    // * ball collision with paddle

        // * paddle1 w/ ball collision
        if (ball.intersects(paddle1)) {

            ball.XVelocity = Math.abs(ball.XVelocity);
            ball.XVelocity++; //incerease speed
            if (ball.YVelocity > 0) {
                ball.YVelocity++; //incerease speed
            } else {
                ball.YVelocity--;
            }
            ball.setXDirection(ball.XVelocity);
            ball.setYDirection(ball.YVelocity);
            ball.hitCounter++;
        }

        // * paddle2 w/ ball collision
        if (ball.intersects(paddle2)) {

            ball.XVelocity = Math.abs(ball.XVelocity);
            ball.XVelocity++; //incerease speed
            if (ball.YVelocity > 0) {
                ball.YVelocity++; //incerease speed
            } else {
                ball.YVelocity--;
            }
            ball.setXDirection(-ball.XVelocity);
            ball.setYDirection(ball.YVelocity);
            ball.hitCounter++;
        }

    // * ball collision with top & bottom border
        if (ball.y <= 0) {
            ball.setYDirection(-ball.YVelocity);
        }
        if (ball.y >= screenHeight-ball.diameter) {
            ball.setYDirection(-ball.YVelocity);
        }

    // * score update
        if (ball.x <= 0) {
            Score.player2++;
            newBall();
            System.out.println(score);
        }

        if (ball.x >= screenWidth-ballDiameter) {
            Score.player1++;
            newBall();
            System.out.println(score);
        }

    // * End game
        if (Score.player1 == 11) {
            Win.winnerId = 1;
            ball.XVelocity = 0;
            ball.YVelocity = 0;

            stopGameThread();

            System.out.println("==================");
            System.out.println("= Player 1 Wins! =");
            System.out.println("==================");
        }

        if (Score.player2 == 11) {
            Win.winnerId = 2;
            ball.XVelocity = 0;
            ball.YVelocity = 0;

            stopGameThread();

            System.out.println("==================");
            System.out.println("= Player 2 Wins! =");
            System.out.println("==================");
        }


    }

    @Override
    public void paint(Graphics g) {

        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    public void draw(Graphics g) {

        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
        playerWin.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }


}
