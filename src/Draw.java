import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
//autor Louis,Ben
public class Draw extends Canvas {
	private Canvas zCanvas = new Canvas();
	private Fahrzeug[] zFahrzeuge;
	final int breite = 95;
	private Spielbrett zSpielbrett = new Spielbrett();
	private Graphics arg1;
	public Draw() {
		setSize(800, 800);
		//zFahrzeuge = zSpielbrett.ladeLevel();
		//drawFahrzeuge(zFahrzeuge);
	}

	//public void zeichneAufSpielbrett (int pLevelNummer) {
	    //drawFahrzeuge(zSpielbrett.ladeLevel(pLevelNummer - 1));
    //}
	
	@Override
	public void paint(Graphics arg) {
		arg1 = arg;
		// Vierecke 95,95 Platz zwischen feldern 16///
		//setLocation((getParent().getWidth() / 2) - (getWidth() / 2), (getParent().getHeight() / 2) - (getHeight() / 2));//getParent() = uebergeordneter Container



		
		for(int x = 0; x < 6; x++)
			for(int y = 0; y < 6; y++)
				arg.drawRect(75 + (breite + 16) * x, 75 + (breite + 16) * y, breite, breite);
		arg.clearRect(749, 297, 3, 96);
		//drawFahrzeuge(pFahrzeuge);

		for(int i = 0; i < zFahrzeuge.length; i++) {
			if(zFahrzeuge[i].istVertikal())//vertikal?
			{
				//zeichne( i, breite, breite + 16);
				if(zFahrzeuge[i] instanceof PKW)
				//PKW?
				{
					arg1.setColor(zFahrzeuge[i].gibFarbe());
					if (zFahrzeuge[i].gibX1() < zFahrzeuge[i].gibX2()){
						arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), breite, 2*breite+16);
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), breite, 2*breite+16);
					}
					else {
						arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), breite, 2*breite+16);
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), breite, 2*breite+16);
					}
				}
				else if(zFahrzeuge[i] instanceof LKW){
					arg1.setColor(zFahrzeuge[i].gibFarbe());
					if (zFahrzeuge[i].gibX1() < zFahrzeuge[i].gibX2()){
						arg1.fillRect(75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), breite,3*breite+32);
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), breite,3*breite+32);
					}
					else {
						arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), breite, 3*breite+32);
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), breite, 3*breite+32);
					}
				}
			}
			else {
				//zeichne( i, breite + 16, breite);
				if(zFahrzeuge[i] instanceof PKW)
				//PKW?
				{
					arg1.setColor(zFahrzeuge[i].gibFarbe());
					if (zFahrzeuge[i].gibX1() < zFahrzeuge[i].gibX2()){
						arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 2*breite+16, breite);
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 2*breite+16, breite);
					}
					else {
						arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), 2*breite+16, breite);
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), 2*breite+16, breite);
					}
				}
				else if(zFahrzeuge[i] instanceof LKW){
					arg1.setColor(zFahrzeuge[i].gibFarbe());
					if (zFahrzeuge[i].gibX1() < ((LKW)zFahrzeuge[i]).gibX3()){
						arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 3*breite+32, breite);
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 3*breite+32, breite);
					}
					else {
						arg1.fillRect(75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), 3*breite+32, breite);
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), 3*breite+32, breite);
					}

				}
			}
		}
	}

	//generiere Fahrzeuge ABER noch ohne verschiebeMethode
	public void drawFahrzeuge(Fahrzeug[] pFahrzeuge) {
		zFahrzeuge = pFahrzeuge;
	}
	
	private void zeichne( int i, int breite, int i2) {
	}
}