import static org.junit.jupiter.api.Assertions.*;
import java.awt.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EndGameScreenTest {
    private EndGameScreen endGameScreen;

    @BeforeEach
    public void setUp() {
        endGameScreen = new EndGameScreen("Fenerbahce",1);
    }

    @Test
    public void testGetTeamColor() {
        assertEquals(Color.YELLOW, endGameScreen.getTeamColor("Fenerbahce"));
        assertEquals(Color.RED, endGameScreen.getTeamColor("Galatasaray"));
        assertEquals(Color.BLACK, endGameScreen.getTeamColor("Besiktas"));
        assertEquals(Color.BLUE, endGameScreen.getTeamColor("Trabzonspor"));
    }
}