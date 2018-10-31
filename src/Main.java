import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Main extends JFrame 
{
	/* Attribute */
	private Draw zgenerate;
	
	/* Methoden */
    public Main()
    {
		setLocation(0,0);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		zgenerate = new Draw();
		cp.add(zgenerate);
		setUndecorated(true);
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(), (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		setAlwaysOnTop(true);
		setVisible(true);
    }
}
