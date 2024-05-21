import java.awt.*;

public class Score extends Rectangle {

    static int GAME_WIDTH;
    static int GAME_HEIGHT;
    int player1;
    int player2;

    Score(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Consolas",Font.PLAIN,60));

        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);

        g.drawString(String.valueOf(player1 / 10) + String.valueOf(player1 % 10), (GAME_WIDTH / 2) - 85, 50);
        g.drawString(String.valueOf(player2 / 10) + String.valueOf(player2 % 10), (GAME_WIDTH / 2) + 20, 50);

        g.setFont(new Font("Consolas", Font.PLAIN, 20));
        g.drawString("First to score 3 Goals wins", (GAME_WIDTH / 2) - 220, 100);
    }


    public void setPlayer1Score(int player1){
        this.player1=player1;
    }

    public void setPlayer2Score(int player2){
        this.player2=player2;
    }

    public int getPlayer1Score() {
        return player1;
    }

    public int getPlayer2Score() {
        return player2;
    }

    public void incrementPlayer1Score() {
        player1++;
    }

    public void incrementPlayer2Score() {
        player2++;
    }
}
