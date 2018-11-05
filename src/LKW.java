/**
 * @author theo
 * @version 30/10/18
 */
public class LKW extends Fahrzeug {
    /* Attribute */
    private int zX3, zY3;
    
    /* Methoden */
    LKW(int pX1, int pY1, int pX2, int pY2, int pX3, int pY3) {
        super(pX1, pY1, pX2, pY2);
        zX3 = pX3;
        zY3 = pY3;
    }
	/**
	 * @return liefert X3
	 */
	public int gibX3(){
        return this.zX3;
    }
	/**
	 * @return liefert Y3
	 */
	public int gibY3(){
        return this.zY3;
    }
}//Ende Klasse: LKW