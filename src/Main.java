import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * @author louis, ben
 * @version 05/11/2018
 */
public class Main extends JFrame implements MouseListener {
    /* Attribute */

    private JLabel zLBSpielzuege;
    private Draw zGenerate;
    private JMenuBar zMBMenueleiste;
    private JMenu zMNLevelauswahl;
    private JMenu zMNgradLeicht;
	private JMenu zMNgradMittel;
	private JMenu zMNgradSchwer;
    // private Fahrzeug[] zFahrzeuge;

    /* Methoden */
    public Main() {

		//Standardeinstellungen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(true);

		//Festlegen des Layouts (Flowlayout)
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		
        
        //initialisiere zGenerate
        zGenerate = new Draw();
        cp.add(zGenerate);

		//Print Spielzuege
		zLBSpielzuege = new JLabel("Zug: ");
		cp.add(zLBSpielzuege);

        //Erstelle Menueleiste
        zMBMenueleiste = new JMenuBar();
		setJMenuBar(zMBMenueleiste);

		//Initialisieren der Menueleisten Gegenstaende
		zMNLevelauswahl = new JMenu("LevelAuswahl");
        zMNgradLeicht = new JMenu("Leichte Level");
		zMNgradMittel = new JMenu("Normale Level");
		zMNgradSchwer = new JMenu("Schwere Level");

		//Gegenstaende zur Menueleiste hinzufuegen
		zMBMenueleiste.add(zMNLevelauswahl);
		zMNLevelauswahl.add(zMNgradLeicht);
		zMNLevelauswahl.add(zMNgradMittel);
		zMNLevelauswahl.add(zMNgradSchwer);

		//Level nach Schwierigkeitsgrd sortieren
        for (int i = 1; i <= 40; i++)
			if (i <= 10) {
				zMNgradLeicht.add(new JMenuItem("Level " + i)); //Hinzufuegen des levels
			} else if (i <= 25) {
				zMNgradMittel.add(new JMenuItem("Level " + i)); //Hinzufuegen des levels
			} else if (i <= 40) {
				zMNgradSchwer.add(new JMenuItem("Level " + i)); //Hinzufuegen des levels
			}
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
        //zGenerate.repaint();
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