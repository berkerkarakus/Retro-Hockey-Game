import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamSelection extends JFrame {
    private JComboBox<String> playerOneComboBox;
    private JComboBox<String> playerTwoComboBox;
    private JButton startButton;

    public TeamSelection() {
        setTitle("Select Teams");
        setSize(800, 500); 
        getContentPane().setBackground(Color.BLACK);
        setLayout(new GridLayout(3, 1, 10, 10)); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

      
        String[] teams = {"Fenerbahce", "Galatasaray", "Besiktas", "Trabzonspor"};

     
        playerOneComboBox = createStyledComboBox(teams);
        playerTwoComboBox = createStyledComboBox(teams);

       
        JPanel playerOnePanel = new JPanel();
        playerOnePanel.setBackground(Color.BLACK);
        playerOnePanel.add(createStyledLabel("Player 1: ", 18));
        playerOnePanel.add(playerOneComboBox);

        
        JPanel playerTwoPanel = new JPanel();
        playerTwoPanel.setBackground(Color.BLACK);
        playerTwoPanel.add(createStyledLabel("Player 2: ", 18));
        playerTwoPanel.add(playerTwoComboBox);

      
        startButton = new JButton("Start Game");
        styleButton(startButton, 18);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String getSelectedTeamP1 = (String)playerOneComboBox.getSelectedItem();
                String getSelectedTeamP2 = (String)playerTwoComboBox.getSelectedItem();
                setVisible(false);
                GameFrame game = new GameFrame(getSelectedTeamP1, getSelectedTeamP2);
                game.setVisible(true);
            }
        });

        add(playerOnePanel);
        add(playerTwoPanel);
        add(startButton);
    }

    private JLabel createStyledLabel(String text, int fontSize) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        return label;
    }

    private JComboBox<String> createStyledComboBox(String[] items) {
        JComboBox<String> comboBox = new JComboBox<>(items);
        comboBox.setBackground(Color.GRAY);
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        return comboBox;
    }

    private void styleButton(JButton button, int fontSize) {
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, fontSize));
    }


}
