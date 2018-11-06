import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
//autor Louis,Ben
public class Draw extends Canvas {
	private Fahrzeug[] zFahrzeuge;
	final int breite = 95;
	private Spielbrett zSpielbrett;
	
	public Draw() {
		setSize(800, 800);
		zSpielbrett = new Spielbrett();
		//zFahrzeuge = zSpielbrett.ladeLevel();
	}
	
	@Override
	public void paint(Graphics arg) {
		// Vierecke 95,95 Platz zwischen feldern 16///
		setBackground(Color.red);
		setLocation((getParent().getWidth() / 2) - (getWidth() / 2), (getParent().getHeight() / 2) - (getHeight() / 2));//getParent() = uebergeordneter Container
		arg.fillRect(0, 0, getWidth(), getHeight());
		arg.setColor(Color.white);
		arg.drawRect(50, 50, 700, 700);
		
		for(int x = 0; x < 6; x++)
			for(int y = 0; y < 6; y++)
				arg.drawRect(75 + (breite + 16) * x, 75 + (breite + 16) * y, breite, breite);
		arg.clearRect(749, 297, 3, 96);
		//drawFahrzeuge(Graphics arg1);
	}
	
	//generiere Fahrzeuge ABER noch ohne verschiebeMethode
	public void drawFahrzeuge(Graphics arg1, Fahrzeug[] pFahrzeuge) {
		for(int i = 0; i < pFahrzeuge.length; i++) {
			if(pFahrzeuge[i].istVertikal())//vertikal?
			{
				zeichne(arg1, i, breite, breite + 16);
			}
			else {
				zeichne(arg1, i, breite + 16, breite);
			}
		}
	}
	
	private void zeichne(Graphics arg1, int i, int breite, int i2) {
		if(zFahrzeuge[i] instanceof PKW)//PKW?
		{
			arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), breite, i2);
			arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2() - 16, breite, breite);
			
		}
		else {
			arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), breite, i2);
			arg1.fillRect(75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), breite, breite);
			arg1.fillRect(75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3() - 16, breite, breite);
		}
	}
}