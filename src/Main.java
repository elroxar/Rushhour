import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author louis, ben ,theo
 * @version 05/11/2018
 */
public class Main extends JFrame{
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
	public Main(){
		
		//Standardeinstellungen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		setAlwaysOnTop(false); //TODO: Auf true setzen
		
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
		zMNgradExtrem = new JMenu("Extreme Level");
		
		//Gegenstaende zur Menueleiste hinzufuegen
		zMBMenueleiste.add(zMNLevelauswahl);
		zMNLevelauswahl.add(zMNgradLeicht);
		zMNLevelauswahl.add(zMNgradMittel);
		zMNLevelauswahl.add(zMNgradSchwer);
		zMNLevelauswahl.add(zMNgradExtrem);
		
		//Level nach Schwierigkeitsgrd sortieren
		JMenuItem lLevel = new JMenuItem();
		for(int i = 0; i < 40; i++){
			
			lLevel = new JMenuItem("Level " + (i + 1));
			lLevel.addActionListener((ActionEvent ev) -> {
				JMenuItem obj = (JMenuItem)ev.getSource();
				int id = Integer.parseInt(obj.getText().split(" ")[1]);
				System.out.println(id);
				id--;
				zGenerate.drawFahrzeuge(zSpielbrett.ladeLevel(id--));
				zGenerate.repaint();
			});
			zLevel[i] = lLevel;
			if(i <= 9){
				zMNgradLeicht.add(zLevel[i]); //Hinzufuegen des levels
			}
			else if(i <= 19){
				zMNgradMittel.add(zLevel[i]); //Hinzufuegen des levels
			}
			else if(i <= 29){
				zMNgradSchwer.add(zLevel[i]); //Hinzufuegen des levels
			}
			else if(i <= 39){
				zMNgradExtrem.add(zLevel[i]); //Hinzufuegen des levels
			}
			
		}
	}
	
	/**
	 *
	 */
	public void update(){} //ist die mouseClicked Methode
}