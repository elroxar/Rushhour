import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @author theo
 * @version 30/10/18
 */
public class Fahrzeug {
    /* Attribute */
    private int zX1, zY1, zX2, zY2;
    Color zFarbe;
    
    /* Methoden */
    Fahrzeug(int pX1, int pY1, int pX2, int pY2){
		if(pX1 >=0 && pX1 <= 5)
            zX1 = pX1;
		else
			System.out.println("Dieses Auto passt nicht auf das Brett.");
		if(pY1 >=0 && pY1 <= 5)
            zY1 = pY1;
		else
			System.out.println("Dieses Auto passt nicht auf das Brett.");
	    if(pX2 >=0 && pX2 <= 5)
            zX2 = pX2;
	    else
		    System.out.println("Dieses Auto passt nicht auf das Brett.");
	    if(pY2 >=0 && pY2 <= 5)
            zY2 = pY2;
	    else
		    System.out.println("Dieses Auto passt nicht auf das Brett.");
        this.setzeFarbe();
    }
	/**
	 * Zufälliges setzen der Farbe
	 */
	private void setzeFarbe()
    {
        int lRandom = ThreadLocalRandom.current().nextInt(0, 6);
        //System.out.println("Random Number: " + lRandom); //DEBUG
        switch(lRandom)
        {
            case 0: zFarbe = Color.CYAN;
            break;
            case 1: zFarbe = Color.GREEN;
            break;
            case 2: zFarbe = Color.MAGENTA;
            break;
            case 3: zFarbe = Color.ORANGE;
            break;
            case 4: zFarbe = Color.YELLOW;
            break;
            case 5: zFarbe = Color.BLUE;
            break;
            //default: zFarbe = Color.RED;
            //break;
        }
    }
    /**
     * @return liefert Ausrichtung
     */
    private boolean istVertikal(){
	    return zX1 == zX2;
    }
    /**
     * @return liefert X1
     */
    public Integer gibX1(){
        return this.zX1;
    }
    /**
     * @return liefert X2
     */
    public int gibX2(){
        return this.zX2;
    }
    /**
     * @return liefert Y1
     */
    public int gibY1(){
        return this.zY1;
    }
    /**
     * @return liefert Y2
     */
    public int gibY2(){
        return this.zY2;
    }
    /**
     * @return liefert Farbe des Fahrzeugs
     */
    public Color gibFarbe(){
        return this.zFarbe;
    }
    /**
     * @return gibt Erfolg zurueck
     */
    public boolean fahreVor(){
        boolean lErfolg = true;
        //Fahrzeug steht mit der Nase nach Unten
        if(this.istVertikal() && zY1 > zY2){
            if(zY1 < 5) {
                zY1--;
                zY2--;
            }
            else
                lErfolg = false;
        }
        //Fahrzeug steht mit der Nase nach Oben
        else if(this.istVertikal() && zY2 > zY1){
            if(zY1 > 0) {
                zY1++;
                zY2++;
            }
            else
                lErfolg = false;
        }
        //Fahrzeug steht mit der Nase nach Rechts
        else if(!this.istVertikal() && zX1 > zX2) {
            if(zX1 < 5) {
                zX1--;
                zX2--;
            }
            else
                lErfolg = false;
        }
        //Fahrzeug steht mit der Nase nach Links
        else if(!this.istVertikal() && zX2 > zX1){
            if(zX1 > 0) {
                zX1++;
                zX2++;
            }
            else
                lErfolg = false;
        }
        return lErfolg;
    }
    /**
     * @return gibt Erfolg zurück
     */
    public boolean fahreZurueck(){
        boolean lErfolg = true;
        //Fahrzeug steht mit der Nase nach Unten
        if(this.istVertikal() && zY1 > zY2){
            if(zY1 < 5) {
                zY1++;
                zY2++;
            }
            else
                lErfolg = false;
        }
        //Fahrzeug steht mit der Nase nach Oben
        else if(this.istVertikal() && zY2 > zY1){
            if(zY1 > 0) {
                zY1--;
                zY2--;
            }
            else
                lErfolg = false;
        }
        //Fahrzeug steht mit der Nase nach Rechts
        else if(!this.istVertikal() && zX1 > zX2) {
            if(zX1 < 5) {
                zX1++;
                zX2++;
            }
            else
                lErfolg = false;
        }
        //Fahrzeug steht mit der Nase nach Links
        else if(!this.istVertikal() && zX2 > zX1){
            if(zX1 > 0) {
                zX1--;
                zX2--;
            }
            else
                lErfolg = false;
        }
        return lErfolg;
    }
}//Ende Klasse: Fahrzeug