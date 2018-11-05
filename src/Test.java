/**
 * @author ben, louis, theo
 * @version 05/11/2018
 */
public class Test {
	/* Attribute */
	
	/* Methoden */
    public static void main(String[] args) {
        //Main zSpiel = new Main();
        Spielbrett zBrett = new Spielbrett();
        int lLevel = 1;
        do{
	        Fahrzeug[] zFahrzeuge = zBrett.ladeLevel(lLevel -1);
	        lLevel++;
        }while(lLevel <= 4);
    }
}