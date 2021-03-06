import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Write a description of class Einstellungen here.
 *
 * @author Ben
 * @version (a version number or a date)
 */
public class Startbutton implements MouseListener{
	private Image zImage;
	private int y, x;
	private Main zStart;
	private Component comp;
	
	public Startbutton(Image pImage, int px, int py, Component comp){
		zImage = pImage;
		x = px;
		y = py;
		this.comp = comp;
		comp.addMouseListener(this);
		
	}
	
	public void paint(Graphics arg){
		Graphics2D gr2d = (Graphics2D)arg;
		Point p = comp.getMousePosition(); //Mouslocation on Window
		if(p != null){
			if(p.getX() >= x && p.getX() <= x + 70 && p.getY() >= y && p.getY() <= y + 70){
				gr2d.setColor(Color.blue);
				gr2d.fillOval(x, y, 70, 70);//gelber Hintergrund hinter dem Button
			}
		}
		gr2d.setColor(Color.BLACK);
		gr2d.drawImage(zImage, x, y, 70, 70, comp);
	}
	
	public void mouseClicked(MouseEvent e){} //wenn Maus geklickt wurde
	
	public void mousePressed(MouseEvent e){
		Point p = comp.getMousePosition(); //Mouslocation on Window
		if(p != null){
			if(p.getX() >= x && p.getX() <= x + 70 && p.getY() >= y && p.getY() <= y + 70){
				zStart = new Main();
				if(comp instanceof JFrame){
					((JFrame)comp).dispose();
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
}
