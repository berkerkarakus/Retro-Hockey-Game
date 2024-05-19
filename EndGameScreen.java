import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndGameScreen extends JFrame {
    private JButton playAgainButton;
    private Color color1;
    private Color color2;
    private String winner;

    public EndGameScreen(String winningTeam, int id) {
        setTitle("Game Over");
        setSize(600, 300); // Increased frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set team colors and winner message based on the team and winning player
        setTeamColors(winningTeam);
        if(id == 1) {
            winner = "Player 1 won the game!";
        } else {
            winner = "Player 2 won the game!";
        }

        // Custom panel to handle color split
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Dimension size = getSize();
                g.setColor(color1);
                g.fillRect(0, 0, size.width / 2, size.height);
                g.setColor(color2);
                g.fillRect(size.width / 2, 0, size.width, size.height);
            }
        };
        setContentPane(panel);
        setLayout(new BorderLayout());

        // Message label
        JLabel messageLabel = new JLabel(winner, SwingConstants.CENTER);
        messageLabel.setForeground(Color.WHITE); // Set text color to white for visibility
        messageLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Increased font size
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(0,0,0,123)); // Semi-transparent background for readability
        add(messageLabel, BorderLayout.CENTER);

        // Play again button
        playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call method to restart the game
                dispose(); // Close this screen
                TeamSelection teamSelection = new TeamSelection();
                teamSelection.setVisible(true);
            }
        });
        add(playAgainButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void setTeamColors(String team) {
        // Customize these colors based on your team color scheme
        switch (team) {
            case "Fenerbahce":
                color1 = new Color(0, 51, 160); // Dark Blue
                color2 = new Color(255, 204, 0); // Yellow
                break;
            case "Galatasaray":
                color1 = new Color(255, 0, 0); // Red
                color2 = new Color(255, 153, 0); // Orange
                break;
            case "Besiktas":
                color1 = new Color(0, 0, 0); // Black
                color2 = new Color(255, 255, 255); // White
                break;
            case "Trabzonspor":
                color1 = new Color(220, 0, 0); // Burgundy
                color2 = new Color(0, 20, 137); // Blue
                break;

        }
    }

}
