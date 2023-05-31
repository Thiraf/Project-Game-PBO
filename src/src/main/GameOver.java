package main;

import main.GamePanel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class GameOver extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Over");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 30));

        frame.add(gameOverLabel);

        frame.setVisible(true);
    }
}
