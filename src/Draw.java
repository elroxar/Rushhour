import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
/**
 * @author ben
 * @version 30/10/18
 */
public class Draw extends Canvas
{
   public Draw()
   {
  	 setSize(900,900);
  	 setBackground(Color.black);
   }
	/**
	 *
	 * @param arg
	 */
	public void paint(Graphics arg)
   {
	  //Vierecke 100,100 Platz zwischen feldern 42
	  arg.setColor(Color.blue);
	  arg.drawLine(50,50,50,850);//oben nach unten links
	  arg.drawLine(50,50,850,50);//links nach rechts oben
	  arg.drawLine(850,50,850,334);//oben nach unten rechts 1
	  arg.drawLine(850,518,850,850);//oben nach unten rechts 2
	  arg.drawLine(50,850,850,850);//links nach rechts unten 
	  //System.out.println("baaaaaggggg");
   }
}//Ende Klasse: Draw