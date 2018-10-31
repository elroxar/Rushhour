import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
public class Main extends JFrame 
{
	/* Attribute */
   private Draw zGenerate;
   
   /* Methoden */
  public Main()
  {
	setSize(1000,1000);
	setLocation(100,100);
	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	zGenerate = new Draw();
	cp.add(zGenerate);
	setVisible(true);
  }
}//Ende Klasse: Main