/**
 * @author tom, theo
 * @version 30/10/18
 */
public class LKW extends Fahrzeug{
	/* Attribute */
	private int zX3, zY3;
	
	/* Methoden *///
	LKW(int pX1, int pY1, int pX2, int pY2, int pX3, int pY3){
		super(pX1, pY1, pX2, pY2);
		if(pX3 >= 0 && pX3 <= 5) zX3 = pX3;
		else System.out.println("Dieses Auto passt nicht auf das Brett.");
		if(pY3 >= 0 && pY3 <= 5) zY3 = pY3;
		else System.out.println("Dieses Auto passt nicht auf das Brett.");
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
	
	public char wasBinIch(){
		return 'L';
	}
	
	public boolean fahreZurueckLKW(){
		boolean lErfolg = true;
		//Fahrzeug steht mit der Nase nach Unten
		if(this.istVertikal() && zY1 > zY3){
			if(zY1 < 5){
				zY1++;
				zY3++;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Oben
		else if(this.istVertikal() && zY3 > zY1){
			if(zY1 > 0){
				zY1--;
				zY3--;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Rechts
		else if(! this.istVertikal() && zX1 > zX3){
			if(zX1 < 5){
				zX1++;
				zX3++;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Links
		else if(! this.istVertikal() && zX3 > zX1){
			if(zX1 > 0){
				zX1--;
				zX3--;
			}
			else lErfolg = false;
		}
		return lErfolg;
	}
	
	public boolean fahreVorLKW(){
		boolean lErfolg = true;
		//Fahrzeug steht mit der Nase nach Unten
		if(this.istVertikal() && zY1 > zY3){
			if(zY1 < 5){
				zY1--;
				zY3--;
			}
			else lErfolg = false;
		}
		//Fahrzeug steht mit der Nase nach Oben
		else if(this.istVertikal() && zY3 > zY1){
			if(zY1 > 0){
				zY1++;
				zY3++;
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
}//Ende Klasse: LKW