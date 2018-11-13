import javax.swing.*;
import java.awt.Event;
import java.awt.*;
/**
 * Write a description of class Einstellungen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestklasseButtons extends Canvas
{
    Canvas zCanvas = new Canvas();
    public TestklasseButtons()
    {
        setSize(70,70);
        setVisible(true);
    }
    public void paint(Image pBild,int px,int py)
    {
        Graphics arg = zCanvas.getGraphics();
        arg.drawImage(pBild,px,py,70,70,this);

    }
}
