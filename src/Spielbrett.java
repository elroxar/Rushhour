/**
 * @author theo,louis
 * @version 30/10/18
 */
public class Spielbrett {
    /* Attribute */
    private boolean[][] zSpielbrett;
    private int[][][] zSpielbrettKoord;
    private LevelVerwaltung zLV;
    
    /* Methoden *///
    Spielbrett(){
        zSpielbrett = new boolean[6][6];
        zSpielbrettKoord = new int [6][6][2];
        zLV = new LevelVerwaltung();
        fuelleSpielbrettKoord();
    }
    /**
     * //TODO: Dokumentieren
     */
    public void fuelleSpielbrettKoord() {
        int zMarginX = 175,zMarginY = 175;
        int zFeld = 96;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                //fensterrand zum ersten kasten 175
                    zSpielbrettKoord[i][j][0] = zMarginX;
                    zSpielbrettKoord[i][j][1] = zMarginY;
                    zMarginX += zFeld + 3;
                    //System.out.println(zSpielbrettKoord[i][j][0]);
                    //System.out.println(zSpielbrettKoord[i][j][1]);
            }
            zMarginY += zFeld + 3;
            //System.out.println(zMarginY);
        }
    }
	/**
	 * @param pLevel Arrayposition des zu ladenden Levels (Levelnummer - 1)
	 * @return liefert einen Array mit allen Fahrzeugen des angegebenen Levels
	 */
	public Fahrzeug[] ladeLevel(int pLevel){
		System.out.println("\nLevel: " + (pLevel + 1) + ", Index: " + pLevel); //DEBUG
        String[] lLevel = zLV.gibLevel(pLevel);
        Fahrzeug[] lFahrzeuge = new Fahrzeug[lLevel.length];
        for(int i = 0; i<lFahrzeuge.length; i++){
            int lX1, lY1, lX2, lY2, lX3, lY3;
            switch(lLevel[i].charAt(0)){
                case 'P':
                	//System.out.println("Dieses Objekt ist ein PKW."); //DEBUG
                    lX1 = Integer.parseInt("" + lLevel[i].charAt(2));
                    lY1 = Integer.parseInt("" + lLevel[i].charAt(3));
                    lX2 = Integer.parseInt("" + lLevel[i].charAt(5));
                    lY2 = Integer.parseInt(("" + lLevel[i].charAt(6)));
                    lFahrzeuge[i] = new PKW(lX1, lY1, lX2, lY2, false);
                    this.belegeFeld(lX1, lY1);
                    this.belegeFeld(lX2, lY2);
                    break;
                case 'L':

                	//System.out.println("Dieses Objekt ist ein LKW."); //DEBUG
	                lX1 = Integer.parseInt("" + lLevel[i].charAt(2));
	                lY1 = Integer.parseInt("" + lLevel[i].charAt(3));
	                lX2 = Integer.parseInt("" + lLevel[i].charAt(5));
	                lY2 = Integer.parseInt("" + lLevel[i].charAt(6));
                    lX3 = Integer.parseInt("" + lLevel[i].charAt(8));
                    lY3 = Integer.parseInt("" + lLevel[i].charAt(9));
                    lFahrzeuge[i] = new LKW(lX1, lY1, lX2, lY2, lX3, lY3);
                    this.belegeFeld(lX1, lY1);
                    this.belegeFeld(lX2, lY2);
                    this.belegeFeld(lX3, lY3);
                    break;
                default:
                	//System.out.println("Dieses Objekt ist ein rotes Auto."); //DEBUG
	                lX1 = Integer.parseInt("" + lLevel[i].charAt(0));
	                lY1 = Integer.parseInt("" + lLevel[i].charAt(1));
	                lX2 = Integer.parseInt("" + lLevel[i].charAt(3));
	                lY2 = Integer.parseInt("" + lLevel[i].charAt(4));
                    lFahrzeuge[i] = new PKW(lX1, lY1, lX2, lY2, true);
                    this.belegeFeld(lX1, lY1);
                    this.belegeFeld(lX2, lY2);
                    break;
            }
        }
        return lFahrzeuge;
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