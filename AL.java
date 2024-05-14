import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AL extends KeyAdapter {
    public void keyPressed(KeyEvent e) {
        paddle1.keyPressed(e);
        paddle2.keyPressed(e);
    }
    public void keyReleased(KeyEvent e) {
        paddle1.keyReleased(e);
        paddle2.keyReleased(e);
    }
}


