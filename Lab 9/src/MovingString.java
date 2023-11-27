import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MovingString extends JFrame {
    private static final long serialVersionUID = 1L;

    private String movingText = "Привет";
    private int x = 0;
    private int y = 100;
    private int xSpeed = 5; // скорость движения
    private Color textColor = Color.BLACK;

    public MovingString() {
        setTitle("Moving String");
        setSize(800, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Timer timer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                moveString();
                changeColor();
                changeCase();
                repaint();
            }
        });
        timer.start();

        add(new DrawingPanel());
    }

    private void moveString() {
        x += xSpeed;
        if (x + getWidthOfString() > getWidth() || x < 0) {
            xSpeed = -xSpeed; // меняем направление при достижении границ
        }
    }

    private int getWidthOfString() {
        return getFontMetrics(new Font("Arial", Font.PLAIN, 20)).stringWidth(movingText);
    }

    private void changeColor() {
        textColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
    }

    private void changeCase() {
        StringBuilder modifiedText = new StringBuilder();
        for (char c : movingText.toCharArray()) {
            if (Character.isLetter(c)) {
                if (Math.random() < 0.5) {
                    modifiedText.append(Character.toLowerCase(c));
                } else {
                    modifiedText.append(Character.toUpperCase(c));
                }
            } else {
                modifiedText.append(c);
            }
        }
        movingText = modifiedText.toString();
    }

    private class DrawingPanel extends JPanel {
        private static final long serialVersionUID = 1L;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setFont(new Font("Arial", Font.PLAIN, 20));
            g2d.setColor(textColor);
            g2d.drawString(movingText, x, y);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MovingString().setVisible(true);
            }
        });
    }
}
