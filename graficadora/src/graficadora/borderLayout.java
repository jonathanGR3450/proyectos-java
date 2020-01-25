
package graficadora;
import static graficadora.valoresY.ecuacionc;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;


public final class borderLayout implements MouseWheelListener  {
    //creo los atributos de la clase necesarios para la GUI del programa
     private plano plano;
     
     
     
     private Color colr=Color.BLACK;
     private double valoresy[];
     private double valoresx[];
     

     private puntosgrafica puntos;
     private valoresY V;
     
     private boolean nuevog=false;
     
     private JFrame ventana=new JFrame("GRAFICADORA");
     
     private JLabel ecuacion=new JLabel ("F(x)=");
     private JTextField caja=new JTextField(16);
     private JButton limpiar=new JButton("BORRAR");
     private JPanel panel2=new JPanel();
     private JPanel aux=new JPanel();
     private JButton graficar=new JButton("graficar");
     
     private JButton grafica3d=new JButton("3D");
     private JButton mas=new JButton("Zoom+");
     private JButton menos=new JButton("Zoom-");
     private JPanel panel0=new JPanel();
     
     private JLabel grafi=new JLabel("-");
     private JLabel graff=new JLabel("+");
     private JLabel inicio=new JLabel("desde:");
     private JLabel termina=new JLabel("hasta:");
     private JTextField num1=new JTextField(4);
     private JTextField num2=new JTextField(4);
     private ArrayList<Double> ecuacionex=new ArrayList<Double>();
     private ArrayList<Double>ecuacioney=new ArrayList<Double>();
     
     //private int cont;
    // private int cont1;
     private int n;
     private int n1;
     
     
     
