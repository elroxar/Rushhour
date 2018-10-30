/**
 * @author theo
 * @version 30/10/18
 */
public class Spielbrett
{
    /* Attribute */
    private boolean[][] zSpielbrett;
    private Fahrzeug[] zFahrzeuge;
    private LevelVerwaltung zLV;
    
    /* Methoden */
    Spielbrett(){
        zSpielbrett = new boolean[6][6];
        zLV = new LevelVerwaltung();
    }
    /**
     * @param pLevel Nummer des zu Ladenden Levels
     */
    private void ladeLevel(int pLevel){
        String[] lLevel = zLV.gibLevel(pLevel);
        zFahrzeuge = new Fahrzeug[lLevel.length];
        for(int i = 0; i<zFahrzeuge.length; i++){
            int lX1, lY1, lX2, lY2, lX3, lY3;
            switch(lLevel[i].charAt(0)){
                case 'P':
                    lX1 = lLevel[i].charAt(2);
                    lY1 = lLevel[i].charAt(4);
                    lX2 = lLevel[i].charAt(6);
                    lY2 = lLevel[i].charAt(8);
                    zFahrzeuge[i] = new PKW(lX1, lY1, lX2, lY2, false);
                    this.belegeFeld(lX1, lY1);
                    this.belegeFeld(lX2, lY2);
                    break;
                case 'L':
                    lX1 = lLevel[i].charAt(2);
                    lY1 = lLevel[i].charAt(4);
                    lX2 = lLevel[i].charAt(6);
                    lY2 = lLevel[i].charAt(8);
                    lX3 = lLevel[i].charAt(10);
                    lY3 = lLevel[i].charAt(12);
                    zFahrzeuge[i] = new LKW(lX1, lY1, lX2, lY2, lX3, lY3);
                    this.belegeFeld(lX1, lY1);
                    this.belegeFeld(lX2, lY2);
                    this.belegeFeld(lX3, lY3);
                    break;
                default:
					lX1 = lLevel[i].charAt(0);
                    lY1 = lLevel[i].charAt(2);
                    lX2 = lLevel[i].charAt(4);
                    lY2 = lLevel[i].charAt(6);
                    zFahrzeuge[i] = new PKW(lX1, lY1, lX2, lY2, true);
                    this.belegeFeld(lX1, lY1);
                    this.belegeFeld(lX2, lY2);
                    break;
            }
        }
    }
    /**
	 * @param pX x-Koordinate des zu belegenden Feldes
	 * @param pY y-Koordinate des zu belegenden Feldes
	 */
	private void belegeFeld(int pX, int pY){
        zSpielbrett[pX][pY] = true;
    }
    /**
     * @param pX x-Koordinate des zu ueberpruefenden Feldes
     * @param pY y-Koordinate des zu ueberpruefenden Feldes
     * @return liefert Belegung
     */
    public boolean istBelegt(int pX, int pY){
        return zSpielbrett[pX][pY];
    }
}//Ende Klasse: Spielbrett

