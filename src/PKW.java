import java.awt.*;
import java.awt.Graphics;
/**
 * @author theo
 * @version 30/10/18
 */
public class PKW extends Fahrzeug {
    /* Attribute*/
    private boolean zIstRotesAuto;
    
    /* Methoden *///
    PKW(int pX1, int pY1, int pX2, int pY2, boolean pIstRotesAuto) {
        super(pX1, pY1, pX2, pY2);
        zIstRotesAuto = pIstRotesAuto;
        if(this.istRotesAuto())
        	super.zFarbe = Color.RED;
    }
    /**
     * @return liefert, ob das Auto das 'rote' Auto ist
     */
    public boolean istRotesAuto(){
        return this.zIstRotesAuto;
    }

}//Ende Klasse: PKW