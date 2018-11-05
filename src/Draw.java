import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
/**
 * @author ben, louis
 * @version 05/11/2018
 */
public class Draw extends Canvas {
	/* Attribute */
	final int breite = 95;

	/* Methoden */
	public Draw()
	{

		setSize(800,800);

	}
	/**
	 * @param arg Graphics Object
	 */
	@Override
	public void paint(Graphics arg) {
		// Vierecke 95,95 Platz zwischen feldern 16///
		arg.setColor(Color.black);
		arg.drawRect(50, 50, 700, 700);

		for (int x = 0; x < 6; x++)
			for (int y = 0; y < 6; y++)
				arg.drawRect(75 + (breite + 16) * x, 75 + (breite + 16) * y, breite, breite);
		        arg.clearRect(749, 297, 3, 96);

	}
}
