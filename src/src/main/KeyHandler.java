package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean WPressed, SPressed;
    public boolean upPressed, downPressed;

    @Override //! Not Used
    public void keyTyped(KeyEvent e) {}


    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W ) {
            WPressed = true;
        }
        if (code == KeyEvent.VK_S ) {
            SPressed = true;
        }

        if (code == KeyEvent.VK_UP ) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_DOWN ) {
            downPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W ) {
            WPressed = false;
        }
        if (code == KeyEvent.VK_S ) {
            SPressed = false;
        }

        if (code == KeyEvent.VK_UP ) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN ) {
            downPressed = false;
        }

    }
}