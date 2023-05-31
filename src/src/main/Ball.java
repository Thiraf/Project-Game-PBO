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

public class Ball extends Rectangle {
    int diameter = 30;

    Random random;
    int XVelocity;
    int YVelocity;
    int initialSpeed = 5;
    int hitCounter = 0;

    Color white = new Color(254, 241, 209);
    Color yellow = new Color(255, 255, 51);
    Color red = new Color(225, 61, 12);

    public Ball(int ballX, int ballY, int ballWidth, int ballHeight) {
        super(ballX, ballY, ballWidth, ballHeight);
        random = new Random();

        int randomXDirection = random.nextInt(3);
        if (randomXDirection == 0) {
            randomXDirection--;
        }
        setXDirection(randomXDirection*initialSpeed);

        int randomYDirection = random.nextInt(3);
        if (randomYDirection == 0) {
            randomYDirection--;
        }
        setYDirection(randomYDirection*initialSpeed);
    }

    public void setXDirection(int randomXDirection) {
        XVelocity = randomXDirection;
    }

    public void setYDirection(int randomYDirection) {
        YVelocity = randomYDirection;
    }

    public void move() {
        x += XVelocity;
        y += YVelocity;
    }

    public void draw(Graphics g) {

        if (hitCounter < 6) {
            g.setColor(white);
            g.fillOval(x, y, width, height);
        }
        else if (hitCounter < 10) {
            g.setColor(yellow);
            g.fillOval(x, y, width, height);
        }
        else {
            g.setColor(red);
            g.fillOval(x, y, width, height);
        }

    }
}
