import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel(){
        selectTeams(); // Let players select teams at the beginning
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
    }
    public void newPaddles() {
        paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }
    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync(); 

    }
    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }
    public void checkCollision() {

        //bounce ball off top & bottom window edges
        if(ball.y <=0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }
        //bounce ball off paddles
        if(ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //optional for more difficulty
            if(ball.yVelocity>0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++; //optional for more difficulty
            if(ball.yVelocity>0)
                ball.yVelocity++; //optional for more difficulty
            else
                ball.yVelocity--;
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        //stops paddles at window edges
        if(paddle1.y<=0)
            paddle1.y=0;
        if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        if(paddle2.y<=0)
            paddle2.y=0;
        if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        //give a player 1 point and creates new paddles & ball
        if(ball.x <=0) {
            score.player2++;
            newPaddles();
            newBall();
            System.out.println("Player 2: "+score.player2);
        }
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
            score.player1++;
            newPaddles();
            newBall();
            System.out.println("Player 1: "+score.player1);
        }
    }
    public void run() {
        //game loop
        long lastTime = System.nanoTime();
        double amountOfTicks =60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }



    // Define teams
    private enum Team {
        BESIKTAS, GALATASARAY, FENERBAHCE, TRABZONSPOR
    }

    // Selected teams
    private Team team1;
    private Team team2;


    // Method to let players select teams
    private void selectTeams() {
        // Create a dialog for team selection
        JDialog teamSelectionDialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Team Selection", true);
        teamSelectionDialog.setLayout(new GridLayout(3, 2));

        // Add buttons for team selection
        JButton besiktasButton = new JButton("Beşiktaş");
        besiktasButton.addActionListener(e -> {
            team1 = Team.BESIKTAS;
            besiktasButton.setEnabled(false);
        });
        JButton galatasarayButton = new JButton("Galatasaray");
        galatasarayButton.addActionListener(e -> {
            team1 = Team.GALATASARAY;
            galatasarayButton.setEnabled(false);
        });
        JButton fenerbahceButton = new JButton("Fenerbahçe");
        fenerbahceButton.addActionListener(e -> {
            team1 = Team.FENERBAHCE;
            fenerbahceButton.setEnabled(false);
        });
        JButton trabzonsporButton = new JButton("Trabzonspor");
        trabzonsporButton.addActionListener(e -> {
            team1 = Team.TRABZONSPOR;
            trabzonsporButton.setEnabled(false);
        });

        // Add buttons to the dialog
        teamSelectionDialog.add(besiktasButton);
        teamSelectionDialog.add(galatasarayButton);
        teamSelectionDialog.add(fenerbahceButton);
        teamSelectionDialog.add(trabzonsporButton);

        // Set dialog properties
        teamSelectionDialog.setSize(300, 150);
        teamSelectionDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        teamSelectionDialog.setLocationRelativeTo(null);
        teamSelectionDialog.setVisible(true);
    }

    // Determine the winning team and play its anthem
    private void playWinningAnthem() {
        Team winningTeam = score.player1 > score.player2 ? team1 : team2;
        switch (winningTeam) {
            case BESIKTAS:
                playAudio("/path/to/besiktas_anthem.wav");
                break;
            case GALATASARAY:
                playAudio("/path/to/galatasaray_anthem.wav");
                break;
            case FENERBAHCE:
                playAudio("/path/to/fenerbahce_anthem.wav");
                break;
            case TRABZONSPOR:
                playAudio("/path/to/trabzonspor_anthem.wav");
                break;
        }
    }

    // Method to play audio
    private void playAudio(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
