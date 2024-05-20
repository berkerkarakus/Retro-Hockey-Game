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
                // Implement if needed for testing
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
    public void testCheckCollision() {
        gamePanel.getPaddle1().setYDirection(0);
        gamePanel.getPaddle2().setYDirection(0);
        gamePanel.getBall().setXDirection(0);
        gamePanel.getBall().setYDirection(0);
        gamePanel.getBall().setXDirection(-5);
        gamePanel.getBall().setYDirection(-5);
        gamePanel.checkCollision();
        assertEquals(5, gamePanel.getBall().getXDirection());
        assertEquals(5, gamePanel.getBall().getYDirection());
    }

    @Test
    public void testEndGame() {
        gamePanel.getScore().setPlayer1Score(3);
        gamePanel.checkCollision();
        assertEquals("Fenerbahce", gamePanel.getWinnerTeam());
        assertEquals(1, gamePanel.getWinnerId());
    }
}