
package graficadora;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.*;
import java.awt.*;
import static java.lang.Double.isInfinite;
import static java.lang.Double.isNaN;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JPanel;


public class plano extends JPanel {
   private double valoresx[];
   private double valoresy[];
   private int tm;
   private int n;
   private int n1;
   private boolean graficar;
   private boolean area;
   private int a;
   private int b;
   private int num1;
   private int num2;
   private Color color;
    private puntosgrafica puntos=new puntosgrafica();
   


    public plano(){
        
        this.tm=-1;
        this.n=1;
        this.n1=1;
        this.graficar=false;
        this.area=false;
        this.color =new Color(0,0,0);
        this.setLayout(new BorderLayout());

    }
    public void setcolor(Color color){
        this.color=color;
    }
    
    void setcolor(String s) {
        Scanner sc = new Scanner(s);
        sc.useDelimiter("\\D+");
        this.color = new Color(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }
    public Color getcolor(){
        return color;
    }
    public void tama(int n, int n1){
        this.n=n;
        this.n1=n1;
    }
    public int getn(){
        return n;
    }
    public int getn1(){
        return n1;
    }
    public void setgraficar(boolean graficar){
        this.graficar=graficar;
    }
    public void setvaloresXY(ArrayList <Double> valoresx,ArrayList <Double> valoresy){
        this.valoresx=new double[valoresx.size()];
        this.valoresy=new double[valoresy.size()];
        for(int i=0;i<valoresx.size();i++){
            this.valoresx[i]=valoresx.get(i);
            this.valoresy[i]=valoresy.get(i);
           }
            
    }
   @Override
    public void paint (Graphics g){
           super.paint(g);
       
        
        Graphics2D g2 = (Graphics2D)g;
          
        //estos for hacen una cuadricula en el fondo de la grafica
        for(int i = 0; i < this.getHeight()*2; i++){
		if(i % 10 == 0){
			g2.setColor(new Color(204,204,204));
			g2.drawLine(i,0,i,this.getWidth()*2);
		}
	}
        
		
	for(int i = 0; i < this.getWidth()*2; i++){
		if(i % 10 == 0){
			g2.setColor(new Color(204,204,204));
			g2.drawLine(0,i,this.getHeight()*2,i);
		}
	}
        
        //aqui dibujamos los ejes x,y de las coordenadas
        g.setColor(Color.red);
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        g.drawLine(this.getWidth()/2, 0 ,this.getWidth()/2, this.getHeight());
        
        
        int pix;
        int piy;
        int p0x;
        int p0y;
  
  
        pix=this.getWidth()/2;
        piy=getHeight()/2;
        
        p0x=this.getWidth()/2;
        p0y=getHeight()/2;
        
        
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        if(n1==n){
                    n1=1;
                    n=1;
                }
        
        //numeracion para Y
        g.setColor(Color.black);
        for(double i=1;i<50;i++){
            double a=(i/n)*n1;
            g.drawString(""+df.format(a), pix, (int) (piy-(i*50)));
        }
        
        
        for(double i=-1;i>-50;i--){
            double a=(i/n)*n1;
            g.drawString(""+df.format(a), p0x, (int) (p0y-(i*50)));
        }
        
        //numeracion para x
        for(double i=1;i<50;i++){
            double a=(i/n)*n1;
            g.drawString(""+df.format(a), (int) (pix+(i*50)), piy);
        }    
        
        for(double i=-1;i>-50;i--){
            double a=(i/n)*n1;
            g.drawString(""+df.format(a), (int) (p0x+(i*50)-10), p0y-2);
        }
        
                //traslate cambia la posicion 0,0 de java al centro de nuestro plano cartesiano
		g2.translate(getWidth() / 2, getHeight() / 2);
		
                //creamos lineas de los ejes 
                g2.setColor(Color.red);
                for(int i=-60;i<60;i++){
                    g2.drawLine(50*i, -10, 50*i, 10);
                }
                for(int i=-60;i<60;i++){
                    g2.drawLine(-10, 50*i, 10, 50*i);
                    
                }
                
                g2.setColor(color);
                //graficar
                if(this.graficar==true){
                    for(int i=0;i<this.valoresx.length;i++){
                        if(i+1<this.valoresx.length){
                            if(isNaN(valoresy[i])==false&&isInfinite(valoresy[i+1])==false&&isNaN(valoresy[i+1])==false&&isInfinite(valoresy[i])==false){
                                if(isInfinite(valoresy[i])==true){
                                    if(valoresy[i]<0){
                                        valoresy[i]=-99999;
                                    }
                                    
                                }
                                //if(valoresx[i]<valoresx[i+1]){
                                Line2D l = new Line2D.Float((float) this.valoresx[i]*50.0f*n/n1, (float) this.valoresy[i]*tm*50.0f*n/n1, (float) this.valoresx[i+1]*50.0f*n/n1, (float) this.valoresy[i+1]*tm*50.0f*n/n1);
                                g2.setStroke(new BasicStroke(2.0f));
                                g2.draw(l);
                                //}
                                
                            }
                            
                    }
                }
                }
    }

    

    
}
    