    public borderLayout(){ 
        //creo la ventana (JFrame) con un tamaño de 600 por 700,  creo un objeto llamado plano(donde dibujamos la grafica en sus ejes x, y).
        ventana.setSize(650, 700);
        ventana.setLocationRelativeTo(null);
        plano=new plano();
        //caja.setText("");
        border();
        this.menu();
        n=1;
        n1=1;
        
        

    }
    public void border(){
        //JPanel llamado aux el cual tiene un GridLayout de una fila y dos columnas;
        //en este JPanel se mostraran los puntos de -6 hasta 6 (los valores de Y respecto a X).
        aux.setLayout(new GridLayout(4,1));
        ventana.setLayout(new BorderLayout());
        ventana.add(plano, BorderLayout.CENTER);
        
        panel0.setLayout(new GridLayout(1,2));
        
        
        panel0.add(mas);
        panel0.add(menos);
        ventana.add(panel0,BorderLayout.SOUTH);
        
        mas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                    n++;
                    plano.tama((int) Math.pow(2, n),(int) Math.pow(2, n1));
                    plano.repaint();
                        if(n==n1){
                            n=1;
                            n1=1;
                        }
                
            }
        });
        
        menos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    n1++;
                    plano.tama((int) Math.pow(2, n),(int) Math.pow(2, n1));
                    plano.repaint();
                        if(n==n1){
                            n=1;
                            n1=1;
                        }
                    
            }
        });
        //aux.add(this.descripcion);
        
        //añado el panel aux a la ventana en la OESTE
        //ventana.add(aux, BorderLayout.WEST);
        
        
        
        //limpiar es un boton, al oprimior este boton elimina la ecucacion (eimina la grafica)
        limpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent ev){
                nuevog=false;
                caja.setText(null);
                num1.setText(null);
                num2.setText(null);
                ecuacionex.removeAll(ecuacionex);
                ecuacioney.removeAll(ecuacioney);
                plano.setgraficar(false);
                plano.repaint();
            }   
        });
        
        
        // agrego a panel2 un JLabel un JTextField donde recibe la ecucacion a graficar,
        //el boton de graficar y el boton de limpiar.
        panel2.setLayout(new FlowLayout());
        panel2.add(this.ecuacion);
        panel2.add(this.caja);
        panel2.add(this.graficar);
        panel2.add(this.limpiar);
        panel2.add(this.inicio);
        panel2.add(this.grafi);
        panel2.add(this.num1);
        panel2.add(this.termina);
        panel2.add(this.graff);
        panel2.add(this.num2);
        //agregamos el panel2 a ventana al norte(parte de arriba).
        ventana.add(panel2, BorderLayout.NORTH);
        
        
        
        
        
        
        
        
    //boton graficar, hace que envie por parametros la ecuacion a una clase aparte donde obtiene los valores de y respecto a x.
    this.graficar.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent ev){
            if(caja.getText().length()!=0){
                if(num1.getText().length()!=0&&num2.getText().length()!=0){
                    if(Integer.parseInt(num1.getText())+Integer.parseInt(num2.getText())<1000){
                        V=new valoresY(caja.getText());
                        if (V.getcorrecto()==true){
                            int a=Integer.parseInt(num1.getText());
                            int b=Integer.parseInt(num2.getText());
                            nuevog=true;
                            plano.setgraficar(true);
                            puntos=new puntosgrafica(V.ecuacionc(),ecuacionc,a,b);
                            puntos.setecuacion(V.ecuacionc());
                            double [] dx=puntos.getValoresx();
                            double [] dy=puntos.getValoresy();
                            for(int i=0;i<puntos.getValoresx().length;i++){
                                ecuacionex.add(dx[i]);
                                ecuacioney.add(dy[i]);
                            }
                            plano.setvaloresXY(ecuacionex, ecuacioney);
                            plano.repaint();
                        }else {
                            JOptionPane.showMessageDialog(null,"ingreso un valor erroneo, recuerde que\nla ecuacion es de una sola variable la cual es x\n"
                            + "debe ser explicito con la sintaxis de la ecuacion.");
                            caja.setText(null);
                        }
                    }else 
                        JOptionPane.showMessageDialog(null,"El intervalo es muy grande.");
                }else{
                    JOptionPane.showMessageDialog(null,"Debe escribir el tamaño de la grafica.");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Debe escribir la ecuacion\npara poder graficar.");
                
            }
            
            
        }
        });  
        
    }
    
    public void menu(){
    
        JMenuBar menub=new JMenuBar();
        ventana.setJMenuBar(menub);
        JMenu archivo=new JMenu("ARCHIVO");
        archivo.setMnemonic('A');
        JMenuItem nuevo=new JMenuItem("NUEVO");
        nuevo.setMnemonic('N');
        archivo.add(nuevo);
        
        nuevo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(nuevog==true){
                    //hay una grafica dibujada
                    String [] menu2={"IMAGEN","MODIFICABLE","NO GUARDAR"};
                    int opcion=JOptionPane.showOptionDialog(null, "desea guardar?", "GUARDAR", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menu2, menu2[0]);
                    if(opcion==0){
                        BufferedImage imagen= new BufferedImage(plano.getWidth(),plano.getHeight(),BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g = imagen.createGraphics();
                        plano.paint(g);
                        File file=null;
                        JFileChooser fc = new JFileChooser();
                        int showSaveDialog = fc.showSaveDialog(null);
                        if(showSaveDialog==javax.swing.JFileChooser.APPROVE_OPTION){
                        file=new File(fc.getSelectedFile()+".png");
                        try {  
                        ImageIO.write(imagen, "png" , file);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "ocurrio un error guardando el archivo");
                        }
                        }
                        plano.setgraficar(false);
                        plano.repaint();
                        caja.setText(null);
                    }else if(opcion==1){
                        if(nuevog==true){
                                JFileChooser fc=new JFileChooser();
                                int op=fc.showSaveDialog(ventana);
                            if(op==JFileChooser.APPROVE_OPTION){
                                FileWriter fichero=null;
                                PrintWriter pw = null;
                            try{
                                    fichero=new FileWriter(fc.getSelectedFile()+".txt");
                                    pw = new PrintWriter(fichero);
                                    valoresx=new double[ecuacionex.size()];
                                    valoresy=new double[ecuacioney.size()];
                                    for(int k=0;k<ecuacioney.size();k++){
                                        valoresx[k]=ecuacioney.get(k);
                                        valoresy[k]=ecuacionex.get(k);
                                        }
                                    
                                for (int i = 0; i < valoresy.length+3; i++){
                                    if(i==0){
                                    pw.println(caja.getText());
                                    }else if(i==1){
                                        pw.println(plano.getcolor().toString());
                                    }else if(i==2){
                                    pw.println(ecuacioney.size());  
                                    }else{
                                    pw.println(valoresy[i-3]);
                                    pw.println(valoresx[i-3]);
                                    }
                                }
                                pw.close();
                            }catch(IOException ex){
                                JOptionPane.showMessageDialog(null, "ocurrio un error guardando el archivo");
                            }
                            }
                                plano.setgraficar(false);
                                plano.repaint();
                                caja.setText(null);
                            
                }else{
                JOptionPane.showMessageDialog(null, "no hay grafica que guardar");
                }
                    }else if(opcion==2){
                        plano.setgraficar(false);
                        plano.repaint();
                        caja.setText(null);
                    }
                }else{
                    plano.setgraficar(false);
                    plano.repaint();
                    caja.setText(null);
                }
            }
        });
        
        
        
        JMenuItem guardarplano=new JMenuItem("GUARDAR");
        guardarplano.setMnemonic('G');
        archivo.add(guardarplano);
        guardarplano.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
               if(nuevog==true){ 
                
                   JFileChooser fc=new JFileChooser();
                                int op=fc.showSaveDialog(ventana);
                            if(op==JFileChooser.APPROVE_OPTION){
                                FileWriter fichero=null;
                                PrintWriter pw = null;
                            try{
                                    fichero=new FileWriter(fc.getSelectedFile()+".txt");
                                    pw = new PrintWriter(fichero);
                                    valoresx=new double[ecuacionex.size()];
                                    valoresy=new double[ecuacioney.size()];
                                    for(int k=0;k<ecuacioney.size();k++){
                                        valoresx[k]=ecuacioney.get(k);
                                        valoresy[k]=ecuacionex.get(k);
                                        }
                                    
                                for (int i = 0; i < valoresy.length+3; i++){
                                    if(i==0){
                                    pw.println(caja.getText());
                                    }else if(i==1){
                                        pw.println(plano.getcolor().toString());
                                    }else if(i==2){
                                    pw.println(ecuacioney.size());  
                                    }else{
                                    pw.println(valoresy[i-3]);
                                    pw.println(valoresx[i-3]);
                                    }
                                }
                                pw.close();
                            }catch(IOException ex){
                                JOptionPane.showMessageDialog(null, "ocurrio un error guardando el archivo");
                            }
                            }
                   
                /*FileNameExtensionFilter type = new FileNameExtensionFilter(".grp", "grp");
                JFileChooser fc=new JFileChooser();
                fc.setFileFilter(type);
                int op=fc.showSaveDialog(ventana);
                if(op==JFileChooser.APPROVE_OPTION){
                    try {
                        BufferedWriter write = new BufferedWriter(new FileWriter(fc.getSelectedFile()+".grp"));
			PrintWriter pw= new PrintWriter(write);
                        
                        if(fc.getFileFilter().getDescription()== ".grp"){
				valoresy=puntos.getValoresy();
                                String g=plano.getcolor().toString();
                            for (int i = 0; i < valoresy.length+2; i++){
                                if(i==0){
                                    pw.println(caja.getText());
                                }else if(i==1){
                                    pw.println(g);
                                }else
                                    pw.println(valoresy[i-2]);
                            }
                                pw.close();
			}		
			} catch (Exception e1) {
                            e1.printStackTrace();
			} 
                }*/
            }else{
               JOptionPane.showMessageDialog(null,"no hay grafica que guardar");
               }       
                
            }
        });
        
        JMenuItem guardar=new JMenuItem("GUARDAR PNG");
        guardar.setMnemonic('G');
        archivo.add(guardar);
        
        JMenuItem abrir=new JMenuItem("ABRIR");
        abrir.setMnemonic('A');
        archivo.add(abrir);
        abrir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                int i=0;
                JFileChooser fc=new JFileChooser();
                double valorx[] = null;
                double valory[] = null;
                int conx=0;
                int cony=0;
                //FileNameExtensionFilter type = new FileNameExtensionFilter(".grp", "grp");
                //fc.setFileFilter(type);
                int op=fc.showOpenDialog(ventana);
                String s="";
                if(op==JFileChooser.APPROVE_OPTION){
                    String sele=fc.getSelectedFile().toString();
                    if(".grp".equals(sele.substring(sele.length()-4, sele.length()))||".txt".equals(sele.substring(sele.length()-4, sele.length()))){
                        FileReader fr = null;
                        BufferedReader br = null;
                        try {
                                fr=new FileReader(fc.getSelectedFile());
                                br=new BufferedReader(fr);
                                try{
                            while((s=br.readLine())!=null){
                                if(i==0){
                                    caja.setText(s);
                                }else if(i==1){
                                    plano.setcolor(s);
                                }else if(i==2){
                                    valory=new double[Integer.parseInt(s)];
                                    valorx=new double[Integer.parseInt(s)];
                                }else if(i%2!=0){
                                    ecuacionex.add(Double.parseDouble(s));
                                    conx++;
                                }else if(i%2==0){
                                   ecuacioney.add(Double.parseDouble(s)); 
                                    cony++;
                                }
                                i++; 
                            }
                                }catch(Exception e){
                                        JOptionPane.showMessageDialog(null, "ocurrio un error abriendo el archivo");
                                    }
                            nuevog=true;
                            plano.setgraficar(true);
                            plano.setvaloresXY(ecuacionex, ecuacioney);
                            plano.repaint();
                                
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "ocurrio un error abriendo el archivo");
                    }
                    }else 
                        JOptionPane.showMessageDialog(null, "este tipo de archivo es invalido para el programa");
                    
                }
            }
        });
        
        guardar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                if(nuevog==true){
                BufferedImage imagen= new BufferedImage(plano.getWidth(),plano.getHeight(),BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = imagen.createGraphics();
                plano.paint(g);
                File file=null;
                    JFileChooser fc = new JFileChooser();
                    int showSaveDialog = fc.showSaveDialog(null);
                    if(showSaveDialog==JFileChooser.APPROVE_OPTION){
                        file=new File(fc.getSelectedFile()+".png");
                        try {  
                        ImageIO.write(imagen, "png" , file);
                        } catch (IOException ex) {
                            Logger.getLogger(borderLayout.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                }else{
                JOptionPane.showMessageDialog(null, "no hay grafica que guardar");
                }
                
            }
            
        });
        
        JMenuItem salir=new JMenuItem("SALIR");
        salir.setMnemonic('S');
        archivo.add(salir);
        salir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                if(nuevog==true){
                    //hay una grafica dibujada
                    String [] menu2={"IMAGEN","MODIFICABLE","SALIR"};
                    int opcion1=JOptionPane.showOptionDialog(null, "desea guardar antes de salir?", "SALIR", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, menu2, menu2[0]);
                    if(opcion1==0){
                        BufferedImage imagen= new BufferedImage(plano.getWidth(),plano.getHeight(),BufferedImage.TYPE_INT_ARGB);
                        Graphics2D g = imagen.createGraphics();
                        plano.paint(g);
                        File file=null;
                        JFileChooser fc = new JFileChooser();
                        int showSaveDialog = fc.showSaveDialog(null);
                        if(showSaveDialog==javax.swing.JFileChooser.APPROVE_OPTION){
                        file=new File(fc.getSelectedFile()+".png");
                        try {  
                        ImageIO.write(imagen, "png" , file);
                        } catch (IOException ex) {
                            Logger.getLogger(borderLayout.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }System.exit(0);
                    }else if(opcion1==1){
                        
                            JFileChooser fc=new JFileChooser();
                                int op=fc.showSaveDialog(ventana);
                            if(op==JFileChooser.APPROVE_OPTION){
                                FileWriter fichero=null;
                                PrintWriter pw = null;
                            try{
                                    fichero=new FileWriter(fc.getSelectedFile()+".txt");
                                    pw = new PrintWriter(fichero);
                                    valoresx=new double[ecuacionex.size()];
                                    valoresy=new double[ecuacioney.size()];
                                    for(int k=0;k<ecuacioney.size();k++){
                                        valoresx[k]=ecuacioney.get(k);
                                        valoresy[k]=ecuacionex.get(k);
                                        }
                                    
                                for (int i = 0; i < valoresy.length+3; i++){
                                    if(i==0){
                                    pw.println(caja.getText());
                                    }else if(i==1){
                                        pw.println(plano.getcolor().toString());
                                    }else if(i==2){
                                    pw.println(ecuacioney.size());  
                                    }else{
                                    pw.println(valoresy[i-3]);
                                    pw.println(valoresx[i-3]);
                                    }
                                }
                                pw.close();
                            }catch(IOException ex){
                                JOptionPane.showMessageDialog(null, "ocurrio un error guardando el archivo");
                            }
                            }System.exit(0);
                    }else if(opcion1==2){
                        System.exit(0);
                    }
                }else{
                System.exit(0);
                }
            }
            
        });
        menub.add(archivo);
        
        
        JMenu color=new JMenu("COLOR");
        JMenuItem colores=new JMenuItem("COLORES");
        color.add(colores);
        colores.setMnemonic('C');
        colores.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                JColorChooser ventanaDeColores=new JColorChooser();
                colr=ventanaDeColores.showDialog(null, "Seleccione un Color", Color.gray);
                            plano.setcolor(colr);
                            plano.repaint();
            }
        });
        
        
       
        
        
        menub.add(color);
        
        JMenu zoom=new JMenu("ZOOM");
        zoom.setMnemonic('Z');
        JMenuItem aumentar=new JMenuItem("AUMENTAR");
        aumentar.setMnemonic('A');
        zoom.add(aumentar);
        
        JMenuItem disminuir=new JMenuItem("DISMINUIR");
        disminuir.setMnemonic('D');
        zoom.add(disminuir);
        menub.add(zoom);
        
        JMenu calcular=new JMenu("CALCULAR");
        calcular.setMnemonic('C');
        JMenuItem tablaValores= new JMenuItem("TABLA DE VALORES");
        tablaValores.setMnemonic('T');
        calcular.add(tablaValores);
        
        tablaValores.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(nuevog==true){
                    int a=Integer.parseInt(num1.getText());
                    int b=Integer.parseInt(num2.getText());
                    tablaavalores v=new tablaavalores(0,null,a,b);
                }else 
                    JOptionPane.showMessageDialog(null,"debe graficar primero la ecuacion");
            
            }
        });
        JMenuItem integral=new JMenuItem("AREA");
        integral.setMnemonic('A');
        calcular.add(integral);
        integral.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(nuevog==true){
                    int a=Integer.parseInt(num1.getText());
                    int b=Integer.parseInt(num2.getText());
                    tablaavalores tabla=new tablaavalores(1,V.ecuacionc(),a,b);
                    
                }else 
                    JOptionPane.showMessageDialog(null,"debe graficar primero la ecuacion");
            }
        });
        
        JMenu acercaDe=new JMenu("ACERCA DE");
        acercaDe.setMnemonic('A');
        JMenuItem info=new JMenuItem("INFORMACION");
        info.setMnemonic('I');
        acercaDe.add(info);
        
        aumentar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                    n++;
                    plano.tama((int) Math.pow(2, n),(int) Math.pow(2, n1));
                    plano.repaint();
                if(n==n1){
                    n=1;
                    n1=1;
                }
            }
        });
        disminuir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                    n1++;
                    plano.tama((int) Math.pow(2, n),(int) Math.pow(2, n1));
                    plano.repaint();
                if(n==n1){
                    n=1;
                    n1=1;
                }
            }
        });
        
        info.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evento){
                JOptionPane.showMessageDialog(null, "las ecuaciones a graficar son de la forma \nY=ƒ(x) de una sola variable");
            }
            
        });
        menub.add(calcular);
        menub.add(acercaDe);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        plano.addMouseWheelListener(this);
    }

    
    
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.getWheelRotation()==1){
                    n1++;
                    plano.tama((int) Math.pow(2, n),(int) Math.pow(2, n1));
                    plano.repaint();
                if(n==n1){
                    n=1;
                    n1=1;
                }
        }else if(e.getWheelRotation()==-1){
                        n++;
                        plano.tama((int) Math.pow(2, n),(int) Math.pow(2, n1));
                        plano.repaint();
                     if(n==n1){
                        n=1;
                        n1=1;
                    }
            }
        }
    }