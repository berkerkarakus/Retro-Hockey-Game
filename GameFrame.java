import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(String SelectedTeam1, String SelectedTeam2) {
        GamePanel panel = new GamePanel(SelectedTeam1, SelectedTeam2, new GameEndListener() {
            @Override
            public void onGameEnd() {
                dispose();
            }
        });

        // Frame initialization code
        setTitle("Retro Hockey Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.GRAY);
        add(panel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

}
