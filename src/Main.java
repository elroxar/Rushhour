import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
*
*/
public class Main extends JFrame {
	/* Attribute */
  	private JLabel zZuege;
    private Draw zgenerate;
	
	/* Methoden */
 	public Main() {
		zZuege = new JLabel("Zug: ");
		setLocation(250,10);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		zgenerate = new Draw();
		cp.add(zgenerate);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200,800);
		setAlwaysOnTop(true);
		setVisible(true);
		setResizable(true);
		cp.add(zZuege);
		zZuege.setLocation(300,20);
  	}
  	public void update(){
 	 	//TODO: Implementieren
    }
}