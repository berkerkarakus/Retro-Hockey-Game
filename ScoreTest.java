import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreTest {
    private Score score;

    @BeforeEach
    public void setUp() {
        score = new Score(1000, 555);
    }

    @Test
    public void testInitialScore() {
        assertEquals(0, score.getPlayer1Score());
        assertEquals(0, score.getPlayer2Score());
    }

    @Test
    public void testScoreUpdate() {
        score.incrementPlayer1Score();
        score.incrementPlayer2Score();
        assertEquals(1, score.getPlayer1Score());
        assertEquals(1, score.getPlayer2Score());
    }
}