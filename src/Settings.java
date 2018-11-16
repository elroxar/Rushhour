import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class Settings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Settings extends JFrame implements MouseListener
{
    private Main zMain;
    private StartFenster zStartFenster;
    private JButton zkleinesFenster, zVollbild, zMusikan ,zMusikaus;
    private JLabel zFenstergroeße,zMusik;
    public Settings()
    {
        super("Einstellungen");
        setSize(1200,800);
        Container cp = getContentPane();
        cp.setLayout(null);
        setLocation((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)-600,(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2)-400);
        zFenstergroeße = new JLabel("Fenstergroeße");
        zFenstergroeße.setLocation(200,200);
        zFenstergroeße.setSize(100,70);
        cp.add(zFenstergroeße);
        zkleinesFenster = new JButton("1200*800");
        zkleinesFenster.setLocation(250,200);
        zkleinesFenster.setSize(100,100);
        cp.add(zkleinesFenster);
        zVollbild = new JButton("Vollbild");
        zVollbild.setLocation(400,200);
        zVollbild.setSize(100,100);
        cp.add(zVollbild);
        zMusik = new JLabel("Musik");
        zMusik.setLocation(200,550);
        zMusik.setSize(100,70);
        cp.add(zMusik);
        zMusikan = new JButton("Musik an");
        zMusikan.setLocation(250,550);
        zMusikan.setSize(100,100);
        cp.add(zMusikan);
        zMusikaus = new JButton("Musik aus");
        zMusikaus.setLocation(400,550);
        zMusikaus.setSize(100,100);
        cp.add(zMusikan);
        setVisible(true);
        addMouseListener(this);
    }
    public void mouseClicked(MouseEvent e){

    }

    public void mousePressed(MouseEvent e){}
    /**
     *
     * @param e MouseEvent Object
     */
    public void mouseReleased(MouseEvent e){}
    /**
     *
     * @param e MouseEvent Object
     */
    public void mouseEntered(MouseEvent e)//Maus in der Komponente
    {
    }
    /**
     *
     * @param e MouseEvent Object
     */
    public void mouseExited(MouseEvent e)//Maus aus Komponente verschwunden
    {
    }
}
