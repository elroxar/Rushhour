import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Write a description of class Settingsbutton here.
 *
 * @author Ben
 * @version (a version number or a date)
 */
public class Settingsbutton extends Canvas implements MouseListener
{
    private Image zImage;
    private int x,y;
    private Settings zSettings;
    public Settingsbutton(Image pImage,int px,int py)
    {
        zImage = pImage;
        int x = px;
        int y = py;
        addMouseListener(this);
    }
    public void paint(Graphics arg)
    {
        arg.drawImage(zImage,x,y,70,70,this);
    }
    public void mouseClicked(MouseEvent e)//wenn Maus geklickt wurde
    {
        zSettings = new Settings();
    }

    public void mousePressed(MouseEvent e)//wenn Maustaste runtergedrückt wurde
    {
        zSettings = new Settings();
    }
    public void mouseReleased(MouseEvent e)//wenn Taste wieder losgelassen wurde
    {

    }

    public void mouseEntered(MouseEvent e)//Maus in der Komponente
    {
        setBackground(Color.yellow);

    }
    public void mouseExited(MouseEvent e)//Maus aus Komponente verschwunden
    {
        setBackground(null);
    }
}