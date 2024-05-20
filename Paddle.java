import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{

    String id1;
    int id;
    int yVelocity;
    int speed = 10;

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, String id1,int id){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id1=id1;
        this.id=id;
    }

    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W) {
                    setYDirection(-speed);
                }
                if(e.getKeyCode()==KeyEvent.VK_S) {
                    setYDirection(speed);
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP) {
                    setYDirection(-speed);
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W) {
                    setYDirection(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_S) {
                    setYDirection(0);
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP) {
                    setYDirection(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN) {
                    setYDirection(0);
                }
                break;
        }
    }
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    public int getYDirection() {
        return yVelocity;
    }

    public void move() {
        y= y + yVelocity;
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