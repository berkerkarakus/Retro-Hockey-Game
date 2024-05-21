import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{

    String id1;
    int id;
    int yVelocity;
    int speed = 10;
    boolean[] keyStates = new boolean[256];  // Adjust the size if needed for more keys

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, String id1, int id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id1 = id1;
        this.id = id;
    }

    public void keyPressed(KeyEvent e) {
        keyStates[e.getKeyCode()] = true;  // Set the key state to pressed
    }

    public void keyReleased(KeyEvent e) {
        keyStates[e.getKeyCode()] = false;  // Set the key state to not pressed
    }

    public void move() {
        if (id == 1) {
            if (keyStates[KeyEvent.VK_W]) {
                setYDirection(-speed);
            } else if (keyStates[KeyEvent.VK_S]) {
                setYDirection(speed);
            } else {
                setYDirection(0);
            }
        } else if (id == 2) {
            if (keyStates[KeyEvent.VK_UP]) {
                setYDirection(-speed);
            } else if (keyStates[KeyEvent.VK_DOWN]) {
                setYDirection(speed);
            } else {
                setYDirection(0);
            }
        }

        y += yVelocity;
    }
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public int getYDirection() {
        return yVelocity;
    }


    public void draw(Graphics g) {
        if(id1=="Fenerbahce") {

            g.setColor(Color.YELLOW);
            g.fillRect(x, y, width / 2, height);  // Fill half the width with yellow

            // Draw the second half in blue
            g.setColor(Color.BLUE);
            g.fillRect(x + width / 2, y, width / 2, height);
        } else if (id1=="Galatasaray") {
            g.setColor(Color.YELLOW);
            g.fillRect(x, y, width / 2, height);  // Fill half the width with yellow

            // Draw the second half in blue
            g.setColor(Color.RED);
            g.fillRect(x + width / 2, y, width / 2, height);

        } else if (id1=="Trabzonspor") {
            g.setColor(Color.RED);
            g.fillRect(x, y, width / 2, height);  // Fill half the width with yellow

            // Draw the second half in blue
            g.setColor(Color.BLUE);
            g.fillRect(x + width / 2, y, width / 2, height);

        } else if (id1=="Besiktas") {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, width / 2, height);  // Fill half the width with yellow


            g.setColor(Color.black);
            g.fillRect(x + width / 2, y, width / 2, height);
        }
    }
}