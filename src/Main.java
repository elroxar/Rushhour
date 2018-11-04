import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//Autor Louis,Ben
/**
 *
 */
public class Main extends JFrame implements MouseListener {
    /* Attribute */
    private JLabel zZuege;
    private Draw zgenerate;
    private JMenuBar MenueLeiste;
    private JMenu zLevelauswahl;
    private JMenuItem Level;
    // private Fahrzeug[] zFahrzeuge;

    /* Methoden */
    public Main() {
        zZuege = new JLabel("Zug: ");
        setLocation(250, 10);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        zgenerate = new Draw();
        cp.add(zgenerate);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setAlwaysOnTop(true);
        setVisible(true);
        setResizable(true);
        cp.add(zZuege);
        MenueLeiste = new JMenuBar();
        //TODO: Fix
        //set JMenuBar(MenueLeiste);
        //Levelauswahl = new JMenu("LevelAuswahl");
        for (int i = 1; i < 40; i++)
        {
            //zLevelauswahl.add(new Level("Level"+i));
        }
    }
    public void update(){} //ist die mouseClicked Methode
    public void mouseClicked(MouseEvent e)//wenn Maus geklickt wurde//Feldabfrage//e.getx/y
    {
        //  zgenerate.repaint();
        //if(e.getx())
    }
    public void mousePressed(MouseEvent e)//wenn Maustaste runtergedrückt wurde
    {
    }
    public void mouseReleased(MouseEvent e)//wenn Taste wieder losgelassen wurde
    {
    }
    public void mouseEntered(MouseEvent e)//Maus in der Komponente
    {
    }
    public void mouseExited(MouseEvent e)//Maus aus Komponente verschwunden
    {
    }
}