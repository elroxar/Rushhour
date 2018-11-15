import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Write a description of class Einstellungen here.
 *
 * @author ben
 * @version (a version number or a date)
 */
public class Startbutton extends Canvas implements MouseListener
{
    private Image zImage;
    private int y,x;
    private Graphics arg;
    private Main zStart;
    public Startbutton(Image pImage,int px,int py)
    {
        zImage = pImage;
        x = px;
        y = py;
        addMouseListener(this);
    }
    public void paint(Graphics arg)
    {
        arg.drawImage(zImage,x,y,70,70,this);
    }
    public void mouseClicked(MouseEvent e)//wenn Maus geklickt wurde
    {
        zStart = new Main();
    }

    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e) {setBackground(Color.yellow);}
    public void mouseExited(MouseEvent e) {setBackground(null);}
}
