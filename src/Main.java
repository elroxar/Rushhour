import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * @author louis, ben
 * @version 05/11/2018
 */
public class Main extends JFrame implements MouseListener {
    /* Attribute */
	//TODO: Variablen umbenennen nach LK-Schema
    private JLabel zZuege;
    private Draw zgenerate;
    private JMenuBar MenueLeiste;
    private JMenu zLevelauswahl;
    private JMenuItem Level;
    // private Fahrzeug[] zFahrzeuge;

    /* Methoden */
    public Main() { //TODO: Dokumentieren
        zZuege = new JLabel("Zug: ");
        setLocation(250, 10);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        zgenerate = new Draw();
        cp.add(zgenerate);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
        setAlwaysOnTop(true);
        setVisible(true);
        setResizable(true);
        cp.add(zZuege);
        MenueLeiste = new JMenuBar();
        //TODO: Fix
        setJMenuBar(MenueLeiste);
        zLevelauswahl = new JMenu("LevelAuswahl");
        MenueLeiste.add(zLevelauswahl);
        for (int i = 1; i <= 40; i++)
            zLevelauswahl.add(new JMenuItem("Level " + i));
    }
    /**
     *
     */
    public void update(){} //ist die mouseClicked Methode
    /**
     *
     * @param e MouseEvent Object
     */
    public void mouseClicked(MouseEvent e)//wenn Maus geklickt wurde//Feldabfrage//e.getx/y
    {
        //zgenerate.repaint();
        //if(e.getx())
    }
	/**
	 *
	 * @param e MouseEvent Object
	 */
	public void mousePressed(MouseEvent e)//wenn Maustaste runtergedrückt wurde
    {
    }
	/**
	 *
	 * @param e MouseEvent Object
	 */
	public void mouseReleased(MouseEvent e)//wenn Taste wieder losgelassen wurde
    {
    }
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