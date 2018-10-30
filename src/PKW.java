/**
 * @author theo
 * @version 30/10/18
 */
public class PKW extends Fahrzeug {
    
    /* Attribute*/
    private boolean zIstRotesAuto;
    
    PKW(int pX1, int pY1, int pX2, int pY2, boolean pIstRotesAuto) {
        super(pX1, pY1, pX2, pY2);
        zIstRotesAuto = pIstRotesAuto;
    }
    public boolean istRotesAuto(){
        return this.zIstRotesAuto;
    }
}//Ende Klasse: PKW