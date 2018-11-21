import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

//autor Louis,Ben
public class Draw extends Canvas implements MouseListener{
	final int breite = 95;
	Toolkit Tk = Toolkit.getDefaultToolkit();
	Image zBild;
	private Canvas zCanvas = new Canvas();
	private Fahrzeug[] zFahrzeuge;
	private Spielbrett zSpielbrett = new Spielbrett();
	private Graphics2D arg1;
	
	public Draw(){
		setSize(800, 800);
		zFahrzeuge = new Fahrzeug[0];
		setBackground(Color.gray);
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics arg){
		BufferedImage Buff = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
		arg.setColor(Color.white);
		arg1 = Buff.createGraphics();
		
		// Vierecke 95,95 Platz zwischen feldern 16///
		//setLocation((getParent().getWidth() / 2) - (getWidth() / 2), (getParent().getHeight() / 2) - (getHeight() / 2));//getParent() = uebergeordneter Container
		
		
		for(int x = 0; x < 6; x++)
			for(int y = 0; y < 6; y++)
				arg.drawRect(75 + (breite + 16) * x, 75 + (breite + 16) * y, breite, breite);
		arg.clearRect(749, 297, 3, 96);
		//drawFahrzeuge(pFahrzeuge);
		
		for(int i = 0; i < zFahrzeuge.length; i++){
			if(zFahrzeuge[i].istVertikal())//vertikal?
			{
				//zeichne( i, breite, breite + 16);
				if(zFahrzeuge[i] instanceof PKW)
				//PKW?
				{
					if(zFahrzeuge[i].gibY1() < zFahrzeuge[i].gibY2()){
						zBild = Tk.getImage("data/cars/PKW/90/car" + zFahrzeuge[i].gibFarbe() + ".png");
						arg1.drawImage(zBild, 75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), breite, 2 * breite + 16, this);//x0,y0,Breite,Hoehe
					}
					else{
						zBild = Tk.getImage("data/cars/PKW/90/car" + zFahrzeuge[i].gibFarbe() + ".png");
						arg1.drawImage(zBild, 75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), breite, 2 * breite + 16, this);//x0,y0,Breite,Hoehe
					}
				}
				else if(zFahrzeuge[i] instanceof LKW){
					if(zFahrzeuge[i].gibY1() < zFahrzeuge[i].gibY2()){
						zBild = Tk.getImage("data/cars/LKW/90/car1.png");
						arg1.drawImage(zBild, 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX1(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY1(), breite, 3 * breite + 32, this);//x0,y0,Breite,Hoehe
					}
					else{
						zBild = Tk.getImage("data/cars/LKW/90/car1.png");
						arg1.drawImage(zBild, 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), breite, 3 * breite + 32, this);//x0,y0,Breite,Hoehe
					}
				}
			}
			else{
				//zeichne( i, breite + 16, breite);
				if(zFahrzeuge[i] instanceof PKW)
				//PKW?
				{
					if(((PKW)zFahrzeuge[i]).istRotesAuto()){
						Image redCar = Tk.getImage("data/cars/PKW/redCar.png");
						if(zFahrzeuge[i].gibX1() < zFahrzeuge[i].gibX2()){
							arg1.drawImage(redCar, 75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 2 * breite + 16, breite, this);//x0,y0,Breite,Hoehe
						}
						else{
							arg1.drawImage(redCar, 75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), 2 * breite + 16, breite, this);//x0,y0,Breite,Hoehe
						}
						
					}
					else{
						
						if(zFahrzeuge[i].gibX1() < zFahrzeuge[i].gibX2()){
							zBild = Tk.getImage("data/cars/PKW/car" + zFahrzeuge[i].gibFarbe() + ".png");
							arg1.drawImage(zBild, 75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 2 * breite + 16, breite, this);//x0,y0,Breite,Hoehe
						}
						else{
							zBild = Tk.getImage("data/cars/PKW/car" + zFahrzeuge[i].gibFarbe() + ".png");
							arg1.drawImage(zBild, 75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), 2 * breite + 16, breite, this);//x0,y0,Breite,Hoehe
						}
					}
				}
				
				else if(zFahrzeuge[i] instanceof LKW){
					
					if(zFahrzeuge[i].gibX1() < ((LKW)zFahrzeuge[i]).gibX3()){
						zBild = Tk.getImage("data/cars/LKW/car1.png");
						arg1.drawImage(zBild, 75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 3 * breite + 32, breite, this);//x0,y0,Breite,Hoehe
					}
					else{
						zBild = Tk.getImage("data/cars/LKW/car1.png");
						arg1.drawImage(zBild, 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), 3 * breite + 32, breite, this);//x0,y0,Breite,Hoehe
					}
					
				}
			}
		}
		arg.drawImage(Buff, 0, 0, null);
	}
	
	//generiere Fahrzeuge ABER noch ohne verschiebeMethode
	public void drawFahrzeuge(Fahrzeug[] pFahrzeuge){
		zFahrzeuge = pFahrzeuge;
	}
	
	private void zeichne(int i, int breite, int i2){
	}
	private boolean stoesstZusammen(int pX, int pY, char pDir){
		boolean lErfolg = true;
		int lPosX, lPosY;
		switch(pDir){
			
			case 'o':
				lPosX = pX;
				lPosY = pY - 1;
				break;
			case 'r':
				lPosX = pX + 1;
				lPosY = pY;
				break;
			case 'u':
				lPosX = pX;
				lPosY = pY + 1;
				break;
			case 'l':
				lPosX = pX - 1;
				lPosY = pY;
				break;
			default:
				lPosX = 0;
				lPosY = 0;
		}
		for(Fahrzeug i: zFahrzeuge)
			if((i.gibX1() == lPosX && i.gibY1() == lPosY) || (i.gibX2() == lPosX && i.gibY2() == lPosY))
				lErfolg = false;
			else if(i instanceof LKW) lErfolg = ((LKW)i).gibX3() != lPosX && ((LKW)i).gibY3() != lPosY;
		return lErfolg;
	}
	
	/**
	 * @param e MouseEvent Object
	 */
	public void mouseClicked(MouseEvent e)//wenn Maus geklickt wurde//Feldabfrage//e.getx/y
	{
		/*
		int lPosX = findeFeld(e.getX());
		int lPosY = findeFeld(e.getY());
		if(! zSpielbrett.istBelegt(lPosX, lPosY)){
			for(Fahrzeug i: zFahrzeuge){
				if(i instanceof LKW){
					if(i.gibX1() == lPosX && i.gibY1() == lPosY){
						//zGenerate.clearFahrzeug(i);
						i.fahreVor();
						this.repaint();
						//zGenerate.maleFahrzeug(i);
					}
					else if(((LKW)i).gibX3() == lPosX && ((LKW)i).gibY3() == lPosY) i.fahreZurueck();
				}
				else if(i instanceof PKW){
					if(i.gibX1() == lPosX && i.gibY1() == lPosY) i.fahreVor();
					else if(i.gibX2() == lPosX && i.gibY2() == lPosY){
						i.fahreZurueck();
						this.repaint();
					}
				}
			}
		}
		*/
	}
	
	private int findeFeld(int pPos){
		if(pPos >= 75 && pPos <= 170) return 0;
		else if(pPos >= 186 && pPos <= 281) return 1;
		else if(pPos >= 297 && pPos <= 392) return 2;
		else if(pPos >= 408 && pPos <= 503) return 3;
		else if(pPos >= 519 && pPos <= 614) return 4;
		else if(pPos >= 630 && pPos <= 725) return 5;
		return 0;
	}
	
	/**
	 * @param e MouseEvent Object
	 */
	public void mousePressed(MouseEvent e)//wenn Maustaste runtergedrückt wurde
	{
		int lPosX = findeFeld(e.getX());
		int lPosY = findeFeld(e.getY());
		if(! zSpielbrett.istBelegt(lPosX, lPosY)){
			for(Fahrzeug i: zFahrzeuge){
				if(i instanceof LKW){
					if(i.gibX1() == lPosX && i.gibY1() == lPosY && this.stoesstZusammen(lPosX, lPosY, this.gibRichtung(i, lPosX, lPosY))) i.fahreZurueck();
					else if(((LKW)i).gibX3() == lPosX && ((LKW)i).gibY3() == lPosY && this.stoesstZusammen(lPosX, lPosY, this.gibRichtung(i, lPosX, lPosY))) i.fahreVor();
				}
				else if(i instanceof PKW){
					if(i.gibX1() == lPosX && i.gibY1() == lPosY && this.stoesstZusammen(lPosX, lPosY, this.gibRichtung(i, lPosX, lPosY))) i.fahreZurueck();
					else if(i.gibX2() == lPosX && i.gibY2() == lPosY && this.stoesstZusammen(lPosX, lPosY, this.gibRichtung(i, lPosX, lPosY))) i.fahreVor();
				}
			}
			this.repaint();
		}
	}
	
	private char gibRichtung(Fahrzeug pFahrzeug, int pPosX, int pPosY){
		char lDir = 'r';
		if(pFahrzeug.istVertikal() && pFahrzeug.gibY1() < pFahrzeug.gibY2() && pPosY == pFahrzeug.gibY1())
			lDir = 'o';
		else if(pFahrzeug.istVertikal() && pFahrzeug.gibY1() < pFahrzeug.gibY2() && pPosY == pFahrzeug.gibY2())
			lDir = 'u';
		else if(pFahrzeug.istVertikal() && pFahrzeug.gibY2() < pFahrzeug.gibY1() && pPosY == pFahrzeug.gibY1())
			lDir = 'u';
		else if(pFahrzeug.istVertikal() && pFahrzeug.gibY2() < pFahrzeug.gibY1() && pPosY == pFahrzeug.gibY2())
			lDir = 'o';
		else if(!pFahrzeug.istVertikal() && pFahrzeug.gibX1() < pFahrzeug.gibX2() && pPosX == pFahrzeug.gibX1())
			lDir = 'l';
		else if(!pFahrzeug.istVertikal() && pFahrzeug.gibX1() < pFahrzeug.gibX2() && pPosX == pFahrzeug.gibX2())
			lDir = 'r';
		else if(!pFahrzeug.istVertikal() && pFahrzeug.gibX2() < pFahrzeug.gibX1() && pPosX == pFahrzeug.gibX1())
			lDir = 'r';
		else if(!pFahrzeug.istVertikal() && pFahrzeug.gibX2() < pFahrzeug.gibX1() && pPosX == pFahrzeug.gibX2())
			lDir = 'l';
		System.out.println(lDir);
		return lDir;
	}
	
	/**
	 * @param e MouseEvent Object
	 */
	public void mouseReleased(MouseEvent e)//wenn Taste wieder losgelassen wurde
	{
	}
	
	/**
	 * @param e MouseEvent Object
	 */
	public void mouseEntered(MouseEvent e)//Maus in der Komponente
	{
	}
	
	/**
	 * @param e MouseEvent Object
	 */
	public void mouseExited(MouseEvent e)//Maus aus Komponente verschwunden
	{
	}
}