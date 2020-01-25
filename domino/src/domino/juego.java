/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

/**
 *
 * @author PERSONAL
 */

import Listas.jugadores;
import Listas.fichas;
import Listas.Tjugadores;
import Nodos.NodoJ;
import Nodos.NodoF;
import Nodos.NodoT;
import java.util.Random;

public class juego {
    
    private Tjugadores jugadores=new Tjugadores();
    private fichas F1= new fichas();
    private fichas F2= new fichas();
    private fichas F3= new fichas();
    private fichas F4= new fichas();
    private fichas F5= new fichas();
    private fichas F6= new fichas();
    private fichas F7= new fichas();
    private fichas F8= new fichas();
    private fichas F9= new fichas();
    private fichas F10= new fichas();
    private fichas F11= new fichas();
    private fichas F12= new fichas();
    private fichas F13= new fichas();
    private fichas F14= new fichas();
    private fichas F15= new fichas();
    private fichas F16= new fichas();
    private fichas F17= new fichas();
    private fichas F18= new fichas();
    private fichas F19= new fichas();
    private fichas F20= new fichas();
    private fichas F21= new fichas();
    private fichas F22= new fichas();
    private fichas F23= new fichas();
    private fichas F24= new fichas();
    private fichas F25= new fichas();
    private fichas F26= new fichas();
    private fichas F27= new fichas();
    private fichas F28= new fichas();
    
    private Random rm= new Random();
    private String [] valor=new String[28];
    private jugadores j1=new jugadores();
    private jugadores j2=new jugadores();
    private jugadores j3=new jugadores();
    private jugadores j4=new jugadores();
    private jugadores jaux=new jugadores();
    private int NJugadores;
    
    
    public juego(){
        NJugadores=2;
        
        F1.insertarfichas(0,0);
        F2.insertarfichas(0,1);
        F3.insertarfichas(1,1);
        F4.insertarfichas(0,2);
        F5.insertarfichas(1,2);
        F6.insertarfichas(2,2);
        F7.insertarfichas(0,3);
        F8.insertarfichas(1,3);
        F9.insertarfichas(2,3);
        F10.insertarfichas(3,3);
        F11.insertarfichas(0,4);
        F12.insertarfichas(1,4);
        F13.insertarfichas(2,4);
        F14.insertarfichas(3,4);
        F15.insertarfichas(4,4);
        F16.insertarfichas(0,5);
        F17.insertarfichas(1,5);
        F18.insertarfichas(2,5);
        F19.insertarfichas(3,5);
        F20.insertarfichas(4,5);
        F21.insertarfichas(5,5);
        F22.insertarfichas(0,6);
        F23.insertarfichas(1,6);
        F24.insertarfichas(2,6);
        F25.insertarfichas(3,6);
        F26.insertarfichas(4,6);
        F27.insertarfichas(5,6);
        F28.insertarfichas(6,6);
        
        jaux.insertarJugador(1, F1);
        jaux.insertarJugador(2, F2);
        jaux.insertarJugador(3, F3);
        jaux.insertarJugador(4, F4);
        jaux.insertarJugador(5, F5);
        jaux.insertarJugador(6, F6);
        jaux.insertarJugador(7, F7);
        jaux.insertarJugador(8, F8);
        jaux.insertarJugador(9, F9);
        jaux.insertarJugador(10, F10);
        jaux.insertarJugador(11, F11);
        jaux.insertarJugador(12, F12);
        jaux.insertarJugador(13, F13);
        jaux.insertarJugador(14, F14);
        jaux.insertarJugador(15, F15);
        jaux.insertarJugador(16, F16);
        jaux.insertarJugador(17, F17);
        jaux.insertarJugador(18, F18);
        jaux.insertarJugador(19, F19);
        jaux.insertarJugador(20, F20);
        jaux.insertarJugador(21, F21);
        jaux.insertarJugador(22, F22);
        jaux.insertarJugador(23, F23);
        jaux.insertarJugador(24, F24);
        jaux.insertarJugador(25, F25);
        jaux.insertarJugador(26, F26);
        jaux.insertarJugador(27, F27);
        jaux.insertarJugador(28, F28);
        
        this.jugadores.insertarT("aux", jaux);
        this.repartir();
    }
    
    public void repartir(){
        try{
            int r=0;
        fichas faux=new fichas();
        for (int i = 0; i < NJugadores; i++) {
            for (int j = 0; j < 7; j++) {
                r=rm.nextInt(jaux.getCantidad());
                if(r==0){
                    faux=jaux.extraerCabeza();
                }else if(r==jaux.getCantidad()){
                    faux=jaux.extraerCola();
                }else{
                    faux=jaux.extraer(r);
                }
                
                if(i==0){
                    j1.insertarJugador(j, faux);
                }else if(i==1){
                    j2.insertarJugador(j, faux);
                }else if(i==2){
                    j3.insertarJugador(j, faux);
                }else if(i==3){
                    j4.insertarJugador(j, faux);
                }
            }
            if(i==0){
               jugadores.insertarT("jugador"+i, j1);
            }else if(i==1){
               jugadores.insertarT("jugador"+i, j2);
            }else if(i==2){
               jugadores.insertarT("jugador"+i, j3);
            }else if(i==3){
               jugadores.insertarT("jugador"+i, j4);
            }
        }
            
        }catch(Exception e){
            //this.repartir();
            System.out.println("error");
        }
        
        //jugadores.Mostrar();
    }
}
