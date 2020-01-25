/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoci;

/**
 *
 * @author PERSONAL
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class laberinto {
    //private Scanner lector;
    private String[][] matriz;
    private int filas;
    private int columnas;
    private StringBuilder s = new StringBuilder();
    private ListaCircular lista=new ListaCircular();
    
    private listas listas0=new listas();
    //private ListaCircular2 lista2=new ListaCircular2();
    private int nodo[]=new int[2];
    private int xf=0;
    private int yf=0;
    private int distancia;
    private int TamNodo;
    private int tam;
    //private boolean exito;
    private StringBuffer s1=new StringBuffer();
    

    public laberinto() {
        this.filas=0;
        this.columnas=0;
        this.TamNodo=0;
        //this.exito=false;
        
    }
    
    public void ingresar(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        
        
        try {
            int cf=0;
            int j = 0;
            //String cadena;
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\Users\\PERSONAL\\Desktop\\laberinto.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
             j=linea.length();
             cf++;
             s.append(linea);
             
         }
         this.filas=cf;
         this.columnas=j;
         int aux=0;
         matriz=new String [this.filas][this.columnas];
         
            for (int i = 0; i < filas; i++) {
                for (int k = 0; k < columnas; k++) {
                    this.matriz[i][k]=""+s.charAt(aux);
                    aux++;
                }
                
            }
         
        }
        catch(Exception e){
            System.out.println("error");
        }
        this.xf=this.salida()[0];
        this.yf=this.salida()[1];
    }
    
    
    public boolean existeCamino(int fila, int columna) {
       
        if(fila < 0 || fila >= filas || columna < 0 || columna >= columnas||matriz[fila][columna].equals("1")||matriz[fila][columna].equals("-")||matriz[fila][columna].equals("*")){
            return false;
        }
        return true;
    }
    
    public double[] CaminosValidos(int fila, int columna){
        double [] caminos=new double [9];
        for (int i = 0; i < caminos.length; i++) {
            caminos[i]=1.5;
        }
        
        int con=0;
            //arriba
            if(fila-1>=0){
                if(this.matriz[fila-1][columna].equals("0")||this.matriz[fila-1][columna].equals("y")){
                con++;
                caminos[1]=fila-1;
                caminos[2]=columna;
                }
            }
            //abajo
            if(fila+1<this.filas){
                if(this.matriz[fila+1][columna].equals("0")||this.matriz[fila+1][columna].equals("y")){
                con++;
                caminos[3]=fila+1;
                caminos[4]=columna;
                }
            }
            //izquierda 
            if(columna-1>=0){
                if((this.matriz[fila][columna-1].equals("0")||this.matriz[fila][columna-1].equals("y"))){
                con++;
                caminos[5]=fila;
                caminos[6]=columna-1;
                }
            }
            //derecha
            if (columna+1<this.columnas) {
               if(this.matriz[fila][columna+1].equals("0")||this.matriz[fila][columna+1].equals("y")){
                con++; 
                caminos[7]=fila;
                caminos[8]=columna+1;
               }
            }
            caminos[0]=con;
        return caminos;
    }
    public void setDistanciaInicial(int distancia){
        this.distancia=distancia;
    }
    
    public int getDistanciaInicial(){
        return this.distancia;
    }
    
    public boolean resolver(int fil, int col) {
      boolean salida = false;
      double [] distancias={100,100,100,100};
      
        this.mostrar();
        if(this.salida()[0]==this.entrada()[0]&&this.salida()[1]==this.entrada()[1]){
            System.out.println("solucionado!");}
        
            for (int i = 1; i < distancias.length+1; i++) {
               if (this.CaminosValidos(fil, col)[i*2-1]!=1.5&&this.CaminosValidos(fil, col)[i*2]!=1.5) {
                    distancias[i-1]=this.distancia((int) this.CaminosValidos(fil, col)[i*2-1], (int) this.CaminosValidos(fil, col)[i*2]);
                    //System.out.println(distancias[i-1]+" ("+CaminosValidos(fil, col)[i*2-1]+","+CaminosValidos(fil, col)[i*2]+")");
               } 
            }
            double menor=distancias[0];
            int pos=0;
            for(int i = 1; i < distancias.length; i++){
                if ( distancias[i] <= menor){
                    menor = distancias[i];
                    pos=i;
                }
            }
            if(menor!=100&&menor>=0){
                    System.out.println("Distancia menor: "+menor);
            }else{
                System.out.println("camino cerrado");
            }
            
        if(this.CaminosValidos(fil, col)[0]>1){
            matriz[fil][col] = "*";
            nodo[0]=fil;
            nodo[1]=col;
            //this.TamNodo=this.getLista().cantidad()-2;
            tam=s1.length()/5;
            System.out.println("tamaño String:"+tam+"  tamaño en nodo:"+TamNodo);
            System.out.println(s1);
            System.out.println("Nodo es: "+nodo[0]+","+nodo[1]);
        } else{
            matriz[fil][col] = "-";
        }
            if (fil == this.salida()[0] && col == this.salida()[1]) {
                return true;
            }
        if(menor!=100&&menor>=0){
            if(pos==0){
                if (!salida && existeCamino(fil - 1, col)) {
                    matriz[fil-1][col]="x";
                    //lista.insertarCola("("+(fil-1)+","+(col)+")");
                    s1.append("("+(fil-1)+","+(col)+")");
                    salida = resolver(fil - 1, col);
                }
            }else if(pos==1){
                if (!salida && existeCamino(fil + 1, col)) {
                    matriz[fil+1][col]="x";
                    //lista.insertarCola("("+(fil+1)+","+(col)+")");
                    s1.append("("+(fil+1)+","+(col)+")");
                    salida = resolver(fil + 1, col);
                }
            }else if(pos==2){
                if (!salida && existeCamino(fil, col - 1)) {
                    matriz[fil][col-1]="x";
                    //lista.insertarCola("("+(fil)+","+(col-1)+")");
                    s1.append("("+(fil)+","+(col-1)+")");
                    salida = resolver(fil, col - 1);
                }
            }else if(pos==3){
                if (!salida && existeCamino(fil, col + 1)) {
                    matriz[fil][col+1]="x";
                    //lista.insertarCola("("+(fil)+","+(col+1)+")");
                    s1.append("("+(fil)+","+(col+1)+")");
                    salida = resolver(fil, col + 1);
                }
            }
            
        }else{
            //this.lista.insertarCola(s1);
            this.listas0.insertarLista(s1.toString());
            System.out.println("salida:["+this.xf+","+this.yf+"]  la x esta:["+fil+","+col+"]");
            if(this.xf!=fil&&this.yf!=col){
                
                System.out.println(""+s1);
                for (int i = 0; i < (s1.length()/5-tam)+2; i++) {
                    s1.delete(s1.length()-5, s1.length());
                }
                System.out.println(""+s1);
                
                /*for (int i = 0; i < (this.getLista().cantidad()-this.TamNodo); i++) {
                    this.lista.extraerCola();
                }
                */
                if (!salida && existeCamino(nodo[0] - 1, nodo[1])) {
                    matriz[nodo[0]-1][nodo[1]]="x";
                    //lista.insertarCola("("+(nodo[0]-1)+","+(nodo[1])+")");
                    s1.append("("+(nodo[0]-1)+","+(nodo[1])+")");
                    salida = resolver(nodo[0] - 1, nodo[1]);
                }
                  
                if (!salida && existeCamino(nodo[0] + 1, nodo[1])) {
                    matriz[nodo[0]+1][nodo[1]]="x";
                   // lista.insertarCola("("+(nodo[0]+1)+","+(nodo[1])+")");
                    s1.append("("+(nodo[0]+1)+","+(nodo[1])+")");
                    salida = resolver(nodo[0] + 1, nodo[1]);
                }

                if (!salida && existeCamino(nodo[0], nodo[1] - 1)) {
                    matriz[nodo[0]][nodo[1]-1]="x";
                   // lista.insertarCola("("+(nodo[0])+","+(nodo[1]-1)+")");
                    s1.append("("+(nodo[0])+","+(nodo[1]-1)+")");
                    salida = resolver(nodo[0], nodo[1] - 1);
                }

                if (!salida && existeCamino(nodo[0], nodo[1] + 1)) {
                    matriz[nodo[0]][nodo[1]+1]="x";
                    //lista.insertarCola("("+(nodo[0])+","+(nodo[1]+1)+")");
                    s1.append("("+(nodo[0])+","+(nodo[1]+1)+")");
                    salida = resolver(nodo[0], nodo[1] + 1);
                }
            
            }else{
                System.out.println("Se encontro la salida!");
                //this.lista.insertarCola(s1);
                //this.lista2.insertarCola(this.lista);
                
            }
        }
        
return salida;
    }
    
    public int[] salida(){
        int [] arreglo= new int[2];
        for (int i = 0; i < matriz.length; i++) {
             for (int j = 0; j < matriz[0].length; j++) {
                 if (matriz[i][j].equals("y")) {
                     arreglo[0]=i;
                     arreglo[1]=j;
                 }
             }
         }
         return arreglo;
    }
    
    public int[] entrada(){
        int [] arreglo= new int[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j].equals("x")) {
                    arreglo[0]=i;
                    arreglo[1]=j;
                }
            }
        }
        return arreglo;
    }
    
    public void mostrar(){
        System.out.println("\nel tablero es: ");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("[" + matriz[i][j]+ "]");
            }
            System.out.println();
        }
    }
    public ListaCircular getLista(){
        return this.lista;
    }
    public listas getListas(){
        return this.listas0;
    }
    public double distancia(int x, int y){
        return ((this.salida()[0]-x)+(this.salida()[1]-y));
    }
    
}
