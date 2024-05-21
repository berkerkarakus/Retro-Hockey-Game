import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BallTest {
    private Ball ball;

    @BeforeEach
    public void setUp() {
        ball = new Ball(100, 100, 20, 20);
    }

    @Test
    public void testBallMove() {
        ball.setXDirection(5);
        ball.setYDirection(5);
        ball.move();
        assertEquals(105, ball.getX());
        assertEquals(105, ball.getY());
    }

    @Test
    public void testSetXDirection() {
        ball.setXDirection(5);
        assertEquals(5, ball.getXDirection());
    }

    @Test
    public void testSetYDirection() {
        ball.setYDirection(5);
        assertEquals(5, ball.getYDirection());
    }
}
