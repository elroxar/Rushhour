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
        zLevel = new String[4][]; //TODO: Zurück auf 40 ändern nach Vervollständigung aller Level
    }
	/**
	 * @return liefert Die Rohdaten aller Level in einem 2Dimensionalem Array
	 */
	private String[][] liesLevelEin(){
		String[][] lLevel = new String[4][];
        try {
            fr = new FileReader("data/level.csv");
            br = new BufferedReader(fr);
            int i = 0;
            while(br.ready()){
                String lLine = br.readLine();
	            int lFahrzeugAnzahl;
	            if(lLine.charAt(1) == ';') {
		            lFahrzeugAnzahl = Integer.parseInt("" + lLine.charAt(0)); //Liest anzahl der Fahrzeuge in diesem Level
		            //System.out.println("In Level " + (i+1) + " existieren " + lFahrzeugAnzahl + " Fahrzeuge."); //DEBUG
		            lLine = lLine.substring(2); //Fahrzeugeanzahl wird aus String entfernt
	            }
	            else {
		            lFahrzeugAnzahl = Integer.parseInt(lLine.substring(0, 2)); //Liest Anzahl der Fahrzeuge in diesem Level
		            //System.out.println("In Level " + (i+1) + " existieren " + lFahrzeugAnzahl + " Fahrzeuge."); //DEBUG
		            lLine = lLine.substring(3); //Fahrzeuganzahl wird aus String entfernt
	            }
                lLevel[i] = new String[lFahrzeugAnzahl];
                lLevel[i] = lLine.split(";");
                i++;
            }
        br.close();
        }catch(Exception e){System.out.println("Fehler beim Einlesen der Datei");}
		return lLevel;
    }
	/**
	 * @param pLevel Arrayposition des zu ladenden Levels (Levelnummer - 1)
	 * @return liefert die Rohdaten zum angegebenen Level (Position im Array)
	 */
	public String[] gibLevel(int pLevel){
		return this.liesLevelEin()[pLevel--];
    }
}//Ende Klasse: LevelVerwaltung