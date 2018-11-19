import java.awt.*;
import java.awt.image.BufferedImage;

//autor Louis,Ben
public class Draw extends Canvas{
	final int breite = 95;
	Toolkit Tk = Toolkit.getDefaultToolkit();
	Image zBild;
	private Canvas zCanvas = new Canvas();
	private Fahrzeug[] zFahrzeuge;
	private Spielbrett zSpielbrett = new Spielbrett();
	private Graphics2D arg1;
	
	public Draw(){
		setSize(800, 800);
		//drawFahrzeuge(zSpielbrett.ladeLevel());
		setBackground(Color.black);
	}

	
	@Override
	public void paint(Graphics arg){
		BufferedImage Buff = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
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
						arg1.drawImage(zBild,(breite +16)*zFahrzeuge[i].gibX2(), (breite+16)* zFahrzeuge[i].gibY2(), breite, 2 * breite + 16, this);//x0,y0,Breite,Hoehe
						arg1.drawImage(zBild, 75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), breite, 2 * breite + 16, this);//x0,y0,Breite,Hoehe
					}
					else{
						zBild = Tk.getImage("data/cars/PKW/90/car" + zFahrzeuge[i].gibFarbe() + ".png");
						arg1.drawImage(zBild, (breite+16)* zFahrzeuge[i].gibX1(), (breite+16)* zFahrzeuge[i].gibY1(), breite, 2 * breite + 16, this);//x0,y0,Breite,Hoehe
						arg1.drawImage(zBild, 75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), breite, 2 * breite + 16, this);//x0,y0,Breite,Hoehe
					}
				}
				else if(zFahrzeuge[i] instanceof LKW){
					if(zFahrzeuge[i].gibY1() < zFahrzeuge[i].gibY2()){
						zBild = Tk.getImage("data/cars/LKW/90/car1.png");
						arg1.drawImage(zBild, 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX1(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY1(), breite, 3 * breite + 32, this);//x0,y0,Breite,Hoehe
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), breite, 3 * breite + 32);
					}
					else{
						zBild = Tk.getImage("data/cars/LKW/90/car1.png");
						arg1.drawImage(zBild, 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), breite, 3 * breite + 32, this);//x0,y0,Breite,Hoehe
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), breite, 3 * breite + 32);
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
							arg1.setColor(Color.BLACK);
							arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 2 * breite + 16, breite);
						}
						else{
							zBild = Tk.getImage("data/cars/PKW/car" + zFahrzeuge[i].gibFarbe() + ".png");
							arg1.drawImage(zBild, 75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), 2 * breite + 16, breite, this);//x0,y0,Breite,Hoehe
							arg1.setColor(Color.BLACK);
							arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX2(), 75 + (breite + 16) * zFahrzeuge[i].gibY2(), 2 * breite + 16, breite);
						}
					}
				}
				
				else if(zFahrzeuge[i] instanceof LKW){
					
					if(zFahrzeuge[i].gibX1() < ((LKW)zFahrzeuge[i]).gibX3()){
						zBild = Tk.getImage("data/cars/LKW/car1.png");
						arg1.drawImage(zBild, 75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 3 * breite + 32, breite, this);//x0,y0,Breite,Hoehe
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * zFahrzeuge[i].gibX1(), 75 + (breite + 16) * zFahrzeuge[i].gibY1(), 3 * breite + 32, breite);
					}
					else{
						zBild = Tk.getImage("data/cars/LKW/car1.png");
						arg1.drawImage(zBild, 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), 3 * breite + 32, breite, this);//x0,y0,Breite,Hoehe
						arg1.setColor(Color.BLACK);
						arg1.drawRect(75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibX3(), 75 + (breite + 16) * ((LKW)zFahrzeuge[i]).gibY3(), 3 * breite + 32, breite);
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
}