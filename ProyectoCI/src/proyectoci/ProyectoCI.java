/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoci;

import java.util.Arrays;

/**
 *
 * @author PERSONAL
 */
public class ProyectoCI {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        laberinto la=new laberinto();
        la.ingresar();
        System.out.println("entrada: "+la.entrada()[0]+","+la.entrada()[1]);
        System.out.println("salida: "+la.salida()[0]+","+la.salida()[1]);
        System.out.println("distancia: "+la.distancia(la.entrada()[0],la.entrada()[1]));
        la.setDistanciaInicial((int) la.distancia(la.entrada()[0],la.entrada()[1]));
        la.resolver(la.entrada()[0],la.entrada()[1]);
        
        la.getListas().Mostrar();
        System.out.println();
    }
    
}
