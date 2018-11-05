import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * @author ben
 * @version 05/11/2018
 */
public class StartFenster extends JFrame implements ActionListener
{
    private JButton zStart,zEinstellungen;
    private JLabel zTitel;
    public StartFenster()
    {
        Container cp = getContentPane();
        cp.setLayout(null);
        setLocation(100,100);
        zTitel = new JLabel("Welcome to Rushhour");
        zTitel.setSize(100,400);
        zTitel.setLocation(550,200);
        cp.add(zTitel);
        setSize(1200,800);
        zStart = new JButton("Start");
        zStart.setSize(70,70);
        zStart.setLocation(450,400);
        zStart.addActionListener(this);
        cp.add(zStart);
        zEinstellungen = new JButton("Einstellungen");
        zEinstellungen.setSize(70,70);
        zEinstellungen.setLocation(650,400);
        zEinstellungen.addActionListener(this);
        cp.add(zEinstellungen);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent arg)
    {
        if(arg.getSource().equals(zStart))new Main();
        else if(arg.getSource().equals(zEinstellungen))System.exit(0);

    }

}