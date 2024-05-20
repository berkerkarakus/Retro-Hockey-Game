import static org.junit.jupiter.api.Assertions.*;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaddleTest {
    private Paddle paddle;

    @BeforeEach
    public void setUp() {
        paddle = new Paddle(0, 0, 25, 100, "Fenerbahce", 1);
    }

    @Test
    public void testPaddleMoveUp() {
        paddle.setYDirection(-10);
        paddle.move();
        assertEquals(-10, paddle.getY());
    }

    @Test
    public void testPaddleMoveDown() {
        paddle.setYDirection(10);
        paddle.move();
        assertEquals(10, paddle.getY());
    }

    @Test
    public void testKeyPressedUp() {
        KeyEvent keyEvent = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        paddle.keyPressed(keyEvent);
        assertEquals(-10, paddle.getYDirection());
    }

    @Test
    public void testKeyPressedDown() {
        KeyEvent keyEvent = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        paddle.keyPressed(keyEvent);
        assertEquals(10, paddle.getYDirection());
    }

    @Test
    public void testKeyReleased() {
        KeyEvent keyEvent = new KeyEvent(new JButton(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        paddle.keyPressed(keyEvent);
        paddle.keyReleased(keyEvent);
        assertEquals(0, paddle.getYDirection());
    }
}
