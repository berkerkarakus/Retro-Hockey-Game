import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamePanelTest {
    private GamePanel gamePanel;

    @BeforeEach
    public void setUp() {
        gamePanel = new GamePanel("Fenerbahce", "Galatasaray", new GameEndListener() {
            @Override
            public void onGameEnd() {

            }
        });
    }

    @Test
    public void testNewBall() {
        gamePanel.newBall();
        assertNotNull(gamePanel.getBall());
    }

    @Test
    public void testNewPaddles() {
        gamePanel.newPaddles();
        assertNotNull(gamePanel.getPaddle1());
        assertNotNull(gamePanel.getPaddle2());
    }

    @Test
    public void testBallCollisionWithTopEdge() {
        Ball ball = gamePanel.getBall();
        ball.setXDirection(GamePanel.GAME_WIDTH / 2 - GamePanel.BALL_DIAMETER / 2);  // Center the ball horizontally
        ball.setYDirection(0);  // Position at the top edge
        ball.setXDirection(0);
        ball.setYDirection(-5);  // Moving upwards

        for (int i = 0; i < 60; i++) {  // Simulate the game for collusion to happen
            gamePanel.move();
            gamePanel.checkCollision();
        }

        assertEquals(5, ball.getYDirection(), "Ball should invert Y direction upon hitting the top");
    }


    @Test
    public void testBallCollisionWithBottomEdge() {
        Ball ball = gamePanel.getBall();
        ball.setXDirection(GamePanel.GAME_WIDTH / 2 - GamePanel.BALL_DIAMETER / 2);  // Center the ball horizontally
        ball.setYDirection(GamePanel.GAME_HEIGHT - GamePanel.BALL_DIAMETER);  // Position just touching the bottom edge
        ball.setXDirection(0);
        ball.setYDirection(5);  // Moving downwards


        for (int i = 0; i < 60; i++) {  // Simulate the game for collusion to happen
            gamePanel.move();
            gamePanel.checkCollision();
        }

        // Check if the ball's direction has inverted after 'simulated' 1 second
        assertEquals(-5, ball.getYDirection(), "Ball should invert Y direction upon hitting the bottom");
    }





    @Test
    public void testEndGame() {
        gamePanel.getScore().setPlayer1Score(3);
        gamePanel.checkCollision();
        assertEquals("Fenerbahce", gamePanel.getWinnerTeam());
        assertEquals(1, gamePanel.getWinnerId());
    }
}
