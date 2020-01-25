/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p_domino;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author PERSONAL
 */
public class juego {
    private ArrayList f1 = new ArrayList();
    private ArrayList f2 = new ArrayList();
    private ArrayList f3 = new ArrayList();
    private ArrayList f4 = new ArrayList();
    private ArrayList f5 = new ArrayList();
    private ArrayList f6 = new ArrayList();
    private ArrayList f7 = new ArrayList();
    private ArrayList f8 = new ArrayList();
    private ArrayList f9 = new ArrayList();
    private ArrayList f10 = new ArrayList();
    private ArrayList f11 = new ArrayList();
    private ArrayList f12 = new ArrayList();
    private ArrayList f13 = new ArrayList();
    private ArrayList f14 = new ArrayList();
    private ArrayList f15 = new ArrayList();
    private ArrayList f16 = new ArrayList();
    private ArrayList f17 = new ArrayList();
    private ArrayList f18 = new ArrayList();
    private ArrayList f19 = new ArrayList();
    private ArrayList f20 = new ArrayList();
    private ArrayList f21 = new ArrayList();
    private ArrayList f22 = new ArrayList();
    private ArrayList f23 = new ArrayList();
    private ArrayList f24 = new ArrayList();
    private ArrayList f25 = new ArrayList();
    private ArrayList f26 = new ArrayList();
    private ArrayList f27 = new ArrayList();
    private ArrayList f28 = new ArrayList();
    
    private ArrayList faux = new ArrayList();
    
    private ArrayList dealer = new ArrayList();
    private ArrayList j1 = new ArrayList();
    private ArrayList j2 = new ArrayList();
    private ArrayList j3 = new ArrayList();
    private ArrayList j4 = new ArrayList();
    private ArrayList jugadores = new ArrayList();
    
    private int NJugadores=0;
    private Random rm= new Random();
    
    public juego(){
    
        f1.add("00");
        f2.add("01");f3.add("11");
        f4.add("02");f5.add("12");f6.add("22");
        f7.add("03");f8.add("13");f9.add("23");f10.add("33");
        f11.add("04");f12.add("14");f13.add("24");f14.add("34");f15.add("44");
        f16.add("05");f17.add("15");f18.add("25");f19.add("35");f20.add("45");f21.add("55");
        f22.add("06");f23.add("16");f24.add("26");f25.add("36");f26.add("46");f27.add("56");f28.add("66");
        
        this.dealer.add(f1);
        this.dealer.add(f2);
        this.dealer.add(f3);
        this.dealer.add(f4);
        this.dealer.add(f5);
        this.dealer.add(f6);
        this.dealer.add(f7);
        this.dealer.add(f8);
        this.dealer.add(f9);
        this.dealer.add(f10);
        this.dealer.add(f11);
        this.dealer.add(f12);
        this.dealer.add(f13);
        this.dealer.add(f14);
        this.dealer.add(f15);
        this.dealer.add(f16);
        this.dealer.add(f17);
        this.dealer.add(f18);
        this.dealer.add(f19);
        this.dealer.add(f20);
        this.dealer.add(f21);
        this.dealer.add(f22);
        this.dealer.add(f23);
        this.dealer.add(f24);
        this.dealer.add(f25);
        this.dealer.add(f26);
        this.dealer.add(f27);
        this.dealer.add(f28);
        
        this.jugadores.add(dealer);
        
    }
    
    public ArrayList repartir(int NJugadores){
        this.NJugadores=NJugadores;
        for (int i = 0; i < this.NJugadores; i++) {
            for (int j = 0; j < 7; j++) {
                int n=rm.nextInt(dealer.size());
                switch(i){
                    case 0:
                        j1.add(dealer.get(n));
                        //System.out.println("j1 "+n+":  "+dealer.get(n));
                        dealer.remove(n);
                    break;
                    case 1:
                        j2.add(dealer.get(n));
                       // System.out.println("j2 "+n+":  "+dealer.get(n));
                        dealer.remove(n);
                    break;
                    case 2:
                        j3.add(dealer.get(n));
                        //System.out.println("j3 "+n+":  "+dealer.get(n));
                        dealer.remove(n);
                    break;
                    case 3:
                        j4.add(dealer.get(n));
                        //System.out.println("j4 "+n+":  "+dealer.get(n));
                        dealer.remove(n);
                    break;
                }
            }
            
        }
        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        jugadores.add(j4);
        
        return jugadores;
        
    }
    public int comenzar(){
        int c=-1;
        boolean encontro=false;
        for (int k = 0; k < 7; k++) {
            switch(k){
                case 0:
                    this.faux=f28;
                break;
                case 1:
                    this.faux=f21;
                break;
                case 2:
                    this.faux=f15;
                break;
                case 3:
                    this.faux=f10;
                break;
                case 4:
                    this.faux=f6;
                break;
                case 5:
                    this.faux=f3;
                break;
                case 6:
                    this.faux=f1;
                break;
                
            }
            for (int i = 0; i < this.NJugadores+1; i++) {
                switch(i){
                    case 0:
                        if (dealer.indexOf(faux)!=-1) {
                            c=0;
                            System.out.println("el dealer tiene el "+faux.get(0));
                            encontro=false;
                            break;
                        }
                    break;
                    case 1:
                        if (j1.indexOf(faux)!=-1) {
                            c=1;
                            System.out.println("el j1 tiene el "+faux.get(0));
                            encontro=true;
                            break;
                        }
                    break;
                    case 2:
                        if (j2.indexOf(faux)!=-1) {
                            c=2;
                            System.out.println("el j2 tiene el "+faux.get(0));
                            encontro=true;
                            break;
                        }
                    break;
                    case 3:
                        if (j3.indexOf(faux)!=-1) {
                            c=3;
                            System.out.println("el j3 tiene el "+faux.get(0));
                            encontro=true;
                            break;
                        }
                    break;
                    case 4:
                        if (j4.indexOf(faux)!=-1) {
                            c=4;
                            System.out.println("el j4 tiene el "+faux.get(0));
                            encontro=true;
                            break;
                        }
                    break;
                }
        }
            if (encontro==true) {
                break;
            }
        }
        return c;
    }
    
}
