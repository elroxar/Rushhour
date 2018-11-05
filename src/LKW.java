/**
 * @author theo
 * @version 30/10/18
 */
public class LKW extends Fahrzeug {
    /* Attribute */
    private int zX3, zY3;
    
    /* Methoden *///
    LKW(int pX1, int pY1, int pX2, int pY2, int pX3, int pY3) {
        super(pX1, pY1, pX2, pY2);
        if(pX3 >= 0 && pX3 <= 5)
            zX3 = pX3;
        else
	        System.out.println("Dieses Auto passt nicht auf das Brett.");
        if(pY3 >= 0 && pY3 <= 5)
            zY3 = pY3;
        else
	        System.out.println("Dieses Auto passt nicht auf das Brett.");
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