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
        KeyEvent keyEventPress = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        paddle.keyPressed(keyEventPress);
        paddle.move();
        assertTrue(paddle.getY() < 0);
    }

    @Test
    public void testPaddleMoveDown() {
        KeyEvent keyEventPress = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        paddle.keyPressed(keyEventPress);
        paddle.move();
        assertTrue(paddle.getY() > 0);
    }

    @Test
    public void testKeyPressedUp() {
        KeyEvent keyEvent = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        paddle.keyPressed(keyEvent);
        paddle.move(); // Move the paddle after key press
        assertEquals(-10, paddle.getYDirection());
    }

    @Test
    public void testKeyPressedDown() {
        KeyEvent keyEvent = new KeyEvent(new JButton(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        paddle.keyPressed(keyEvent);
        paddle.move(); // Move the paddle after key press
        assertEquals(10, paddle.getYDirection());
    }

    @Test
    public void testKeyReleased() {
        KeyEvent keyEvent = new KeyEvent(new JButton(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        paddle.keyPressed(keyEvent); // Press the key to set the direction
        paddle.keyReleased(keyEvent); // Release the key
        paddle.move(); // Update paddle's position after release
        assertEquals(0, paddle.getYDirection());
    }
}
