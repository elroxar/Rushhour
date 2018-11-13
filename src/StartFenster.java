import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
/**
 * @author ben
 * @version 05/11/2018
 */
public class StartFenster extends JFrame implements MouseListener
{

    private JLabel zTitel;
    private Button zStart,zEinstellungen;
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
        zStart = new Button();
        zStart.setSize(70,70);
        zStart.paint(Toolkit.getDefaultToolkit().getImage("data/rot.png"),450,400);

        cp.add(zStart);
        zEinstellungen = new Button();
        zEinstellungen.paint(Toolkit.getDefaultToolkit().getImage("rot"),650,400);

        cp.add(zEinstellungen);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent arg)
    {
        if(arg.getSource().equals(zStart))new Main();
        //else if(arg.getSource().equals(zEinstellungen))new Einstellungen();

    }
    public void mouseClicked(MouseEvent e)//wenn Maus geklickt wurde//Feldabfrage//e.getx/y
    {
        //zGenerate.repaint();
        //if(e.getx())
    }
    /**
     *
     * @param e MouseEvent Object
     */
    public void mousePressed(MouseEvent e)//wenn Maustaste runtergedrückt wurde
    {
    }
    /**
     *
     * @param e MouseEvent Object
     */
    public void mouseReleased(MouseEvent e)//wenn Taste wieder losgelassen wurde
    {
    }
    /**
     *
     * @param e MouseEvent Object
     */
    public void mouseEntered(MouseEvent e)//Maus in der Komponente
    {
    }
    /**
     *
     * @param e MouseEvent Object
     */
    public void mouseExited(MouseEvent e)//Maus aus Komponente verschwunden
    {
    }
