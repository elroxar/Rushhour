import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
/**
 *
 */
public class Draw extends Canvas {
	/* Attribute */ int x, y;
	int Anfangsbreitex, Anfangsbreitey;
	
	/* Methoden */
	public Draw() {
		x = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		y = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		setSize(x, y);
		Anfangsbreitex = 66;
		Anfangsbreitey = 66;
	}
	@Override
	public void paint(Graphics arg) {
		//Vierecke 100,100 Platz zwischen feldern 16
		arg.setColor(Color.black);
		arg.drawRect(50, 50, 700, 700);
		//arg.drawRect(Anfangsbreitex, Anfangsbreitey, 100,100);
		for(int x = 0; x <= 6; x++)
			for(int y = 0; y <= 6; y++)
				arg.drawRect(Anfangsbreitex, Anfangsbreitey, 100 + (Anfangsbreitex + 16) * x, 100 + (Anfangsbreitey + 16) * y);
	}
}