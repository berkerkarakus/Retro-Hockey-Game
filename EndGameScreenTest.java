import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.Color;

public class EndGameScreenTest {

    @Test
    public void testGetFenerbahceColor() {
        EndGameScreen endGameScreen = new EndGameScreen("Fenerbahce", 1);
        assertEquals(new Color(0, 51, 160), endGameScreen.getTeamColor("Fenerbahce"), "Check Fenerbahce primary color");
    }

    @Test
    public void testGetGalatasarayColor() {
        EndGameScreen endGameScreen = new EndGameScreen("Galatasaray", 1);
        assertEquals(new Color(255, 0, 0), endGameScreen.getTeamColor("Galatasaray"), "Check Galatasaray primary color");
    }

    @Test
    public void testGetBesiktasColor() {
        EndGameScreen endGameScreen = new EndGameScreen("Besiktas", 1);
        assertEquals(new Color(0, 0, 0), endGameScreen.getTeamColor("Besiktas"), "Check Besiktas primary color");
    }

    @Test
    public void testGetTrabzonsporColor() {
        EndGameScreen endGameScreen = new EndGameScreen("Trabzonspor", 1);
        assertEquals(new Color(220, 0, 0), endGameScreen.getTeamColor("Trabzonspor"), "Check Trabzonspor primary color");
    }
}
