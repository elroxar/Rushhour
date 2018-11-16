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

        addMouseListener(this);
		//Standardeinstellungen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
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

			lLevel = new JMenuItem("Level " + (i + 1));
			lLevel.addActionListener((ActionEvent ev) -> {
				JMenuItem obj = (JMenuItem)ev.getSource();
				int id = Integer.parseInt(obj.getText().split(" ")[1]);
				System.out.println(id);
				zGenerate.drawFahrzeuge(zSpielbrett.ladeLevel(id--));
				zGenerate.repaint();
			});
			zLevel[i] = lLevel;
			if (i <= 9) {
				zMNgradLeicht.add(zLevel[i]); //Hinzufuegen des levels
			} else if (i <= 19) {
				zMNgradMittel.add(zLevel[i]); //Hinzufuegen des levels
			} else if (i <= 29) {
				zMNgradSchwer.add(zLevel[i]); //Hinzufuegen des levels
			} else if (i <= 39) {
				zMNgradExtrem.add(zLevel[i]); //Hinzufuegen des levels
			}

		}
	}
    /**
     *
     */
    public void update(){} //ist die mouseClicked Methode
  
    private boolean stoesstZusammen(int pX, int pY, char pDir) {
        boolean lErfolg = true;
        int lPosX, lPosY;
        switch(pDir) {
        	
	        case 'o':
		        lPosX = pX;
		        lPosY = pY - 1;
		        break;
	        case 'r':
		        lPosX = pX + 1;
		        lPosY = pY;
		        break;
	        case 'u':
		        lPosX = pX;
		        lPosY = pY + 1;
		        break;
	        case 'l':
		        lPosX = pX - 1;
		        lPosY = pY;
		        break;
	        default:
	        	lPosX = 0;
	        	lPosY = 0;
        }
        for(Fahrzeug i : zFahrzeuge)
        	if((i.gibX1() == lPosX && i.gibY1() == lPosY) || (i.gibX2() == lPosX && i.gibY2() == lPosY))
        		lErfolg = false;
        	else if(i instanceof LKW) lErfolg = ((LKW)i).gibX3() != lPosX && ((LKW)i).gibY3() != lPosY;
        return lErfolg;
    }
    
	/**
	 *
	 * @param e MouseEvent Object
	 */
    public void mouseClicked(MouseEvent e)//wenn Maus geklickt wurde//Feldabfrage//e.getx/y
    {
    	int lPosX = findeFeld(e.getX());
	    int lPosY = findeFeld(e.getY());
    	if(! zSpielbrett.istBelegt(lPosX, lPosY)){
    	    for(Fahrzeug i: zFahrzeuge) {
		        if(i instanceof LKW) {
			        if(i.gibX1() == lPosX && i.gibY1() == lPosY){
			        	//zGenerate.clearFahrzeug(i);
			        	i.fahreVor();
			        	this.repaint();
			        	//zGenerate.maleFahrzeug(i);
			        }
			        else if(((LKW) i).gibX3() == lPosX && ((LKW) i).gibY3() == lPosY) i.fahreZurueck();
		        }
		        else if(i instanceof PKW) {
			        if(i.gibX1() == lPosX && i.gibY1() == lPosY) i.fahreVor();
			        else if(i.gibX2() == lPosX && i.gibY2() == lPosY){
				        i.fahreZurueck();
				        this.repaint();
			        }
		        }
	        }
        }
    }
        //zGenerate.repaint();
        //if(e.getx())
	private int findeFeld(int pPos) {
		if(pPos >= 75 && pPos <= 170) return 0;
		else if(pPos >= 186 && pPos <= 281) return 1;
		else if(pPos >= 297 && pPos <= 392) return 2;
		else if(pPos >= 408 && pPos <= 503) return 3;
		else if(pPos >= 519 && pPos <= 614) return 4;
		else if(pPos >= 630 && pPos <= 725) return 5;
		return 0;
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