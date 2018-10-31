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
        zLevel = new String[40][];
    }
    private void liesLevelEin(){
        try {
            fr = new FileReader("data/level.csv");
            br = new BufferedReader(fr);
            int i = 1;
            while(br.ready()) {
                String lLine = br.readLine();
                int lFahrzeugAnzahl = lLine.charAt(0);
                lLine = lLine.substring(1);
                zLevel[i-1] = lLine.split(";");
            }
        }catch(Exception e){System.out.println("Fehler beim Einlesen der Datei");}
    }
    public String[] gibLevel(int pLevel){
        return this.zLevel[pLevel];
    }
}//Ende Klasse: LevelVerwaltung
