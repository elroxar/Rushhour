/**
 * @author tom, theo
 * @version 30/10/18
 */
public class PKW extends Fahrzeug{
	/* Attribute*/
	private boolean zIstRotesAuto;
	
	/* Methoden *///
	PKW(int pX1, int pY1, int pX2, int pY2, boolean pIstRotesAuto){
		super(pX1, pY1, pX2, pY2);
		zIstRotesAuto = pIstRotesAuto;
		if(this.istRotesAuto()) super.zFarbe = 0;
	}
	
	/**
	 * @return liefert, ob das Auto das 'rote' Auto ist
	 */
	public boolean istRotesAuto(){
		return this.zIstRotesAuto;
	}
	
	public char wasBinIch(){
		return 'P';
	}
	
	public boolean fahreZurueckPKW(){
		boolean lErfolg = true;
		//Fahrzeug steht mit der Nase nach Unten
		if(this.istVertikal() && zY1 > zY2){
			if(zY1 < 5){
				zY1++;
				zY2++;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Oben
		else if(this.istVertikal() && zY2 > zY1){
			if(zY1 > 0){
				zY1--;
				zY2--;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Rechts
		else if(! this.istVertikal() && zX1 > zX2){
			if(zX1 < 5){
				zX1++;
				zX2++;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Links
		else if(! this.istVertikal() && zX2 > zX1){
			if(zX1 > 0){
				zX1--;
				zX2--;
			}
			else lErfolg = false;
		}
		return lErfolg;
	}
	
	public boolean fahreVorPKW(){
		
		boolean lErfolg = true;
		//Fahrzeug steht mit der Nase nach Unten
		if(this.istVertikal() && zY1 > zY2){
			if(zY1 < 5){
				zY1--;
				zY2--;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Oben
		else if(this.istVertikal() && zY2 > zY1){
			if(zY1 > 0){
				zY1++;
				zY2++;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Rechts
		else if(! this.istVertikal() && zX1 > zX2){
			if(zX1 < 5){
				zX1--;
				zX2--;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Links
		else if(! this.istVertikal() && zX2 > zX1){
			if(zX1 > 0){
				zX1++;
				zX2++;
			}
			else lErfolg = false;
		}
		return lErfolg;
		
	}
}//Ende Klasse: PKW