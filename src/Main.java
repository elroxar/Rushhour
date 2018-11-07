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
	private JMenu zMNgradExtrem;
	private Fahrzeug[] zFahrzeuge;
	private Spielbrett zSpielbrett = new Spielbrett();

	private JMenuItem[] zLevel = new JMenuItem[40];
	private int lI;

    /* Methoden */
    public Main() {

		//Standardeinstellungen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(true);


		//Festlegen des Layouts (Flowlayout)
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.setBackground(Color.BLACK);


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
		zMNgradExtrem = new JMenu("Extreme Level");

		//Gegenstaende zur Menueleiste hinzufuegen
		zMBMenueleiste.add(zMNLevelauswahl);
		zMNLevelauswahl.add(zMNgradLeicht);
		zMNLevelauswahl.add(zMNgradMittel);
		zMNLevelauswahl.add(zMNgradSchwer);
		zMNLevelauswahl.add(zMNgradExtrem);

		//Level nach Schwierigkeitsgrd sortieren
		JMenuItem lLevel = new JMenuItem();
		for (int i = 0; i < 40; i++) {

			lLevel = new JMenuItem(("Level " + i));
			lI = i;
			lLevel.addActionListener((ActionEvent ev) -> {
				JMenuItem obj = (JMenuItem)ev.getSource();
				String id = obj.getText().split(" ")[1];
				zSpielbrett.ladeLevel(Integer.parseInt(id));
			});
			zLevel[i] = lLevel;
			if (i <= 10) {
				zMNgradLeicht.add(zLevel[i]); //Hinzufuegen des levels
			} else if (i <= 20) {
				zMNgradMittel.add(zLevel[i]); //Hinzufuegen des levels
			} else if (i <= 30) {
				zMNgradSchwer.add(zLevel[i]); //Hinzufuegen des levels
			} else if (i <= 40) {
				zMNgradExtrem.add(zLevel[i]); //Hinzufuegen des levels
			}

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