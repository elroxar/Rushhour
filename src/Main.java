import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
public class Main extends JFrame 
{
   private Draw zgenerate;
  public Main()
  {
	setSize(1000,1000);
	setLocation(100,100);
	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	zgenerate = new Draw();
	cp.add(zgenerate);
	setVisible(true);
  }
}
