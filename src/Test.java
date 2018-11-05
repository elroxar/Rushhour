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
	        //DEBUG
	        /*
	        for(Fahrzeug i : zFahrzeuge){
	        	if(i instanceof PKW)
	        	    System.out.println("PKW: " + i.gibFarbe() + ',' + i.gibX1() + ',' + i.gibY1() + ',' + i.gibX2() + ',' + i.gibY2());
	        	else
	        		System.out.println("LKW: " + i.gibFarbe() + ',' + i.gibX1() + ',' + i.gibY1() + ',' + i.gibX2() + ',' + i.gibY2() + ',' + ((LKW)i).gibX3() + ',' + ((LKW) i).gibY3());
	        }
	        */
	        lLevel++;
        }while(lLevel <= 4);
    }
}