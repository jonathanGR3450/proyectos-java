
package graficadora;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.nfunk.jep.*;

public class puntosgrafica {
    private String ecuacion;
    private double vx;
    private double valoresx[]=new double[999*16];
    private double valoresy[]=new double[999*16];
    public static double valoresmostrar[]=new double[999];
    private int inicio;
    private int cont;
    private JEP funcion=new JEP();
    
    public puntosgrafica(String ecuacion,String []ecuacionc,int a,int b){
    this.valoresx=new double[(a+b)*16];
    this.valoresy=new double[(a+b)*16];
    this.ecuacion=ecuacion;
    this.vx=-a;
    this.inicio=-a;
    cont=0;
    try {
        funcion.addStandardFunctions(); //añadimos las funciones matematicas.
        funcion.addStandardConstants(); //añadimos las constantes matematicas.
        
        
        for(int i=0;i<this.valoresx.length;i++){
            funcion.addVariable("x", vx);//añadimos la variable que permitimos usar.
            //funcion.addVariable("y", vx);
            funcion.parseExpression(ecuacion); //pasamos la ecuacion como un String para que la evalue.
            if (vx==inicio){
            puntosgrafica.valoresmostrar[cont]=funcion.getValue();
            cont++;
            inicio++;
            }
            this.valoresy[i]=funcion.getValue();
            this.valoresx[i]=vx;
            vx+=0.0625;
        }
        
        
    } catch(Exception e){
        JOptionPane.showMessageDialog(null,"ocurrio un error en tiempo de ejecuacion");
    }
        
    
    }

    puntosgrafica() {
    }
    public void setecuacion(String ecuacion){
        this.ecuacion=ecuacion;
    }
    public String getecuacion(){
        return this.ecuacion;
    }
    
    public double [] getValoresx(){
        return this.valoresx;
    }
    
    public double [] getValoresy(){
        return this.valoresy;
    }
} 

