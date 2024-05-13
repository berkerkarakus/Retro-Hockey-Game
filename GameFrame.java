import java.awt.*;
import javax.swing.*;
public class GameFrame extends JFrame {
    GamePanel panel=new GamePanel();

     public GameFrame(){

        this.add(panel);
        this.setTitle("Retro Hockey Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }


}
