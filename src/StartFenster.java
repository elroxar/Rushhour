import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author ben
 * @version 05/11/2018
 */
public class StartFenster extends JFrame
{

    private JLabel zTitel;

    private Startbutton zStart;

    private Thread th;


    public StartFenster()
    {
        super("Rushhour-The Game");
        setSize(1200,800);
        setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-600,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-400);
        Container cp = getContentPane();
        cp.setLayout(null);

        zStart = new Startbutton(Toolkit.getDefaultToolkit().getImage("data/play_button.jpg"),(getWidth()/2)-35,(getHeight()/2)-35, this);

        zEinstellungen = new Settingsbutton(Toolkit.getDefaultToolkit().getImage("data/Settings_button.jpg"),0,0);
        zEinstellungen.setSize(70,70);
        zEinstellungen.setLocation(650,400);
        cp.add(zEinstellungen);

        zIcon = new Icon(Toolkit.getDefaultToolkit().getImage("data/icon.jpg"),0,0);
        zIcon.setSize(800,200);
        zIcon.setLocation(200,100);
        cp.add(zIcon);

        cp.setBackground(Color.black);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loop();
    }

    @Override
    public void paint(Graphics gr) {
        BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        super.paint(g2d);
        g2d.drawImage(Toolkit.getDefaultToolkit().getImage("data/bg_6.jpg"), 0, 0, null);
        g2d.drawImage(Toolkit.getDefaultToolkit().getImage("data/Icon.jpg"),200, 100,800,200,this);
        zStart.paint(g2d);

        gr.drawImage(bufferedImage, 0, 0, null);
    }


    public void loop() {
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                while(isVisible()) {
                    repaint();
                    try{
                        Thread.sleep(17);
                    } catch(InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        th.start();
    }

}
