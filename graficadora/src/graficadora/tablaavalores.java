/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficadora;

import static graficadora.puntosgrafica.valoresmostrar;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.nfunk.jep.JEP;
/**
 *
 * @author PERSONAL
 */
public class tablaavalores {
    private JFrame tablap=new JFrame("CALCULAR");
    private JTextField [] botones;
    private JTextField [] botones1;
    private JPanel panel=new JPanel();
    private JPanel panel1=new JPanel();
    private JPanel panel2=new JPanel();
    private JPanel panel3=new JPanel();
    private JLabel grafi=new JLabel("-");
    private JLabel graff=new JLabel("+");
    private JLabel inicio=new JLabel("desde:");
    private JLabel termina=new JLabel("hasta:");
    private JTextField num1=new JTextField(4);
    private JTextField num2=new JTextField(4);
    private JTextField area=new JTextField(4);
    private double a;
    private double b;
    private double xi;
    private double h;
    private double res;
    private int coe;
    private int a1;
    private int b1;
    
    private JEP funcion=new JEP();

     
    private JButton puntosplano=new JButton("calcular");
    private int tabla=0;
     
     
    public tablaavalores(int tabla,String ecuacion,int a,int b){
        this.a1=a;
        this.b1=b;
        this.tabla=tabla;
       tablap.setSize(300, 120);
       tablap.setLocationRelativeTo(null);
       tablap.setLayout(new BorderLayout());
       panel2.setLayout(new GridLayout(2,1));
       panel.add(this.inicio);
       panel.add(this.grafi);
       panel.add(this.num1);
       panel.add(this.termina);
       panel.add(this.graff);
       panel.add(this.num2);
       
       panel1.add(this.puntosplano);
       
       panel2.add(panel);
       panel2.add(panel1);
       tablap.add(panel2, BorderLayout.NORTH);
       
       num1.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                
                if(num1.getText().length()==2){
                    e.consume();
                }
                if(e.getKeyChar()<47||e.getKeyChar()>58){
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });
        num2.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                if(num2.getText().length()==2){
                    e.consume();
                }
                if(e.getKeyChar()<47||e.getKeyChar()>58){
                    e.consume();
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        if(this.tabla==0){
            this.puntosplano.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(num1.getText().length()!=0&&num2.getText().length()!=0){
                    if(Integer.parseInt(num1.getText())+Integer.parseInt(num2.getText())<=40){
                    int a=-Integer.parseInt(num1.getText());
                    int b=Integer.parseInt(num2.getText());
                    int c=Integer.parseInt(num1.getText())+Integer.parseInt(num2.getText())+1;
                    int i=0;
                    panel3.setLayout(new GridLayout(c,1));
                    tablap.setSize(300, 700);
                    botones=new JTextField[c];
                    botones1=new JTextField[c];
                    for(int j=a;j<=b;j++){
                        botones1[i]=new JTextField(""+j);
                        botones[i]=new JTextField(""+valoresmostrar[j+((a1+b1))/2]);
                         
                        panel3.add(botones1[i]);
                        panel3.add(botones[i]);
                        i++;
                    }
                    tablap.add(panel3,BorderLayout.CENTER);
                    }else {
                        JOptionPane.showMessageDialog(null,"el intervalo de los puntos deben ser menores a 40.");
                        num1.setText(null);
                        num2.setText(null);

                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Debe escribir el punto de inicio\npunto final y el desplazamiento.");
                }
                
                }
            });
        }else if(this.tabla==1){
            this.puntosplano.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    if(num1.getText().length()!=0&&num2.getText().length()!=0){
                        
                        DecimalFormat df = new DecimalFormat();
                        df.setMaximumFractionDigits(4);
                        tablap.setSize(300, 250);
                        panel3.setLayout(new BorderLayout());
                        panel3.add(area);
                        double areac=area(ecuacion);
                        area.setText("el area por metodo de simpson: "+df.format(areac));
                        tablap.add(panel3,BorderLayout.CENTER);
                    }else{
                        JOptionPane.showMessageDialog(null,"Debe escribir el punto de inicio\npunto final y el desplazamiento.");
                    }
                }
            });
        }
        tablap.setResizable(false);
       tablap.setVisible(true);
    }
    
    public double area(String ecuacion){
        try {
                        this.funcion.addStandardFunctions(); //añadimos las funciones matematicas.
                        this.funcion.addStandardConstants(); //añadimos las constantes matematicas.
                        this.a=-Integer.parseInt(num1.getText());
                        this.b=Integer.parseInt(num2.getText());
                        this.xi=0;
                        this.h=(b-a)/2;
                        this.coe=1;
                        this.res=0;
                        for (int i=0;i<3;i++){
                            xi=a+i*h;
                            if(i==1)
                            coe=4;
                            else 
                            coe=1;
                            
                            Double addVariable = funcion.addVariable("x", this.xi); //añadimos la variable que permitimos usar.
                            funcion.parseExpression(ecuacion);//pasamos la ecuacion como un String para que la evalue.
                            res+=coe*funcion.getValue();
                        }
                        res=res*(h/3);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ocurrio un error en tiempo de ejecuacion");
        }
            return res;    
    }
    
}
