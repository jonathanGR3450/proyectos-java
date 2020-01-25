/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operativos;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PERSONAL
 */
public class Operativos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner entrada = new Scanner( System.in ); 
        String comando = "";
        String dirOrigen;
        String dirDestino;
        String nombre;
        comandos c=new comandos();
        while(comando.equals("salir")==false){
            System.out.print( "Comando:  " );
            comando = entrada.nextLine();
            
            switch(comando){
                case "copiar":
                    System.out.print( "Direccion origen con nombre del fichero:  " );
                    dirOrigen = entrada.nextLine();
                    System.out.print( "Direccion destino:  " );
                    dirDestino = entrada.nextLine();
                    c.copiar(dirOrigen, dirDestino, 1);
                break;
                case "mover":
                    System.out.print( "Direccion origen con nombre del fichero:  " );
                    dirOrigen = entrada.nextLine();
                    System.out.print( "Direccion destino:  " );
                    dirDestino = entrada.nextLine();
                    c.copiar(dirOrigen, dirDestino, 0);
                    c.eliminar(dirOrigen);
                break;
                case "del_archivo":
                    System.out.print( "Direccion origen con nombre del fichero:  " );
                    dirOrigen = entrada.nextLine();
                    c.eliminar(dirOrigen);
                break;
                case "del_directorio":
                    System.out.print( "Direccion del directorio:  " );
                    dirOrigen = entrada.nextLine();
                    c.eliminar(dirOrigen);
                break;
                case "info_archivo":
                    System.out.print( "Direccion del fichero con nombre y extencion:  " );
                    dirOrigen = entrada.nextLine();
                    c.info(dirOrigen);
                break;
                case "info_directorio":
                    System.out.print( "Direccion del directorio con nombre:  " );
                    dirOrigen = entrada.nextLine();
                    c.info(dirOrigen);
                break;
                case "ruta":
                    c.rutaActual();
                break;  
                case "ejecutar":
                    System.out.print( "Direccion origen con nombre del fichero:  " );
                    dirOrigen = entrada.nextLine();
                    c.ejecutar(dirOrigen);
                break; 
                case "ir":
                    System.out.print( "Direccion del directorio:  " );
                    dirOrigen = entrada.nextLine();
                    c.ir(dirOrigen);
                break;
                default :
                    if(comando.equals("salir")!=true){
                        if(c.terminal(comando)==true){
                            System.out.println("comando valido");
                        }else 
                        System.out.println("comando no valido");
                    }
            }
        }
    }
    
}
