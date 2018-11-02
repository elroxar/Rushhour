import java.io.BufferedReader;
import java.io.FileReader;
/**
 * @author theo
 * @version 30/10/18
 */
public class LevelVerwaltung {
	
    /* Attribute */
    private String[][] zLevel;
    private FileReader fr;
    private BufferedReader br;
    
    /* Methoden */
    LevelVerwaltung(){
        zLevel = new String[4][]; //TODO: Zurück auf 40 ändern
    }
	/**
	 *
	 */
	private String[][] liesLevelEin(){
		String[][] lLevel = new String[4][];
        try {
            fr = new FileReader("data/level.csv");
            br = new BufferedReader(fr);
            int i = 0;
            while(br.ready()){
                String lLine = br.readLine();
                int lFahrzeugAnzahl = Integer.parseInt("" + lLine.charAt(0));
                lLine = lLine.substring(2);
                lLevel[i] = new String[lFahrzeugAnzahl];
                lLevel[i] = lLine.split(";");
                i++;
            }
        }catch(Exception e){System.out.println("Fehler beim Einlesen der Datei");}
		return lLevel;
    }
	/**
	 * @param pLevel
	 * @return liefert die Rohdaten zum angegebenen Level (Position im Array)
	 */
	public String[] gibLevel(int pLevel){
        //zLevel = this.liesLevelEin();
    	//return this.zLevel[pLevel];
		return this.liesLevelEin()[pLevel];
    }
}//Ende Klasse: LevelVerwaltung