import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;

/**
 * @author ben
 * @version 05/11/2018
 */
public class StartFenster extends JFrame
{

    private JLabel zTitel;
    private Startbutton zStart;
    private Settingsbutton zEinstellungen;
    private Icon zIcon;

    public StartFenster()
    {
        super("Rushhour-The Game");
        setSize(1200,800);
        setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-600,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-400);
        Container cp = getContentPane();
        cp.setLayout(null);

        zStart = new Startbutton(Toolkit.getDefaultToolkit().getImage("play_button.jpg"),0,0);
        zStart.setSize(70,70);
        zStart.setLocation(450,400);
        cp.add(zStart);

        zEinstellungen = new Settingsbutton(Toolkit.getDefaultToolkit().getImage("settings_button.jpg"),0,0);
        zEinstellungen.setSize(70,70);
        zEinstellungen.setLocation(650,400);
        cp.add(zEinstellungen);

        zIcon = new Icon(Toolkit.getDefaultToolkit().getImage("Icon.jpg"),0,0);
        zIcon.setSize(800,200);
        zIcon.setLocation(200,100);
        cp.add(zIcon);


        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
