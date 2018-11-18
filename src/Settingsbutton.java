import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Write a description of class Einstellungen here.
 *
 * @author Ben
 * @version (a version number or a date)
 */
public class Settingsbutton implements MouseListener{
	private Image zImage;
	private int y, x;
	private Settings zStart;
	private Component comp;
	
	public Settingsbutton(Image pImage, int px, int py, Component comp){
		zImage = pImage;
		x = px;
		y = py;
		this.comp = comp;
		comp.addMouseListener(this);
		
	}
	
	public void paint(Graphics arg){
		Graphics2D gr2d = (Graphics2D)arg;
		//        gr2d.setBackground(new Color(0,0,0,0));
		//        gr2d.clearRect(x,y,70,70);
		
		Point p = comp.getMousePosition(); //Mouslocation on Window
		if(p != null){
			if(p.getX() >= x && p.getX() <= x + 70 && p.getY() >= y && p.getY() <= y + 70){
				gr2d.setColor(Color.YELLOW);
				gr2d.fillRect(x, y, 70, 70);
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
				zStart = new Settings();
			}
		}
	}
	
	public void mouseReleased(MouseEvent e){}
	
	public void mouseEntered(MouseEvent e){}
	
	public void mouseExited(MouseEvent e){}
}
